#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace std;
using namespace __gnu_pbds;
 
#define pb push_back
#define mk make_pair
#define ff first
#define ss second
#define fast ios::sync_with_stdio(false);cin.tie(0);
 
typedef long long ll;
typedef unsigned long long ull;
typedef long double ld;
typedef tree<int, null_type, less<int>,
        rb_tree_tag, tree_order_statistics_node_update> ordered_set;
 
int n, x;
vector<int> v;
int dp[1000005];
 
void calc(int sum, int len = 0){
	
	if(sum == x){
		if(dp[sum] == -1) dp[sum] = len;
		else dp[sum] = min(dp[sum], len);
		return;
		}
	if(sum > x) return;
	
	if(dp[sum] != -1 && dp[sum] <= len) return;
	dp[sum] = len;
	
	for(int i=0;i<n;i++){
		calc(sum + v[i], len+1);
		}
	
	}
 
int main(){
	fast
	
	cin>>n>>x;
	v.resize(n);
	for(int i=0;i<n;i++){
		cin>>v[i];
		}
	sort(v.begin(),v.end());
	reverse(v.begin(),v.end());
	
	fill(dp,dp+x+1,-1);
	
	calc(0);
	cout<<dp[x];
	
return 0;
}