#include <bits/stdc++.h>
using namespace std;
#define int long long int 
#define mod 1000000007
void comp(int arr[],int sum,int& c,int n){
	if(sum<0)
		return ;
	if( sum==0)
	{
		c++;
		return ;
	}
	
	for(int i=0;i<n;i++){
		comp(arr,sum-arr[i],c,n);
	}
}
int32_t main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);	
	freopen("output.txt", "w", stdout);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	// int n ,sum;
	// cin>> n>>sum;
	// int arr[n];
	// for(int i=0;i<n;i++)
	// {
	// 	cin>> arr[i];
 
	// }
	// int c=0;
	// comp(arr,sum,c,n);
	// cout<< c;
	int x,n;
	cin>>x>> n;
	vector<int> arr(x);
	for(int i=0;i<n;i++)
		cin>>arr[i];
	int dp[n+1]={0};
	dp[0]=1;
	sort(arr.begin(),arr.end());
	for(int i=1;i<=n;i++)
	{
		for(auto j:arr)
		{
			if(i-j>=0)
				dp[i] = (dp[i]%mod + dp[i-j]%mod)%mod;
			else 
				break;
		}
	}
	cout<< dp[n];
	
 
	
	return 0;
}