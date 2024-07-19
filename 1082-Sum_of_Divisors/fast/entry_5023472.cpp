#include <bits/stdc++.h>
using namespace std;
const int mod = (int)1e9 + 7;
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(false), cin.tie(nullptr);
  long long n;
  cin >> n;
  long long ans = 0, sn = sqrt(n);
  for (int i = 1; i <= sn; ++i) {
    long long x = (n/i)%mod;
    ans += i*x + ((sn + x + 1) * (x - sn))/2;
    ans %= mod;
  }
  cout << ans << '\n';
  return 0;
}
