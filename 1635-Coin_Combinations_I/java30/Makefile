PROBLEM = 1635-java
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry04.txt ../test/entry05.txt ../test/entry08.txt ../test/entry11.txt ../test/entry12.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

