import os.path
import time
from datetime import datetime

dirs = [
  "1071-Number_Spiral",
  "1082-Sum_of_Divisors",
  "1084-Apartments",
  "1140-Projects",
  "1158-Bookshop",
  "1621-Distinct_Numbers",
  "1632-Movie_Festival_II",
  "1634-Minimizing_Coins",
  "1635-Coin_Combinations_I",
  "1636-Coin_Combinations_II",
  "1639-Edit_Distance",
  "1640-Sum_of_Two_Values",
  "1642-Sum_of_Four_Values",
  "1643-Maximum_Subarray_Sum",
  "2185-Prime_Multiples",
]


experiments = "Experiments.txt"
toProcess = "ToProcess.txt"
reiniciaUnicaVez =  "Reiniciou.txt"
prevDir = "../"
sleepTime = 120 # seconds
beepInterval = 0.3 # seconds
rebootTime = 0 # minutes
cmdKillNet = "ifconfig eno1 down"
cmdKillAnydesk = "service anydesk stop"
logDir = "log/"
logFile = "myLog.txt"

def write_log (msg):
  print(msg)
  with open(logDir + logFile, "a+") as f:
    f.write(f"{datetime.now()}: {msg}\n")

def kill_and_sleep (sleepTime):
  os.system(cmdKillAnydesk)
  time.sleep(sleepTime)
  os.system(cmdKillNet) #antes do sleep nao estava fazendo efeito
  

def make_beep (n):
  time.sleep(beepInterval)
  for i in range(n):
     time.sleep(beepInterval)
     cmd1 = "speaker-test -t sine -f 1000 -l 1"
     cmd2 = " & sleep .5 && kill -9 $!"
     os.system(cmd1 + cmd2)
     
	
def get_index (mydir):
  for i, v in enumerate(dirs):
    if mydir == v:
      return i
  assert(False)
  return 0


def get_next_dir (file):
    return recorta_primeira_linha(file)
  
def turnXon():
  cmd1 = 'systemctl enable graphical.target --force'
  cmd2 = 'systemctl set-default graphical.target'
  os.system(cmd1)
  os.system(cmd2)


def turnXoff():
  cmd1 = 'systemctl enable multi-user.target --force'
  cmd2 = 'systemctl set-default multi-user.target'
  os.system(cmd1)
  os.system(cmd2)

def arquivos_existem():
    check_exp = os.path.isfile(experiments)
    check_tp = os.path.isfile(toProcess)
    if not(check_exp and check_tp):
        return False
    return True

def cria_arquivo(file):
   open(file,"a+")

def apaga_arquivo(file):
  check_file = os.path.isfile(file)
  if check_file:
    os.system('rm -f ' + file)

def reinicia():
    #print('reboot')
    os.system(f"shutdown -r +{rebootTime}")

def reinicia_unicavez():
   jareiniciou = os.path.isfile(reiniciaUnicaVez)
   if not(jareiniciou):
      cria_arquivo(reiniciaUnicaVez)
      write_log('Last reboot')
      reinicia()

def criaToProcess():
   write_log("Creating file with directories to process...")
   with open(toProcess,"a+") as fapp:
     for mydir in dirs:
       fapp.write(f"{mydir}\n") 

def recorta_primeira_linha(file):
    with open(file, 'r+') as f:
        firstLine = f.readline() # read the first line and throw it out
        data = f.read() # read the rest
        f.seek(0) # set the cursor to the top of the file
        f.write(data) # write the data back
        f.truncate() # set the file size to the current size

        return firstLine.rstrip()

def extrai_params_linha(linha):
    #language machine processor tool directory1 directory2 ...
    params = linha.split()
    if len(params) < 5:
      write_log('Arquivo Experimentos.txt faltando parametros. Abortando!')
      turnXon()
      apaga_arquivo(experiments)
      reinicia()
    lang = params[0]
    maq = params[1]
    proc = params[2]
    tool = params[3]
    dirs = params[4:len(params)]
    
    return lang, maq, proc, tool, dirs

def pega_prox_experimento(file):
    linha = recorta_primeira_linha(file)
    lang, maq, proc, tool, dirs = extrai_params_linha(linha)
    return lang, maq, proc, tool, dirs
    

def gera_makefiles():
  lang, maq, proc, tool, dirs = pega_prox_experimento(experiments)
  print(lang, maq, proc, tool, dirs)
  cmd = 'python3 scripts/generate_makefiles.py ' + lang + ' ' + maq + ' ' + proc + ' ' + tool 
  for i in dirs:
     cmd = cmd + ' ' + i
  print(cmd)
  os.system(cmd)


def prepara_novo_experimento():
    write_log('Novo experimento')
    gera_makefiles()
    criaToProcess()
    turnXoff()
    make_beep(1)
    apaga_arquivo(reiniciaUnicaVez)
    reinicia()

def continua_experimento_atual():
    mydir = get_next_dir(toProcess)
    write_log("Processing files")
    kill_and_sleep(sleepTime)
    indexDir = get_index(mydir) + 1
    msg = f"I'm going to process directory {mydir} {indexDir}"
    write_log(msg)
    os.chdir(mydir)
    os.system("./faztudo.sh")
    os.chdir(prevDir)
    write_log(f"Finished {mydir}")
    make_beep(get_index(mydir))
    reinicia()

def encerra_experimentos():
    turnXon()
    reinicia_unicavez()
    write_log('Job done')

def pega_tamanho_arquivos(experiments,toProcess):
    size_exp = os.stat(experiments).st_size
    size_tp = os.stat(toProcess).st_size
    return size_exp, size_tp

def no_meio_de_experimento(size_tp):
   return size_tp!=0

def tem_experimento_pra_fazer(size_exp):
   return size_exp!=0



#checa se os arquivos experiments e toProcesso existem
if not(arquivos_existem()):
  write_log('Missing experiment files. Aborting.')
  exit()

size_exp, size_tp = pega_tamanho_arquivos(experiments,toProcess)

if no_meio_de_experimento(size_tp):
  continua_experimento_atual()
elif tem_experimento_pra_fazer(size_exp):
  prepara_novo_experimento()
else:
  encerra_experimentos()
  
