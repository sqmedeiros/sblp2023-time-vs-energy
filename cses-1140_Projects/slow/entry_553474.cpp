#include <bits/stdc++.h>
using namespace std;
 
using ll = long long;
#define fastio() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
 
const int N=4e5;
int n,a[N],b[N];
ll p[N],dp[N];
vector<int> st[N];
 
void compress() {
	set<int>v;
	map<int,int>m;
	int cnt=0;
	for(int i=0;i<n;++i)v.insert(a[i]),v.insert(b[i]);
	for(int i:v)m[i]=cnt++;
	for(int i=0;i<n;++i)a[i]=m[a[i]],b[i]=m[b[i]];
}
 
int main() {
	fastio();
	cin>>n;
	for(int i=0;i<n;++i)cin>>a[i]>>b[i]>>p[i];
	fill_n(dp,N,0);
	compress();
	for(int i=0;i<n;++i)st[a[i]].push_back(i);
	for(int i=N-2;i>=0;i--){
		dp[i]=dp[i+1];
		for(int x:st[i])dp[i]=max(dp[i],p[x]+dp[b[x]+1]);
	}
	cout<<dp[0]<<'\n';
}