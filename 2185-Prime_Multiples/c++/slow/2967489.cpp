#pragma GCC target("popcnt")
#include <bits/stdc++.h>
 
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
 
using namespace std;
using namespace __gnu_pbds;
 
typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> ordered_set;
typedef long long li;
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    li n, k;
    cin >> n >> k;
 
    vector<li>a(k);
    for (int i = 0; i < k; i++) {
        cin >> a[i];
    }
 
    li ans = 0;
    for (int mask = 1; mask < (1 << k); ++mask) {
        li num = 1;
	bool bad = false;
        for (int i = 0; i < k; i++) {
            if (mask >> i & 1) {
		if (1.0 * num > 1.0 * n / a[i]) {
			bad = true;
			break;
		}
                num /= __gcd(num, a[i]);
                num *= a[i];
            }
        }
 	if (bad) continue;
        li sign = (__builtin_popcount(mask) & 1) ? 1 : -1;
        ans += sign * n / num;
    }
 
    cout << ans;
    return 0;
}
