#include<bits/stdc++.h>
using namespace std;
 
 
#define vi vector<int>
 
#define vvi vector<vector<int>>
#define fo(i,a,b) for(i=a;i<b;i++)
#define all(x) x.begin(),x.end()
#define trav(x) for(auto it=x.begin();it!=x.end();it++)
#define mod 1000000007
#define Endl endl
#define pb push_back
#define mp make_pair
#define inf 1e9
typedef pair<int, int> ii;
typedef vector<ii> vii;
typedef set<int> si;
typedef map<string, int> msi;
#define siz 1e7+1
#define watch(x) cout << (#x) << " is " << (x) << endl
#define ll long long int
#define N 8
 
 
 
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
  ll t=1,i,j,k;
 // cin>>t;
 
 
  while(t--)
  {
   ll n,maxp;
   cin>>n>>maxp;
   vi cost(n);
   vi page(n);
   fo(i,0,n)
   cin>>cost[i];
   fo(i,0,n)
   cin>>page[i];
   int dp[100001][1001];
   for(i=0;i<=maxp;i++)
   {
       dp[i][0]=0;
   }
    for(i=0;i<=n;i++)
   {
       dp[0][i]=0;
   }
 
   for(i=1;i<=maxp;i++)
   {
       for(j=1;j<=n;j++)
       {
           if(cost[j-1]>maxp)
           dp[i][j]=dp[i][j-1];
           else
           {
               if(i-cost[j-1]>=0)
               dp[i][j]=max(dp[i][j-1],page[j-1]+dp[i-cost[j-1]][j-1]);
               else
               dp[i][j]=dp[i][j-1];
           }
       }
   }
   cout<<dp[maxp][n];
 
 
 
  }
    return 0;
}