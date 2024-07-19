PROBLEM = 1640-java
OUTPUT = > /dev/null 2>&1
TEST = ../test/entry07.txt ../test/entry08.txt ../test/entry09.txt ../test/entry10.txt ../test/entry11.txt ../test/entry12.txt ../test/entry16.txt ../test/entry21.txt ../test/entry22.txt ../test/entry23.txt ../test/entry24.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

