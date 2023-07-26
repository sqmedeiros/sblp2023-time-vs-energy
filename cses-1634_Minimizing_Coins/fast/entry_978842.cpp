//{{{
#pragma GCC diagnostic ignored "-Wunknown-pragmas"
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
typedef vector<int> vi;
typedef pair<int, int> pii;
#define sz(x) (int)((x).size())
#define pb push_back
#define all(x) (x).begin(), (x).end()
#define clr(a, b) memset(a, b, sizeof(a))
#ifdef LOCAL
#include "prettyprint.hpp"
#endif
// clang-format off
void _print() { cerr << "]\033[0m\n"; }
template <typename T> void __print(T x) { cerr << x; }
template <typename T, typename... V> void _print(T t, V... v) { __print(t); if (sizeof...(v)) cerr << ", "; _print(v...); }
#ifdef LOCAL
#define debug(x...) cerr << "\033[1;34m[" << #x << "] = \033[1;32m["; _print(x)
#define debug_arr(x...) cerr << "\033[1;34m[" << #x << "] = \033[1;32m" << (x) << "\033[0m\n"
#else
#define debug(x...)
#define debug_arr(x...)
#endif
// clang-format on
//}}}
 
const int N = 1e6 + 10;
const int mod = 1e9 + 7;
const int inf = 0x3f3f3f3f;
 
int n, x;
int a[N];
int dp[N];
 
int main()
{
#ifdef LOCAL
    freopen("in", "r", stdin);
    // freopen("out", "w", stdout);
#endif
 
    while (cin >> n >> x)
    {
        clr(dp, 0x3f);
        dp[0] = 0;
 
        for (int i = 1; i <= n; ++i)
        {
            cin >> a[i];
            for (int v = a[i]; v <= x; v++)
            {
                dp[v] = min(dp[v - a[i]] + 1, dp[v]);
            }
        }
        if (dp[x] == 0x3f3f3f3f) dp[x] = -1;
        cout << dp[x] << endl;
    }
 
    return 0;
}