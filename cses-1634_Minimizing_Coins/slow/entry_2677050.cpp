#include <bits/stdc++.h>
using namespace std;
 
#define ll long long
const ll int mod = (ll)1e9+7;
#define endl "\n"
const ll int INF = 1e16;
 
//do use flushout in interactive problems
 
 
//calculate GCD in log(min(a,b))
ll int gcd (ll int a,ll int b) {
    while (b) {
        a %= b;
        swap(a, b);
    }
    return a;
}
 
//calculate a^b in logb 
ll int binexp(ll int a,ll int b){
    int ans=1;
    while(b!=0){
        if(b&1){
            ans=ans*a;
            b=b-1;
        }else{
            a*=a;
            b=b/2;
        }
    }
    return ans;
}
//calculate modular exp in logb
long long binpowm(long long a, long long b, long long m) {
    a %= m;
    long long res = 1;
    while (b > 0) {
        if (b & 1)
            res = res * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return res;
}
 
ll int rollinghash(string s){
    ll int pr=1;
    ll int hash=0;
    for(int i=0;i<s.length();i++){
        hash=(hash+((s[i]-'a'+1)*pr)%mod)%mod;
        pr*=31;//any prime greater than 26 for generating any newer formulas too
    }
    return hash;
}
/*-----------------------------------------------------------------------------
------------------------------------------------------------------------------*/
 
 
void solve(){
    int n,x;
    cin>>n>>x;
    int a[n+5];
    for(int i=1;i<=n;i++){
        cin>>a[i];
    }
    int dp[x+5][n+5];
    
    memset(dp,0,sizeof dp);
    
    for(int i=1;i<=x;i++){
        dp[i][0]=10000000;
    }
    for(int i=0;i<=x;i++){
        for(int j=1;j<=n;j++){
            if(i-a[j]>=0){
                dp[i][j]=min(dp[i][j-1],1+dp[i-a[j]][j]);
            }else{
                dp[i][j]=dp[i][j-1];
            }
        }
    }
    if(dp[x][n]==10000000){
        cout<<-1<<endl;
    }else{
        cout<<dp[x][n]<<endl;
    }
    
}
 
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll int t=1;
    ll int cc=1;
    // cin>>t;
    while(t--){
        // cout<<"Case #"<<cc<<": ";cc++;
        solve();
    }
	
	return 0;
}