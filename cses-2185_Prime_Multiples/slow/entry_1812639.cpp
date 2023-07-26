#include<bits/stdc++.h>
using namespace std;
//#include <unordered_map>
#define  ll long long int
#define ld long double
int set_bits(int mask)
{
	int c=0;
	while(mask)
	{
		if(mask&1)
		c++;
		mask=mask>>1;
	}
	return c;
}
void solve()
{
	ll n;
	cin>>n;
	int k;
	cin>>k;
	ll a[k];
	for(int i=0;i<k;i++)
	cin>>a[i];
	ll sum=0;
	for(int mask=1;mask<(1<<k);mask++)
	{
		int j=set_bits(mask);
		ll pr=1;
		bool flag=0;
		for(int i=0;i<k;i++)
		{
			if(mask&(1<<i))
			{
				int lna=log(pr);
				int lnb=log(a[i]);
				int lnn=log(n);
				if(lna+lnb>lnn)
				{
					flag=1;
					break;
				}
				pr=pr*a[i];
			}
		}
		if(flag)
		continue;
//		cout<<"pr "<<pr<<"  for mask "<<mask<<endl;
		ll k=n/pr;
		if(j%2)
		sum+=k;
		else
		sum-=k;
	}
	cout<<sum<<endl;
}
 
int main()
{
	
	int t;
	ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
	solve();
}
