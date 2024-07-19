PROBLEM = 1071-java
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry01.txt ../test/entry02.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
#	sudo modprobe msr
#	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

