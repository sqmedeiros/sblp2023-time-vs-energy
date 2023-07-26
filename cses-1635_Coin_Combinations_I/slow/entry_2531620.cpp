#include <bits/stdc++.h>
#include <cstdint>
 
using namespace std;
 
using ll = long long;
using ld = long double;
 
#define FAST_IO ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(),(x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define fi first
#define se second
#define nline "\n"
#define as " "
#define rep(i, l, r) for(int i=l;i<r;++i)
 
#define sum(a)     ( accumulate ((a).begin(), (a).end(), 0ll))
#define mine(a)    (*min_element((a).begin(), (a).end()))
#define maxe(a)    (*max_element((a).begin(), (a).end()))
#define mini(a)    ( min_element((a).begin(), (a).end()) - (a).begin())
#define maxi(a)    ( max_element((a).begin(), (a).end()) - (a).begin())
#define maxij(a, i, j)    ( max_element((a).begin()+i, (a).begin()+j+1) - (a).begin())
#define lowb(a, x) ( lower_bound((a).begin(), (a).end(), (x)) - (a).begin())
#define uppb(a, x) ( upper_bound((a).begin(), (a).end(), (x)) - (a).begin())
#define sz(a)      (int)((a).size())
#define rs(a, n)   ((a).resize(n))
#define ms(a, val)     ( memset((a), val, sz(a))
 
//debugging
#ifndef ONLINE_JUDGE
#define dg(x) cerr << #x << " "; _print(x); cerr << endl;
#define dg2(x, y) cerr << #x << " "; _print(x); cerr << "\t|\t" << #y << " "; _print(y); cerr << endl;
#define dg3(x, y, z) cerr << #x << " "; _print(x); cerr << "\t|\t" << #y << " "; _print(y); cerr << "\t|\t" << #z << " "; _print(z); cerr << endl;
#define dg4(x, y, z, w) cerr << #x << " "; _print(x); cerr << "\t|\t" << #y << " "; _print(y); cerr << "\t|\t" << #z << " "; _print(z); cerr << "\t|\t" << #w << " "; _print(w); cerr << endl;
#else
#define dg(x)
#define dg2(x)
#define dg3(x)
#define dg4(x)
#endif
 
void _print(int x){cerr << x;}
void _print(float x){cerr << x;}
void _print(string x){cerr << x;}
void _print(ll x){cerr << x;}
void _print(char x){cerr << x;}
void _print(bool x){cerr << x;}
template<class T,class V>void _print(pair<T,V> x){cerr << "[";_print(x.fi);cerr << " ";_print(x.se);cerr << "]";}
template<class T> void _print(vector<T> x){cerr << "[ ";for(T i:x){_print(i);cerr << " ";}cerr << "]";}
template<class T> void _print(set<T> x){cerr << "[ ";for(T i: x){_print(i);cerr << " ";}cerr << "]";}
 
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<string> vs;
typedef vector<bool> vb;
typedef pair<int, int> pii;
typedef pair<int, bool> pib;
typedef pair<string, int> psi;
typedef pair<string, string> pss;
typedef vector<pii> vpii;
typedef vector<psi> vpsi;
typedef vector<pss> vpss;
 
// Vector
template<typename T>            istream& operator>>(istream& is,  vector<T> &v){for (auto& i : v) is >> i;        return is;}
template<typename T>            ostream& operator<<(ostream& os,  vector<T>  v){for (auto& i : v) os << i << ' '; return os;}
// Pair
template<typename T,typename U> istream& operator>>(istream& is, pair<T, U> &p){is >> p.first >> p.second;        return is;}
template<typename T,typename U> ostream& operator<<(ostream& os, pair<T, U>  p){os << p.first << ' ' << p.second; return os;}
//Vector + Pair
template<typename T,typename U> istream& operator>>(istream& is, vector<pair<T,U>> &p){for(auto &i:p){is >> i.fi >> i.se;}return is;}
template<typename T,typename U> ostream& operator<<(ostream& os, vector<pair<T,U>> &p){for(auto &i:p){os << i.fi << " " << i.se << endl;}return os;}
template <typename T>pair<T, bool> getNthElement(set<T>& searchSet,int index){pair<T, bool> result;if (searchSet.size() > index) {result.first= *(std::next(searchSet.begin(),index));result.second = true;}else result.second = false;return result;}
//Set
template<typename T>            istream& operator>>(istream& is,  set<T> &v){for (auto& i : v) is >> i;        return is;}
template<typename T>            ostream& operator<<(ostream& os,  set<T>  v){for (auto& i : v) os << i << ' '; return os;}
 
const ll mod = 1e9+7;
const int N = 1e6+10;
 
// Modulus-Mathematics
template<typename T,typename U>            ll modMul(T a, U b){return ((a%mod)*1LL*(b%mod))%mod;}
template<typename T,typename U>            ll binpower(T n, U k){T res=1;  while(k){   if(k & 1){res=modMul(res, n);}  n=modMul(n, n); k >>= 1;}   return res%mod;}
template<typename T>            T moduloInverse(T a){return binpower(a, mod-2);}
template<typename T,typename U>            ll modAdd(T a, U b){return ((a%mod)+(b%mod))%mod;}
template<typename T,typename U>            ll modSub(T a, U b){return ((a%mod)-(b%mod)+mod)%mod;}
template<typename T,typename U>            ll modDiv(T a, U b){return modMul(a, moduloInverse(b));}
 
void solve(){
    int n,m; cin >> n >> m;
    vi A(n);
    cin >> A;
    sort(all(A));
    vi dp(m+1, 0);
    dp[0]=1;
    rep(i, 1, m+1){
        for(auto j: A){
            if(j<=i){
                dp[i]=modAdd(dp[i], dp[i-j]);
            }else{
                break;
            }
        }
    }
    cout << dp[m] << nline;
}
 
void initialise() {
    return;
}
 
int main() {
    FAST_IO;
 
#ifndef ONLINE_JUDGE
    freopen("Input.txt", "r", stdin);
    freopen("Output.txt", "w", stdout);
    freopen("Error.txt", "w", stderr);
#endif
 
    int t=1;
//    cin >> t;
    initialise();
    rep(i, 1, t+1){
//        cout << "Case #" << i << ": ";
        solve();
    }
 
    return 0;
}