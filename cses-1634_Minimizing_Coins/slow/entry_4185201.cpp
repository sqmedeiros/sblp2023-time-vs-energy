// Author: OptimalKnight
 
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#include <functional>
#include <chrono>
 
using namespace std;
using namespace __gnu_pbds;
using namespace chrono;
 
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("Ofast")
#pragma GCC target("fma,sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,tune=native")
 
#define ios ios_base::sync_with_stdio(false);cin.tie(NULL);
 
#define max4(a,b,c,d) max(max((a),(b)),max((c),(d)))
#define max3(a,b,c) max(max((a),(b)),(c))
#define min4(a,b,c,d) min(min((a),(b)),min((c),(d)))
#define min3(a,b,c) min(min((a),(b)),(c))
 
#define ll long long
#define pll pair<long long,long long>
#define endl "\n"
#define all(V) V.begin(),V.end()
#define sz(x) (long long)x.size()
 
#define d0(x) cout<<(x)<<" "
#define d1(x) cout<<(x)<<endl
#define d2(x,y) cout<<(x)<<" "<<(y)<<endl
 
#define take(x) for(auto &y:x) cin>>y
#define show(x) for(auto y:x) cout<<y<<" "; cout<<endl
#define showp(x) for(auto y:x) cout<<y.first<<" "<<y.second<<endl; cout<<""
#define ye(x) ((x)==0)?(cout<<"YES"<<endl):(cout<<"Yes"<<endl)
#define no(x) ((x)==0)?(cout<<"NO"<<endl):(cout<<"No"<<endl)
 
ll dx[]={-1,0,0,1, -1,-1,1,1};
ll dy[]={0,-1,1,0, -1,1,-1,1};
 
template<typename T> using ordered_set = tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;
// find_by_order(K): Returns an iterator to the Kth largest element(counting from zero)
// order_of_key(K): Returns the number of items that are strictly smaller than K
 
mt19937_64 gen(chrono::steady_clock::now().time_since_epoch().count());
// uniform_int_distribution<long long> dis(L,R);
// dis(gen): Produces uniformly distributed integer values on the closed interval [L,R]
// dis.reset(): Resets the distribution
 
const long long MOD=1e9+7;
// const long long MOD=998244353;
const long long INF=1e18;
const long double PI=3.14159265358979323846264338;
 
// Template Ends
 
int main(){
    ios
    #ifndef ONLINE_JUDGE
        freopen("INPUT.txt", "r", stdin);
        freopen("OUTPUT.txt", "w", stdout);
    #endif
 
    ll Tests=1;
    // cin>>Tests;
    for(ll tt=1;tt<Tests+1;tt++){
        ll N,X;
        cin>>N>>X;
        vector<ll> coin(N);
        for(auto &x:coin){
            cin>>x;
        }
 
        vector<ll> dp(X+1,0);
        for(ll i=1;i<=X;i++){
            dp[i]=INF;
            for(auto x:coin){
                if((i-x)>=0){
                    dp[i]=min(dp[i],dp[i-x]+1);
                }
            }
        }
 
        if(dp[X]==INF){
            dp[X] = -1;
        }
        cout<<dp[X]<<endl;
    }
 
    return 0;
}