#include "bits/stdc++.h"
using namespace std;
#define ll         long long int
#define pb         push_back
#define pf         push_front
#define all(x)     (x).begin(),(x).end()
#define sz(x)      (int)((x).size())
#define fr         first
#define sc         second
#define pii        pair<int,int>
#define F(i,a,b)   for(int i=a;i<b;i++)
#define mem1(a)    memset(a,-1,sizeof(a))
#define mem0(a)    memset(a,0,sizeof(a))
 
int mod=1e9+7;
 
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(0);cout.tie(0);
    int n,x;
    cin>>n>>x;
    vector<int>coins(n);
    for(auto &c:coins)cin>>c;
    vector<int>dp(x+1,0);
    dp[0]=1;
    for(int i=0;i<n;i++)
    {
        for(int j=1;j<=x;j++)
        {
            if(coins[i]<=j)
            dp[j]=(dp[j]%mod+dp[j-coins[i]]%mod)%mod;
        }
    }
    cout<<dp[x];
	return 0;
}