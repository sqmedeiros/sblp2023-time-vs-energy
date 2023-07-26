import os
import sys

for argumento in sys.argv:
  print(argumento)


#-------------------------------------------------------------------------------------
#defs da parte 2

def vetorUnicoArquivo(arquivo):
  ref_arquivo = open(arquivo,"r")
  arquivoInteiro = []
  arquivoVetorUnico = []
  for linha in ref_arquivo:
    valores = linha.split()
    arquivoInteiro.append(valores)
  
  for i in range(0,len(arquivoInteiro)):
    for j in range(0,len(arquivoInteiro[i])):
      arquivoVetorUnico.append(arquivoInteiro[i][j])
  ref_arquivo.close()
  return (arquivoVetorUnico)


def encontra_Heap_Summary(arquivo_Lista):
  tamanho = len(arquivo_Lista)
  for i in range(0,len(arquivo_Lista)):
    if arquivo_Lista[0] != "HEAP" and arquivo_Lista[0] != "Summary:" :
      del arquivo_Lista[0]
    else :
      return arquivo_Lista

def encontra_exit_allocsUse_alçocsFree_totaloAllocated(saida_Lista):
  tamanho = len(saida_Lista)
  exitt = "nada"
  usage = "nada"
  free = "nada"
  allocated = "nada"
  for index, valor in enumerate(saida_Lista):
    if saida_Lista[index] == "exit:":
      exitt = saida_Lista[index+1]
    if saida_Lista[index] == "usage:":
      usage = saida_Lista[index+1]
    if saida_Lista[index] == "frees,":
      free = saida_Lista[index-1]
    if saida_Lista[index] == "allocated":
      allocated = saida_Lista[index-2]
  if exitt != "nada" and usage != "nada" and free != "nada" and allocated != "nada":
    #dadosHeapSummary = dHS
    dHS = []
    dHS.append(exitt)
    dHS.append(usage)
    dHS.append(free)
    dHS.append(allocated)
    return dHS
    
def validar_leak(saida_Lista):
  for index, valor in enumerate(saida_Lista):
    if saida_Lista[index] == "LEAK" and saida_Lista[index+1] == "SUMMARY:":
      return True      
  return False
  

def numeros_do_leak(dados_do_dHS, existencia_leak, saida_Lista):
  if existencia_leak == True:
    definitely = "nada"
    indirectly = "nada"
    possibly = "nada"
    reachable = "nada"
    for index, valor in enumerate(saida_Lista):
    
      if saida_Lista[index] == "definitely":
        definitely = saida_Lista[index+2]
      if saida_Lista[index] == "indirectly":
        indirectly = saida_Lista[index+2]
      if saida_Lista[index] == "possibly":
        possibly = saida_Lista[index+2]
      if saida_Lista[index] == "reachable:":
        reachable = saida_Lista[index+1]
      if definitely != "nada" and indirectly != "nada" and possibly != "nada" and reachable != "nada":
        dados_do_dHS.append(definitely)
        dados_do_dHS.append(indirectly)
        dados_do_dHS.append(possibly)
        dados_do_dHS.append(reachable)
        return dados_do_dHS
  else:
    for i in range(0,4):
      dados_do_dHS.append("0")
    return dados_do_dHS


def tornar_dados_inteiros(dados_gerais):
  chars = ','
  w = []
  for i in range (0,len(dados_gerais)):
    res = dados_gerais[i].translate(str.maketrans('', '', chars))
    w.append(res)
    w[i] = int(w[i])
  return w

def adciona_linha_em_csv(dados_gerais_int, exe, nome_do_problema, pasta, typeArq):
  with open(f'{nome_do_problema}_mem_{pasta}_{typeArq}.csv', 'a+') as stream:
    stream.write(f"{exe},{dados_gerais_int[0]},{dados_gerais_int[1]},{dados_gerais_int[2]},{dados_gerais_int[3]},{dados_gerais_int[4]},{dados_gerais_int[5]},{dados_gerais_int[6]},{dados_gerais_int[7]}\n")


