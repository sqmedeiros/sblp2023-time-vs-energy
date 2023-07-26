#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pi;
#define all(a) a.begin(), a.end()
const int Mod = 1e9 + 7;
 
int main() {
	string a, b;
	cin >> a >> b;
	// transform a to b.
	int n = a.size();
	int m = b.size();
	const int INF = 1e9;
 
	vector<vector<int>> dp(n + 1, vector<int>(m + 1, -1));
	function<int(int, int)> solve = [&] (int n, int m) {
		if (n == 0) return m;
		if (m == 0) return n;
		if (dp[n][m] != -1) return dp[n][m];
		if (a[n - 1] == b[m - 1]) return solve(n - 1, m - 1);
		int ans = INF;
		ans = min(ans, 1 + solve(n, m - 1));
		ans = min(ans, 1 + solve(n - 1, m - 1));
		ans = min(ans, 1 + solve(n - 1, m));
		return dp[n][m] = ans;
	};
	cout << solve(n, m) << "\n";
    return 0;
}