#include<bits/stdc++.h>
using namespace std;
#define ll  long long
#define rep(i,a,n) for(int i=a;i<n;i++)
#define rev(i,a,n) for(int i=n-1;i>=a;i--)
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define gcd __gcd
#define pi pair<int,int>
#define pll pair<ll,ll>
#define tc           ll t1; cin>>t1; while(t1--)
#define inp         ll n; cin>>n; ll arr[n]; rep(i,0,n) cin>>arr[i];
#define vect vector<ll>
#define sortv(v)       sort(v.begin(),v.end())
#define lower(v,n)    lower_bound(v.begin(),v.end(),n)-v.begin()
#define upper(v,n)    upper_bound(v.begin(),v.end(),n)-v.begin()
#define all(v)        v.begin(),v.end()
#define bitcount(n) __builtin_popcount(n)
#define ln <<endl
#define inf          INT_MAX
#define ninf         LONG_MIN
#define fast()       ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
const   ll mod=1e9+7;
const ll N=2e5+5;
 
int main()
{
 fast();
 int n,sum;
 cin>>n>>sum;
 int coin[n];
 rep(i,0,n)
 cin>>coin[i];
 sort(coin,coin+n);
 vector<int>dp(sum+1);
 dp[0]=1;
 for(int i=1;i<=sum;i++){
 	for(int j=0;j<n;j++){
 		if(coin[j]>i)
 		break;
 		else
 		dp[i]=(dp[i]%mod+dp[i-coin[j]]%mod)%mod;
	 }
 }
 cout<<dp[sum]%mod;
return 0;
}
 