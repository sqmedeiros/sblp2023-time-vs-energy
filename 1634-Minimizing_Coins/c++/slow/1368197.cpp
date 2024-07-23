#pragma GCC optimize("Ofast")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
#include <bits/stdc++.h>
#include <complex>
#include <queue>
#include <set>
#include <unordered_set>
#include <list>
#include <chrono>
#include <random>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <stack>
#include <iomanip>
#include <fstream>
 
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int,int> p32;
typedef pair<ll,ll> pll;
typedef pair<double,double> pdd;
typedef vector<ll> vll;
typedef vector<vector<ll> > vvll;
typedef vector<vector<pll> > vvpll;
typedef vector<pll> vpll;
ll MOD = 10e9 +7;
double eps = 1e-12;
#define fori(e) for(ll i = 0; i < e; i++)
#define forj(e) for(ll j = 0; j < e; j++)
#define fork(e) for(ll k = 0; k < e; k++)
#define forsi(s,e) for(ll i = s; i < e; i++)
#define forsj(s,e) for(ll j = s; j < e; j++)
#define forsk(s,e) for(ll k = s; k < e; k++)
#define forn(k,e) for(ll k = 0; k < e; k++)
#define forsn(i,s,e) for(ll i = s; i < e; i++)
#define forx(v) for(auto x:v)
#define gcd             __gcd
#define maxe           *max_element
#define mine           *min_element
#define deci(x, y)     fixed<<setprecision(y)<<x
#define ln "\n"
#define dbg(x) cout<<#x<<" = "<<x<<ln
#define mp make_pair
#define pb push_back
#define fi first
#define se second
#define INF 2e8
#define fast_cin() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define all(x) (x).begin(), (x).end()
#define sz(x) ((ll)(x).size())
 
void get_ar(ll *ar, ll n){
    fori(n) cin>>ar[i];
}
void printar(ll *ar, ll n){
    fori(n) cout<<ar[i]<<" ";
    cout<<"\n";
}
 
void print_vect(vll v){
    forx(v) cout<<x<<" ";
    cout<<"\n";
}
 
 
int dp[1000005][105];
 
void solve(){
    int n,i,j,k,temp,ans,N;
    cin >>n>>N;
    ll ar[105];
    get_ar(ar,n);
    sort(ar,ar+n);
    dp[0][0]=0;
    forsi(0,N+1){
        forsj(0,n+1){
            if (i==0 and j==0)continue;
            if (j==0){
                dp[i][j]=INF;
                continue;
            }
            dp[i][j]=INF;
            if (i-ar[j-1] >=0){
                dp[i][j]=min(dp[i][j-1],dp[i-ar[j-1]][j]+1);
            }
            else{
                dp[i][j]=dp[i][j-1];
            }
        }
 
    }
    ans=dp[N][n];
    if (ans>1000000){
        cout<<-1<<"\n";
    } else cout<<ans<<"\n";
 
 
 
 
 
 
 
 
}
int main()
{
    fast_cin();
    ll t=1;
//  cin >> t;
    for(int it=1;it<=t;it++) {
        solve();
    }
    return 0;
}
