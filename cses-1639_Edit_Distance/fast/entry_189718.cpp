    #include <bits/stdc++.h>
    using namespace std;
 
    #define f(i,n) for(int i=1;i<=n;i++)
    #define fast ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0)
 
    const int N = 5010;
 
    int dp[2][N];
    string a,b;
 
    int main()
    {
     fast;
 
     cin >> a >> b;
 
     int n = a.length(), m = b.length();
 
     f(j,m) dp[0][j] = j;   
 
     f(i,n) 
     {
       dp[(i&1)][0] = i;
         
       f(j,m)
          dp[(i&1)][j] = min ( min( dp[1-(i&1)][j] , dp[(i&1)][j-1] ) + 1 , (a[i-1]!=b[j-1]) + dp[1-(i&1)][j-1] );
     }
     cout << dp[(n&1)][m];
    }