# -*- coding: utf-8 -*-
"""
Created on Sat May 13 09:26:47 2023

@author: Marcelo
"""

from signal import signal
import sys
import pandas
import matplotlib.pyplot as plt
import numpy as np
import os
from scipy import stats
import platform
import glob


def mmq(x,y):
    A = np.vstack([x, np.ones(len(x))]).T
    a, b = np.linalg.lstsq(A, y, rcond=None)[0]
    return a,b

def ajusteax(x,y):
    return (x*y).sum()/(x*x).sum()

def mmqcompeso(x,y,stdy):
    return (x*y* 1/(stdy**2)).sum()/(x*x* 1/(stdy**2)).sum()

def checknumberofexecutionsandsolutions(nlinhas,nexec,nsolutions):
    if nlinhas != nexec*nsolutions:
            print('\nAbnormal number of lines. Aborting!')
            exit()   

def findnumberofexec(df):
    namefirstsolution = df.iloc[0,0]
    cont = 1
    while namefirstsolution == df.iloc[cont,0]:
        cont = cont + 1
    print('Detected ' + str(cont) + ' executions for each code')
    return cont

def OrderbynameandComputenexec(df,computenexec,nexec):
    df = df.sort_values('codigo',ignore_index=True) #ignore index para poder refazer os indices
    if computenexec:
        nexec = findnumberofexec(df)
    return df, nexec

def saveSlopesCsv(slopes, lincoeff, arquivoscurtos,experimentname):
    d = {'nome': arquivoscurtos, 'slopes': slopes, 'lincoeff': lincoeff}
    ds = pandas.DataFrame(data=d)
    ds = ds.sort_values('nome')
    ds.to_csv('analysis_results/slopes-' + experimentname + '.csv', index = False)


def removeinitialditdash(arquivos):
    for i in range(1,len(arquivos)):
        if arquivos[i][0:2] == '.\\':   #remove .\ do inicio dos argumentos caso exista
            arquivos[i] = arquivos[i][2:len(arquivos[i])]
    return arquivos


def getshortnames(arquivos):
    arquivoscurtos = []
    for i in range(1,len(arquivos)):
        #arquivoscurtos.append(arquivos[i][5:len(arquivos[i])-4])
        arquivoscurtos.append(arquivos[i][0:4])
    return arquivoscurtos

def getexperimentname(arquivos):
    i = arquivos[1].find('control')
    if i == -1:
        i = arquivos[1].find('training')
    return arquivos[1][i:-4]


def checkargs(arquivos):
    narq = len(arquivos)
    if  narq < 2: #o primeiro argumento é o nome do proprio script
        print('usage: analisacsv file1_machine1.csv file2_machine1.csv ... file1_machine2.csv file2_machine2.csv... ... <-wmmq> <-tclock> <-nexec n1> <-nsolustions n2> <-rout> <-rtail> <-b>')
        exit()          
    return narq

def getsimpleflag(flag, flags,arquivos, narq):
    flags[flag] = False
    if ('-' + flag) in arquivos:
        flags[flag] = True
        arquivos.remove('-' +flag)
        narq = narq-1
    return flags, arquivos, narq

def temasterisco(s):
    if '*' in s:
        return True
    else:
        return False
        
def listaarquivos(arquivos):
    lista = glob.glob(arquivos)
    return lista

def expandeargumentos(arquivos):
    for i in arquivos:
        if temasterisco(i):
            lista = listaarquivos(i)
            arquivos.remove(i)
            for j in lista:
                arquivos.append(j)
    return arquivos

