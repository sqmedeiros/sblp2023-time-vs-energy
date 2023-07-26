#include <iostream>
 
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
 
const int M = 1000000007;
 
int main() {
    std::ios_base::sync_with_stdio(0);
    std::cin.tie(0);
 
    int n{}, x{};
    std::cin >> n >> x;
 
    int c[100];
    for (int i{0}; i < n; i++) {
        std::cin >> c[i];
    }
 
    int dp[x+1];
    dp[0] = 1;
 
    for (int i{1}; i < x + 1; i++) {
        long long tmp{};
        for (int j{0}; j < n; j++) {
            if (i >= c[j]) {
                tmp += dp[i - c[j]];
            }
        }
        dp[i] = tmp % M;
    }
 
    std::cout << dp[x];
    return 0;
}