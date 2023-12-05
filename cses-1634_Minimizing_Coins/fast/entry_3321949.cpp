#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#pragma GCC optimize("O3,unroll-loops")
//#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
#define INF 0x3f3f3f3f
#define LLINF 0x3f3f3f3f3f3f3f3f
#define uset unordered_set
#define umap unordered_map
#define pb push_back
#define ms(a,b) memset(a,b,sizeof(a));
#define mp make_pair
#define fi first
#define se second
#define double long double
using namespace std;
using namespace __gnu_pbds;
typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> oset;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
typedef pair<double,double> pdd;
const int MM = 1e6+5;
int N, X, dp[MM];
signed main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	ms(dp,0x3f);
	dp[0] = 0;
	cin >> N >> X;
	for (int i = 1; i <= N; ++i) {
		int x;
		cin >> x;
		for (int j = x; j <= X; ++j) {
			dp[j] = min(dp[j], dp[j - x] + 1);
		}
	}
	cout << (dp[X] == INF ? -1 : dp[X]) << "\n";
}
