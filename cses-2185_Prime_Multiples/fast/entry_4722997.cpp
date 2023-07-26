#include <bits/stdc++.h>
using namespace std;
long long n;
int k;
long long a[20];
long long ans = 0;
long long dfs(long long cur, int cnt) {
	long long c = n / cur;
	if (cnt==k-1) return c;
	for (int i = cnt+1; i < k; i++) {
		if (n / cur < a[i]) continue;
		c -= dfs(cur*a[i], i);
	}
	return c;
}
void solve() {
	cin>>n>>k;
	for (int i = 0; i < k; i++)
		cin>>a[i];
	sort(a, a+k);
	for (int i = 0; i < k; i++)
		ans += dfs(a[i], i);
	cout<<ans<<endl;
}
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.sync_with_stdio(0);
	int t = 1;
	while (t--)
		solve();
	return 0;
}
