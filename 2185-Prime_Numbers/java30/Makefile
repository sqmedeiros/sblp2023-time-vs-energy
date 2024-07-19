PROBLEM = 2185-java
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry02.txt ../test/entry03.txt ../test/entry04.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

