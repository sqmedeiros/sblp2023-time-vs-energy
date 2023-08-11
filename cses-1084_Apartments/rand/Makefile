compile: $(patsubst %.cpp, %.exe, $(wildcard *.cpp))

%.exe: %.cpp Makefile
	g++ $< -o $@ $(CPPFLAGS)
	sudo modprobe msr
	sudo ../../RAPL/main "./$@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.exe

