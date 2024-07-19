#include <stdio.h>
 
#define N 5000
#define MIN(a, b) (((a) < (b)) ? (a) : (b))
 
int main() {
	char a[N + 2], b[N + 2];
	static int c[N + 1];
	int r;
 
	scanf("%s %s", a, b);
 
	for(int j = 0; b[j]; j++) {
		c[j + 1] = j + 1;
	}
 
	for(int i = 0; a[i]; i++) {
		int p = c[0]++;
		for(int j = 0; b[j]; j++) {
			int q = c[j + 1];
			r = c[j + 1] = MIN(MIN(c[j + 1] + 1, p + (a[i] != b[j])), c[j] + 1);
			p = q;
		}
	}
 
	printf("%d\n", r);
}