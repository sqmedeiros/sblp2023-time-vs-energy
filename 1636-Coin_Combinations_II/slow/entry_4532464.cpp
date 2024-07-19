#include<bits/stdc++.h>
using namespace std;
#define sp(y) fixed<<setprecision(y)
#define t_c int t_;cin>>t_;while(t_--)
#define inparr(arr) for(auto &x: arr){cin>>x;}
#define printarr(arr) for( auto x: arr){cout<<x<<" ";}
#define CY cout<<"YES\n"
#define CN cout<<"NO\n"
#define loop(i,a,b) for(int i=(a);i<=(b);i++)
#define looprev(i,a,b) for(int i=a;i>=b;i--)
 
int dx[8] = {1, -1, 0,  0, 1,  1, -1, -1};
int dy[8] = {0,  0, 1, -1, 1, -1,  1, -1};
void fastIO(){
     ios_base::sync_with_stdio(false);
     cin.tie(NULL);
 
}
int mod = 1e9+7;
 
void solve(){
     int n,x;cin>>n>>x;
     int arr[n];
     inparr(arr);
     int dp[1000005]={0};
     dp[0]=1;
     sort(arr,arr+n);
     loop(i,0,n-1){
          loop(j,1,x){
               int val = j - arr[i];
               if(val>=0){
                    dp[j] = (dp[j]%mod + dp[val]%mod ) %mod;
               }
          }
     }
     cout<<dp[x]<<endl;
}
int32_t main(){
     fastIO();
     //t_c 
      solve();
     //int t_;cin>>t_;loop(i,1,t_){cout<<"Case "<<i<<": ";solve();}
     
          
    
}