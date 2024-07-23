#include <bits/stdc++.h>
using namespace std;
 
#pragma GCC optimize "trapv"
#define ll long long
#define nline cout << "\n"
#define int ll
#define nl "\n"
#define all(x) x.begin(), x.end()
#define sz(x) (int)x.size()
#define pii pair<int, int>
#define db(str, x) cout << str << " = " << x << nline;
#define dbv(a)        for(auto it: a)cout<<it<<" "; cout << nline;
#define db1(a)        cout<<a<<"\n";
#define db2(a,b)      cout<<a<<" "<<b<<"\n";
#define db3(a,b,c)    cout<<a<<" "<<b<<" "<<c<<"\n";
#define fastio() ios_base::sync_with_stdio(false);cin.tie(0);
 
const int M = 1e9+7;
 
int dp[1000001];
 
void solve(){
    int n, target;
    cin >> n >> target;
    vector<int> v(n);
    for(int i=0; i<n; i++) cin >> v[i];
 
    // vector<vector<int>> dp(n, vector<int> (target+1));
 
    for(int i=1; i<=target; i++)
      dp[i] = 1e9;
 
    dp[0] = 0;
 
    for(int i=1; i<=target; i++){
      for(int j=0; j<n; j++){
        if(v[j] <= i){
          dp[i] = min(dp[i], 1 + dp[i-v[j]]);
        }
      }
    }
 
    cout << (dp[target] == 1000000000 ? -1 : dp[target]) << nl;
}
 
int32_t main(){
  fastio()
  #ifndef ONLINE_JUDGE
  freopen("Input.txt", "r", stdin);
  freopen("Output.txt", "w", stdout);
  #endif
 
  int t=1;
  // clock_t tStart = clock();
  // cin >> t;
  for(int tc=1; tc<=t; tc++){
    solve();
  }
 
  // cout << ((double(clock() - tStart)) / CLOCKS_PER_SEC) << nl; 
  // running time: 0.870868 ms
  
  return 0;
}