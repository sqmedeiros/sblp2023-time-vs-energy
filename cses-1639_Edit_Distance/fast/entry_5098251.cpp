/* *
 * It's fine, it's okay
 * I'll die anyway
 * */
 
#include <bits/stdc++.h>
using namespace std;
 
typedef pair <int, int> pii;
#define s second
#define f first
#define ll long long
 
const ll Mod = 1e9 + 7;
const int N = 5e3 + 100;
 
string a, b;
ll n, m, dp[2][N];
 
void input() {
        cin >> a >> b;
        n = a.size(), m = b.size();
}
 
void solve() {
        iota(dp[0], dp[0] + n + 1, 0);
        for (int i = 1; i <= m; i++) {
                dp[i & 1][0] = i;
                for (int j = 1; j <= n; j++) {
                        dp[i & 1][j] = min(dp[(i & 1) ^ 1][j - 1] + (a[j - 1] != b[i - 1]), min(dp[i & 1][j - 1] + 1, dp[(i & 1) ^ 1][j] + 1));
                }
        }
        cout << dp[m & 1][n] << '\n';
}
 
signed main() {
        ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
        input();
        solve();
        return 0;
}