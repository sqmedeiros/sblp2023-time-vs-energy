#include<bits/stdc++.h>
#define FAST ios_base::sync_with_stdio(false);cin.tie();cout.tie();
#define FILE_READ_IN freopen("input.txt","r",stdin);
#define FILE_READ_OUT freopen("output.txt","w",stdout);
#define deb(x) cout<<#x<<":= "<<x<<"\n";
#define MOD 1000000007
#define amax(x,y) x=max(x,y);
#define amin(x,y) x=min(x,y);
using namespace std;
typedef long long ll;
typedef long double ld;
const int N = 1e5;
 
void solve()
{
   // write your logic here
   int n, x; cin >> n >> x;
   vector<int> a(n);
   for (int i = 0; i < n; i++) cin >> a[i];
   // for amount x find dp[x] += dp[x-c[i]] where i-c[i] >= c[i]
 
   int dp[n + 1][x + 1];
   memset(dp, 0, sizeof(dp));
 
   dp[0][0] = 1;
 
   /*
      dp[i][j] = number of ways making j using upto i coins
   */
   // for (int i = 1; i <= n; i++)
   // {
   //    for (int j = 0; j <= x; j++)
   //    {
   //       dp[i][j] = dp[i - 1][j];
   //       if (j >= a[i - 1] )
   //       {
   //          (dp[i][j] += dp[i][j - a[i - 1]]) %= MOD;
   //       }
   //    }
   // }
 
   for (int j = 0; j <= x; j++)
   {
      for (int i = 1; i <= n; i++)
      {
         dp[i][j] = dp[i - 1][j];
 
         if (j >= a[i - 1] )
         {
            (dp[i][j] += dp[i][j - a[i - 1]]) %= MOD;
         }
      }
   }
   cout << dp[n][x] << "\n";
}
 
int main()
{
   FAST
#ifndef ONLINE_JUDGE
   FILE_READ_IN
   FILE_READ_OUT
#endif
   int t = 1;
   // cin>>t;
   while (t--)
   {
      solve();
   }
   return 0;
}