export PROBLEM = 1640-HPELITE-java
export OUTPUT = > /dev/null 2>&1
export TEST = ../../test/entry07.txt ../../test/entry08.txt ../../test/entry09.txt ../../test/entry10.txt ../../test/entry11.txt ../../test/entry12.txt ../../test/entry16.txt ../../test/entry21.txt ../../test/entry22.txt ../../test/entry23.txt ../../test/entry24.txt

all:
	+$(MAKE) -C fast
	+$(MAKE) -C lang
	+$(MAKE) -C slow

clean:
	rm fast/*.class lang/*.class slow/*.class  
