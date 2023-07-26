#include<bits/stdc++.h>
using namespace std;
 
#define M1 1000000007
#define M2 998244353
#define PI 3.1415926535897932384626433832795
#define PB push_back
#define PPB pop_back
#define PF push_front
#define PPF pop_front
#define BB(x) x.begin()
#define RB(x) x.rbegin()
#define EE(x) x.end()
#define RE(x) x.rend()
#define ALL(x) BB(x), EE(x)
#define RALL(x) RB(x), RE(x)
#define FI first
#define SE second
#define SIZE 1e5 + 10
#define EPS 1e-9
#define testdebug(tc) cerr << "TEST CASE: " << tc << "----------" << endl
 
#ifndef ONLINE_JUDGE
#define debug(x) cerr << "Line No. " << __LINE__ << ": " #x << " "; _print(x); cerr << endl;
#else
#define debug(x)
#endif
 
using namespace std;
 
typedef long long int ll;
typedef long double ld;
typedef bool bl;
typedef unsigned long long ull;
typedef vector<ll> vll;
typedef vector<int> vi;
typedef vector<pair<ll, ll> > vpll;
typedef pair<ll, ll> pll;
typedef vector<vector<ll> > vvll;
typedef vector<pair<ll, vector<ll> > > vpllvll;
typedef map<ll, ll> mll;
typedef map<ll, vector<ll> > mllvll;
typedef map<ll, pair<ll, ll> > mllpll;
typedef set<ll> sll;
typedef multiset<ll> msll;
typedef deque<ll> dll;
typedef stack<ll> stll;
typedef queue<ll> qll;
 
// LOOPS------------------------------------------------------------------------------------------------------------------------
#define repg(i, a, b, c) for(ll i = a; i < b; i += c)
#define rep(i, a, b) for(ll i = a; i < b; i++)
#define rrep(i, a, b) for(ll i = a; i > b; i--)
#define rrepg(i, a, b, c) for(ll i = a; i > b; i -= c)
#define itr(x, cont) for(auto x : cont)
//------------------------------------------------------------------------------------------------------------------------------
 
// DEBUG------------------------------------------------------------------------------------------------------------------------
void _print(ll t) {cerr << t;}
void _print(int t) {cerr << t;}
void _print(string t) {cerr << t;}
void _print(char t) {cerr << t;}
void _print(ld t) {cerr << t;}
void _print(double t) {cerr << t;}
void _print(ull t) {cerr << t;}
 
template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T> void _print(queue <T> q);
template <class T> void _print(deque <T> q);
template <class T> void _print(stack <T> s);
template <class T, class V> void _print(map <T, V> v);
template <class T, class V> void _print(pair <T, V> p) {cerr << "{"; _print(p.FI); cerr << ","; _print(p.SE); cerr << "}";}
template <class T> void _print(vector <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(set <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(multiset <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(queue <T> q) {cerr << "[ "; while (!q.empty()) {_print(q.top()); cerr << " "; q.pop();} cerr << "]";}
template <class T> void _print(deque <T> q) {cerr << "[ "; while (!q.empty()) {_print(q.top()); cerr << " "; q.pop_front();} cerr << "]";}
template <class T> void _print(stack <T> s) {cerr << "[ "; while (!s.empty()) {_print(s.top()); cerr << " "; s.pop();} cerr << "]";}
template <class T, class V> void _print(map <T, V> v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}
// -----------------------------------------------------------------------------------------------------------------------------
 
// MATH-------------------------------------------------------------------------------------------------------------------------
ll bin_exp(ll a, ll b, ll mod){
    a %= mod;
    ll ans = 1;
    while(b > 0){
        if(b & 1){
            ans = (ans * a) % mod;
        }
        a = (a * a) % mod;
        b >>= 1;
    }
    return ans;
}
ll bin_exp(ll a, ll b){ll ans = 1;while(b > 0){if(b & 1){ans *= a;}a *= a;b >>= 1;}return ans;}
ll ceild(ll x, ll y){if((x < 0 && y > 0) || (x > 0 && y < 0)) return x / y;return (x - 1) / y + 1;}
ll mod(ll a, ll b){if(a > 0) return a % b;else return b + a % b;}
ll mod2(ll a, ll b){if(mod(a, b) == 0) return b;return mod(a, b);}
ll gcd(ll a, ll b){if(a >= b) swap(a, b);if(a == 0) return b;return gcd(b % a, a);}
//-----------------------------------------------------------------------------------------------------------------------------
 
void solve(){
    ll x, y;
    cin >> y >> x;
 
    ll n = max(x, y);
 
    if(n & 1){
        if(x < n){
            cout << (n - 1) * (n - 1) + x << '\n';
        }
        else{
            cout << (n - 1) * (n - 1) + n - y + (n) << '\n';
        }
    }
    else{
        if(y < n){
            cout << (n - 1) * (n - 1) + y << '\n';
        }
        else{
            cout << (n - 1) * (n - 1) + n - x + (n) << '\n';
        }
    }
}
 
 
int main(){
 
    //auto start = chrono :: high_resolution_clock :: now();
 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    #ifndef ONLINE_JUDGE
    freopen("error.txt", "w", stderr);
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
 
 
    int t = 1;
    cin >> t;
    int tc = 1;
 
    while(t--){
        testdebug(tc);
        //cout << "Case #" << tc << ": ";
        solve();
 
        tc++;
    }
 
    // auto stop = chrono ::  high_resolution_clock :: now();
 
    // #ifndef ONLINE_JUDGE
    // auto duration = chrono :: duration_cast <chrono :: milliseconds> (stop - start);
    // cerr << "Time exe: "<< duration.count() <<"ms"<< endl;
    // #endif
 
    return 0;
}