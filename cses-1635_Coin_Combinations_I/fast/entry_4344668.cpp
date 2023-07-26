#include <stdio.h>
#include <stdlib.h>
 
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
 
#include <stdio.h>
#include <stdlib.h>
 
static int mod = 1e9 + 7;
#define N 100
#define M 1000000
int c[N];
int d[M];
int n;
 
int cmp (const void *a, const void *b) {
   return (*(int *)a - *(int *)b);
}
 
int main() {
	int x, i;
	long b;
	scanf("%d %d", &n, &x);
 
	for(i = 0; i < n; i++) {
		scanf("%d", &c[i]);
	}
	qsort(c, n, sizeof(int), cmp);
 
 	d[0] = 1;
	for(int j = 1; j <= x; j++) {
		b = 0;
		for(i = 0; i < n; i++) {
			if(c[i] <= j) {
				b = b + d[j - c[i]];
			}
		}
		d[j] = b % mod;
	}
 
	printf("%ld\n", b % mod);
}