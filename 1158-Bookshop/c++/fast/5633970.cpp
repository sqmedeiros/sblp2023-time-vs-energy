#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("O3")
#pragma GCC optimization ("unroll-loops")
 
#include<bits/stdc++.h>
using namespace std;
 
const int N = 1e3+10;
int h[N], s[N], dp[100010];
void solve(){
    int n, x;
    cin>>n>>x;
    for(int i = 0; i < n; i++){
        cin>>h[i];
    }
    for(int i = 0; i < n; i++){
        cin>>s[i];
    }
    fill(dp, dp+x+1, 0);
    for(int i = 0; i < n; i++){
        for(int j = x; j >=h[i]; j--){
            dp[j] = max(dp[j], s[i] + dp[j-h[i]]);
        }
    }
 
    cout<<dp[x];
}
 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    solve();
    return 0;
}
