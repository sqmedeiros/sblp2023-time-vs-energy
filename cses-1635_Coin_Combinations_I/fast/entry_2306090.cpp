#include <bits/stdc++.h>
using namespace std;
#define REP(i,a,b) for (long long i = a; i < b; i++)
#define REF(i,a,b) for (int i = a; i < b; i++)
#define PB push_back 
#define MP make_pair
#define arrin(a,n) forn(i,n) cin >> a[i];
typedef long long ll;
typedef vector<long long> vl;
typedef vector<int> vi;
#define F first 
#define S seconds
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")
 
 
int main(){
 
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    ios::sync_with_stdio(0);
 
    static int arr[100], dp[1000001];
    int n, sum;
    long long temp;
    
    cin>>n>>sum;
    REF(i,0,n)cin>>arr[i];//store value of coins
    dp[0] = 1;
    REF(i,1,sum+1) {
        temp=0;
        REF(j,0,n)if (i >= arr[j])temp+= dp[i-arr[j]];
        dp[i] =temp % 1000000007;
    }
    cout<<dp[sum];
    return 0;
}