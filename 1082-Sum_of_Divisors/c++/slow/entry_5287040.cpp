#include <bits/stdc++.h>
 
#define PI 3.14159265358979323846
 
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define pb push_back
#define eb emplace_back
#define vec vector
 
using ll = long long;
using ull = unsigned long long;
using namespace std;
 
#ifndef LOCAL 
 
#pragma GCC optimize ("O3")
#define debug(...)
 
#else 
 
#include "../../debug.cpp"
 
#endif 
 
template<ll M>
struct modint {
 
    static ll _pow(ll n, ll k) {
        ll r = 1;
        for (; k > 0; k >>= 1, n = (n*n)%M)
            if (k&1) r = (r*n)%M;
        return r;
    }
 
    ll v; modint(ll n = 0) : v(n%M) { v += (M&(0-(v<0))); }
    
    friend string to_string(const modint n) { return to_string(n.v); }
    friend istream& operator>>(istream& i, modint& n) { return i >> n.v; }
    friend ostream& operator<<(ostream& o, const modint n) { return o << n.v; }
    template<typename T> explicit operator T() { return T(v); }
 
    friend bool operator==(const modint n, const modint m) { return n.v == m.v; }
    friend bool operator!=(const modint n, const modint m) { return n.v != m.v; }
    friend bool operator<(const modint n, const modint m) { return n.v < m.v; }
    friend bool operator<=(const modint n, const modint m) { return n.v <= m.v; }
    friend bool operator>(const modint n, const modint m) { return n.v > m.v; }
    friend bool operator>=(const modint n, const modint m) { return n.v >= m.v; }
 
    modint& operator+=(const modint n) { v += n.v; v -= (M&(0-(v>=M))); return *this; }
    modint& operator-=(const modint n) { v -= n.v; v += (M&(0-(v<0))); return *this; }
    modint& operator*=(const modint n) { v = (v*n.v)%M; return *this; }
    modint& operator/=(const modint n) { v = (v*_pow(n.v, M-2))%M; return *this; }
    friend modint operator+(const modint n, const modint m) { return modint(n) += m; }
    friend modint operator-(const modint n, const modint m) { return modint(n) -= m; }
    friend modint operator*(const modint n, const modint m) { return modint(n) *= m; }
    friend modint operator/(const modint n, const modint m) { return modint(n) /= m; }
    modint& operator++() { return *this += 1; }
    modint& operator--() { return *this -= 1; }
    modint operator++(int) { modint t = *this; return *this += 1, t; }
    modint operator--(int) { modint t = *this; return *this -= 1, t; }
    modint operator+() { return *this; }
    modint operator-() { return modint(0) -= *this; }
 
    // O(logk) modular exponentiation
    modint pow(const ll k) const {
        return k < 0 ? _pow(v, M-1-(-k%(M-1))) : _pow(v, k);
    }
    modint inv() const { return _pow(v, M-2); }
};
 
using mi = modint<1000000007>;
 
int main(){
    ios_base::sync_with_stdio(false), cin.tie(NULL);
 
    ll n; cin >> n;
    auto f = [&](ll x){
        return n/x;
    };
    ll b = 1;
    mi ans = 0;
    for(int i = 1; i <= sqrt(n); ++i){
        ans += i*(n/i);
        b = i+1;
    }
    while(b != n+1){
        ll l = b, r = n+1;
        while(r - l > 1){
            ll m = (l+r)/2;
            if(f(b) == f(m)){
                l = m;
            } else {
                r = m;
            }
        }
        mi a = f(b);
        mi x = b;
        mi y = l;
        ans += a * (y-x+1)*(y+x)/2;
        b = l+1;
    }
    cout << ans << endl;
 
    return 0;
}
