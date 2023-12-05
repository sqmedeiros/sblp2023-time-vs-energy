#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#include<iostream>
using namespace std;
 
int main() {
    int dp[1000001],coins[101],i=0,n,x,j;
    dp[0]=1;
    cin>>n>>x;
    while(i<n) {
        cin>>coins[i++];
    }
    for(i=1;i<=x;) {
        long long tmp = 0;
        for(j=0;j<n;j++){
            if(i>=coins[j]){
                tmp += dp[i-coins[j]];
            }
        }
        dp[i++] = tmp%1000000007;
    }
    cout<<dp[x]<<"\n";
}
