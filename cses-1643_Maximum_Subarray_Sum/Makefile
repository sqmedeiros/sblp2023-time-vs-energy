export PROBLEM = 1643-HPTHINK-control
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry09.txt ../test/entry10.txt

all:
	#+$(MAKE) -C fast
	#+$(MAKE) -C rand
	#+$(MAKE) -C slow
	+$(MAKE) -C control

clean:
	rm fast/*.exe rand/*.exe slow/*.exe control/*.exe
