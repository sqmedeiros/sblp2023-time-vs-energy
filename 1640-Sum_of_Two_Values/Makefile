export PROBLEM = 1640-HPTHINK-slow-time
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry07.txt ../test/entry08.txt ../test/entry09.txt ../test/entry10.txt ../test/entry11.txt ../test/entry12.txt ../test/entry16.txt ../test/entry21.txt ../test/entry22.txt ../test/entry23.txt ../test/entry24.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C rand
	+$(MAKE) -C slow
	#+$(MAKE) -C control
	#+$(MAKE) -C rand30

clean:
	rm fast/*.exe rand/*.exe slow/*.exe control/*.exe rand30/*.exe
