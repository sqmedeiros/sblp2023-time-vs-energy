compile: $(patsubst %.cpp, %.exe, $(wildcard *.cpp))

%.exe: %.cpp Makefile
	g++ $< -o $@ $(CPPFLAGS)
	sudo modprobe msr
	../../RAPL/main "./$@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	#../../RAPL-time/main "./$@ < "  "$(TEST)" "$(OUTPUT)" ../$(PROBLEM) $@	
	
clean:
	rm *.exe

