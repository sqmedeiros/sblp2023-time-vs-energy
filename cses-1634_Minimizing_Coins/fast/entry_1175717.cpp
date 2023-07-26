#pragma GCC optimize ("Ofast,unroll-loops,-ffloat-store")
#pragma GCC target ("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#include <bits/stdc++.h>
using namespace std;
const int nmax=1e6+5;
const int mod=1e9+7;
int n,x,c[nmax];
int dp[nmax];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    //freopen("main.inp","r",stdin);
    //freopen("main.out","w",stdout);
    cin>>n>>x;
    for (int i=1;i<=n;i++)
        cin>>c[i];
    memset(dp,0x3f,sizeof dp);
    dp[0]=0;
    for (int i=1;i<=n;i++)
        for (int j=c[i];j<=x;j++)
            dp[j]=min(dp[j],dp[j-c[i]]+1);
    if (dp[x]<nmax)
        cout<<dp[x];
    else cout<<-1;
}