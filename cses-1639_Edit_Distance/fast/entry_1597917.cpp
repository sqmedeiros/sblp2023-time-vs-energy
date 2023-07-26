#include <bits/stdc++.h>
 
using namespace std;
 
using ll = long long;
 
void solve() {
	string s, t;
	cin >> s >> t;
	vector<int> dp(t.size() + 1), pdp(t.size() + 1);
	iota(begin(pdp), end(pdp), 0);
	for (int i = 0; i < (int)s.size(); ++i) {
		dp[0] = i + 1;
		for (int j = 0; j < (int)t.size(); ++j) {
			dp[j + 1] = min({pdp[j] - (s[i] == t[j]), pdp[j + 1], dp[j]}) + 1;
		}
		pdp = dp;
	}
	cout << dp.back();
}
 
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
 
	solve();
 
	return 0;
}