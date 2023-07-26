#include<bits/stdc++.h>
 
using namespace std;
 
// type
using ll = long long;
using ld = long double;
using db = double;
using str = string;
 
// pairs
using pi = pair<int,int>;
using pl = pair<ll,ll>;
using pd = pair<db,db>;
 
// vector
using vi = vector<int>;
using vb = vector<bool>;
using vl = vector<ll>;
using vd = vector<db>;
using vs = vector<str>;
using vpi = vector<pi>;
using vpl = vector<pl>;
using vpd = vector<pd>;
#define pb push_back
#define pf push_front
#define all(x) x.begin(), x.end()
#define sz(x) x.size()
#define sor(x) sort(all(x))
#define rsz resize
#define rtn return
 
// binary search
#define lb lower_bound
#define ub upper_bound
template<class T> ll lwb(vector<T>& a, const T& b) { rtn lb(all(a), b) - a.begin(); }
template<class T> ll upb(vector<T>& a, const T& b) { rtn ub(all(a), b) - a.begin(); }
 
// pairs
#define mp make_pair
#define f first
#define s second
 
// loops
#define FOR(i,a,b) for (ll i = (a); i < (b); ++i)
#define F0R(i,a) FOR(i,0,a)
#define ROF(i,a,b) for (ll i = (b)-1; i >= (a); --i)
#define R0F(i,a) ROF(i,0,a)
#define each(a,x) for (auto& a: x)
#define cont continue
#define bre break
 
// FILE I/O
void setIn(str s) { freopen(s.c_str(),"r",stdin); }
void setOut(str s) { freopen(s.c_str(),"w",stdout); }
void setIO(str s) {
    setIn(s+".inp"); setOut(s+".out");
}
 
const int MOD = 1e9 + 7; //998244353;
const int MX = 2e5+5;
const ll INF = 1e15;
const db PI = acos((db)-1);
const int dx[4] = {1,0,-1,0}, dy[4] = {0,1,0,-1};
template<class T> using pqg = priority_queue<T,vector<T>,greater<T>>;
 
// modulo, exponentiation, inverse
ll pow_mod(ll a, ll b, ll m) { ll res = 1; while(b){ res = res * (b & 1 ? a : 1) % m; a = a * a % m; b >>= 1; } rtn res; }
ll inv(ll a, ll m) { rtn pow_mod(a, m - 2, m); }
 
ll nxt(void) { // fast way for cin operation
    ll x; cin >> x;
    rtn x;
}
 
#define MXN 1001
 
ll n, x, l, r, sum;
 
pl a[MXN];
 
int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
//    setIO("CodeforcesEasy");
 
    cin >> n >> x;
    F0R(i, n) {
        cin >> a[i].f;
        a[i].s = i + 1;
    }
    sort(a, a + n);
    F0R(i, n) FOR(j, i + 1, n) if(a[i].f + a[j].f < x) {
        ll l = 0, r = n - 1;
        while(l < i && r > j) {
            sum = a[l].f + a[i].f + a[j].f + a[r].f;
 
            if(sum == x) {
                cout << a[l].s << ' ' << a[i].s << ' ' << a[j].s << ' ' << a[r].s << '\n';
                rtn 0;
            }
            else if(sum > x) r--;
            else if(sum < x) l++;
        }
    }
    cout << "IMPOSSIBLE";
 
    rtn 0;
}