def getflags(arquivos, narq, so):
    '''
    wmmq = weitghted mmq
    tclock = usar tempo do wall clock (o default é usar a soma do user+sys)
    perf = somar pkg e ram dados pelo perf
    rout = remove outliers and compute slope again
    rtail = remove the longest executing program if it is an outlier and compute slope again
    b = compute ax+b with mmq
    sen = ao inves do mmq, usa theil-sen pra estimar a reta
    '''
    if so == 'Windows':
        arquivos = expandeargumentos(arquivos)

    vflags = ['wmmq','tclock','perf','rout','rtail','b','sen','nobaseline']
    flags = {}
    
    for i in vflags:
        flags, arquivos, narq = getsimpleflag(i, flags, arquivos, narq)
 
    #quantas execucoes de cada codigo foram feitas. 10 por default
    nexec = 10 
    flags['computenexec'] = True #achar automaticamente o numero de execucoes
    if '-nexec' in arquivos:
        nexecindex = arquivos.index('-nexec')
        nexec = int(arquivos[nexecindex+1])
        arquivos.pop(nexecindex+1)
        arquivos.remove('-nexec')
        narq = narq-2
        flags['computenexec'] = False

    #quantas solucoes presentes no .csv
    flags['usensolutions'] = False
    if '-nsolutions' in arquivos:
        flags['usensolutions'] = True
        nsolutionsindex = arquivos.index('-nsolutions')
        flags['nsolutions'] = int(arquivos[nsolutionsindex+1])
        arquivos.pop(nsolutionsindex+1)
        arquivos.remove('-nsolutions')
        narq = narq-2

    return flags, narq, nexec, arquivos

def criarelatorio(arquivoscurtos):
    try:
        os.mkdir('analysis_results')
        print('cirando diretorio de resultados')
    except OSError as error:
        print('diretorio de resultados ja existe') 
    file = open("analysis_results/relatorio" + ''.join(arquivoscurtos[0:]) + ".txt", "w")
    return file

def incrementaestilo(nestilo,i):
    if i%7==1:
        nestilo += 1
    return nestilo

def carregacsv(arquivo, flags, nexec):

    print('carregando ',arquivo)
    #carrega sem nomes de colunas pra descobrir quantas colunas tem
    dfsemnomes = pandas.read_csv(arquivo)
    ncolunas = len(dfsemnomes. columns)
    if ncolunas == 6:
        df = pandas.read_csv(arquivo,names=['codigo', 'pkg','cpu', 'n1','n2','tempo'])
    else:
        df = pandas.read_csv(arquivo,names=['codigo', 'pkg','cpu', 'n1','n2','tempo','tuser','tsys'])
        print('mais colunas de tempo detectadas')

    df, nexec = OrderbynameandComputenexec(df,flags['computenexec'],nexec)

    #calcular a média e variancia das nexec execucoes de cada codigo
    nlinhas = len(df)
    if flags['usensolutions']:
            checknumberofexecutionsandsolutions(nlinhas,nexec,flags['nsolutions'])

    return df, ncolunas, nlinhas, nexec

def salvaresumo(arquivo,vnome, vmconsumo, vdconsumo, vmtempo,vdtempo, vmtsoma, vdtsoma):

    print('salvando resumo de  ',arquivo)
    slopeindividual = vmconsumo/vmtempo
    
    d = {'nome': vnome, 'consumo_medio': vmconsumo, 'desvio_consumo':vdconsumo, 'tempo_medio':vmtempo, 'desvio_tempo':vdtempo, 'temposoma_medio':vmtsoma, 'desvio_temposoma':vdtsoma, 'slope_individual': slopeindividual}
    ds = pandas.DataFrame(data=d)
    ds = ds.sort_values('nome')
    ds.to_csv('analysis_results/resumo' + arquivo)

    return ds, d

def checardiferencamaxima(difft, df, j):
    if (difft.max() > 10):
        print("\n\n\nDifference between times seem too large in " + df.iloc[j,0] + ". Max = " + str(difft.max()) + ". Number of occurences: " + str(sum(i > 10 for i in difft)) + "\n\n\n\n")
        file.write("\n\n\nDifference between times seem too large in " + df.iloc[j,0] + ". Max = " + str(difft.max()) + ". Number of occurences: " + str(sum(i > 10 for i in difft)) + "\n\n\n\n")

def removeextremos(pkg,t,tsomausersys,nexec):
    #ordena de acordo com o consumo (pkg) para remover os extremos (10% do nexec)
    dt = {'pkg': pkg, 'tempo':t, 'temposoma':tsomausersys}
    dtemp = pandas.DataFrame(data=dt)
    dtemp = dtemp.sort_values('pkg',ignore_index=True) #ignore index para poder refazer os indices
    listprimeiros = list(range(0,int(nexec*0.1)))
    listultimos = list(range(len(dtemp)-int(nexec*0.1),len(dtemp)))
    listtodos = listprimeiros + listultimos
    dtemp.drop(labels=listtodos, axis=0, inplace=True)
    
    pkg = np.array(dtemp.iloc[:,0])
    t = np.array(dtemp.iloc[:,1])
    tsomausersys = np.array(dtemp.iloc[:,2])
    return pkg, t, tsomausersys

