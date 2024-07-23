#include<bits/stdc++.h>
#define ll  int
using namespace std;
#define const unsigned int M = 1000000007 ;
 
#define  quick  ios_base::sync_with_stdio(false); cin.tie(0);cout.tie(0);
#define s(x) sort(x.begin(),x.end())
#define sr(x) sort(x.begin(),x.end(),greater<ll>())
#define v1 vector<ll>
 
#define p1 pair<ll,ll>
#define m1 map<ll,ll>
#define take(v,n) for(i=0;i<n;i++)    cin>>v[i];
#define print(v,n) for(i=0;i<n;i++)    cout<<v[i]<<" ";
#define ff first
#define ss second
#define ee  endl ; 
#define pb push_back
#define all(v) v.begin(),v.end()
#define f(i,x,y) for(i=x;i<y;i++)
#define mp make_pair
#define yes cout<<"YES"<<endl
#define no  cout<<"NO"<<endl
 
 
void  solve()
{
    ll n,x ,i,j; 
    cin>>n>>x ;
    
    ll  t[n+1][x+1] ; 
    memset(t , INT_MAX ,sizeof(t)) ; 
    v1  a(n)  ; 
    take(a,n);  
    for(i=0;i<n+1 ;i++)
    {
            for(j=0;j<x+1;j++)
            {
                    if( j==0)
                       t[i][j] = 0; 
                    if(i==0)
                       t[i][j] = INT_MAX - 1 ;   
            }
    }  
    for(i = 1 ;i<=n;i++)
    {
             for(j=1;j<=x;j++)
            {
                if(j % a[0] == 0 )
                      t[i][j] = j / a[0] ; 
                else 
                  t[i][j]  = INT_MAX -  1 ;       
            }
    }
    for(i=1;i<n+1;i++)
    {
            for(j=1;j<x+1;j++)
            {
                   if(a[i-1]<=j)
                       t[i][j] = min (t[i-1][j] , 1  +  t[i][j- a[i-1]] ); 
                   else
                      t[i][j]  = t[i-1][j] ; 
            }
    }
   
    if(t[n][x]==INT_MAX - 1)
     {
         cout<<-1<<ee ;
         return ;  
      }   
    cout <<t[n][x]<<ee;
}
 
 
 int32_t main()
 { 
    quick ; 
    ll t = 1 ; 
    //cin>>t;
    while(t--)
    {
          solve();
    } 
    return 0;
 }