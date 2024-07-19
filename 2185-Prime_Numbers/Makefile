export PROBLEM = 2185-HPELITE-control20-time
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry02.txt ../test/entry03.txt

all:
	#+$(MAKE) -C fast
	#+$(MAKE) -C rand
	#+$(MAKE) -C slow
	#+$(MAKE) -C control
	#+$(MAKE) -C rand30
	+$(MAKE) -C control20

clean:
	rm fast/*.exe rand/*.exe slow/*.exe control/*.exe rand30/*.exe control20/*.exe
