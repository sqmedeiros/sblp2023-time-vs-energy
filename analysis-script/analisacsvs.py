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


def mmq(x,y):
    A = np.vstack([x, np.ones(len(x))]).T
    a, b = np.linalg.lstsq(A, y, rcond=None)[0]
    return a,b

def ajusteax(x,y):
    return (x*y).sum()/(x*x).sum()

def mmqcompeso(x,y,stdy):
    return (x*y* 1/(stdy**2)).sum()/(x*x* 1/(stdy**2)).sum()

arquivos = sys.argv
narq = len(arquivos)

if  narq < 2: #o primeiro argumento é o nome do proprio script
    print('usage: analisacsv file1_machine1.csv file2_machine1.csv ... file1_machine2.csv file2_machine2.csv... ... <-wmmq> <-tsum>')
    exit()          

#opcao de usar mmq normal ou com peso (-wmmq)
wmmq = False
if '-wmmq' in arquivos:
    wmmq = True
    arquivos.remove('-wmmq')
    narq = narq-1

#opcao de usar a soma do tempo user + sys no lugar do tempo medido
tsum = False
if '-tsum' in arquivos:
    tsum = True
    arquivos.remove('-tsum')
    narq = narq-1

cores = ['b','r','g','m','k','c','y']
estilos = ['.','s','+','d','o']
nestilo = -1

#quantas execucoes de cada codigo foram feitas
nexec = 10 
#número de desvios padrao da barra de erro
nsigma = 2

h1 = plt.figure()
h2 = plt.figure()

arquivoscurtos = []
for i in range(1,len(arquivos)):
    if arquivos[i][0:2] == '.\\':   #remove .\ do inicio dos argumentos caso exista
        arquivos[i] = arquivos[i][2:len(arquivos[i])]
    arquivoscurtos.append(arquivos[i][5:len(arquivos[i])-4])

print(arquivoscurtos)
try:
    os.mkdir('analysis_results')
    print('cirando diretorio de resultados')
except OSError as error:
    print('diretorio de resultados ja existe') 
file = open("analysis_results/relatorio" + ''.join(arquivoscurtos[0:]) + ".txt", "w")

#listas com pontos de interesse
csel = []
tsel = []
dcsel = []
dtsel = []
indsel = []
nomesel = []

#tempos medios e inclinações de cada
slopes = []
tempomedio = []
consumomedio = []
Vr2 = []
Vspearman = []
gorduras = []


