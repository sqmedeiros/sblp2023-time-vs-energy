#include<stdio.h>
#include<stdlib.h>
#pragma GCC optimize ("O3")
#pragma GCC target ("avx,avx2")
#pragma GCC optimize ("unroll-loops")
static int h[1000];
static int s[1000];
static int v[100001];
 
int main(void) {
    int n, x;
    scanf("%d%d", &n, &x);
    for (int i = 0; i < n; ++i){
        scanf("%d", h+i);
    }
    for (int i = 0; i < n; ++i){
        scanf("%d", s+i);
    }
    for (int i = 0; i < n; ++i){
        for (int j = x; j >= h[i]; --j){
            int rm = s[i] + v[j - h[i]];
            v[j] = v[j] > rm ? v[j] : rm;
        }
    }
    printf("%d\n", v[x]);
    return EXIT_SUCCESS;
}