def checknegative(pkg, t):
    #verifica se tem algum valor negativo
    if min(pkg.min(), t.min()) <= 0:
        print('Valor negativo detectado. Abortando!')
        exit()

def removeBaseline(mediaconsumo, mediatempo):
    mediaconsumo = mediaconsumo - mediatempo*baselineslope
    return mediaconsumo

def calculamedias(df, ncolunas, nlinhas, nexec, flags, file):

    print('processando ',arquivos[i])
    file.write('processando ' + arquivos[i] + '\n')

    j = 0
    cont = 0
    vnome = []
    vmconsumo = np.zeros(int(nlinhas/nexec))
    vdconsumo = np.zeros(int(nlinhas/nexec))
    vmtempo = np.zeros(int(nlinhas/nexec))
    vdtempo = np.zeros(int(nlinhas/nexec))
    vmtsoma = np.zeros(int(nlinhas/nexec))
    vdtsoma = np.zeros(int(nlinhas/nexec))
        
    while j < nlinhas:
        vnome.append(df.iloc[j,0])
        pkg = np.array(df.iloc[j:j+nexec,1])
        ramperf = np.array(df.iloc[j:j+nexec,3])
        if flags['perf']:
            pkg = pkg + ramperf
        t = np.array(df.iloc[j:j+nexec,5])
        tsomausersys = np.zeros(nexec)
        if ncolunas == 8:
            tuser = np.array(df.iloc[j:j+nexec,6])
            tsys = np.array(df.iloc[j:j+nexec,7])
            tsomausersys = tuser + tsys
            difft = np.array(t - tsomausersys)
            checardiferencamaxima(difft, df, j)
                
        pkg, t, tsomausersys = removeextremos(pkg,t,tsomausersys,nexec)

        checknegative(pkg, t)        
        
        mediaconsumo = pkg.mean()
        desvioconsumo = pkg.std()
        mediatempo = t.mean()
        desviotempo = t.std()
        mediatemposoma = tsomausersys.mean()
        desviotemposoma = tsomausersys.std()
        mediaconsumo = removeBaseline(mediaconsumo, mediatempo)
        vmconsumo[cont] = mediaconsumo
        vdconsumo[cont] = desvioconsumo
        vmtempo[cont] = mediatempo
        vdtempo[cont] = desviotempo
        vmtsoma[cont] = mediatemposoma
        vdtsoma[cont] = desviotemposoma
        
        j = j + nexec
        cont = cont + 1
    return vnome, vmconsumo, vdconsumo, vmtempo, vdtempo, vmtsoma, vdtsoma

def carregaordenadonome(ds):
    #carrega novamente os valores nos vetores agora ordenado pelo nome caso os .csvs estejam em ordens diferentes (importante na analise dos ouliers)
    vnome = np.array(ds.iloc[:,0])
    vmconsumo = np.array(ds.iloc[:,1])
    vdconsumo = np.array(ds.iloc[:,2])
    vmtempo = np.array(ds.iloc[:,3])
    vdtempo = np.array(ds.iloc[:,4])
    vmtsoma = np.array(ds.iloc[:,5])
    vdtsoma = np.array(ds.iloc[:,6])
    return vnome, vmconsumo, vdconsumo, vmtempo, vdtempo, vmtsoma, vdtsoma

def salvaresumoordenado(d,arquivo):
    ds = pandas.DataFrame(data=d)
    ds = ds.sort_values('tempo_medio')
    ds.to_csv('analysis_results/resumo_ordenado_tempo' + arquivo)

def diferencatempos(ncolunas, vmtempo, vdtempo, vmtsoma, flags):

    #diferença entre tempos medidos (rapl e time)
    if ncolunas == 8:
        verrotempo = (vmtempo - vmtsoma)**2
        tempoRMSE = verrotempo.mean()**0.5
        print('Root Mean Squared Error entre os tempos medidos: ', tempoRMSE)
        file.write('Root Mean Squared Error entre os tempos medidos: ' + str(tempoRMSE) + '\n')
        if (tempoRMSE > 10):
            print('\n\n\n\nRMSE difference between times seem too large\n\n\n\n')
            file.write('\n\n\n\nRMSE difference between times seem too large\n\n\n\n')
        if not(flags['tclock']):
            vmtempo = vmtsoma
            vdtempo = vdtsoma
    return vmtempo, vdtempo

