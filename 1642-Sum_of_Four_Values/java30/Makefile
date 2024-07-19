PROBLEM = 1642-java
OUTPUT = > /dev/null 2>&1
export TEST = ../test/entry09.txt ../test/entry10.txt ../test/entry11.txt ../test/entry12.txt ../test/entry13.txt ../test/entry14.txt ../test/entry17.txt ../test/entry18.txt ../test/entry19.txt ../test/entry23.txt ../test/entry26.txt

compile: $(patsubst %.java, %, $(wildcard *.java))

%: %.java Makefile
	javac $<
	sudo modprobe msr
	sudo ../../RAPL/main "java $@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.class

