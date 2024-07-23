#include<bits/stdc++.h>
 
using namespace std;
 
// #include <ext/pb_ds/assoc_container.hpp>
// #include <ext/pb_ds/tree_policy.hpp>
// using namespace __gnu_pbds;
 
#define ll long long
#define ull unsigned long long
#define lld long double
#define f(i,s,n) for(ll i=s;i<=n;i++)
#define fr(i,n,s) for(ll i=n;i>=s;i--)
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define trav(x) for(auto &it:x)
ll mod=1e9+7;
// #define mod 998244353
#define pi 3.141592653589793238462643383279
typedef pair<ll,ll> pii;
#define ub upper_bound
#define lb lower_bound
typedef vector<ll> vll;
typedef vector<vector<ll>> vvll;
typedef vector<pair<ll, ll>> vpll;
#define all(x) (x).begin(), (x).end() //--
#define inf 1e18
#define setp(x) setprecision(x)
#define min(a, b)       ((a) < (b) ? (a) : (b))
#define max(a, b)       ((a) < (b) ? (b) : (a))
inline int power(ll x, ll y,ll mod){ if(y==0)return 1;x%=mod;if(y%2)return (x*power(x*x, y/2,mod))%mod;return power(x*x, y/2,mod)%mod;}
int power(ll b, ll e)
{
    ll res = 1;
    f(i, 1, e) res *= b;
    return res;
}
 
void __print(int x) {cerr << x;}
void __print(long x) {cerr << x;}
void __print(long long x) {cerr << x;}
void __print(unsigned x) {cerr << x;}
void __print(unsigned long x) {cerr << x;}
void __print(unsigned long long x) {cerr << x;}
void __print(float x) {cerr << x;}
void __print(double x) {cerr << x;}
void __print(long double x) {cerr << x;}
void __print(char x) {cerr << '\'' << x << '\'';}
void __print(const char *x) {cerr << '\"' << x << '\"';}
void __print(const string &x) {cerr << '\"' << x << '\"';}
void __print(bool x) {cerr << (x ? "true" : "false");}
template<typename T, typename V>
void __print(const pair<T, V> &x) {cerr << "{ "; __print(x.first); cerr << ", "; __print(x.second); cerr << " }";}
template<typename T>
void __print(const T &x) {int f = 0; cerr << " "; for (auto &i: x) cerr << (f++ ? " , " : ""), __print(i); cerr << " ";}
void _print() {cerr << "]\n";}
template <typename T, typename... V>
void _print(T t, V... v) {__print(t); if (sizeof...(v)) cerr << ", "; _print(v...);}
#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "[" << #x << "] = ["; _print(x)
#else
#define debug(x...)
#endif
 
 
clock_t time_p=clock();
void timer(){time_p=clock()-time_p;cerr<<"\nTime Taken : "<<(float)(time_p)/CLOCKS_PER_SEC<<"sec\n";}
 
void swap(ll &x, ll &y) {ll temp = x; x = y; y = temp;}
void google(ll t) {cout << "Case #" << t << ": ";}
ll mod_add(ll a, ll b, ll m) {a = a % m; b = b % m; return (((a + b) % m) + m) % m;}
ll mod_sub(ll a, ll b, ll m) {a = a % m; b = b % m; return (((a - b) % m) + m) % m;}
 
vll factorial(2e5+1);
void f_factorial() {
      factorial[0] = 1 , factorial[1] = 1;
      f(i,2,2e5) {
            factorial[i] = factorial[i-1]*i;
            factorial[i]%=mod;
      }
}
 
 
ll bimult(ll a , ll b , ll m) {
      ll res = 0;
      while(b) {
            if(b&1) {
                  res = (res + a)%m;
            }
            a = (a + a)%m;
            b>>=1;
      }
      return res;     
}
ll biexp(ll a, ll b , ll m) {
      ll res = 1;
      while(b) {
            if(b&1) {
                  res = res * a;
                  res%=m;
            }
            a = a * a;
            a%=m;
            b>>=1;
      }
      return res;
}
 
 
 
ll ncr(ll a , ll b , ll m) {
      ll res = bimult(factorial[a] , biexp(factorial[b],m-2,m) , m);
      res = bimult(res , biexp(factorial[a-b],m-2 , m) , m);
      return res;
}
 
