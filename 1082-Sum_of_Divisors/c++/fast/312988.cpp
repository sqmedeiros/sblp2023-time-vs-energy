#include <bits/stdc++.h>
#define ull unsigned long long
using namespace std;
#define mod 1000000007
int main(){
	ull n,e,a = 0;
	cin>>n;
	for (ull i = 1; i <= sqrt(n); ++i)
	{	
		e = (n/i)%mod;
		if(e>=i)	a = (a+(e-i)*i + e*(e+1)/2 - i*(i-1)/2)%mod;
	}
	cout<<a;
	return 0;
}
