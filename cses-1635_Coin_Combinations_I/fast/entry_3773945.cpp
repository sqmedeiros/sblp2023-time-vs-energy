#ifndef LOCAL
    #pragma GCC optimize("O3,unroll-loops")
//    #pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt")
// #pragma GCC target("avx2,sse4.2,bmi,bmi2,popcnt,lzcnt")
#endif
 
#include "bits/stdc++.h"
 
#ifdef DEBUG
    #include "includes/debug/debug.hpp"
#else
    #define debug(...) 0
#endif
 
using ll = int64_t;
using ull = uint64_t;
using ld = long double;
 
using namespace std;
 
static constexpr int mod = int(1e9) + 7;
int a[100];
int dp[1'000'001];
 
int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    // cout << setprecision(20) << fixed;
    // int _tests = 1;
    // cin >> _tests;
    // for (int _test = 1; _test <= _tests; ++_test) {
    // cout << "Case #" << _test << ": ";
    constexpr auto rd = [] {
        int x;
        cin >> x;
        return x;
    };
    const int n = rd();
    const int x = rd();
    for (int i = 0; i != n; ++i) a[i] = rd();
    sort(a, a + n);
    dp[0] = 1;
    for (int i = 1; i != x + 1; ++i) {
        ll ans = 0;
        for (int j = 0; j != n; ++j)
            if (i >= a[j]) ans += dp[i - a[j]];
        dp[i] = ans % mod;
    }
    cout << dp[x] << '\n';
    // }
}
 
