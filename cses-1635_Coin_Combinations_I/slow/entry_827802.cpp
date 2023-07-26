#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <climits>
#include <unordered_map>
#include <set>
#include <map>
#include <stack>
#include <queue>
 
 
#define lli unsigned long long int
#define pb push_back
#define mod 1e9+7
#define fi(i,n) for(int i=1; i<=n;i++)
#define INF 10000000000
#define unm  unordered_map<int , int>
#define vvi  vector<vector<int>>
#define sortall(v) sort(v.begin(),v.end())
#define deb(x)     cout << #x << "=" << x << endl
#define deb2(x,y)  cout << #x << "=" << x << "," << #y << "=" << y << endl
#define mp make_pair
#define F  first
#define S second
#define itr(it,a) for(auto it = a.begin(); it!=a.end();it++)
#define vi  vector<int>
#define pii pair<int ,int>
#define vii vector<vi>
using namespace std;
 
int main(){
	int n ,x; cin >> n >> x;
	vi coins(n);
	for(auto &i : coins) cin >> i;
	
	vi dp(x+1);
	dp[0] = 1;
	for(int i=1; i<=x;i++){
		for(int j= 0; j<n;j++){
			if(coins[j] <= i){
				dp[i] = dp[i] + dp[i-coins[j]];
				if(dp[i] > mod) dp[i]-=mod;
			}
		}
	}
 
	cout << dp[x] << endl;
}
 