/* 
	author: Suraj Kumar 
	NIT Patna
*/
 
#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp> //for pb_ds(policy_based) data structure ex: ordered_set
#include<ext/pb_ds/tree_policy.hpp>
 
using namespace std;
using namespace __gnu_pbds;
 
typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update > pbds;  //find_by_order(x)-> element_at_index x order_of_key(x)-> no_of_element_small_than x
 
#define all(x)                  (x).begin(), (x).end()
#define rall(x)               	(x).rbegin(), (x).rend()
#define ll                      long long
#define pb                      push_back
#define f(i,a,b)                for(int i=a;i<b;i++)
#define fll(i,a,b)              for(ll i=a;i<b;i++)
#define vi                      vector<int>
#define vb                      vector<bool>
#define vd                      vector<double>
#define vvi                     vector<vi>
#define vll                     vector<long long>
#define vvll                    vector<vll>
#define pii                     pair<int,int>
#define pll                     pair<ll,ll>
#define sz(x)                   (int)(x.size())
#define scan0(x)                for(int i=0;i<sz(x);i++) cin>>x[i]
#define scan1(x)                for(int i=1;i<sz(x);i++) cin>>x[i]
#define ff                      first
#define ss                      second
#define PI                      3.1415926535897932384626
#define debug(x)                cout<<"#.... "<<x<<"  \n";
#define int                     long long
const ll MOD=1e9+7;
const ll MOD1=998244353;
 
/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
 
ll binexp(ll a,ll b) {  ll res = 1; while (b > 0) { if (b & 1)  res = res * a;  a = a * a;  b >>= 1;}   return res; }
ll binexp_mod(ll x, ll y, ll p){   ll res=1; x=x%p;    while(y>0){ if (y&1) res= (res*x)%p; y=y>>1; x=(x*x)%p; }   return res%p;}
ll phin(ll n) {ll number = n; if (n % 2 == 0) {number /= 2; while (n % 2 == 0)n /= 2;} for (ll i = 3; i <= sqrt(n); i += 2) {if (n % i == 0) {while (n % i == 0)n /= i; number = (number / i * (i - 1));}} if (n > 1)number = (number / n * (n - 1)) ; return number;} //O(sqrt(N))
void extendgcd(ll a, ll b, ll*v) {if (b == 0) {v[0] = 1; v[1] = 0; v[2] = a; return ;} extendgcd(b, a % b, v); ll x = v[1]; v[1] = v[0] - v[1] * (a / b); v[0] = x; return;} //pass an arry of size1 3
ll mminv(ll a, ll b) {ll arr[3]; extendgcd(a, b, arr); return arr[0]<0?arr[0]+b:arr[0];} //for non prime b
ll mminvprime(ll a, ll b) {return binexp_mod(a, b - 2, b);}
ll median(vll v){ll n = v.size();	ll m = n%2==1 ? v[n/2] : (v[n/2-1]+v[n/2])/2; return m;	}
int32_t mod_inv(int32_t a, int32_t m) {
	int32_t g = m, r = a, x = 0, y = 1;
	while (r != 0) {
		int32_t q = g / r;
		g %= r; swap(g, r);
		x -= q * y; swap(x, y);
	}
	return x < 0 ? x + m : x;
}
 
// __builtin_popcount(4)  give no of setbit in a number
 
/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
 
ll binpow(ll a,ll b,ll p){
    if(b==0)return 1;
    ll t=binpow(a,b/2,p);
    if(b%2)return (((a*t)%p)*t)%p;
    else return ((t*t)%p);
}
const int N=1e6+4; 
ll fact[N],invFact[N];
void init(){
    fact[0] = invFact[0] = 1;
    for (int i = 1; i < N; i++) {
        fact[i] = (fact[i - 1] * i) % MOD;
        invFact[i] = binpow(fact[i], MOD - 2,MOD);
    }
}
ll ncr(ll n,ll r,ll p){
    if (r > n) {
        return 0;
    }
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
}
 
void subtest()
{
	int n;
	cin>>n;
	vi v(n);
	scan0(v);
	int lmx=v[0];
	int gmx = v[0];
 
	f(i,1,n)
	{
		lmx = max(lmx + v[i] , v[i]);
		gmx = max(gmx , lmx);
	}
 
	cout<<gmx;
}
 
 
void solve()
{  
	init();
    ll test=1;
	//cin>>test;
	while(test--)
	{
		subtest();
	}
}
 
void setIO()
{
    #ifndef ONLINE_JUDGE
      freopen("input.txt","r",stdin);
      freopen("output.txt","w",stdout);
    #endif
} 
 
signed main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    //setIO();
    solve();
}
