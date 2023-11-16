export PROBLEM = 1084-HPTHINK-control-time
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry05.txt ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry13.txt ../test/entry14.txt ../test/entry15.txt ../test/entry16.txt ../test/entry17.txt

all:
	#+$(MAKE) -C fast
	#+$(MAKE) -C rand
	#+$(MAKE) -C slow
	+$(MAKE) -C control

clean:
	rm fast/*.exe rand/*.exe slow/*.exe control/*.exe