def calculaajuste(vmtempo, vmconsumo, vdconsumo, flags):
    b = 0
    if flags['sen']:
        a,b,lowslope,highslope = stats.theilslopes(vmconsumo, vmtempo)
        if not flags['b']:
            b = 0
    else:
        if flags['wmmq']:
            a = mmqcompeso(vmtempo, vmconsumo, vdconsumo)
            #a = mmqcompeso(vmtempo, vmconsumo, vdconsumo*vdtempo)
        else:
            if flags['b']:
                a,b = mmq(vmtempo, vmconsumo)
                a = ajusteax(vmtempo, vmconsumo) #faz novamente pra ficar o slope sem considerar o b
            else:
                a = ajusteax(vmtempo, vmconsumo)
            
    return a,b


def gerapontosreta(a,b,vmtempo):
    xr = np.array([0,vmtempo.max()*1.05])
    yr = np.array(a*xr + b)
    return xr, yr

def plotaretas(a,b,vmtempo,vdtempo,vmconsumo,vdconsumo,nsigma,estilo,estilo2,cor,arquivo,h):
    xr, yr  = gerapontosreta(a,b,vmtempo)
    
    #plota pontos e reta de tendencia
    plt.figure(h.number)
    plt.plot(xr,yr,estilo+ cor)        
    #plt.errorbar(vmtempo,vmconsumo, yerr=nsigma*vdconsumo, fmt =estilos[nestilo]+cores[(i-1)%7],label=arquivos[i][0:-4],markersize=8)
    plt.errorbar(vmtempo,vmconsumo, yerr=nsigma*vdconsumo, xerr=nsigma*vdtempo,fmt =estilo2+cor,label=arquivo[0:-4],markersize=8)
    return xr, yr
    
def calculaerro(a,b,vmtempo, vmconsumo, gorduras, flags, file):
    verr = a*vmtempo + b -  vmconsumo #erros com sinais + e -
    #https://stats.libretexts.org/Bookshelves/Introductory_Statistics/Book%3A_Introductory_Statistics_(OpenStax)/12%3A_Linear_Regression_and_Correlation/12.07%3A_Outliers
    if flags['wmmq']:
        #sse = np.sum(((verr)**2)*(1/vdconsumo))/np.mean(1/vdconsumo) #sum of weighted squared erros divided by mean of weights
        sse = np.sum((verr)**2) #sum of squared erros
    else:
        sse = np.sum((verr)**2) #sum of squared erros
    desvioerro = np.sqrt(sse/(verr.size-2))
    print('Gordura (desvio do erro) da reta calculada:', desvioerro)
    file.write('Gordura (desvio do erro) da reta calculada:' + str(desvioerro) + '\n')
    gorduras.append(desvioerro)
    return verr, sse, desvioerro, gorduras

def shapiro(verr, file):
    #teste de chapiro wilk no vetor de erros para ver se segue uma distribuição normal
    rshapwilk = stats.shapiro(verr)
    print('Confiança de que o erro segue uma distribuição normal: ', rshapwilk)
    file.write('Confiança de que o erro segue uma distribuição normal: ' +  str(rshapwilk) + '\n')
    if rshapwilk.pvalue > 0.05:
        print('\t\tSegue uma distribuição normal com confiança de 95%')
        file.write('\t\tSegue uma distribuição normal com confiança de 95%' + '\n')
    else:
        print('\t\tNão podemos afirmar que segue uma distribuição normal')
        file.write('\t\tNão podemos afirmar que segue uma distribuição normal' + '\n')
    return rshapwilk

def pearson(vmtempo,vmconsumo, sse, file, arquivo, Vr2):
    nvarr = np.sum((vmconsumo - vmconsumo.mean())**2)


    #coeficiente R2
    #coeffP =  (nvarr - sse)/nvarr

    #Coeficiente de pearson pelo pandas
    d = { 'tempo_medio':vmtempo, 'consumo_medio': vmconsumo}
    ds = pandas.DataFrame(data=d)
    corrmat = ds.corr(method='pearson')
    coeffP = corrmat.values[0,1]**2
    
    print('Coeficiente R2: ', coeffP)
    file.write(arquivo + '\n')
    file.write('Coeficiente R2: '+ str(coeffP)+ '\n')
    Vr2.append(coeffP)

    

    return coeffP, Vr2

