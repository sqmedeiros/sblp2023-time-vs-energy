#include <bits/stdc++.h>
 
using namespace std;
 
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<vvi> vvvi;
typedef long long ll;
typedef vector<ll> vll;
typedef vector<vll> vvll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pll;
typedef vector<pi> vpi;
typedef vector<bool> vbool;
 
#define pb push_back
#define eb emplace_back
#define forall(it, s) for(auto it = s.begin(); it != s.end(); ++it)
#define F0(i, n) for(int i = 0; i < n; i++)
#define F1(i, n) for(int i = 1; i <= n; i++)
#define rep(i, a, b) for(int i = a; i <= b; i++)
#define per(i, a, b) for(int i = b; i >= a; i--)
#define FIN ios::sync_with_stdio(false);cin.tie(0);
#define db(x) cerr<<#x<<" = "<<x<<"\n"
#define db2(x, y) cerr<<#x<<" = "<<x<<" , "<<#y<<" = "<<y<<"\n"
#define RAYA cerr<<"=======================\n"
#define all(v) v.begin(),v.end()
#define modulo(a, b) ((a%b)+b)%b
const int INF = 1000000010;
const ll INFLL = 1000000000000000000LL;
#define eps 0.000000001
#define mod 1000000007
 
template<class C>
void mini(C &a, C b) { a = min(a, b); }
 
template<class C>
void maxi(C &a, C b) { a = max(a, b); }
 
ll powmod(ll a, ll b) {
    ll res = 1;
    a %= mod;
    assert(b >= 0);
    for (; b; b >>= 1) {
        if (b & 1)res = res * a % mod;
        a = a * a % mod;
    }
    return res;
}
 
ll powmod(ll a, ll b, ll m) {
    ll res = 1;
    a %= m;
    assert(b >= 0);
    for (; b; b >>= 1) {
        if (b & 1)res = res * a % m;
        a = a * a % m;
    }
    return res;
}
 
ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }
 
template<typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
    os << "[";
    for (int ii = 0; ii < (int) v.size(); ii++) {
        if (ii > 0) os << ",";
        os << v[ii];
    }
    return os << "]";
}
 
//=======================//
 
void exponentiation() {
    ll a, b;
    cin >> a >> b;
    cout << powmod(a, b) << "\n";
}
 
void exponentiation2() {
    // p := a^(mod-1) = 1, entonces a^x = a^(x % (mod-1))
    ll a, b, c;
    cin >> a >> b >> c;
    ll p = powmod(b, c, mod - 1);
    cout << powmod(a, p) << "\n";
}
 
void countingDivisors() {
    int mx = 1000000;
    vector<int> criba(mx + 1);
    criba[1] = 1;
    for (int v = 2; v <= mx; v++) {
        if (criba[v] != 0) continue;
        for (int multiplo = v; multiplo <= mx; multiplo += v) {
            if (criba[multiplo] == 0) {
                criba[multiplo] = v;
            }
        }
    }
    vector<int> factores;
    auto factorizar = [&](int v) {
        factores.clear();
        while (v != 1) {
            factores.push_back(criba[v]);
            v /= criba[v];
        }
    };
 
    auto divisores = [&](int v) {
        factorizar(v);
        factores.push_back(0);
        int c = 0;
        int last = -1;
        int res = 1;
        for (int f: factores) {
            if (f == last) {
                c++;
            } else {
                res *= c + 1;
                c = 1;
            }
            last = f;
        }
        return res;
    };
 
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cout << divisores(x) << "\n";
    }
}
 
void commonDivisors() {
    int n;
    cin >> n;
    int mx = 1000000;
    vector<int> cnt(mx + 1);
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        cnt[x]++;
    }
    for(int d = mx; d >= 1; d--) {
        int divideA = 0;
        for(int multiplo = d; multiplo <= mx; multiplo += d) {
            divideA += cnt[multiplo];
        }
        if(divideA > 1) {
            cout << d << "\n";
            return;
        }
    }
    assert(false);
}
 
void sumOfDivisors() {
    ll n; cin >> n;
    ll res = 0;
    for(ll i = 1; i <= n; ) {
        // Considero n/i. Busco el j mas chico con n/j < n/i
        ll l = i, r = n+1;
        ll ans = -1;
        ll div = n/i;
        while(l <= r) {
            ll m = (l+r)/2;
            if(n/m < div) {
                ans = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        ll grande = ans%mod, chico = i%mod;
        ll t = ((grande * (grande-1) - chico  *  (chico-1)) / 2) % mod;
        res += modulo(t * (div%mod), mod);
        i = ans;
        if(res >= mod) res-=mod;
    }
    cout << res%mod << "\n";
}
 
int main() {
    FIN
    int t = 1;
    //cin >> t;
    while (t--) {
        sumOfDivisors();
    }
    return 0;
}
