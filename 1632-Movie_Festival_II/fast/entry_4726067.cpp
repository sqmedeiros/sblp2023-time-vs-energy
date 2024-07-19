#include <stdio.h>
#include <stdlib.h>
 
#define N 200000
#define T 1000000000
 
int cmp(const void *a, const void *b) {
    return *(int *)a - *(int *)b;
}
 
static inline int getint() {
    int x, y;
    while((x = getchar_unlocked()) < '0') {}
    x -= '0';
    while((y = getchar_unlocked()) >= '0') { x = x * 10 + y - '0'; }
    return x;
}
 
// Credit for idea: https://travisdowns.github.io/blog/2019/05/22/sorting.html
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
    static int t[N * 2];
    static int s[N * 2 + 1], sn[N * 2 + 1];
    static long tmp[N * 2];
 
    int n = getint(), k = getint();
 
    for(int i = 0; i < n * 2;) {
        t[i++] = getint();
        t[i++] = getint();
    }
 
    // qsort(t, n, sizeof(int) * 2, cmp); // sorted by starting time
    radix_sort((long *)t, n, tmp);
 
    s[0] = T + 1;
    for(int i = 1; i <= k; i++) {
        s[i] = T;
        sn[i] = i;
    }
    for(int i = k + 1; i <= n + k; i++) {
        sn[i] = i;
    }
 
    //Allocate movie to the member with the earliest start time that comes after this finish time
 
    int r = 0;
    for(int i = (n * 2) - 2; i >= 0; i -= 2) {
        // Find smallest s[j] >= t[i + 1]
        int j = 0, p = 1 << 17;
        while(p) {
            if(j + p < k + r + 1 && s[j + p] >= t[i + 1]) {
                j += p;
            }
            p /= 2;
        }
 
        // If s[j] has been 'deleted', find predecessor
        while(sn[j] != j) {
            sn[j] = sn[sn[j]];
            j = sn[sn[j]];
        }
 
        if(j != 0) {
            s[k + r + 1] = t[i];
            sn[j] = sn[j - 1];
            r++;
        }
    }
 
    printf("%d\n", r);
}