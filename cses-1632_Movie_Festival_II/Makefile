export PROBLEM = 1632-HPELITE-Os
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -Os
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry05.txt ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry12.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C lang
	+$(MAKE) -C slow

clean:
	rm fast/*.exe lang/*.exe slow/*.exe
