#include <bits/stdc++.h>
 
using namespace std;
 
int main(int argc, char const *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  int k;
  long long n, ans = 0;
  cin >> n >> k;
  vector<long long> a(k);
  for(auto &u: a) cin >> u;
  for(int i = 1; i < (1 << k); ++i) {
    bitset<25> x(i);
    long long s = 1;
    for(int j = 0; j < k; ++j)
      if (x[j]) {
        long long y = gcd(s, a[j]);
        if (1.0 * s / y > 1.0 * n / a[j]) s = n + 1;
        else s = lcm(s, a[j]);
      }
    if (__builtin_popcount(i) & 1)
      ans += n / s;
    else
      ans -= n / s;
  }
  cout << ans << endl;
  return 0;
}
