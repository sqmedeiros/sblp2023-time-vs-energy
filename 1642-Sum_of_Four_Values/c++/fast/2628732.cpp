#include <bits/stdc++.h>
using namespace std;
#define int long long
#define sz(x) ((int)(x).size())
#define debug(x) cout << #x << " ------> " << x << "\n"
 
const int N = 5e3 + 5, mod = 998244353;
int nums[N], id[N];
 
vector<int> N_sum(int i, int j, int n, int tot) {
    if (n == 1) {
        int pos = lower_bound(nums + i, nums + j + 1, tot) - nums;
        if (nums[pos] == tot) return {id[pos]};
    } else if (n == 2) {
        int l = i, r = j;
        while (l < r and nums[r] + nums[r - 1] >= tot and nums[l] + nums[l + 1] <= tot) {
            int cur_sum = nums[l] + nums[r];
            if (cur_sum == tot)
                return {id[l], id[r]};
            else if (cur_sum > tot)
                r--;
            else
                l++;
        }
        return {};
    } else {
        for (int k = i + n - 1; k <= j; k++) {
            vector<int> ans = N_sum(i, k - 1, n - 1, tot - nums[k]);
            if (ans.size()) {
                ans.push_back(id[k]);
                return ans;
            }
        }
    }
    return {};
}
void solve() {
    int n, target;
    cin >> n >> target;
    vector<pair<int, int>> arr(n);
 
    for (int i = 0; i < n; i++) {
        cin >> arr[i].first;
        arr[i].second = i + 1;
    }
 
    sort(arr.begin(), arr.end());
 
    for (int i = 0; i < n; i++) nums[i] = arr[i].first, id[i] = arr[i].second;
 
    vector<int> ans = N_sum(0, n - 1, 4, target);
 
    if (ans.size() == 0)
        cout << "IMPOSSIBLE";
    else
        for (int &x : ans) cout << x << ' ';
}
 
signed main() {
    ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin), freopen("output.txt", "w", stdout);
#endif
    int T = 1;
    // cin >> T;
    for (int i = 1; i <= T; i++) {
        solve();
        // cout << solve() << '\n';
    }
}
