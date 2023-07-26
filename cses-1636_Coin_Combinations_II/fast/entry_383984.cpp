#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
#include <stdio.h>
#include <string.h>
#define MOD 1000000007
#define MAX_X 1000000
int n, x, ci;
int dp[MAX_X + 1];
int main() {
    dp[0] = 1;
    scanf("%d %d", &n, &x);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &ci);
        for (int j = ci; j <= x; ++j) {
            dp[j] += dp[j - ci];
            if (dp[j] >= MOD)
                dp[j] -= MOD;
        }
    }
    printf("%d\n", dp[x]);
}