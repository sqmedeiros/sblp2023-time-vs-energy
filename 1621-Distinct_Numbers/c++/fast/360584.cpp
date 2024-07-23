#include <cstdio>
#include <algorithm>
 
template <typename T> void scan(T &angka) {
	T kali = 1;angka = 0;char input = getchar_unlocked();
	while(!(48 <= input && input <= 57)) { if(input == '-') kali = -1; input = getchar_unlocked();}
	while((48 <= input && input <= 57)) angka = (angka << 3) + (angka << 1) + input - 48, input = getchar_unlocked(); angka *= kali;
}
 
int main() {
	int n;
	scan(n);
	
	int inp[n + 3];
	int count = 1;
	
	for(int i = 1; i <= n; ++i)
		scan(inp[i]);
	
	std::sort(inp + 1, inp + n + 1);
	
	for(int i = 2; i <= n; ++i) {
		if(inp[i] != inp[i - 1])
			++count;
	}
	printf("%d", count);
}