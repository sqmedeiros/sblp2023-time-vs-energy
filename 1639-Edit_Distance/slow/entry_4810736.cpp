#include <bits/stdc++.h>
 
using namespace std;
typedef pair <int, int> ii;
#define int long long
 
 
int n, m;
string s, t;
const int mx = 5123;
int dp[mx][mx];
 
int solve (int a, int b) {
  if (a == n && b == m) return 0;
  if (a == n) return m-b;
  if (b == m) return n-a;
  int &ans = dp[a][b];
  if (~ans) return ans;
  ans = n+m;
  if (s[a] == t[b]) ans = solve (a+1, b+1);
  else ans = min(ans, 1 + min(solve (a+1, b+1), min(solve (a+1, b), solve (a, b+1))));
  return ans;
}
 
int32_t main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> s >> t;
  memset(dp, -1, sizeof dp);
  n = s.size(), m = t.size();
 
  cout << solve(0, 0) << endl;
}