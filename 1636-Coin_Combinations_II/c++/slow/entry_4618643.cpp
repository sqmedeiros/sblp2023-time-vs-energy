#include <bits/stdc++.h>
 
using namespace std;
int mod = 1e9+7;
int main()
{
    int n,x; cin >> n >> x;
    
    int dp[x+1];
    for(int i = 0; i<=x; i++)dp[i] = 0;
    dp[0] = 1;
    
    vector<int> coin(n);
    for(int i = 0; i<n; i++)cin >> coin[i];
    
    for(int j = 0; j<n; j++){
        for(int i = 1; i<=x; i++){
            if(coin[j]>i)continue;
            dp[i] = (dp[i]%mod + dp[i-coin[j]]%mod)%mod;
        }
    }
    
    cout << dp[x] << endl;
    
    return 0;
}