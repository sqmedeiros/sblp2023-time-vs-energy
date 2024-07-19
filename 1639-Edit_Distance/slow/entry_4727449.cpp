#include <bits/stdc++.h>
using namespace std;
#define int long long
using ii = pair<int, int>;
#define F first
#define S second
#define IOS                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);
int mod = 1e9 + 7;
string s, t;
int n, m;
int dp[5001][5001];
int rec(int i, int j)
{
    if (i == n)
        return m - j;
    if (j == m)
        return n - i;
    if (dp[i][j] != -1)
        return dp[i][j];
    int ans = 1 + min({rec(i, j + 1), rec(i + 1, j), rec(i + 1, j + 1)});
    if (s[i] == t[j])
    {
        ans = min(ans, rec(i + 1, j + 1));
    }
    return dp[i][j] = ans;
}
void solve()
{
    cin >> s >> t;
    n = (int)s.size();
    m = (int)t.size();
    memset(dp, -1, sizeof(dp));
    cout << rec(0, 0) << "\n";
}
signed main()
{
    IOS;
    int t = 1;
    // cin >> t;
    for (int i = 1; i <= t; i++)
    {
        // cout << "Case #" << i << " ";
        solve();
    }
    return 0;
}