#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma") 
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int dp[100001];
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n,x;
    cin >> n >> x;
    vector<pair<int,int>> ws(n);
    for(auto& w : ws) cin >> w.first;
    for(auto& w : ws) cin >> w.second;
    int have=0;
    sort(ws.begin(),ws.end());
    for(auto [h,s] : ws) {
        have = min(x,have+h);
        int lim = max(0,x+1-h);
        for(int j=x-have;j<lim;j++) {
            dp[j] = max(dp[j+h]+s,dp[j]);
        }
    }
    cout << *max_element(dp,dp+x+1) << endl;
}
