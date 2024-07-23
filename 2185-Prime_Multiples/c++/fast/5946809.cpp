#include <bits/stdc++.h>
using namespace std;
#define l(i,o,n) for(int i=o;i<n;i++)
typedef long long ll;
ll n, ans = 0; int k;
vector <ll> primes;
void REC (int i, ll mult, bool b) {
  if (i == k) {
    if (b) ans += mult;
    else ans -= mult;
    return;
  }
  REC(i+1, mult, b);
  REC(i+1, mult / primes[i], !b);
}
int main() {
  cin >> n >> k;
  l(i,0,k) {
    ll z; cin >> z; primes.push_back(z);
  }
  REC(0,n,0);
  cout << ans + n;
}
