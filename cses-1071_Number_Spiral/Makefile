export PROBLEM = 1071
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry01.txt ../test/entry02.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C rand
	+$(MAKE) -C slow

clean:
	rm fast/*.exe rand/*.exe slow/*.exe
