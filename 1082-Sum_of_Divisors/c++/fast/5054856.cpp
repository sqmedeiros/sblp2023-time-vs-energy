//Wed Nov 10 23:48:28 IST 2021
#include<bits/stdc++.h>
#include <bits/stdc++.h>
using namespace std;
#define vc vector
#define int int64_t
#define mk make_pair
#define pb push_back
#define gh cout<<'\n';
#define PII pair<int,int>
#define all(x) x.begin(),x.end()
#define Fo(i,k,n) for(int i=k;i<=n;i++)
#define Ro(i,n,k) for(int i=n;i>=k;i--)
#define w(x) cout<<'['<<(#x)<<" : "<<(x)<<"]"<<" ";
#define play(A,k,n) cout<<(#A)<<" : ";Fo(i,k,n)cout<<A[i]<<' ';gh;
 
void Solve(){
	int n, mod = 1e9 + 7, ans = 0;
	cin >> n;
	for(int i=1, sn = sqrt(n); i<=sn; ++i){
		int T = (n/i)%mod;
		ans += i*T + ((sn + T + 1)*(T - sn))/2;
		ans%=mod;
	}
	cout << ans << endl;
}
 
int32_t main(){
	cin.tie(0)->sync_with_stdio(0);
	int Test=1;//cin >> Test;
	Fo(tc,1,Test){//cout << "Case #" << tc << ": ";
		Solve();
	}
	return 0;
}
