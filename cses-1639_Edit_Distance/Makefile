export PROBLEM = 1639
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry09.txt ../test/entry10.txt ../test/entry11.txt ../test/entry15.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C lang
	+$(MAKE) -C slow

clean:
	rm fast/*.exe lang/*.exe slow/*.exe
