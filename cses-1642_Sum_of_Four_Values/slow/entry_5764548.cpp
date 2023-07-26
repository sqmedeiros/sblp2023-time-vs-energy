#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <random>
#include <bitset>
#include <assert.h>
#include <algorithm>
#include <list>
#include <set>
#include <map>
 
using namespace std;
typedef long long ll;
typedef unsigned int uint;
typedef unsigned long long ull;
 
#define all(a) (a).begin(), (a).end()
#define rall(a) (a).rbegin(), (a).rend()
 
const ll inf = (ll)1e16;
const int maxn = (int)2e5 + 10;
 
void solve() {
	ll n, x;
	cin >> n >> x;
	map<ll, vector<pair<ll, int>>> q;
	vector<ll> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			q[a[i] + a[j]].push_back({ i, j });
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			ll sum = a[i] + a[j];
			for (auto& [k, p] : q[x - sum]) {
				if (k == i || k == j || p == i || p == j) continue;
				cout << i + 1 << " " << j + 1 << " " << k + 1 << " " << p + 1 << '\n';
				return;
			}
			q[x - sum].clear();
		}
	}
	cout << "IMPOSSIBLE\n";
}
 
signed main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int t = 1;
	//cin >> t;
	while (t--) {
		solve();
	}
 
	return 0;
}
