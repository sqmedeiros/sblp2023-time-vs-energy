#include<bits/stdc++.h>
#define pb push_back
#define mp make_pair
#define fr first
#define sc second
#define len(x) x.size()
#define max3(a,b,c) man(a,man(b,c))
#define min3(a,b,c) min(a,min(b,c))
#define speed ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
const char digits[] = "00010203040506070809101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596979899";
 
//  *****IMPORTANT NOTE*****
// dont forget to change return type of these functions same as to your variable data type.
// use get_num for taking input.
// use put_num for output.
// use putchar_unlocked(' '); for spacing.
inline void put_num(ll n) {
  char buf[32];
	int idx = 0;
 
	if (n == 0) {
		putchar_unlocked('0');
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
		putchar_unlocked(buf[idx]);
	}
}
 
inline ll get_num() {
	ll chr = getchar_unlocked();
	ll a = chr - '0';
 
	while (true) {
		chr = getchar_unlocked();
		if (chr < '0') return a;
		a = a * 10 + chr - '0';
	}
}
 
ll solve(ll row,ll col)
{
    if(row==1 && col==1)
      return 1;
    if(row==col)
      return row*(row-1)+1;
    if(row>col)
    {
      if(row%2==0)
        return row*row-col+1;
      return (row-1)*(row-1)+col;
    }
    else
    {
      if(col%2!=0)
        return col*col-row+1;
      return (col-1)*(col-1)+row;
    }
 
}
int32_t main()
{
    speed
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
 
    ll test,row,col;
    test=get_num();
    while(test--)
    {
        row=get_num();
        col=get_num();
        put_num(solve(row,col));
        putchar_unlocked('\n');
        //code here
    }
 
    return 0;
 
}