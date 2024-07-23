/** 
 * Dont raise your voice, improve your argument.
 * --Desmond Tutu
 */
 
#include <bits/stdc++.h>
using namespace std;
 
typedef long long ll;
 
const char digits[] =
		"00010203040506070809101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596979899";
 
#define pc(x) putchar_unlocked(x);
inline void writeInt(ll n) {
	char buf[32];
	int idx = 0;
 
	if (n == 0) {
		pc('0');
		return;
	}
 
	while (n >= 100) {
		ll val = n % 100;
		buf[idx++] = digits[val * 2 + 1];
		buf[idx++] = digits[val * 2];
		n /= 100;
	}
 
	while (n) {
		buf[idx++] = n % 10 + '0';
		n /= 10;
	}
 
	while (idx--) {
		pc(buf[idx]);
	}
}
 
#define gc() getchar_unlocked()
 
inline void fs(ll &number) {
	int c = gc();
	while (c == ' ' || c == 10)
		c = gc();
 
	number = 0;
	while (c >= '0' && c <= '9') {
		number = number * 10 + c - '0';
		c = gc();
	}
}
 
void solve() {
    ll llx, lly;
    fs(lly);
    fs(llx);
 
    ll ans;
    if(lly>=llx) {
        if(lly&1)
            ans=(lly-1)*(lly-1)+llx;
        else {
            ans=lly*lly-llx+1;
        }
    } else {
        if(llx&1)
            ans=(llx*llx)-lly+1;
        else {
            ans=((llx-1)*(llx-1))+lly;
        }
    }
 
    writeInt(ans);
    pc('\n');
}
 
int main() {
    int t;
    cin>>t;
 
    while(t--)
        solve();
}
 