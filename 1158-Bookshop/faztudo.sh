#!/bin/bash
sudo echo 1 > /sys/devices/system/cpu/cpu1/online
sudo echo 1 > /sys/devices/system/cpu/cpu2/online
sudo echo 1 > /sys/devices/system/cpu/cpu3/online
ulimit -s unlimited
make clean
make
speaker-test -t sine -f 1000 -l 1 -p20000
