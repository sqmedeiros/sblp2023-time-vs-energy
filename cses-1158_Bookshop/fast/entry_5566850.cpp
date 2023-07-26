#pragma GCC optimize("Ofast,unloop-rolls")
#pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt,fma,tune=native")
#include <bits/stdc++.h>
 
using namespace std;
 
const int N = 1e3 + 5;
const int X = 1e5 + 5;
 
int n , x , h[N] , s[N] , dp[X];
 
void maximize(int &a , int b) {
    if (a < b) a = b;
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> x;
    for (int i = 1 ; i <= n ; ++i)
        cin >> h[i];
    for (int i = 1 ; i <= n ; ++i)
        cin >> s[i];
    for (int i = 1 ; i <= n ; ++i)
        for (int j = x ; j >= h[i] ; --j)
            maximize(dp[j] , dp[j - h[i]] + s[i]);
    // for (int i = 1 ; i <= x ; ++i)
        // cout << dp[i] << ' ' ; cout << '\n';
    cout << dp[x];
}