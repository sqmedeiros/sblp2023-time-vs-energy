PROBLEM = 1084-java
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry05.txt ../test/entry06.txt ../test/entry07.txt ../test/entry08.txt ../test/entry13.txt ../test/entry14.txt ../test/entry15.txt ../test/entry16.txt ../test/entry17.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

