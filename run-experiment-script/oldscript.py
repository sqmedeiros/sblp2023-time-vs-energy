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
  "1091-Concert_Tickets",
  "1131-Tree_Diameter",
  "1132-Tree_Distances_I",
  "1190-Subarray_Sum_Queries",
  "1192-Counting_Rooms",
  "1195-Flight_Discount",
  "1197-Cycle_Finding",
  "1619-Restaurant_Customers",
  "1628-Meet_in_the_Middle",
  "1666-Building_Roads",
  "1667-Message_Route",
  "1668-Building_Teams",
  "1669-Round_Trip",
  "1671-Shortest_Routes_I",
  "1672-Shortest_Routes_II",
  "1674-Subordinates",
  "2166-Prefix_Sum_Queries"
]


toProcess = "ToProcess.txt"
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
  with open(file, 'r+') as f:
    firstLine = f.readline() # read the first line and throw it out
    data = f.read() # read the rest
    f.seek(0) # set the cursor to the top of the file
    f.write(data) # write the data back
    f.truncate() # set the file size to the current size
    return firstLine.rstrip()
  
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

#checa se o arquivo ja existe
check_file = os.path.isfile(toProcess)

if check_file == False:
   write_log("Creating file with directories to process...")
   with open(toProcess,"a+") as fapp:
     for mydir in dirs:
       fapp.write(f"{mydir}\n")
     fapp.write('Final reboot\n')
   turnXoff()
   make_beep(1)
   os.system('shutdown -r now')
elif os.stat(toProcess).st_size == 0:
  msg = "Job done."
  write_log(msg)
else:
  mydir = get_next_dir(toProcess)
  if mydir == 'Final reboot':
    write_log(mydir)
    turnXon()
    os.system(f"shutdown -r +{rebootTime}")
  else:
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
    os.system(f"shutdown -r +{rebootTime}")

