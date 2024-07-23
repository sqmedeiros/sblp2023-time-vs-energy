#include<bits/stdc++.h>
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef set<int> si;
typedef set<ll> sl;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<pii> vii;
typedef vector<pll> vll;
typedef map<int, int> mii;
typedef map<ll, ll> mll;
 
#define fastIO          ios_base::sync_with_stdio(false),cin.tie(NULL);
#define test  freopen("input.txt", "r", stdin); freopen("output.txt", "w", stdout);
#define input(arr)    for(auto &i : arr) cin>>i;
#define print(arr)    for(auto &i : arr) cout<<i<<" "; cout<<nl;
#define F first
#define S second
#define pb push_back
#define mp make_pair
#define f(i,a,b) for(int i=a; i<b; i++)
#define fi(j,a,b,i) for(int j=a; j<b; j+=i)
#define all(v) v.begin(), v.end()
#define sorti(v) sort(all(v))
#define sortd(v) sort(all(v), greater<int>())
#define reverse(v) reverse(all(v))
#define SUM(v,sum) sum=0; f(i,0,v.size()) sum+=v[i];
#define INF 1e9+7
#define INFF 1e18+7
#define MOD 1000000007
#define MOD2 1000000009
#define SQR(x) ((ll)(x) * (x))
#define nl "\n"
#define m0(a) memset(a,0,sizeof(a[0])*a.size());
#define _m0(a,n) memset(a,0,sizeof(a[0])*n);
#define m1(a) memset(a,-1,sizeof(a[0])*a.size());
#define _m1(a,n) memset(a,-1,sizeof(a[0])*n);
#define YES "YES\n";
#define NO "NO\n";
#define tt(i) cerr << "\t" << #i << " : " << i << nl
 
ll xpow(ll x, ull y) {
    ll res = 1;
    while (y > 0) {
        if (y & 1)res = (res * x) % (long long)INFF;
        y = y >> 1;
        x = (x * x) % (long long)INFF;
    }
    return (res % (long long)INFF);
}
 
void solve() {
    ll i, j;
    cin >> j >> i;
 
    if (i == 1 && j == 1) {
        cout << 1 << nl;
        return;
    }
    ull mx = max(i, j);
    ull res = (mx * mx) - mx + 1;
 
    tt(res);
 
    if (i == j) {
        cout << res << nl;
    } else if (i < j) {
        if (max(i, j) & 1) {
            res -= abs(i - j);
        } else {
            res += abs(i - j);
        }
        cout << res << nl;
 
    } else {
        if (max(i, j) & 1) {
            res += abs(i - j);
        } else {
            res -= abs(i - j);
        }
        cout << res << nl;
 
    }
 
    return;
}
 
int main() {
    fastIO
#ifndef ONLINE_JUDGE
    test
#endif
    int t;
    cin >> t;
    while (t--)
        solve();
 
    return 0;
}