def spearman(ds, file):
    '''
    #coeficiente de correlacao de Spearman
    ds = ds.sort_values('tempo_medio')
    ds['rank_tempo'] = ds['tempo_medio'].rank()
    ds['rank_consumo'] = ds['consumo_medio'].rank()
    d2 = ( np.array(ds['rank_tempo']) - np.array(ds['rank_consumo']) )**2
    coeffS = 1 - 6*np.sum(d2)/(d2.size*(d2.size**2 - 1))
    print('Coeficiente Spearman: ',coeffS)
    file.write('Coeficiente Spearman: '+ str(coeffS)+ '\n')
    Vspearman.append(coeffS)
    '''
    
    d = { 'tempo_medio':ds['tempo_medio'], 'consumo_medio': ds['consumo_medio']}
    ds = pandas.DataFrame(data=d)
    corrmat = ds.corr(method='spearman')
    coeffS = corrmat.values[0,1]
    print('Coeficiente Spearman: ',coeffS)
    file.write('Coeficiente Spearman: '+ str(coeffS)+ '\n')
    Vspearman.append(coeffS)
    

    return coeffS, Vspearman

def plotarestasdesvio(xr,yr,sigout,desvioerro,cor,h):
    plt.figure(h.number)
    plt.plot(xr,yr,cor)
    plt.plot(xr,yr+sigout*desvioerro,'--' + cor,alpha=0.2)
    plt.plot(xr,yr-sigout*desvioerro,'--' + cor,alpha=0.2)

def detectaoutliers(outliers,vmtempo,vmconsumo,vdtempo,vdconsumo,sigout,desvioerro,verr,vnome,cor,h):

    plt.figure(h.number)
    vlabel = ['low','medium','high']
    vestcol = ['.','d','s']
    for k in range(0,3):
        ctmp = []
        ttmp = []
        dctmp = []
        dttmp = []
        itmp = []
        nometemp = []

        for m in range(0,vmtempo.size):
            #print('analisando ', vnome[m])
            #print('desvio erro de todos: ',desvioerro)
            #print('erro do cara: ', verr[m])
            #print('desvio do cara: ', vdconsumo[m])
            #print(sigout*desvioerro  + k*vdconsumo[m], '<', abs(verr[m]) , '<', sigout*desvioerro  + (k+1)*vdconsumo[m])
            if (abs(verr[m]) >= sigout*desvioerro  + k*vdconsumo[m]) and ((abs(verr[m]) < sigout*desvioerro  + (k+1)*vdconsumo[m]) or (k == 2)):
                ctmp.append(vmconsumo[m]) 
                ttmp.append(vmtempo[m])
                dctmp.append(vdconsumo[m])
                dttmp.append(vdtempo[m])
                itmp.append(m)
                if verr[m] < 0:
                    complemento = 'Acima'
                else:
                    complemento = 'Abaixo'
                nometemp.append(vnome[m] + '\t'+ vlabel[k] + '\t' + complemento)
                print('\tinteresse ' + vlabel[k] +': ', vnome[m], '. ' + complemento)
                file.write('\tinteresse ' + vlabel[k] +': ' + vnome[m] + '. ' + complemento + '\n')
                plt.annotate(vnome[m], (vmtempo[m]+10, vmconsumo[m]))
        if i == 1:
            plt.errorbar(ttmp,ctmp, yerr=dctmp, xerr=dttmp, fmt = vestcol[k]+cor,label=vlabel[k])

        else:
            plt.errorbar(ttmp,ctmp, yerr=dctmp, xerr=dttmp, fmt = vestcol[k]+cor)
        #inserir, na k esima linha, a lista de selecionados com interesse k    
        outliers['csel'].append(ctmp)
        outliers['tsel'].append(ttmp)
        outliers['dcsel'].append(dctmp)
        outliers['dtsel'].append(dttmp)
        outliers['indsel'].append(itmp)
        outliers['nomesel'].append(nometemp)

    return outliers

