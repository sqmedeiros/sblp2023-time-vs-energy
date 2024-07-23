#include <bits/stdc++.h>
#define pb push_back
#define all(x) x.begin(),x.end()
using namespace std;
 
using ll = long long;
const char nl = '\n';
const int MAXN = 1e5 + 5;
const ll mod = 1e9 + 7;
const int MAXX = 1e6 + 5;
 
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	ll n;
	int k;
	cin >> n >> k;
	vector<ll> v(k);
	for (ll &c : v) cin >> c;
	ll ans = 0;
	for (int i = 1; i < (1<<k); i++) {
		ll nb = 1;
		for (int j = 0; j < k; j++)
			if ((1<<j)&i) {
				if (log(nb)+log(v[j]) > log(n)) nb = n+1;
				else nb *= v[j];
			}
		ans += (__builtin_popcount(i)%2? 1 : -1) * n/nb;
	}
	cout << ans;
	return 0;
}