for i in range(1,len(arquivos)):
    if i%7==1:
        nestilo += 1
    print('carregando ',arquivos[i])
    #carrega sem nomes de colunas pra descobrir quantas colunas tem
    dfsemnomes = pandas.read_csv(arquivos[i])
    ncolunas = len(dfsemnomes. columns)
    if ncolunas == 6:
        df = pandas.read_csv(arquivos[i],names=['codigo', 'pkg','cpu', 'n1','n2','tempo'])
    else:
        df = pandas.read_csv(arquivos[i],names=['codigo', 'pkg','cpu', 'n1','n2','tempo','tuser','tsys'])
        print('mais colunas de tempo detectadas')

    #calcular a média e variancia das nexec execucoes de cada codigo
    nlinhas = len(df)
    j = 0
    cont = 0
    vnome = []
    vmconsumo = np.zeros(int(nlinhas/nexec))
    vdconsumo = np.zeros(int(nlinhas/nexec))
    vmtempo = np.zeros(int(nlinhas/nexec))
    vdtempo = np.zeros(int(nlinhas/nexec))
    vmtsoma = np.zeros(int(nlinhas/nexec))
    vdtsoma = np.zeros(int(nlinhas/nexec))
    print('processando ',arquivos[i])
    file.write('processando ' + arquivos[i] + '\n')
        
    while j < nlinhas:
        vnome.append(df.iloc[j,0])
        pkg = np.array(df.iloc[j:j+nexec,1])
        t = np.array(df.iloc[j:j+nexec,5])
        tsomausersys = np.zeros(nexec)
        if ncolunas == 8:
            tuser = np.array(df.iloc[j:j+nexec,6])
            tsys = np.array(df.iloc[j:j+nexec,7])
            tsomausersys = tuser + tsys
            difft = np.array(t - tsomausersys)
            if (difft.max() > 10):
                print("\n\n\nDifference between times seem too large in " + df.iloc[j,0] + " = " + str(difft.max()) + "\n\n\n\n")
                file.write("\n\n\nDifference between times seem too large in " + df.iloc[j,0] + " = " + str(difft.max()) + "\n\n\n\n")
        
        #ordena de acordo com o tempo para remover os dois extremos
        dt = {'pkg': pkg, 'tempo':t, 'temposoma':tsomausersys}
        dtemp = pandas.DataFrame(data=dt)
        dtemp = dtemp.sort_values('tempo')
        dtemp.drop(labels=[0, len(dtemp)-1], axis=0, inplace=True)
        
        pkg = np.array(dtemp.iloc[:,0])
        t = np.array(dtemp.iloc[:,1])
        tsomausersys = np.array(dtemp.iloc[:,2])
        
        #verifica se tem algum valor negativo
        if min(pkg.min(), t.min()) <= 0:
            print('Valor negativo detectado. Abortando!')
            exit()
        
        mediaconsumo = pkg.mean()
        desvioconsumo = pkg.std()
        mediatempo = t.mean()
        desviotempo = t.std()
        mediatemposoma = tsomausersys.mean()
        desviotemposoma = tsomausersys.std()
        vmconsumo[cont] = mediaconsumo
        vdconsumo[cont] = desvioconsumo
        vmtempo[cont] = mediatempo
        vdtempo[cont] = desviotempo
        vmtsoma[cont] = mediatemposoma
        vdtsoma[cont] = desviotemposoma
        
        j = j + nexec
        cont = cont + 1
    
    print('salvando resumo de  ',arquivos[i])

    d = {'nome': vnome, 'consumo_medio': vmconsumo, 'desvio_consumo':vdconsumo, 'tempo_medio':vmtempo, 'desvio_tempo':vdtempo, 'temposoma_medio':vmtsoma, 'desvio_temposoma':vdtsoma}
    ds = pandas.DataFrame(data=d)
    ds = ds.sort_values('nome')
    ds.to_csv('analysis_results/resumo' + arquivos[i])

    #carrega novamente os valores nos vetores agora ordenado pelo nome caso os .csvs estejam em ordens diferentes (importante na analise dos ouliers)
    vnome = np.array(ds.iloc[:,0])
    vmconsumo = np.array(ds.iloc[:,1])
    vdconsumo = np.array(ds.iloc[:,2])
    vmtempo = np.array(ds.iloc[:,3])
    vdtempo = np.array(ds.iloc[:,4])
    vmtsoma = np.array(ds.iloc[:,5])
    vdtsoma = np.array(ds.iloc[:,6])

    ds = pandas.DataFrame(data=d)
    ds = ds.sort_values('tempo_medio')
    ds.to_csv('analysis_results/resumo_ordenado_tempo' + arquivos[i])

    #diferença entre tempos medidos (rapl e time)
    if ncolunas == 8:
        verrotempo = (vmtempo - vmtsoma)**2
        tempoRMSE = verrotempo.mean()**0.5
        print('Root Mean Squared Error entre os tempos medidos: ', tempoRMSE)
        file.write('Root Mean Squared Error entre os tempos medidos: ' + str(tempoRMSE) + '\n')
        if (tempoRMSE > 10):
            print('\n\n\n\nRMSE difference between times seem too large\n\n\n\n')
            file.write('\n\n\n\nRMSE difference between times seem too large\n\n\n\n')
        if tsum:
            vmtempo = vmtsoma
            vdtempo = vdtsoma

    #calcula reta tendencia y = ax + b
    b = 0
    #a,b = mmq(vmtempo, vmconsumo)

    #calcula reta tentendia y = ax
    if wmmq:
        a = mmqcompeso(vmtempo, vmconsumo, vdconsumo)
        #a = mmqcompeso(vmtempo, vmconsumo, vdconsumo*vdtempo)
    else:
        a = ajusteax(vmtempo, vmconsumo)
    
    print('slope: ',a)

    #armazena slope e tempo medio da solucao
    slopes.append(a)
    tempomedio.append(vmtempo.mean())
    consumomedio.append(vmconsumo.mean())

    #gera reta
    xr = np.array([0,vmtempo.max()*1.05])
    yr = np.array(a*xr + b)
    
    #plota pontos e reta de tendencia
    plt.figure(h1.number)
    plt.plot(xr,yr,'-' +estilos[nestilo]+ cores[(i-1)%7])        
    #plt.errorbar(vmtempo,vmconsumo, yerr=nsigma*vdconsumo, fmt =estilos[nestilo]+cores[(i-1)%7],label=arquivos[i][0:-4],markersize=8)
    plt.errorbar(vmtempo,vmconsumo, yerr=nsigma*vdconsumo, xerr=nsigma*vdtempo,fmt =estilos[nestilo]+cores[(i-1)%7],label=arquivos[i][0:-4],markersize=8)
    
    
    #plota pontos com cores de acordo com a distancia para a reta tendencia
    verr = a*vmtempo + b -  vmconsumo #erros com sinais + e -
    #https://stats.libretexts.org/Bookshelves/Introductory_Statistics/Book%3A_Introductory_Statistics_(OpenStax)/12%3A_Linear_Regression_and_Correlation/12.07%3A_Outliers
    if wmmq:
        #sse = np.sum(((verr)**2)*(1/vdconsumo))/np.mean(1/vdconsumo) #sum of weighted squared erros divided by mean of weights
        sse = np.sum((verr)**2) #sum of squared erros
    else:
        sse = np.sum((verr)**2) #sum of squared erros
    desvioerro = np.sqrt(sse/(verr.size-2))
    print('Gordura (desvio do erro) da reta calculada:', desvioerro)
    file.write('Gordura (desvio do erro) da reta calculada:' + str(desvioerro) + '\n')
    gorduras.append(desvioerro)

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
    
    nvarr = np.sum((vmconsumo - vmconsumo.mean())**2)
    
    #coeficiente de correlacao de Pearson
    coeffP =  (nvarr - sse)/nvarr
    print('Coeficiente R2: ', coeffP)
    file.write(arquivos[i] + '\n')
    file.write('Coeficiente R2: '+ str(coeffP)+ '\n')
    Vr2.append(coeffP)


    #coeficiente de correlacao de Spearman
    ds = ds.sort_values('tempo_medio')
    ds['rank_tempo'] = ds['tempo_medio'].rank()
    ds['rank_consumo'] = ds['consumo_medio'].rank()
    d2 = ( np.array(ds['rank_tempo']) - np.array(ds['rank_consumo']) )**2
    coeffS = 1 - 6*np.sum(d2)/(d2.size*(d2.size**2 - 1))
    print('Coeficiente Spearman: ',coeffS)
    file.write('Coeficiente Spearman: '+ str(coeffS)+ '\n')
    Vspearman.append(coeffS)


    sigout = 2 #nmero de desvios para um ponto ser considerado outlier
    plt.figure(h2.number)
    plt.plot(xr,yr,cores[(i-1)%7])
    plt.plot(xr,yr+sigout*desvioerro,'--' + cores[(i-1)%7],alpha=0.2)
    plt.plot(xr,yr-sigout*desvioerro,'--' + cores[(i-1)%7],alpha=0.2)
    
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
            plt.errorbar(ttmp,ctmp, yerr=dctmp, xerr=dttmp, fmt = vestcol[k]+cores[(i-1)%7],label=vlabel[k])

        else:
            plt.errorbar(ttmp,ctmp, yerr=dctmp, xerr=dttmp, fmt = vestcol[k]+cores[(i-1)%7])
        #inserir, na k esima linha, a lista de selecionados com interesse k    
        csel.append(ctmp)
        tsel.append(ttmp)
        dcsel.append(dctmp)
        dtsel.append(dttmp)
        indsel.append(itmp)
        nomesel.append(nometemp)

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
print('\nslopes:')
file.write('\nslopes:\n')
for i in range(len(tempomedio)):
    print(slopes[i],end='\t')   
    file.write("{:.5f}".format(slopes[i]))
    file.write("\t")
