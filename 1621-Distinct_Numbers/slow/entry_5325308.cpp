#include<bits/stdc++.h>
#define int long long int
using namespace std;
 
 
void Stable_Count(int exp,vector<int> &a)
{
	vector<int> f(10,0);
	
	for(auto it:a)
	{
		f[(it/exp)%10]++;
	}
 
	
	for(int i=1;i<10;i++) f[i]+=f[i-1];
	
	
	vector<int> ans(a.size());
	
	
	for(int i=a.size()-1;i>=0;i--)
	{
		int pos=f[(a[i]/exp)%10];
		pos--;
		f[(a[i]/exp)%10]--;
		ans[pos]=a[i];
	}
	
	
	for(int i=0;i<a.size();i++) a[i]=ans[i];
	
	
}
 
 
void Radix_Sort(vector<int> &a)
{
	int tt=1;
	for(int i=1;i<=10;i++)
	{
		
		Stable_Count(tt,a);
		
		tt=tt*10;
	}
}
 
void Insertion_Sort(vector<int> &a)
{
	int n=a.size();
	for(int i=1;i<n;i++)
	{
		int t=i;
		while(t>0 and a[t]>a[t-1])
		{
			swap(a[t],a[t-1]);
			t--;
		}
	}
}
vector<int> ans(200000);
void Merge(vector<int> &a,int ss,int ee,int s,int e)
{
	
	int l=ss;
	int r=e;
	int t=ss;
	while(ss<=ee or s<=e)
	{
		if(ss>ee) 
		{
			ans[t++]=a[s];
			s++;
		}
		else if(s>e)
		{
			ans[t++]=a[ss];
			ss++;
		}
		else
		{
			if(a[s]<a[ss])
			{
				ans[t++]=a[s++];
			}
			else
			{
				ans[t++]=a[ss++];
			}
		}
	}
	for(int x=l;x<=r;x++) a[x]=ans[x];
}
 
void Merge_Sort(vector<int> &a,int s,int e)
{
//	cout<<"s="<<s<<" e="<<e<<"\n";
	if(s==e||s>e) return;
//	else if(s+1==e) 
//	{
//		if(a[s]>a[e]) swap(a[s],a[e]);
//		return;
//	}
	else
	{
		int mid=(s+e)/2;
		Merge_Sort(a,s,mid);
		Merge_Sort(a,mid+1,e);
		Merge(a,s,mid,mid+1,e);
	}
}
 
int partition(vector<int> &a,int low,int high)
{	
	int pivot=a[high];
	int i=low-1;
	int p=2;
	
	
	for(int j=low;j<high;j++)
	{
		if(a[j]<=pivot)
		{
			if( a[j]==pivot and ++p and p%2==0)
			{
				i++;
				swap(a[i],a[j]);
			}
			else if(a[j]<pivot)
			{
				i++;
				swap(a[i],a[j]);
			}
		}
	}
	i++;
	swap(a[i],a[high]);
	return i;
	
}
 
void Quick_Sort(vector<int> &a,int l,int r)
{
	if(l<r)
	{
		int pidx=partition(a,l,r);
	//	cout<<"Pidx="<<pidx<<"\n";
		Quick_Sort(a,l,pidx-1);
		Quick_Sort(a,pidx+1,r);
	}
}
 
 
int32_t main()
{
	
	
	int n;
	cin>>n;
	vector<int> a;
	for(int i=0;i<n;i++) 
	{
		int x;
		cin>>x;
		a.push_back(x);
	}
	
	Quick_Sort(a,0,a.size()-1);
	int ans=1;
	for(int i=1;i<n;i++) ans+=(a[i]!=a[i-1]);
//	for(auto it:a) cout<<it<<" "<<"\n";
	cout<<ans;
	
	return 0;
	
}
 
 