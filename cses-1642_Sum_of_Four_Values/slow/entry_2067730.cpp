// Problem: Sum of Four Values
// Contest: CSES - CSES Problem Set
// URL: https://cses.fi/problemset/task/1642
// Memory Limit: 512 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)
 
/*########  IN THE NAME OF ALLAH   ##########*/
 
#pragma GCC diagnostic ignored "-Wunused-variable"
#pragma GCC diagnostic ignored "-Wunused-parameter" 
#include<bits/stdc++.h>
using namespace std;
#pragma GCC diagnostic ignored "-Wunused-but-set-variable" 
#pragma GCC diagnostic ignored "-Wformat"
#define ll long long
#define ull unsigned long long
#define INF 999999999999999999
#define nl printf("\n")
#define sf1(x)  scanf("%d",&x)
#define sf2(x,y)  scanf("%d %d",&x,&y)
#define sf3(x,y,z)  scanf("%d %d %d",&x,&y,&z)
#define pf1(x)  printf("%d\n",x)
#define pf2(x,y)  printf("%d %d\n",x,y)
#define pf3(x,y,z)  printf("%d %d %d\n",x,y,z)
#define pc(x,y)  printf("Case %d: %d\n",x,y)
#define pcn(x)  printf("Case %d:\n",x)
#define pb push_back
#define mp make_pair
#define pa pair<int,int>
#define mem(a,b) memset(a,b,sizeof(a))
#define MIN  -99999999999999999
#define READ(f) freopen(f,"r",stdin)
#define WRITE(f) freopen(f,"w",stdout)
#define pi 2.0*acos(0.0)
#define pi2 acos(-1.0)
#define vs(v) (v.begin(),v.end())
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
ll power(ll B,ll P){ if(P==0) return 1; ll X=power(B,P/2); if(P%2==0) return X*X; else return B*X*X;}
int fx[]={1,-1,0,0}; int fy[]={0,0,1,-1};
int main()
{
   ll n,val;
   cin>>n>>val;
   vector<pair<ll,ll> >v;
   ll ar[n+4];
   for(int i=0;i<n;i++)
   {
   	 cin>>ar[i];
   	 v.push_back({ar[i],i+1});
   }
   
   sort(v.begin(),v.end());
   for(int i =0;i<n;i++)
   {
   	    for(int j =i+1;j<n;j++)
   	    {
   	    	int lo= j+1,hi=n-1;
   	    	while(lo<hi)
   	    	{
   	    		 int num = v[i].first+v[j].first+v[lo].first+v[hi].first;
   	    		 if(num==val)
   	    		 {
   	    		 	cout<<v[i].second<<" "<<v[j].second<<" "<<v[lo].second<<" "<<v[hi].second<<endl;return 0;
   	    		 }
   	    		 
   	    		 if(num>val) hi--;
   	    		 else if(num<val) lo++;
   	    	}
   	    }
   }
   
   cout<<"IMPOSSIBLE\n";
     
   
   /************ALEYA YOUSUF ************/
 
 /************ALLtAH IS ALMIGHTY ************/
return 0;
 
}
