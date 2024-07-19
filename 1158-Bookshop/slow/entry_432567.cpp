#include<bits/stdc++.h>
 
using namespace std;
typedef long long int ll;
int main()
{	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
 
	int n,x;
	cin>>n>>x;
	int price[n],pages[n];
	for(int i=0;i<n;i++)
	cin>>price[i];
	for(int i=0;i<n;i++)
	cin>>pages[i];
	int res[x+1][n];
	
	for(int p=0;p<n;p++)
	res[0][p]=0;
	//memset(res,0,sizeof(res));
	for(int i=1;i<=x;i++)
	{if(i-price[0]>=0)
	res[i][0]=pages[0];
	else
	res[i][0]=0;
	}
	for(int i=1;i<=x;i++)
	{	for(int p=1;p<n;p++)
		{	res[i][p]=0;
			if(i-price[p]>=0)
			{	
				res[i][p]=(pages[p]+res[i-price[p]][p-1]);
				
			}
			//if(p!=0)
			res[i][p]=max(res[i][p],res[i][p-1]);
		}
	}
	
	cout<<res[x][n-1]<<"\n";
}
 
 