#include <bits/stdc++.h>
 
#define eq(a, b) (abs(a - b) < EPS)
#define lt(a, b) ((a + EPS) < b)
#define gt(a, b) (a > (b + EPS))
#define le(a, b) (a < (b + EPS))
#define ge(a, b) ((a + EPS) > b)
 
using namespace std;
 
using ll = long long int;
using ld = long double;
using ii = pair<int, int>;
using vii = vector<ii>;
using vi = vector<int>;
using graph = vector<vi>;
using wgraph = vector<vii>;
 
const int INF = 1e9+7;
const ll mod = 1000000007;
const double EPS = 1e-9;
const int MAXN = 5e3 + 6;
 
int dp[2][MAXN];
int main() {
    string a, t;
    cin >> a >> t;
    int n = a.size();
    int m = t.size();
 
    for (int i = 0; i <= m; ++i) {
        dp[0][i] = i;
    }
    for (int i = 1, b; i <= n; ++i) {
        b = i&1;
        dp[b][0] = i;
        for (int j = 1; j <= m; ++j) {
            dp[b][j] = 1 + min(dp[b][j-1], dp[b^1][j]);
            dp[b][j] = min(dp[b][j], dp[b^1][j-1] + int(a[i-1] != t[j-1]));
        }
    }
    cout << dp[n&1][m] << '\n';
}