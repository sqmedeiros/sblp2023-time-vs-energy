#include <bits/stdc++.h>
#include <unistd.h>
#define ll long long
using namespace std;
 
char ibuf[10000000];
ll bufidx = 0;
 
ll read_int() {
	while (!(('0' <= ibuf[bufidx]) && ('9' >= ibuf[bufidx])))
		bufidx++;
	ll ret = 0;
	while (('0' <= ibuf[bufidx]) && ('9' >= ibuf[bufidx])) {
		char n = ibuf[bufidx] - '0';
		ret *= 5;
		ret <<= 1;
		ret += n;
		bufidx++;
	}
	bufidx++;
	return ret;
}
 
int main() {
	read(0, ibuf, 10000000);
 
	ll n, m, k;
	n = read_int();
	m = read_int();
	k = read_int();
 
	ll a[n], b[m];
 
	for (ll i = 0; i < n; i++)
		a[i] = read_int();
 
	sort(a, a + n);
 
	for (ll i = 0; i < m; i++)
		b[i] = read_int();
 
	sort(b, b + m);
 
	ll idx = 0, ans = 0;
 
	for (ll i = 0; (i < n) && (idx < m); ) {
		if (b[idx] < a[i] - k) {
			idx++;
			continue;
		}
		if (b[idx] > a[i] + k) {
			i++;
			continue;
		}
		ans++;
		idx++;
		i++;
	}
 
	cout << ans;
 
	return 0;	
}
