import os.path
import time
import argparse
from datetime import datetime
import sys
from os import listdir
from os.path import isfile, join

dirs = [
  "1071-Number_Spiral",
#  "1082-Sum_of_Divisors",
#  "1084-Apartments",
#  "1140-Projects",
#  "1158-Bookshop",
#  "1621-Distinct_Numbers",
#  "1632-Movie_Festival_II",
#  "1634-Minimizing_Coins",
#  "1635-Coin_Combinations_I",
#  "1636-Coin_Combinations_II",
#  "1639-Edit_Distance",
#  "1640-Sum_of_Two_Values",
#  "1642-Sum_of_Four_Values",
#  "1643-Maximum_Subarray_Sum",
#  "2185-Prime_Multiples"
] 


faztudo_pre = (
"#!/bin/bash\n"
)


faztudo_pos = (
"ulimit -s unlimited\n"
"make clean\n"
"make\n"
"speaker-test -t sine -f 1000 -l 1 -p20000\n"
)


cpu_on = (
"sudo echo 1 > /sys/devices/system/cpu/cpu1/online\n"
"sudo echo 1 > /sys/devices/system/cpu/cpu2/online\n"
"sudo echo 1 > /sys/devices/system/cpu/cpu3/online\n"
)


cpu_off = (
"sudo echo 0 > /sys/devices/system/cpu/cpu1/online\n"
"sudo echo 0 > /sys/devices/system/cpu/cpu2/online\n"
"sudo echo 0 > /sys/devices/system/cpu/cpu3/online\n"
)


logDir = "log/"
logFile = "myLog.txt"
prevDir = "../"
makefileDir = 'scripts/'
expDir = "last_exp/"

def write_log (msg):
  print(msg)
  with open(logDir + logFile, "a+") as f:
    f.write(f"{datetime.now()}: {msg}\n")


def getEntries():
  entries = [f for f in listdir("./test") if isfile(join("./test", f))]
  return entries


def generateEntryline(entries):
  line = "export TEST = "
  for ent in entries:
    line = line + "../test/" + ent + " "
  line = line + "\n"
  return line

def generateMakefileText(mydir, make_config, dataFormatada):
  lang = make_config.lang
  cpu = make_config.cpu
  machine = make_config.machine
  profiler = make_config.profiler
  dirs = make_config.dirs
  
  texto = f"export PROBLEM = {mydir}-{lang}-{cpu}-{profiler}-{machine}-{'-'.join(dirs)}-{dataFormatada}\n"
  
  texto  = texto + "export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2\n"
  if profiler == "perf":
    texto = texto + "export OUTPUT = 2>&1 > /dev/null\n"
  else:
    texto = texto + "export OUTPUT = > /dev/null 2>&1\n"
  entries = getEntries()
  entryline  = generateEntryline(entries)
  texto = texto + entryline
  texto = texto + "all:\n"
  texto += "\t+$(MAKE) -C " + expDir + "\n"
  texto = texto + "clean:\n\trm " + expDir + "/*.exe " + expDir + "/*.class\n"
  return texto


def createFazTudo(mydir, make_config):
  texto = faztudo_pre
  
  if make_config.cpu == "sing":
    texto += cpu_off
  else:
    texto += cpu_on
  texto += faztudo_pos
  
  with open("faztudo.sh","w") as f:
    f.write(texto) # write the data back
    f.truncate() # set the file size to the current size
  
  os.chmod("faztudo.sh", 0o775) 


def createMakefile(mydir, make_config, dataFormatada):
  texto = generateMakefileText(mydir, make_config, dataFormatada)
  with open("Makefile","w") as f:
    f.write(texto) # write the data back
    f.truncate() # set the file size to the current size


def generateexperimentdir(mydir, make_config):
  os.system('rm -rf ' + mydir + '/' + expDir)
  os.system('mkdir ' + mydir + '/' + expDir)
  lang = make_config.lang
  for x in make_config.dirs:
    cmd = 'cp ' + mydir + '/' + lang + '/' + x + '/* ' + mydir + '/' + expDir
    print(f"My cmd = {cmd}")
    os.system(cmd)


def copyMakefilesubdir(mydir, make_config):
  lang = make_config.lang
  profiler = make_config.profiler
  if lang == 'c++' and profiler == 'perf':
    cmd = 'cp ' + makefileDir + 'Makefile-perf-c++ ' + mydir + '/' + expDir + '/Makefile'
  elif lang == 'c++' and profiler == 'rapl':
    cmd = 'cp ' + makefileDir + 'Makefile-RAPL-c++ ' + mydir + '/' + expDir + '/Makefile'
  elif lang == 'java' and profiler == 'perf':
    print(f'Not supported yet. Aborting.\nmake_config = {make_config}.')
    sys.exit()
  elif lang == 'java' and profiler == 'rapl':
    cmd = 'cp ' + makefileDir + 'Makefile-RAPL-java ' + mydir + '/' + expDir + '/Makefile'
  else:
    print(f'Unrecognized experiment type. Aborting.\nmake_config = {make_config}.')
    sys.exit()

  print(f"copy make {cmd}")
  os.system(cmd)


def config_parser(parser):
  parser.add_argument('lang', choices=['c++', 'java'])
  parser.add_argument('machine', choices=['xeon', 'elite', 'think'])
  parser.add_argument('cpu', choices=['sing', 'mult'])
  parser.add_argument('profiler', choices=['rapl', 'perf'])
  parser.add_argument('dirs', nargs='+'	)


parser = argparse.ArgumentParser(description='Generate makefiles.')
config_parser(parser)
make_config = parser.parse_args()
print(make_config)

dataAtual = datetime.now()
dataFormatada = dataAtual.strftime("%d-%m-%Y-%H-%M")


if not os.path.exists(logDir):
    os.makedirs(logDir)    
write_log("Generating Makefiles")
if make_config.profiler == "perf":
  print('Measurements with PERF')
else:
  print('Measurements with RAPL')


for mydir in dirs:
  write_log("Working on " + mydir)
  os.chdir(mydir)
  createFazTudo(mydir,make_config)
  createMakefile(mydir,make_config,dataFormatada)
  os.chdir(prevDir)
  generateexperimentdir(mydir, make_config)
  copyMakefilesubdir(mydir, make_config)
write_log("Makefiles Complete")
