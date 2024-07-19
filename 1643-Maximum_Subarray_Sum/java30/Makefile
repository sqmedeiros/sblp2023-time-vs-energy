PROBLEM = 1643-java
OUTPUT = > /dev/null 2>&1
TEST = ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry09.txt ../test/entry10.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

