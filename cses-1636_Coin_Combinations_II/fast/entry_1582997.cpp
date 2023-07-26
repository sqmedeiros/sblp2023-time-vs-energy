#pragma GCC optimize("Ofast", "unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx")
#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;
using ld = long double;
 
const int mod = 1e9 + 7;
 
ll binpow(ll a, ll p) {
    ll res = 1;
    while (p) {
        if (p & 1) {
            (res *= a) %= mod;
        }
        p >>= 1;
        (a *= a) %= mod;
    }
    return res;
}
 
const int N = 101;
const int M = 1e6 + 3;
 
int a[N];
int dp[M];
 
void solve() {
    int n, x;
    cin >> n >> x;
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
 
    dp[0] = 1;
    for (int j = 0; j < n; j++) {
        int* t = dp;
        for (int i = a[j]; i <= x; i++) {
            dp[i] += *(t++);
            if (dp[i] >= mod) dp[i] -= mod;
        }
    }
    cout << dp[x] << '\n';
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int T = 1;
    // cin >> T;
    for (int tc = 1; tc <= T; tc++) {
        // cout << "Case #" << tc << ": ";
        solve();
    }
    return 0;
}