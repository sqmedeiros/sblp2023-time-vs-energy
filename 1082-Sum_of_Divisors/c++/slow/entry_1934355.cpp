#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
typedef vector<ll> vi;
 
ll n;
const ll mod = 1e9 + 7;
 
inline bool Ok(ll i, ll q) {
    return n / i >= q;
}
 
ll FindLast(ll i) {
    ll q = n / i;
    ll begin = i, end = n + 1, mid, ans;
    while (begin < end) {
        mid = (begin + end) / 2;
        if (Ok(mid, q)) {
            ans = mid;
            begin = mid + 1;
        } else end = mid;
    }
    return ans;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    ll ans = 0;
    for (ll i = 1, j; i <= n; i = j + 1) {
        j = FindLast(i);
        ll add;
        if ((j - i + 1) & 1) {
            add = (((i + j) / 2) % mod * ((j - i + 1) % mod)) % mod;
        } else {
            add = (((j - i + 1) / 2) % mod * ((i + j) % mod)) % mod;
        }
        add *= (n / i) % mod;
        add %= mod;
        ans += add;
        ans %= mod;
    }
    cout << ans;
}