def matrizrelacaotempomedio(slopes,tempomedio,file):
    if  narq <= 2  : #so calcula matrizes e busca outliers se recebido mais de um arquivo e se o numero de arquivos for impar (numero de .vsc par)
        return
    print('\n\nmatriz de relação de tempo medio')
    print('informa o quanto a solucao da linha i é mais rapida que a solucao da coluna j\n')
    file.write('\n\nmatriz de relação de tempo medio')
    file.write('\ninforma o quanto a solucao da linha i é mais rapida que a solucao da coluna j\n')
    for i in range(len(slopes)):
        for j in range(len(slopes)):
            print("{:.3f}".format((tempomedio[j]/tempomedio[i])),end='\t')
            file.write("{:.3f}".format((tempomedio[j]/tempomedio[i])))
            file.write("\t")
        print('')
        file.write('\n')

    print('\nmatriz de relação de consumo (slope)')
    print('informa o quanto a solucao da linha i consome a mais que a solucao da coluna j\n')
    file.write('\nmatriz de relação de tempo medio e consumo (slope)')
    file.write('\ninforma o quanto a solucao da linha i consome a mais que a solucao da coluna j\n')
    for i in range(len(slopes)):
        for j in range(len(slopes)):
            print("{:.3f}".format((slopes[i]/slopes[j])),end='\t')
            file.write("{:.3f}".format((slopes[i]/slopes[j])))
            file.write("\t")
        print('')
        file.write('\n')

    print('\nmatriz de relação de tempo medio e consumo (slope)')
    print('informa o quanto a solucao da linha i é melhor que a solucao da coluna j\n')
    file.write('\nmatriz de relação de tempo medio e consumo (slope)')
    file.write('\ninforma o quanto a solucao da linha i é melhor que a solucao da coluna j\n')
    for i in range(len(slopes)):
        for j in range(len(slopes)):
            print("{:.3f}".format((tempomedio[j]/tempomedio[i])/(slopes[i]/slopes[j])),end='\t')
            file.write("{:.3f}".format((tempomedio[j]/tempomedio[i])/(slopes[i]/slopes[j])))
            file.write("\t")
        print('')
        file.write('\n')

def buscaoutliersmaquinasdiferentes(narq,outliers,arquivos,file):
    if  narq <= 2 or narq%2 != 1 : #so calcula matrizes e busca outliers se recebido mais de um arquivo e se o numero de arquivos for impar (numero de .vsc par)
        return

    indsel = outliers['indsel']
    nomesel = outliers['nomesel']
    #achar ouliers de interesse (supoes que passou 2*n solucoes rodadas em 2 maquinas diferentes)
    print('Busca por ouliers de uma mesma solucao em máquinas diferentes')
    file.write('\nBusca por ouliers de uma mesma solucao em máquinas diferentes\n')
    primeiro=1
    for i in range(int(3*(narq-1)/2)):
        ind = indsel[i]
        if i%3==0:
            primeiro = 1
        if len(ind)!=0: 
            if i%3==0: #achou um low na primeira maquina
                for j in range(len(ind)):
                    k = ind[j]
                    if k in indsel[int(3*(narq-1)/2)+i+1] or k in indsel[int(3*(narq-1)/2)+i+2]:
                        if primeiro:
                            print(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1])
                            file.write(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1] + '\n')
                            primeiro=0
                        print('\t' + nomesel[i][j])
                        file.write('\t' + nomesel[i][j]+ '\n')
            if i%3==1: #achou um medio
                for j in range(len(ind)):
                    k = ind[j]
                    if k in indsel[int(3*(narq-1)/2)-1+i] or k in indsel[int(3*(narq-1)/2)+i] or k in indsel[int(3*(narq-1)/2)+i+1]:
                        if primeiro:
                            print(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1])
                            file.write(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1] + '\n')      
                            primeiro=0
                        print('\t' + nomesel[i][j])
                        file.write('\t' + nomesel[i][j]+ '\n')
            if i%3==2: #achou um high
                for j in range(len(ind)):
                    k = ind[j]
                    if k in indsel[int(3*(narq-1)/2)-2+i] or k in indsel[int(3*(narq-1)/2)-1+i] or k in indsel[int(3*(narq-1)/2)+i]:
                        if primeiro:
                            print(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1])
                            file.write(arquivos[int(i/3)+1] + ' e ' + arquivos[int((narq-1)/2) + int(i/3) + 1] + '\n')
                            primeiro=0
                        print('\t' + nomesel[i][j])
                        file.write('\t' + nomesel[i][j]+ '\n')

