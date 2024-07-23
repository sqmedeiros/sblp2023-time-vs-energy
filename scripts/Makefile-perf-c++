compile: $(patsubst %.cpp, %.exe, $(wildcard *.cpp))

%.exe: %.cpp Makefile
	g++ $< -o $@ $(CPPFLAGS)
	sudo modprobe msr
	sudo python3 ../../run-experiment-script/perf-rapl.py "./$@ < "  "$(OUTPUT)" ../$(PROBLEM) $@	"$(TEST)"
		
clean:
	rm *.exe

