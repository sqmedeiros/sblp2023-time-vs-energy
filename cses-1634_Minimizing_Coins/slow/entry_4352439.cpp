#include<bits/stdc++.h>
using namespace std;
#define int long long int
vector<int>v;
vector<int>dp(1e6+1,-2);
 
int m(vector<int>p)
{
    if(p.size()==0)
    return 0;
    int min=p[0];
    for(auto i:p)
    if(i<min)
    min=i;
    return min;
}
 
int mini(int n)
{
    if(n<0)
    return -1;
    if(n==0)
    return 0;
    if(dp[n]!=-2)
    return dp[n];
    vector<int>k;
    for(auto i:v)
    {
        int s=mini(n-i)+1;
        if(s!=0)
        k.push_back(s);
    }
    dp[n]=m(k);
    if(dp[n]==0)
    dp[n]=-1;
    return dp[n];
}
 
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n,x;
    cin>>n>>x;
    int a;
    for(int i=0;i<n;i++)
    {
        cin>>a;
        v.push_back(a);
    }
    sort(v.begin(),v.end());
    for(auto i:v)
    dp[i]=1;
    int t=v[n-1];
    for(int i=t;i<=1000000;i+=t)
    dp[i]=i/t;
    for(int i=1;i<v[0];i++)
    dp[i]=-1;
    cout<<mini(x);
    return 0;
}