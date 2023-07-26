#include<bits/stdc++.h>
using namespace std;
#define FOR(i,n) for(auto i=0;i<n;++i)
#define rep(i,a,b) for(auto i=a;i<=b;++i)
#define rfor(i,a,b) for(auto i=a;i>=b;--i)
#define F first
#define S second
#define all(x) x.begin(),x.end()
#define revall(x) x.rbegin(),x.rend()
#define INF 1e18
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<long long> vll;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
// #define LOCAL
#ifndef LOCAL
#define debug(x) cerr<<#x<<" ";_print(x);cerr<<'\n';
#else
#define debug(x) cout<<#x<<" ";_print(x);cout<<'\n';
#endif
 
template<class T> void _print(T a){cerr<<a;}
template<class T1,class T2> void _print(pair<T1,T2> p){_print(p.first);cerr<<",";_print(p.second);}
template<class T> void _print(vector<T> v){cerr<<"[ ";for(T it:v){_print(it);cerr<<" ";}cerr<<"]"<<'\n';}
template<class T1,class T2> void _print(map<T1,T2> m){cerr<<"[";for(auto it:m){_print(it.F);cerr<<" ";_print(it.S);cerr<<";";}cerr<<"]";}
template<class T1,class T2> void _print(unordered_map<T1,T2> m){cerr<<"[";for(auto it:m){_print(it.F);cerr<<" ";_print(it.S);cerr<<";";}cerr<<"]";}
template<class T1,class T2> void _print(vector<pair<T1,T2>> v){cerr<<"[";for(auto it:v){_print(it.F);cerr<<" ";_print(it.S);cerr<<";";}cerr<<"]";}
template<class T> void _print(set<T> s){cerr<<"[";for(auto it:s){_print(it);cerr<<" ";}cerr<<"]";}
template<class T> void _print(unordered_set<T> s){cerr<<"[";for(auto it:s){_print(it);cerr<<" ";}cerr<<"]";}
template<class T> void _print(multiset<T> s){cerr<<"[";for(auto it:s){_print(it);cerr<<" ";}cerr<<"]";}
/*----------------USEFUL FUNCTIONS--------------------------------------------------*/
ll expo(ll a, ll b, ll mod) {ll res = 1; while (b > 0) {if (b & 1)res = (res * a) % mod; a = (a * a) % mod; b = b >> 1;} return res;}
vector<ll> sieve(int n) {int*arr = new int[n + 1](); vector<ll> vect; for (int i = 2; i <= n; i++)if (arr[i] == 0) {vect.push_back(i); for (int j = 2 * i; j <= n; j += i)arr[j] = 1;} return vect;}
ll getRandomNumber(ll l, ll r) {return uniform_int_distribution<ll>(l, r)(rng);} 
/*-----------------------------------------------------------------------------------*/
void solve()
{
    int n,k;
    cin >> n >> k;
    vector<int> coins(n);
    for(auto &x: coins) cin >> x;
 
    sort(all(coins));
 
    if(k < coins[0]){
        cout  << -1 << '\n';
        return;
    }
 
    int mx = 1000000007;
 
    int dp[k+1][n];
    for(int i = 0; i < n; i++) dp[0][i] = 0;
    for(int i = 1; i <= k; i++) dp[i][0] = (i%coins[0] == 0 ? i/coins[0]:mx);
    for(int i = 1; i <= k; i++){
        for(int j = 1; j < n; j++){
            if(coins[j] > i){
                dp[i][j] = dp[i][j-1];
            } else{
                dp[i][j] = min(dp[i][j-1], 1+dp[i-coins[j]][j]);
            }
        }
    }
    cout << (dp[k][n-1] == mx ? -1 : dp[k][n-1]) << '\n';
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cerr.tie(NULL);
    // freopen("input.txt", "r" ,stdin);
    // freopen("output.txt", "w" ,stdout);
    #ifndef LOCAL
    freopen("Error.txt","w",stderr);
    #endif
    solve();
    return 0;
}