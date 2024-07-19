#include <bits/stdc++.h>
#define int long long
using namespace std;
int dp[1000000];
int arr[1000000];
int a[1000000];
main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int n,res=0;
    cin>>n;
    dp[0]=0;
    for(int i=1; i<=n; i++)
    {
        cin>>arr[i];
        if(dp[i-1]+arr[i]>0)
        {
            dp[i]=dp[i-1]+arr[i];
        }
        else
        {
            dp[i]=0;
        }
        a[i]=arr[i];
    }
    sort(a+1,a+n+1);
    for(int i=1; i<=n; i++)
    {
        res=max(res,dp[i]);
    }
    if(a[n]>=0)
    {
        cout<<res<<endl;
    }
    else
    {
        cout<<a[n]<<endl;
    }
 
 
    return 0;
}