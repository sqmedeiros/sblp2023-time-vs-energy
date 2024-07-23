// Problem: Coin Combinations I
// Contest: CSES - CSES Problem Set
// URL: https://cses.fi/problemset/task/1635
// Memory Limit: 512 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)
 
#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;
#define pi (3.141592653589)
#define int long long int
#define float double
#define endl "\n"
#define UB upper_bound
#define LB lower_bound
#define BS binary_search
#define mp make_pair
#define eb emplace_back
#define se second
#define fi first
#define pb push_back
#define grev greater<int>()
#define w(t) int t;cin>>t;while(t--)
#define vi vector<int>
#define vint vector<int>
#define vpi vector<pair<int,int>>
#define FOR(c,a,b); for(int c=a;c<b;c++)
#define vin(a,n) FOR(x,0,n){int po;cin>>po;a.pb(po);}
#define si set<int>
#define vs2(v) sort(v.begin(),v.end(),greater<int>());
#define vs(v) sort(v.begin(),v.end());
#define vcom(n,a) int n;cin>>n;vi a;vin(a,n);
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0)
template<typename T> bool chkmin(T &a, T b){return (b < a) ? a = b, 1 : 0;}
template<typename T> bool chkmax(T &a, T b){return (b > a) ? a = b, 1 : 0;}
 
// ******Policy based data structures******
// template<class T> using oset = tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;
// template<class key, class value> using omap = tree <key,value,less<key>,rb_tree_tag,tree_order_statistics_node_update>;
// find_by_order(k) -> returns iterator to kth element from start 0
// order_of_key(k) -> returns count of elements < k
 
const int M = 1e9+7;//998244353;
 
int gcd(int a, int b) { while (b) {a %= b; swap(a,b);} return a; }
int lcm(int a, int b) { int g=gcd(a,b); int res=a*(b/g); return res; }
int extended_gcd(int a, int b, int &x, int &y) { if (b==0) { x=1; y=0; return a; } int x1,y1; int g=extended_gcd(b,a%b,x1,y1); x=y1; y=x1-y1*(a/b); return g; }
int binExp(int a, int b, int m=M) { a = a % m; int res = 1; while (b) { if (b&1) { res=(res * a) % m; } a=(a * a) % m; b>>=1; } return res; }
int mod_inv(int a, int m=M) { a = a % m; return binExp(a,m-2,m); }		// only for prime m
int mod_add(int a, int b, int m=M) { a = a % m; b = b % m; return (((a + b) % m) + m) % m; }
int mod_sub(int a, int b, int m=M) { a = a % m; b = b % m; return (((a - b) % m) + m) % m; }
int mod_mul(int a, int b, int m=M) { a = a % m; b = b % m; return (((a * b) % m) + m) % m; }
int mod_div(int a, int b, int m=M) { a = a % m; int binv = mod_inv(b,m); return (((a * binv) % m) + m) % m; }
 
vi dp(1e7,0);
 
int32_t main()
{
	int n,x; cin>>n>>x;
	vi a; vin(a,n);
	dp[0]=1;
	FOR(i,0,x+1)
	{
		FOR(j,0,n)
		{
			if(dp[i]!=0 and (i+a[j])<=x)dp[i+a[j]]=mod_add(dp[i+a[j]],dp[i],M);
			dp[i+a[j]]%=M;
		}
	}
	cout<<dp[x]%M<<endl;
}