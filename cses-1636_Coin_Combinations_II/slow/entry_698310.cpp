#include<bits/stdc++.h>
#define speedio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
using namespace std;
// #include <ext/pb_ds/assoc_container.hpp>
// using namespace __gnu_pbds;
 
typedef long long       ll;
typedef long double     ld;
 
typedef vector<int>     vi;
typedef vector<bool>    vb;
typedef vector<ll>      vll;
typedef vector<vi>      vvi;
typedef vector<vll>     vvll;
typedef vector<string>  vs;
 
typedef pair<int, int>  pii;
typedef pair<ll, int>   pli;
typedef pair<ll, ll>    pll;
typedef vector< pii >   vpi;
typedef vector< pll >   vpll;
 
// typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> oset;
 
#define pb           push_back
// #define mod          1000000007
#define INF          1e17
#define mini         INT_MIN
#define maxo         INT_MAX
#define eb           emplace_back
#define ff           first
#define ss           second
#define re           return 
#define endl         "\n" 
 
#define all(c)       c.begin(),c.end()
#define be           begin()
#define en           end()
#define sz(x)        (ll)x.size()
#define mem(a,val)   memset(a,val,sizeof(a))
#define mk(x,y)      make_pair(x,y)
#define mid(s,e)     ((s)+((e)-(s))/2) 
 
#define fo(i,a,b)     for(int i = a; i <= b; i++)
#define rf(i,a,b)    for(int i = (int)(a); i >= (int)(b); i--)
#define read(a,n)    for(int i=0;i<n;i++)cin>>a[i];
#define show(a,n)    for(int i=0;i<n;i++)cout<<a[i]<<' ';cout<<endl;
#define p2(n)        (1LL << (n))
#define deb(x) cout <<#x << " = " << x << " | " << "LINE: "<<__LINE__<< endl;
template<typename... T> void rd(T&... args) { ((cin >> args), ...); }
template<typename... T> void pp(T... args) { ((cout << args << " "), ...); cout<<"\n"; }
 
// ll add(ll x, ll y){ x += y; if(x>=mod) x %= mod; if(x<0) x = x%mod + mod; return x; }
 
//============== *** START OF CODE ***
 
 
 
 
void solve()
{
    ll n,x;rd(n,x);
    int mod = 1e9 + 7;
    int c[n];  
    fo(i,0,n-1)cin>>c[i];
    int dp[n+1][x+1];
    mem(dp,0);
    // dp[i] -> no of o-ways for sum  = i;
    fo(j,0,n-1)dp[j][0]=1;
    for(int i=1;i<=x;i++){
        for(int j=0;j<n;j++){
            if(i>=c[j]) dp[j][i] = dp[j][i-c[j]];
            if(j!=0) dp[j][i] += dp[j-1][i];
            dp[j][i] %= mod;
        }
    }
    pp(dp[n-1][x]);
    
}
 
 
void prep(){}
 
//=============== *** END OF CODE ***
 
int main(){
    speedio; cout<<fixed<<setprecision(12);
 
// #ifndef ONLINE_JUDGE
//     freopen("input.txt", "r", stdin);
//     freopen("output.txt", "w", stdout);
// #endif
 
    prep();
    int t = 1;
    // cin >> t;
    while(t--)
        solve();
 
    cout<<"\n";
    return 0;
}