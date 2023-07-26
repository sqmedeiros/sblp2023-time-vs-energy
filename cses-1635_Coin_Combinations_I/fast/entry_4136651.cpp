#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
 
int main() {
    std::ios_base::sync_with_stdio(0);
    std::cin.tie(0);
    int M = 1000000007;
    int n,x;
    std::cin >> n >> x;
    int coins[n];
    for (int i = 0; i<n; i++) std::cin >> coins[i];
    int dp[x+1];
    dp[0]=1;
    //for (int i : coins) dp[i]=1;
    for (int i = 1; i<=x; i++) {
        long long t{};
        for (int j = 0; j<n; j++) {
            if (coins[j]<=i) {
                t+=dp[i-coins[j]];
            }
        }
        dp[i] = t%M;
    }
    std::cout << dp[x];
}