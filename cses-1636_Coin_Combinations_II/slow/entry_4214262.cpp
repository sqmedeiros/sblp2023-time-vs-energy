//sahil animesh is working on this code........
#include<bits/stdc++.h>
using namespace std;
#define ll long long int
int c=1e9+7;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    ll n,m;
    cin>>n>>m;
    vector<int> v(n),dp(m+1,0);
    for(int i=0;i<n;i++)
    {
        cin>>v[i];
    }
    dp[0]=1;
    for(int i=0;i<n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            if(j>=v[i])
            {
                dp[j]=(dp[j]%c+dp[j-v[i]]%c)%c;
            }
        }
    }
    cout<<dp[m]<<endl;
}