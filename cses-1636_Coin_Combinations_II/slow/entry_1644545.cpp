#include <iostream>
#include <limits.h>
#include <cstdint>
#include <vector>
#include <string>
#include <math.h>
#include <algorithm>
#include <numeric>
#include <map>
#include <unordered_map>
#include <set>
#include <cstring>
#include <deque>
#include <stack>
#include <queue>
#include <utility> 
#include <iomanip>      // std::setprecision
#include <sstream>      // std::stringstream
using namespace std;
typedef long long l1;
typedef long long unsigned lu1;
typedef long double ld;
#define FIO std::ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define PI acos(-1.0)
#define pb push_back
// #define SORT(A) sort(A.begin(), A.end());
// #define REVERSE(A) reverse(A.begin(), A.end());
#define deb(x) cout << #x << ": " << x << "\n"
#define PrintArray(arr) for(int i=0;i<(int)arr.size();i++)cout<<arr[i]<<" ";cout<<"\n";
#define pii pair<int,int>
#define pll pair<long long int , long long int>
#define puu pair<long long unsigned , long long unsigned>
// #define int long long
const int MOD = 1e9+7;
 
const int N = 1e6+1;
// int dp[100+1][N];
// int solve(int arr[], int n, int indx, int temp)
// {
//     if(indx < 0 || temp <0 ) return 0;
//     if(temp == 0) return 1;
//     if(dp[indx][temp] != -1) return dp[indx][temp];
//     return dp[indx][temp] = (solve(arr,n,indx,temp-arr[indx])%MOD + solve(arr,n,indx-1,temp)%MOD)%MOD;
// }
 
int32_t main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    // FIO;
    int t;
    t = 1;
    // cin>>t; 
    for (int tc=0;tc<t;tc++) 
    {   
        int n, target;
        cin>>n>>target;
        // scanf("%lld %lld",&n,&target);
        vector<vector<int> > dp(n+1, vector<int>(target+1,0));
        int arr[n];
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<=target;j++) dp[i][j] = 0;
        }
        for(int i1=0;i1<n;i1++) 
        {
            cin>>arr[i1];
            // scanf("%lld",&arr[i1]);
        }
        for(int i=0;i<n;i++) dp[i][0] = 1;
        // int ans = solve(arr,n,n-1,target);
        // cout<<ans%MOD<<"\n";
        
        // for(int sum = 1 ;sum<=target;sum++)
        // {
        //     for(int i=0;i<n;i++)
        //     {
                // if(i>0) dp[i][sum] += dp[i-1][sum];
                // if(sum-arr[i]>=0)
                // {
                //     dp[i][sum] = (dp[i][sum] + dp[i][sum-arr[i]]);
                // }
        //     }
        // }
        for(int i=0;i<n;i++)
        {
            for(int sum=1;sum<=target;sum++)
            {
                if(i>0) dp[i][sum] += dp[i-1][sum];
                if(sum-arr[i]>=0)
                {
                    dp[i][sum] = (dp[i][sum]%MOD + dp[i][sum-arr[i]]%MOD)%MOD;
                }
            }
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<=target;j++) cout<<dp[i][j]<<" ";
        //     cout<<"\n";
        // }
        cout<<dp[n-1][target]%MOD<<"\n";
        // printf("%lld\n",(dp[n-1][target]%MOD));
    }
 
    #ifndef ONLINE_JUDGE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
    #endif
    return 0;
}