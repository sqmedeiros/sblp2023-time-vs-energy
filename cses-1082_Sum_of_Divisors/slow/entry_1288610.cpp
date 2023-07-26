#include <bits/stdc++.h>
 
#define M 1000000007
 
using namespace std;
 
long long powmod(long long a, long long n){
	if (n == 0) return 1%M;
	a = a%M;
	long long u = powmod(a, n/2);
	u = (u*u)%M;
	if (n%2) u = (u*a)%M;
	return (u+M)%M;
}
 
long long invmod(long long x){
	return powmod(x, M-2);
}
 
long long sum(long long a, long long b){
	return (long long) (((a+b)%M)*((b-a+1)%M)%M)*(invmod(2)%M)%M;
}
 
int main(){
	long long n;
	cin >> n;
	long long l = 1;
	long long res = 0;
	while (l <= n){
		long long k = n/l;
		long long r = n/k;
		res += (long long) ((sum(l, r)%M)*(k%M))%M;
		res %= M;
		l = r+1;
	}
	res %= M;
	cout << res << "\n";
	return 0;
}
