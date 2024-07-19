export PROBLEM = 1071-HPTHINK-slow-time
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry01.txt ../test/entry02.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C rand
	+$(MAKE) -C slow
	#+$(MAKE) -C control
	#+$(MAKE) -C rand30

clean:
	rm fast/*.exe rand/*.exe slow/*.exe control/*.exe rand30/*.exe