def crialistaoutliers():
    outliers = {}
    outliers['csel'] = []
    outliers['tsel'] = []
    outliers['dcsel'] = []
    outliers['dtsel'] = []
    outliers['indsel'] = []
    outliers['nomesel'] = []
    return outliers

def mostraesalvagraficos(arquivoscurtos):
    plt.figure(h1.number)
    plt.title('Energy Vs Time')  
    plt.ylabel('Energy Comsumption (J)')  
    plt.xlabel('Execution Time (ms)')
    plt.legend(loc='lower right')
    plt.savefig('analysis_results/grafico' + ''.join(arquivoscurtos[0:]) + '.pdf')  
    plt.figure(h2.number)
    plt.title('Outliers detected')  
    plt.ylabel('Energy Comsumption (J)')  
    plt.xlabel('Execution Time (ms)')
    plt.legend(loc='lower right')
    plt.savefig('analysis_results/outliers' + ''.join(arquivoscurtos[0:]) + '.pdf')  
    plt.show()

def imprimesalvainfo(slopes,lincoeff,tempomedio,consumomedio,arquivoscurtos,experimentname,Vr2,Vspearman,gorduras,file):

    print('\nslopes:')
    file.write('\nslopes:\n')
    for i in range(len(tempomedio)):
        print(slopes[i],end='\t')   
        file.write("{:.5f}".format(slopes[i]))
        file.write("\t")
    print('\nlinear coefficients:')
    file.write('\nlinear coefficients:\n')
    for i in range(len(tempomedio)):
        print(lincoeff[i],end='\t')   
        file.write("{:.5f}".format(lincoeff[i]))
        file.write("\t")
    saveSlopesCsv(slopes,lincoeff, arquivoscurtos, experimentname)
    print('\ntempos medios das solucoes:')
    file.write('\ntempos medios das solucoes:\n')
    for i in range(len(tempomedio)):
        print(tempomedio[i],end='\t')
        file.write("{:.5f}".format(tempomedio[i]))
        file.write("\t")
    print('\nconsumo medio:')
    file.write('\nconsumo medio:\n')
    for i in range(len(tempomedio)):
        print(consumomedio[i],end='\t')
        file.write("{:.5f}".format(consumomedio[i]))
        file.write("\t")
    print('\nCoeficientes R2:')
    file.write('\nCoeficientes R2:\n')
    print('Coeficientes Spearman:')
    file.write('Coeficientes Spearman:\n')
    print('Gordura (desvio do erro) da reta calculada:')
    file.write('Gordura (desvio do erro) da reta calculada:\n')
    for i in range(len(tempomedio)):
        print(Vr2[i],end='\t')   
        file.write("{:.5f}".format(Vr2[i]))
        file.write("\t")
    print('')
    file.write("\n")
    for i in range(len(tempomedio)):
        print(Vspearman[i],end='\t')   
        file.write("{:.5f}".format(Vspearman[i]))
        file.write("\t")
    print('')
    file.write("\n")
    for i in range(len(tempomedio)):
        print(gorduras[i],end='\t')   
        file.write("{:.5f}".format(gorduras[i]))
        file.write("\t")
    print('')
    file.write("\n")


def removeoutliers(ind, vmtempo, vmconsumo, vdconsumo, tail=False):
    cont = 0
    print(ind)
    vmtempo_ord = sorted(vmtempo, reverse=True)
    max1 = vmtempo_ord[0]
    max2 = vmtempo_ord[1]
    ratio = 1.5
    for i in ind:
        if not tail or (vmtempo[i] == max1 and max1 >= ratio * max2):
            #print(f"removing outliers max vmtempo {max1}, current = {vmtempo[i]} i = {i}")
            vmtempo = np.delete(vmtempo, i-cont) #cada vez que remove 1, os indices diminuem em 1
            vmconsumo = np.delete(vmconsumo, i-cont)
            vdconsumo = np.delete(vdconsumo, i-cont)
            cont = cont + 1
    return vmtempo, vmconsumo, vdconsumo

def setbaselineslope(experimentname, flags):
    if flags['nobaseline']:
        return 0
    if experimentname.find('elite') >= 0:
        print('removing baseline for experiment in elite machine')
        return baselineslopeelite
    elif experimentname.find('think') >= 0:
        print('removing baseline for experiment in think machine')
        return baselineslopethik
    else:
        return 0

