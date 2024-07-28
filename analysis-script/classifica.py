from signal import signal
import sys
import pandas
import matplotlib.pyplot as plt
import numpy as np
import os
from scipy import stats

def carregacsvs(arq1, arq2):
    df1 = pandas.read_csv(arq1)
    nomes1 = df1['nome'].to_numpy()
    slopes1 = df1['slopes'].to_numpy()
    try:
        lincoeff1 = df1['lincoeff'].to_numpy()
    except:
        lincoeff1 = np.zeros(len(slopes1))

    df2 = pandas.read_csv(arq2)
    nomes2 = df2['nome'].to_numpy()
    slopes2 = df2['slopes'].to_numpy()
    try:
        lincoeff2 = df2['lincoeff'].to_numpy()
    except:
        lincoeff2 = np.zeros(len(slopes2))

    if not((nomes1 == nomes2).all):
        print('arquivos com nomes diferentes')
        exit()
    return slopes1, slopes2, lincoeff1, lincoeff2, nomes1


def classificaGeral(slopes1, slopes2, lincoeff1, lincoeff2):
    n = slopes1.size
    nacertos = np.zeros(n)
    vacertos = np.zeros((n, n))
    for i in range(n):
        nacertos[i], vacertos[i,:] = classificaN(slopes1, slopes2, lincoeff1, lincoeff2, i)
    return nacertos, vacertos

def distancia(s, l, slopes, lincoeff):
    diffs = (slopes - s)**2
    diffl = (lincoeff - l)**2
    difft = (alpha*diffs + (1-alpha)*diffl)**(1/2)
    return difft


def classificaN(slopes1, slopes2, lincoeff1, lincoeff2, N):
    n = slopes1.size
    acertou = np.zeros(n)
    for i in range(n):
        s = slopes1[i]
        l = lincoeff1[i]
        diff = distancia(s,l,slopes2,lincoeff2)
        acertou[i] = nmenor(diff, N, i)
    nacertos = np.sum(acertou)
    return nacertos, acertou
   
def nmenor(diff, N, indiceproblema):
    for i in range(N):
        index = np.argmin(diff)
        if index == indiceproblema:
            return 1
        else:
            diff[index] = 999
    return 0
    

def grafico(nacertos, h, l, estilo):
    plt.figure(h.number)
    n = nacertos.size
    x = range(0,n)
    plt.plot(x,nacertos*100/n,estilo,label=l)
    plt.grid()
    plt.yticks(np.arange(0, 101, 10))
    plt.ylabel("Percentage correctly classified")
    plt.xlabel("Number of tries")


def imprimeaceretoproblemas(vacertos, nomes, ax):
    print('numero de acertos em funcao de n e probelmas classificados corretamente a partir deste passo')
    total_acertos = 0
    n = len(nomes)
    for i in range(1, n):
        #np.set_printoptions(threshold=np.inf)
        classified = nomes[np.logical_and(vacertos[i,:]==1, vacertos[i,:]!= vacertos[i-1,:])]
        percent_total = (100 * nacertos[i]) / n
        print(f"{i}: {nacertos[i]:.0f} ({percent_total:.0f}%) {classified}")
        if i > 15 and classified.size > 0   :
            ax.text(i,percent_total, str(classified))

def vetornulo(v):
    if sum(v) == 0:
        return True
    else:
        return False

def graficoespacoestados(slopes1, slopes2, lincoeff1, lincoeff2,  nomes, h):
    plt.figure(h.number)
    ax = h.add_subplot()
    cont = 0
    #lincoeff1 = (1-alpha)*lincoeff1
    #lincoeff2 = (1-alpha)*lincoeff2
    if vetornulo(lincoeff1):
        lincoeff1 = np.linspace(0,1,32)
        lincoeff2 = lincoeff1
    for i in range(len(slopes1)):
        plt.plot(slopes1[i],lincoeff1[i],'o', color=cores[cont])
        plt.plot(slopes2[i],lincoeff2[i],'s', color=cores[cont])
        plt.plot([slopes1[i],slopes2[i]],[lincoeff1[i],lincoeff2[i]],'--', color=cores[cont])
        ax.text(slopes1[i],lincoeff1[i], nomes[i])
        cont = cont+1
        if cont % len(cores)==0:
            cont = 0
    plt.xlabel("Normalized Slopes")
    plt.ylabel("Normalized Linear Coeficients")

def normalizapar(v1,v2):
    v12 = np.append(v1,v2)
    minv = np.min(v12)
    v12 = v12-minv
    maxv = np.max(v12)
    v1 = v1 - minv
    v2 = v2 - minv
    v1 = v1/maxv
    v2 = v2/maxv
    return v1, v2


def normaliza(s1, s2, l1, l2):
    s1,s2 = normalizapar(s1,s2)
    l1,l2 = normalizapar(l1,l2)
    return s1,s2,l1,l2

def equalizapar(v1,v2):
    mv1 = np.mean(v1)
    mv2 = np.mean(v2)
    vdiff = mv1 - mv2
    print(vdiff)
    v2 = v2 + vdiff
    return v2

def equaliza(slopes1, slopes2, lincoeff1, lincoeff2):
    slopes2 = equalizapar(slopes1, slopes2)
    lincoeff2 = equalizapar(lincoeff1, lincoeff2)
    return slopes1, slopes2, lincoeff1, lincoeff2

def checkargs(narq):
    if narq < 3:
        print('usage: classifica.py <control1.csv> <training1.csv> <control2.csv> <training2.csv> ...')
        exit()
    return

########### main ##########

arquivos = sys.argv
narq = len(arquivos)

checkargs(narq)

h1 = plt.figure()
ax = h1.add_subplot()
h2 = plt.figure()

#o quanto o slope importa mais que o b 
alpha = 0.5

label = ['HPELITE','HPTHINK','HPELITE removing tail','HPTHINK removing tail']
estilo = ['b','r','b--','r--']


for i in range(1,narq-1,2):

    arq1 = arquivos[i]
    arq2 = arquivos[i+1]  

    slopes1, slopes2, lincoeff1, lincoeff2,  nomes = carregacsvs(arq1, arq2)
    if not(vetornulo(lincoeff1)):
        slopes1, slopes2, lincoeff1, lincoeff2 = normaliza(slopes1, slopes2, lincoeff1, lincoeff2)
    nacertos, vacertos = classificaGeral(slopes1, slopes2, lincoeff1, lincoeff2)

    imprimeaceretoproblemas(vacertos, nomes, ax)
    grafico(nacertos, h1, label[int(i/2)],estilo[int(i/2)])

    cores = ['b','r','g','m','c','y','k','tab:brown','tab:orange','tab:purple','tab:gray']

    graficoespacoestados(slopes1, slopes2, lincoeff1, lincoeff2,  nomes, h2)

plt.figure(h1.number)
plt.title('Classification success')
plt.legend(loc='lower right')
plt.show()

