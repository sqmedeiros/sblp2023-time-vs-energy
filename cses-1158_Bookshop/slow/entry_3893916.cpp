#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define f first
#define s second
#define _ ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
int main(){
    int n,x;
    cin>>n>>x;
    int price[n],space[n];
    for(int i=0;i<n;i++){
        cin>>price[i];
    }
    for(int i=0;i<n;i++){
        cin>>space[i];
    }
    int dp[x+1][n+1];
    for(int i=0;i<=n;i++){
        dp[0][i]=0;
    }
    for(int i=1;i<=x;i++){
        dp[i][0]=0;
        for(int j=1;j<=n;j++){
            if(i-price[j-1]>=0) dp[i][j]=max(dp[i][j-1],dp[i-price[j-1]][j-1]+space[j-1]);
            else dp[i][j]=dp[i][j-1];
        }
    }
    cout<<dp[x][n];
    return 0;
}