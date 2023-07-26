#include <stdio.h>
 
#define N 200000
 
#define MAX(a, b) (((a) > (b)) ? (a) : (b))
 
static inline int getint() {
    int x, y;
    while((x = getchar_unlocked()) < '0') {}
    x -= '0';
    while((y = getchar_unlocked()) >= '0') { x = x * 10 + y - '0'; }
    return x;
}
 
void radix_sort(long *x, int n, long *t) {
    static int freq[4][256];
    static long *qp[256];
    long *src, *dst;
 
    for(int i = 0; i < n; i++) {
        long v = x[i];
        for(int p = 0; p < 4; p++) {
            freq[p][v & 0xff]++;
            v >>= 8;
        }
    }
 
    for(int p = 0; p < 4; p++) {
        src = (p & 1) ? t : x;
        dst = (p & 1) ? x : t;
 
        qp[0] = dst;
        for(int i = 1; i < 256; i++) {
            qp[i] = qp[i - 1] + freq[p][i - 1];
        }
 
        for(int i = 0; i < n; i++) {
            int b = (src[i] >> (p * 8)) & 0xff;
            *qp[b]++ = src[i];
            __builtin_prefetch(qp[b] + 1);
        }
    }
}
 
int main() {
	static int ab[N * 4], t[N * 4];
	static int a[N], b[N], p[N];
	static long m[N * 2]; // max ammount of money to be made by day N (compressed index)
	int n = getint();
 
	for(int i = 0, j = 0; i < n; i++) {
		a[i] = getint();
		b[i] = getint();
		p[i] = getint();
 
		// Use LSB to indicate start or finish time
		// (also causes start times to come before equal finish times when sorting)
		ab[j++] = a[i] * 2;
		ab[j++] = i;
		ab[j++] = b[i] * 2 + 1;
		ab[j++] = i;
	}
 
	// for(int i = 0; i < n * 4; i++) {
	// 	printf("%d ", ab[i]);
	// }
	// printf("\n");
 
	// Step 1: Rewrite a[i], b[i] with compressed indices
	radix_sort((long *)ab, n * 2, (long *)t);
 
	// for(int i = 0; i < n * 4; i++) {
	// 	printf("%d ", ab[i]);
	// }
	// printf("\n");
 
	for(int j = 0, k = 0; j < n * 4; j += 2, k++) {
		if(ab[j] & 1) {
			b[ab[j + 1]] = k;
		} else {
			a[ab[j + 1]] = k;
		}
	}
 
	// for(int i = 0; i < n; i++) {
	// 	printf("%d %d %d\n", a[i], b[i], p[i]);
	// }
 
	// Step 2: DP
	for(int j = 0, k = 0; j < n * 4; j += 2, k++) {
		m[k] = MAX(m[k], m[k - 1]);
		if((ab[j] & 1) == 0) {
			int i = ab[j + 1];
			m[b[i]] = MAX(m[b[i]], m[a[i]] + p[i]);
		}
		// for(int i = 0; i < n * 2; i++) {
		// 	printf("%ld ", m[i]);
		// }
		// printf("\n");
	}
 
	printf("%ld\n", m[n * 2 - 1]);
}