#include <bits/stdc++.h>
using namespace std;
 
#define paiu return
#define moment 0;
 
#define int long long
#define ll long long
 
#define forr(i,x) for (int i=0; i<x; i++)
#define forn(i,x) for (int i=0; i<x; i++)
#define forrr(i,j,x) for (int i=j; i<x; i++)
 
#define di(a,n) deque<int> a(n,0)
#define dll(a,n) deque<ll> a(n,0)
#define vi(a,n) vector<int> a(n,0)
#define vll(a,n) vector<ll> a(n,0)
 
//cringe define
#define vii(a,n) vi(a,n); forr(i,n) cin>>a[i];
vector<int> ___makeprefsum(vector<int>&a) {
    int n=a.size();
    vi(pr,n+1);
    forn(i,n) pr[i+1]=pr[i]+a[i];
    return pr;
}
#define prefsum(pr,a) vector<int> pr=___makeprefsum(a);
 
#define all(v) v.begin(),v.end()
#define rall(v) v.rbegin(),v.rend()
 
#define pb(x) push_back(x)
#define pf pop_front();
#define last(c) c[c.size()-1]
 
#define f first
#define s second
 
#define pi pair<int, int>
#define mp(x,y) make_pair(x, y)
 
const ll mod = 1000000007;
const double ppi = acos(0) * 2;
     
//const int maxn = 3e5+1;
const int inf = INT_MAX;
const ll linf = LLONG_MAX;
const ll mmod = 998244353;
 
void solve() {
    
    int ans=0;
 
    int n,x; cin>>n>>x;
    map<int,deque<int>> m;
    vii(a,n);
    forn(i,n) m[a[i]].pb(i);
    forn(i,n) {
        m[a[i]].pop_front();
        if (m[x-a[i]].size()) {
            cout<<i+1<<' '<<m[x-a[i]].back()+1<<'\n';
            return;
        }
    }
 
    cout<<"IMPOSSIBLE";
}
 
int32_t main() {
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
 
    //init_primes();
    
    int t=1;
    //cin>>t;
    
    while(t--) solve();
    
    paiu moment
}