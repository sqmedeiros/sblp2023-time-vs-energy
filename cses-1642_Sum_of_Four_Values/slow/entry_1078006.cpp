#pragma optimize("unroll-loops,no-stack-protector")
#pragma GCC target ("avx2")
#pragma GCC optimization ("O3")
#pragma GCC optimization ("unroll-loops")
#include <bits/stdc++.h>
using namespace std;
// using namespace __gnu_pbds;
// #include <ext/pb_ds/assoc_container.hpp>
// typedef tree<int,null_type,less<int>,rb_tree_tag,
// tree_order_statistics_node_update> indexed_set;
#define f(i,a,b) for(ll i=a;i<b;i++)
#define rep(i,n) f(i,0,n)
#define fd(i,a,b) for(ll i=a;i>=b;i--)
#define Max(a,b,c) max(a,max(b,c))
#define Min(a,b,c) min(a,min(b,c))
#define pb push_back
#define mp make_pair
#define vi vector< int >
#define pc(x)  __builtin_popcount (x)
#define vl vector< ll >
#define sorts(v) sort(v.begin(),v.end())
#define sortg(v) sort(v.begin(),v.end(),greater<ll>())
#define ss second
#define ff first
#define ll long long
#define ld long double
#define pii pair< int,int >
#define pll pair< ll,ll >
#define sz(a) a.size()
#define inf (1000*1000*1000+5)
#define all(a) a.begin(),a.end()
#define tri pair<int,pii>
#define vii vector<pii>
#define vll vector<pll>
#define viii vector<tri>
#define mod 1000000007
#define mem(x,y) memset(x,y,sizeof(x))
#define pqueue priority_queue< int >
#define pdqueue priority_queue< int,vi ,greater< int > >
#define flush fflush(stdout) 
#define gcd __gcd
#define primeDEN 727999983
#define nx_pe next_permutation(s.begin(),s.end())
#define cl cout<<"\n"
#define sp(x) setprecision(x)
 
 
 
void solve()
{
   ll n,s;
   cin>>n>>s;
   vll v;
   map<ll,ll>val;
   rep(i,n){
       ll x;
       cin>>x;
       val[x]++;
       if(val[x]>4){
           continue;
       }
       v.pb(mp(x,i+1));
   }
   if(n<4){
       cout<<"IMPOSSIBLE";
       return;
   }
   n=v.size();
   map<ll,vll>m;
   rep(i,n){
       rep(j,n){
           if(i==j)continue;
           m[v[i].ff+v[j].ff].pb({v[i].ss,v[j].ss});
       }
   }
   rep(i,n){
       rep(j,n){
           if(i==j){
               continue;
           }
           ll x=v[i].ff+v[j].ff;
           ll req=s-x;
        //    cout<<i<<" "<<j<<" "<<x<<" "<<req<<"\n";
           if(m.find(req)!=m.end()){
               rep(k,m[req].size()){
                   pll p=m[req][k];
                   if(p.ff!=i+1&&p.ff!=j+1&&p.ss!=i+1&&p.ss!=j+1){
                       cout<<v[i].ss<<" "<<v[j].ss<<" "<<p.ff<<" "<<p.ss<<"\n";
                       return;
                   }
               }
           }
       }
   }
   cout<<"IMPOSSIBLE";
 
}
 
 
    
int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin) ;
    freopen("output.txt", "w", stdout) ;
    #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    std::ios::sync_with_stdio(false);
    ll te=1;
    // cin>>te;
    while(te--){
        solve();
    }
    
}
