#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target("avx,avx2,fma,bmi,bmi2")
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
 
const int mod = 1000000007;
int c[100], dp[1000001] = {0};
 
int main()
{
    cin.tie(0)->sync_with_stdio(0);
    
    int n, x;
    cin >> n >> x;
    for (int i = 0; i < n; i++)
        cin >> c[i];
    sort(c, c + n);
 
    dp[0] = 1;
    for (int i = 0; i < n; i++)
        for (int j = c[i]; j <= x; j++)
            dp[j] -= mod * ((dp[j] += dp[j - c[i]]) >= mod);
 
    cout << dp[x] << '\n';
 
    return 0;
}