########   main   ##################

sistemaoperacional = platform.system()
print('Executing on ', sistemaoperacional)

arquivos = sys.argv
narq = checkargs(arquivos)

cores = ['b','r','g','m','k','c','y']
estilos = ['-','--','-.',':','-','--','-.']
estilos2 = ['.','s','+','d','o','*','^']
nestilo = -1

#número de desvios padrao da barra de erro
nsigma = 2

h1 = plt.figure()
h2 = plt.figure()

flags, narq, nexec, arquivos = getflags(arquivos, narq, sistemaoperacional)

arquivos = removeinitialditdash(arquivos)
arquivoscurtos = getshortnames(arquivos)
experimentname = getexperimentname(arquivos)

file = criarelatorio(arquivoscurtos)

#tempos medios e inclinações de cada
slopes = []
lincoeff = []
slopesoutliersless = []
tempomedio = []
consumomedio = []
Vr2 = []
Vspearman = []
gorduras = []

#listas com pontos de interesse (outliers)
outliers = crialistaoutliers()

baselineslopeelite = 0.000470713037088506
baselineslopethik = 0.004206933889974837


for i in range(1,len(arquivos)):
    nestilo = incrementaestilo(nestilo,i)
    df, ncolunas, nlinhas, nexec = carregacsv(arquivos[i], flags, nexec)
    baselineslope = setbaselineslope(arquivos[i],flags)
    vnome, vmconsumo, vdconsumo, vmtempo, vdtempo, vmtsoma, vdtsoma = calculamedias(df, ncolunas, nlinhas, nexec, flags, file)
    ds, d = salvaresumo(arquivos[i],vnome, vmconsumo, vdconsumo, vmtempo,vdtempo, vmtsoma, vdtsoma)
    vnome, vmconsumo, vdconsumo, vmtempo, vdtempo, vmtsoma, vdtsoma =  carregaordenadonome(ds)
    salvaresumoordenado(d,arquivos[i])
    vmtempo, vdtempo = diferencatempos(ncolunas, vmtempo, vdtempo, vmtsoma, flags)
    
    a,b = calculaajuste(vmtempo, vmconsumo, vdconsumo, flags)

    indest = (i-1)%7
    xr, yr = plotaretas(a,b,vmtempo,vdtempo,vmconsumo,vdconsumo,nsigma,estilos[indest],estilos2[indest],cores[indest],arquivos[i],h1)
    verr, sse, desvioerro, gorduras = calculaerro(a,b,vmtempo, vmconsumo, gorduras, flags, file)
    sigout = 2 #nmero de desvios para um ponto ser considerado outlier
    plotarestasdesvio(xr,yr,sigout,desvioerro,cores[indest],h2)

    rshapwilk = shapiro(verr, file)
    coeffP, Vr2 = pearson(vmtempo,vmconsumo, sse, file, arquivos[i], Vr2)
    coeffS, Vspearman = spearman(ds, file)

    outliers = detectaoutliers(outliers,vmtempo,vmconsumo,vdtempo,vdconsumo,sigout,desvioerro,verr,vnome, cores[indest],h2)

    if flags['rout'] or flags['rtail']:
        idx = (i - 1) * 3 + 2
        #print(f"Arquivo {arquivos[i]} outliers = {outliers['indsel'][i]} ->  {outliers['indsel'][idx]} -> todos {outliers}")
        nvmtempo, nvmconsumo, nvdconsumo = removeoutliers(outliers['indsel'][idx], vmtempo, vmconsumo, vdconsumo, tail=flags['rtail'])
        a,b = calculaajuste(nvmtempo, nvmconsumo, nvdconsumo, flags)
        

    #armazena slope e tempo medio da solucao
    slopes.append(a)
    lincoeff.append(b)
    print('slope: ',a,' linear coeff: ', b)
    tempomedio.append(vmtempo.mean())
    consumomedio.append(vmconsumo.mean())

imprimesalvainfo(slopes,lincoeff,tempomedio,consumomedio,arquivoscurtos,experimentname,Vr2,Vspearman,gorduras,file)

#matrizrelacaotempomedio(slopes,tempomedio,file)
buscaoutliersmaquinasdiferentes(narq,outliers,arquivos,file)

mostraesalvagraficos(arquivoscurtos)

file.close()
