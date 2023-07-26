#include <bits/stdc++.h>
 
using namespace std;
typedef long long ll;
#define int long long int
#define loop(i,a, n) for (int i = a; i < n; i++)
#define vec(a,n) vi a(n);loop(i,0,n) cin>>a[i];
#define endl '\n'
#define vi vector<int>
#define pb push_back
#define sort(a) sort(a.begin(),a.end());
const int mod = 1e9 + 7;
#define take(n) int(n); cin >> n;
#define NO cout<<"NO"<<endl;return;
#define YES cout<<"YES"<<endl;return;
#define track(x) cerr<<#x<<"="<<x<<endl;
 
 
void solve()
{
	take(r);
	take(c);
	int l,a;
	int ans;
	a=max(r,c)*max(r,c);
	l=(max(r,c)-1)*(max(r,c)-1);
	if(r>=c){
		if(r%2==1){
			ans=(r-1)*(r-1)+1+c-1;
		}
		else{
			ans=r*r+1-c;
		}
	}
	else{
		if(c%2==1){
			ans=c*c+1-r;
		}
		else{
			ans=(c-1)*(c-1)+1+r-1;
		}
	}
	cout<<ans<<endl;
}
 
int32_t main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    int test_cases=1;
    cin >> test_cases;
    int i=test_cases;
    while (test_cases--)
    {
        track(i-test_cases);
        solve();
    }
 
    return 0;
}