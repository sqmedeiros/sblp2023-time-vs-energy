#include <bits/stdc++.h>
using namespace std;
 
__int128 lcm(__int128 a, __int128 b) {
	if (a == 0) return b;
	return a*b/__gcd(a, b);
}
 
signed main() {
	ios::sync_with_stdio(0); cin.tie(0);
	
	long long n; int k; cin >> n >> k;
	vector<long long> a(k);
	for (int i = 0; i < k; i++) {
		cin >> a[i];
	}
 
	long long ans = 0;
	for (int i = 1; i < (1 << k); i++) {
		__int128 g = 0;
		for (int j = 0; j < k; j++) {
			if (i & (1 << j)) {
				g = lcm(g, (__int128)a[j]);
				if (g > n) break;
			}
		}
		if (g > n) continue;
 
		if (__builtin_popcount(i) % 2) ans += n/g;
		else ans -= n/g;
	}
	cout << ans << '\n';
	
	return 0;
}