inline ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a % b); }
inline ll lcm(ll a, ll b) { return a * b / gcd(a, b); }
inline ll ceil(ll a, ll b){  return (a%b==0) ? a/b : a/b +1 ;}
//#define onebits(x)      __builtin_popcountll(x)
ll set_bits(ll n) { ll cnt = 0;while(n) { n-=n&-n; cnt++;}return cnt;}
#define zerobits(x)      __builtin_ctzll(x)
 
 
vll pri(2000000+10);
 
void prime_factorization(){
      f(i,2,2000000+5) pri[i] = -1;
      pri[1] = 1;
      f(i,2,2000000+5){
            if(pri[i] == -1){
                  for(ll j = i ; j<= 2000000 + 5; j+=i){
                        if(pri[j] == -1){
                              pri[j] = i;
                        }
                  }
            }
      }
}
 
vll pfactors(ll n){
      vll res;
      while(pri[n]!=1){
            res.pb(pri[n]);
            n = n/pri[n];
      }
      return res;
}
 
vll factor_Count(2000000+10,0);
 
void pf_count() {
      for (ll i = 2; i <= 2000000+2; i++) {
            if (factor_Count[i] == 0) { // Number is prime
                  for (ll j = i; j <= 2000000+2; j += i) {
                        factor_Count[j]++;
                  }
            }
      }
}
 
bool isprime(ll n) {
      if(n == 1) return false;
      if(n == 2 || n == 3) return true;
      if(n%2 == 0 || n%3 == 0) return false;
      for(ll i=5; i*i<=n; i=i+6) {
            if(n%i==0 || n%(i+2)==0)
            return false;
      }
      return true;
}
 
// "excitement leads to disappointment"
// if -x <= a <= x , see for ( 0 0 0 ... ).
// for storing freq use vector if arr[i] <= 2e5 .. ( 0 <= a[i] <= n ).
 
// #define ordered_set tree<ll, null_type,less<ll>, rb_tree_tag,tree_order_statistics_node_update>
  // find_by_order() , order_of_key()
const ll N = 2000010;
priority_queue< ll , vector<ll> ,greater<ll> > pq;
vll dx{1 , 0 , -1 , 0};
vll dy{0 , 1 , 0 , -1};
string S1 = "abcdefghijklmnopqrstuvwxyz";
string S2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
// ---------------------------------------*******************--------------------------------------//
#define int long long
 
int fun1(string &A, string &B, int n, int m,vector<vector<long long>>&dp)
{
    if(n==0)return m;
    if(m==0)return n;
 
    if(dp[n][m]!=1e18)return dp[n][m];
 
    if(A[n-1]==B[m-1])
    {
        dp[n][m]=fun1(A,B,n-1,m-1,dp);
    }
    else 
    {
        dp[n][m]=1+ min(fun1(A,B,n-1,m,dp), min(fun1(A,B,n,m-1,dp), fun1(A,B,n-1,m-1,dp)));
    }
    return dp[n][m];
}
 
 
int minDistance(string A, string B) {
    int n=A.size();
    int m=B.size();
    vector<vector<long long>>dp(n+1,vector<long long>(m+1,1e18));
    int ans=fun1(A,B,n,m,dp);
    return ans;
}
 
 
 
void solve()
{
 string s1,s2;
 cin>>s1>>s2;
 
 int ans=minDistance(s1,s2);
 cout<<ans<<endl;
 
}
 
 
/* stuff you should really look for
    * "Keep your thought process clear!"
    * THINK FIRST!, THEN CODE!
    * List/write down the OBSERVATIONS and think in a DISCIPLINED way !
    * Observe/simulate the test cases properly
    * Re-read the question.
    * DON'T GET STUCK ON ONE APPROACH
    * int overflow, array bounds
    * special cases (n=1?), set assert, clear structure for next test case.
    * comparitive(&&,||,==) execute first than bit operator(<<,>>,&,^,|).
    * do smth instead of nothing and stay organized
    * oeis.org
*/
// Template by Benq.
 
 
// ---------------------------------------*******************--------------------------------------//
 
 
signed main()
{
 #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
      ios_base::sync_with_stdio(0);
      cin.tie(0);
      cout.tie(0);
    //   prime_factorization();
    //   f_factorial();
    //   pf_count();
      ll t=1;
      // cin>>t;
      while(t--){
            solve();
      }
      timer();
      return 0;
}