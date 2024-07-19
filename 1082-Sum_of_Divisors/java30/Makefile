PROBLEM = 1082-HPELITE-java-single
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry11.txt ../test/entry12.txt ../test/entry13.txt ../test/entry14.txt ../test/entry15.txt ../test/entry17.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

