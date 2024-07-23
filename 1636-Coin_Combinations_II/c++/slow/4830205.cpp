#include<bits/stdc++.h>
using namespace std;
 
int mod=1e9+7;
 
int32_t main(){
	int n,target;
	cin>>n>>target;
	vector<int> nums(n);
	for(int i=0;i<n;i++)cin>>nums[i];
	vector<int> dp(target+1,0);
    dp[0]=1;
    for(int i=0;i<nums.size();i++){
        for(int j=1;j<=target;j++){
            if(j>=nums[i]){
            dp[j]=(dp[j]%mod+dp[j-nums[i]]%mod)%mod;
            }
        }
    }
    cout<<dp[target]<<endl;
	return 0;
}