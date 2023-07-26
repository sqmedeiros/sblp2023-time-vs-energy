export PROBLEM = 2185
export CPPFLAGS = -DONLINE_JUDGE -std=c++17 -O2
export OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry02.txt ../test/entry03.txt ../test/entry04.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C lang
	+$(MAKE) -C slow

clean:
	rm fast/*.exe lang/*.exe slow/*.exe
