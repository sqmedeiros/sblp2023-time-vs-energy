#include <bits/stdc++.h>
 
using namespace std;
 
#define f first
#define s second
 
long long mul(long long x, long long y, long long mod) {
    long long ret = 0;
    while (y) {
        if (y & 1) {
            ret += x;
            ret %= mod;
        }
        x *= 2;
        x %= mod;
        y /= 2;
    }
    return ret;
}
 
long long suma(long long x, long long y, long long mod) {
    if (x % 2 == 0)
        x = mul(x / 2, x + 1, mod);
    else
        x = mul(x, (x + 1) / 2, mod);
    if (y % 2 == 0)
        y = mul(y / 2, y + 1, mod);
    else
        y = mul(y, (y + 1) / 2, mod);
    return (y - x + mod) % mod;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    long long n, ans = 0, mod = 1e9 + 7;
    cin >> n;
    long long k = sqrt(n), p;
    for (long long i = 1; i <= n; i++) {
        ans += i * suma(n / (i + 1), n / i, mod);
        ans %= mod;
        if (n / (i + 1) <= k) {
            p = n / (i + 1);
            break;
        }
    }
    for (long long i = 1; i <= p; i++) {
        ans += i * (n / i);
        ans %= mod;
    }
    cout << ans;
    return 0;
}
