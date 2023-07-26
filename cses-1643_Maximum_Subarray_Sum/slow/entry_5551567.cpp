#include <bits/stdc++.h>
 
using namespace std;
 
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> a(n);
  for(int i = 0; i < n; i++) {
    cin >> a[i];
  }
  long long sum = -1e17, ans = -1e17;
  for(int i = 0; i < n; i++) {
    if(sum < 0) {
      sum = a[i];
    }
    else {
      sum += a[i];
    }
    cerr << sum << '\n';
    ans = max(ans, sum);
  }
  cout << ans << '\n';
  return 0;
}
