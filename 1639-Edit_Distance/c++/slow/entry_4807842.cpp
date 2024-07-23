#include <bits/stdc++.h>
using namespace std;
using ll = long long;
 
const int MAX_N = 1e5 + 1;
const ll mod = 1e9 + 7;
const ll inf = 1e9;
 
string start;
string en;
int n,m;
int dp[5050][5050];
 
int rec(int i,int j){
 
    if(i==n && j==m){
        return 0;
    }
    else if(i>=n && j<m){
        dp[i][j]=rec(i,j+1)+1;
    }
    else if(i<n && j>=m){
        dp[i][j]=rec(i+1,j)+1;
    }
 
    if(dp[i][j]!=-1)return dp[i][j];
 
    if(start[i]==en[j]){
        dp[i][j]=rec(i+1,j+1);
    }   
    else{
        dp[i][j]=min({rec(i+1,j)+1,rec(i+1,j+1)+1,rec(i,j+1)+1});
    }
 
    return dp[i][j];
}
 
void solve(){
 
    cin>>start>>en;
    n=start.length();
    m=en.length();
    memset(dp,-1,sizeof(dp));
 
    cout<<rec(0,0);
 
}
 
signed main(){
 
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
 
    //Read and write to txt files
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
 
    solve();
    
}