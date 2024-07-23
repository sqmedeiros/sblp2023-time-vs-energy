#include "bits/stdc++.h"
using namespace std;
 
#ifdef SEN_JUDGE
#include "debug.h"
#define debug(x...)               \
    cerr << "[" << #x << "] = ["; \
    _print(x)
#else
#define debug(x...)
#endif
 
// #define int long long
#define ll long long
#define endl '\n'
#define all(x) x.begin(), x.end()
 
const int MOD = 1e9 + 7;
 
 
 
void solve(int _tc)
{
 
    int n;
    cin >> n;
 
    map<int, long long>dp;
    map<int, vector<pair<int, int>>>mp;
 
    for(int i = 1; i <= n; i++){
        int u, v, w;
        cin >> u >> v >> w;
        u--;
        mp[v].push_back({u, w});
        dp[v] = dp[u] = 0;
    }
    long long prev = 0;
    for(auto e: dp){
        int x = e.first;
 
        for(auto i: mp[x]){
            dp[x] = max(dp[x], dp[i.first] + (ll)i.second);
        }
        dp[x] = max(dp[x], prev);
        prev = dp[x];
    }
 
    cout << prev << endl;
 
 
}
 
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t = 1;
    // cin >> t;
 
 
    for (int _tc = 1; _tc <= t; _tc++)
    {
        // cout << "Case #"<< _tc << ": ";
        solve(_tc);
    }
    return 0;
}