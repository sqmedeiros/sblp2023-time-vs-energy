copy myscript to /etc/ini.d
change directory in myscript (~/rouxinol)
update init jobs: sudo update-rc.d myscript defaults
create blank ToProcess.txt in ~/rouxinol
create Experiments.txt in ~/rouxinol with experiments you want to run

Experiments.txt has the following format:
language machine processor tool directory1 directory2 ...

(Example of Experiments.txt)
c++ think mult rapl control-01
java elite sing perf training-02 rand30


restart pc

