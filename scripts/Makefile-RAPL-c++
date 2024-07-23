compile: $(patsubst %.cpp, %.exe, $(wildcard *.cpp))

%.exe: %.cpp Makefile
	g++ $< -o $@ $(CPPFLAGS)
	sudo modprobe msr
	../../RAPL-time/main "./$@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.exe