print('\nCoeficientes R2:')
file.write('\nCoeficientes R2::\n')
for i in range(len(tempomedio)):
    print(Vr2[i],end='\t')   
    file.write("{:.5f}".format(Vr2[i]))
    file.write("\t")
print('\nCoeficientes Spearman:')
file.write('\nCoeficientes Spearman:\n')
for i in range(len(tempomedio)):
    print(Vspearman[i],end='\t')   
    file.write("{:.5f}".format(Vspearman[i]))
    file.write("\t")
print('\nGordura (desvio do erro) da reta calculada:')
file.write('\nGordura (desvio do erro) da reta calculada:\n')
for i in range(len(tempomedio)):
    print(gorduras[i],end='\t')   
    file.write("{:.5f}".format(gorduras[i]))
    file.write("\t")
    

if  narq != 2: #so calcula matrizes e busca outliers se recebido mais de um arquivo
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

    #achar ouliers de interesse (supoes que passou 2*n solucoes rodadas em 2 maquinas diferentes)
    print('Busca por ouliers de uma mesma solucao em máquinas diferentes')
    file.write('\nBusca por ouliers de uma mesma solucao em máquinas diferentes\n')
    primeiro=1
    for i in range(int(3*(narq-1)/2)):
        #print(i)
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

file.close()
