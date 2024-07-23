change directory in myscript (~/repository)
copy myscript to /etc/ini.d
update init jobs: sudo update-rc.d myscript defaults
create blank ToProcess.txt in ~/rouxinol
create Experiments.txt in ~/rouxinol with experiments you want to run

Experiments.txt has the following format:
language machine processor tool directory1 directory2 ...

(Example of Experiments.txt)
c++ think mult perf control-01 training-02
java elite sing rapl rand30


restart pc

