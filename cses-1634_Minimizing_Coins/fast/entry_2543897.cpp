#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#include<bits/stdc++.h>
using namespace std;
#define hackcyborg shresth_walia
#define ll long long
#define ld long double
#define pb push_back
#define mod 1000000007
#define IO ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
#define ordered_set tree<int,null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
ll bp(ll a,ll b)
{
    ll res=1;
    while(b>0)
    {
        if(b&1)
        res=(a*res);
        a=(a*a);
        b/=2;
    }
    return res;
}
const int N=1e6+10;
int dp[N]={0};
main() {
    int n,X;
    cin>>n>>X;
    for(int x=0;x<N;x++)
       dp[x]=1e9;
    dp[0]=0;
    int a[n];
    for(int x=0;x<n;x++)
      cin>>a[x];
    for(int x=0;x<n;x++)
    {
        for(int y=a[x];y<=N;y++)
        dp[y]=min(dp[y],dp[y-a[x]]+1);
    }
    if(dp[X]<1e9)
    cout<<dp[X]<<"\n";
    else
        cout<<-1;
}