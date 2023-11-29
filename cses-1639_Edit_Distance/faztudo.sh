#!/bin/bash
ulimit -s unlimited
make clean
make
speaker-test -t sine -f 1000 -l 1 -p20000
