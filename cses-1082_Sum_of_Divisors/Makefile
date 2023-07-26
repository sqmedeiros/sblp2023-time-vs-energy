export PROBLEM = 1082
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -Os
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry11.txt ../test/entry12.txt ../test/entry13.txt ../test/entry14.txt ../test/entry15.txt ../test/entry17.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C lang
	+$(MAKE) -C slow

clean:
	rm fast/*.exe lang/*.exe slow/*.exe
