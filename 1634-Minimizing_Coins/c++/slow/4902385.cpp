#include <bits/stdc++.h>
using namespace std;
#define ll long long
const int MOD=1e9+7;
 
ll diceCombinations(int n){
    if(n<0) return 0;
    if(n<2) return 1;
    ll one = 1, two = 2, three = 4, four = 8, five = 16, six = 32;
    if(n<7){
        if(n==2) return two;
        if(n==3) return three;
        if(n==4) return four;
        if(n==5) return five;
        return six;
    }
    ll res;
    for(int i=7;i<=n;i++){
        res = (one + two + three + four + five + six)%MOD;
        one = two;
        two = three;
        three = four;
        four = five;
        five = six;
        six = res;
    }
    return res;
}
 
const int N = 1e6 + 7;
int dp[N];
 
int minimizingCoins(int n, int x, int a[]){
    if(x<0) return -1;
    if(x == 0) return 0;
    if(dp[x]) return dp[x];
    vector<int> res(n);
    for(int i=0;i<n;i++){
        res[i] = minimizingCoins(n, x-a[i], a);
    }
    int ans = INT_MAX;
    for(int i=0;i<n;i++){
        if(res[i]!=-1)
            ans = min(ans, res[i]);
    }
    if(ans == INT_MAX) ans = -1;
    return dp[x] = (ans == -1) ? -1 : (1 + ans);
}
 
int main(){
    int n, x;
    cin>>n>>x;
    int a[n];
    for(int i=0;i<n;i++)
        cin>>a[i];
    cout<<minimizingCoins(n, x, a);
    return 0;
}