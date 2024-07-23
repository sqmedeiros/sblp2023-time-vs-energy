#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n, x;
    cin>>n>>x;
    int c[n];
    int p[n];
    for(int i=0; i<n; i++) cin>>c[i];
    for(int i=0; i<n; i++) cin>>p[i];
    if(x==0||n==0) return 0;
    int dp[n+1][x+1];
    memset(dp, -1, sizeof(dp));
    for(int i=0; i<=n; i++){
        for(int j=0; j<=x; j++){
            if(i==0|| j==0) dp[i][j]=0;
        }
    }
    
    for(int i=1; i<n+1; i++){
        for(int j=1; j<x+1; j++){
            if(c[i-1]<=j){
                dp[i][j]=max(dp[i-1][j-c[i-1]]+p[i-1],dp[i-1][j]);
            }
            else
            {
                dp[i][j]=dp[i-1][j];
            }
        }
    }
 
    cout<<dp[n][x]<<endl;
 
}