def adciona_linha_em_csv_media(dados_gerais_media_int, exe, nome_do_problema, pasta, typeArq):
  with open(f'{nome_do_problema}_mem_{pasta}_media_{typeArq}.csv', 'a+') as stream:
    stream.write(f"{exe},{dados_gerais_media_int[0]},{dados_gerais_media_int[1]},{dados_gerais_media_int[2]},{dados_gerais_media_int[3]},{dados_gerais_media_int[4]},{dados_gerais_media_int[5]},{dados_gerais_media_int[6]},{dados_gerais_media_int[7]}\n")

#-------------------------------------------------------------------------------------
pasta = sys.argv[1]
nome_do_problema = sys.argv[2]
typeArq = sys.argv[3]
print(f"pasta = {pasta}")
print(f"nome = {nome_do_problema}")
print(f"typeArq = {typeArq}")

assert(typeArq == "c++" or typeArq == "java")

primeiraLinhaCsv = ["nome","exit","usage","free","allocated","definitely","indirectly","possibly","reachable"]
with open(f'{nome_do_problema}_mem_{pasta}_{typeArq}.csv', 'a+') as stream:
    stream.write(f"{primeiraLinhaCsv[0]},{primeiraLinhaCsv[1]},{primeiraLinhaCsv[2]},{primeiraLinhaCsv[3]},{primeiraLinhaCsv[4]},{primeiraLinhaCsv[5]},{primeiraLinhaCsv[6]},{primeiraLinhaCsv[7]}\n")

primeiraLinhaCsvMedia = ["nome","exit","usage","free","allocated","definitely","indirectly","possibly","reachable"]
with open(f'{nome_do_problema}_mem_{pasta}_media_{typeArq}.csv', 'a+') as stream:
    stream.write(f"{primeiraLinhaCsvMedia[0]},{primeiraLinhaCsvMedia[1]},{primeiraLinhaCsvMedia[2]},{primeiraLinhaCsvMedia[3]},{primeiraLinhaCsvMedia[4]},{primeiraLinhaCsvMedia[5]},{primeiraLinhaCsvMedia[6]},{primeiraLinhaCsvMedia[7]}\n")

#subpast = ["fast","lang","slow"]

testes = os.listdir(f"test")
arqtxt = []
for test in testes:
  print(test)
  if test.endswith(".txt"):
    arqtxt.append(test)  

numeroDeTestes = len(arqtxt)

somaTestesValores = []

def fastlangslow(pasta, typeArq):
  arquivos = os.listdir(f"{typeArq}")
  arqexe = []
  for arquivo in arquivos:
    if typeArq == "c++":
      if arquivo.endswith(".exe"):
        arqexe.append(arquivo)
    elif typeArq == "java":
      if arquivo.endswith(".java"):
        arqexe.append(arquivo)
  for exe in arqexe:
    dados_gerais_media_int = [0,0,0,0,0,0,0,0]
    for test in testes:
      arquivoo = f"arquivoo-{typeArq}.txt"
      comando = "valgrind "
      if typeArq == "c++":
      	comando += f"./{pasta}/{exe}"
      else:
      	comando += f"java {pasta}/{exe[:-5]}"
      comando += f" < test/{test} > /dev/null 2>{arquivoo}"
      print("Vou executar " + comando) 
      os.system(comando)
      arquivo_Lista = vetorUnicoArquivo(arquivoo)
      saida_Lista = encontra_Heap_Summary(arquivo_Lista)
      dados_do_dHS = encontra_exit_allocsUse_alçocsFree_totaloAllocated(saida_Lista)
      existencia_leak = validar_leak(saida_Lista)
      dados_gerais = numeros_do_leak(dados_do_dHS, existencia_leak, saida_Lista)
      dados_gerais_int = tornar_dados_inteiros(dados_gerais)
      adciona_linha_em_csv(dados_gerais_int, exe, nome_do_problema, pasta, typeArq)
      for i in range(0,8):
        dados_gerais_media_int[i] = dados_gerais_media_int[i] + dados_gerais_int[i]
    for i in range(0,8):
      dados_gerais_media_int[i] = int(dados_gerais_media_int[i]/len(testes))
    adciona_linha_em_csv_media(dados_gerais_media_int, exe, nome_do_problema, pasta, typeArq)
      

fastlangslow(pasta,typeArq)

#fastlangslow(pasta,typeArq = "lang")
#fastlangslow(pasta,typeArq = "slow")


