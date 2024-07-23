#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long LL;
 
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
 
  int T = 1;
  // cin >> T;
  for (int t_ = 0, n, m; t_ < T && cin >> n >> m; ++t_) {
    vector<pair<int, int>> a(n);
    for (int i = 0; i < n && cin >> a[i].first; ++i) a[i].second = i + 1;
    sort(a.begin(), a.end());
    if (a.front().first * 4LL > m || a.back().first * 4LL < m) {
      cout << "IMPOSSIBLE" << '\n';
      continue;
    }
    function<vector<int>()> go = [&]() -> vector<int> {
      unordered_map<int, pair<int, int>> c;
      for (int i = 0; i < n && a[i].first * 2LL + a[0].first * 2 <= m; ++i) {
        for (int j = i + 1; j < n && a[i].first + a[j].first + a[0].first * 2LL <= m; ++j) {
          int x = m - a[i].first - a[j].first;
          auto it = c.find(x);
          if (it != c.end()) {
            return {it->second.first, it->second.second, a[i].second, a[j].second};
          }
        }
        for (int j = 0; j < i && a[j].first + a[i].first * 3LL <= m; ++j) {
          c[a[j].first + a[i].first] = {a[j].second, a[i].second};
        }
      }
      return {};
    };
    vector<int> ans = go();
    if (ans.empty()) cout << "IMPOSSIBLE";
    else cout << ans[0] << ' ' << ans[1] << ' ' << ans[2] << ' ' << ans[3] << '\n';
  }
 
  return 0;
}
