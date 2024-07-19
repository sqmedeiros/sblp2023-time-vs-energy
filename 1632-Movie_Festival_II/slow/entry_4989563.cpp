#include<bits/stdc++.h>
using namespace std;
#define ii pair<long long,long long>
#define fi first
#define se second
const int MAXN=400000;
long long seg[MAXN*4+5],lazy[MAXN*4+5];
map<long long,long long> M;
void down(int pos)
{
	long long val=lazy[pos];
	seg[pos*2]+=val,seg[pos*2+1]+=val;
	lazy[pos*2]+=val,lazy[pos*2+1]+=val;
	lazy[pos]=0;
	return ;
}
void update(int l,int r,int u,int v,long long val,int pos)
{
	if(v<l||r<u) return ;
	if(u<=l&&r<=v) { seg[pos]+=val,lazy[pos]+=val;return ; }
	int mid=(l+r)/2;
	down(pos);
	update(l,mid,u,v,val,pos*2);
	update(mid+1,r,u,v,val,pos*2+1);
	seg[pos]=max(seg[pos*2],seg[pos*2+1]);
}
long long getmax(int l,int r,int u,int v,int pos)
{
	if(v<l||r<u) return 0;
	if(u<=l&&r<=v) return seg[pos];
	int mid=(l+r)/2;
	down(pos);
	return max(getmax(l,mid,u,v,pos*2),getmax(mid+1,r,u,v,pos*2+1));
}
struct num
{
	long long l,r,pos;
};
bool sortt(num a,num b)
{
	if(a.l==b.l) return a.r>b.r;
	return a.l<b.l;
}
num A[200001];
priority_queue< ii,vector<ii> > B;
vector<int> C;
vector<int> D;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    long long n,k;
    cin>>n>>k;
    for(int i=1;i<=n;i++)
    {
    	cin>>A[i].l>>A[i].r;
    	A[i].pos=i;
    	D.push_back(A[i].l);
    	D.push_back(A[i].r);
	}
	sort(D.begin(),D.end());
	int c=1;
	M[D[0]]=1;
	for(int i=1;i<n*2;i++) if(D[i]!=D[i-1]) c++,M[D[i]]=c;
	for(int i=1;i<=n;i++) A[i].l=M[A[i].l],A[i].r=M[A[i].r]-1;
	sort(A+1,A+n+1,sortt);
	int pos=1;
	for(int i=1;i<=n*2;i++)
	{
		while(A[pos].l<=i&&pos<=n) { update(1,n*2,A[pos].l,A[pos].r,1,1);B.push({A[pos].r,A[pos].l*(n*2+1)+A[pos].pos}),pos++; }
		long long v=getmax(1,n*2,i,i,1);
		if(v>k)
		{
			for(int j=1;j<=v-k;j++)
			{
				C.push_back(B.top().se%(n*2+1));
				update(1,n*2,B.top().se/(n*2+1),B.top().fi,-1,1);
				B.pop();
			}
		}
	}
	cout<<n-C.size();
}
 