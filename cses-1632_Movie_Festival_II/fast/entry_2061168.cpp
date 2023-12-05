#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#include<bits/stdc++.h>
#include<stdio.h>
#include<math.h>
using namespace std;
 
static struct IO {
	char tmp[1 << 10];
 
	// fast input routines
	char cur;
 
//#define nextChar() (cur = getc_unlocked(stdin))
//#define peekChar() (cur)
	inline char nextChar() { return cur = getc_unlocked(stdin); }
	inline char peekChar() { return cur; }
 
	inline operator bool() { return peekChar(); }
	inline static bool isBlank(char c) { return (c < '-' && c); }
	inline bool skipBlanks() { while (isBlank(nextChar())); return peekChar() != 0; }
 
	inline IO& operator >> (char & c) { c = nextChar(); return *this; }
 
	inline IO& operator >> (char * buf) {
		if (skipBlanks()) {
			if (peekChar()) {
				*(buf++) = peekChar();
				while (!isBlank(nextChar())) *(buf++) = peekChar();
			} *(buf++) = 0; } return *this; }
 
	inline IO& operator >> (string & s) {
		if (skipBlanks()) {	s.clear(); s += peekChar();
			while (!isBlank(nextChar())) s += peekChar(); }
		return *this; }
 
	inline IO& operator >> (double & d) { if ((*this) >> tmp) sscanf(tmp, "%lf", &d); return *this;	}
 
#define defineInFor(intType) \
	inline IO& operator >>(intType & n) { \
		if (skipBlanks()) { \
			int sign = +1; \
			if (peekChar() == '-') { \
				sign = -1; \
				n = nextChar() - '0'; \
			} else \
				n = peekChar() - '0'; \
			while (!isBlank(nextChar())) { \
				n += n + (n << 3) + peekChar() - 48; \
			} \
			n *= sign; \
		} \
		return *this; \
	}
 
defineInFor(int)
defineInFor(unsigned int)
defineInFor(long long)
defineInFor(unsigned long long)
defineInFor(__int128)
 
	// fast output routines
 
//#define putChar(c) putc_unlocked((c), stdout)
	inline void putChar(char c) { putc_unlocked(c, stdout); }
	inline IO& operator << (char c) { putChar(c); return *this; }
	inline IO& operator << (const char * s) { while (*s) putChar(*s++); return *this; }
 
	inline IO& operator << (const string & s) { for (int i = 0; i < (int)s.size(); ++i) putChar(s[i]); return *this; }
 
	char * toString(double d) { sprintf(tmp, "%lf%c", d, '\0'); return tmp; }
	inline IO& operator << (double d) { return (*this) << toString(d); }
 
 
#define defineOutFor(intType) \
	inline char * toString(intType n) { \
		char * p = (tmp + 30); \
		if (n) { \
			bool isNeg = 0; \
			if (n < 0) isNeg = 1, n = -n; \
			while (n) \
				*--p = (n % 10) + '0', n /= 10; \
			if (isNeg) *--p = '-'; \
		} else *--p = '0'; \
		return p; \
	} \
	inline IO& operator << (intType n) { return (*this) << toString(n); }
 
defineOutFor(int)
defineOutFor(long long)
defineOutFor(unsigned long long)
defineOutFor(__int128)
 
#define endl ('\n')
#define cout __io__
#define cin __io__
} __io__;
 
typedef unsigned long long ll;
#define FOR(i,a,b) for(ll i=a; i<b; ++i)
#define pvec(v) for(auto &it : v) cout << it << " "; cout << endl;
#define ppair(arr) for(auto &k : arr) { cout << k.second << " " << k.first << endl;}
#define DEBUG(x) cout << #x << " = " << x << endl;
#define search(k,m) m.find(k) != m.end()
#define pb(x) push_back(x)
 
bool cmp(const pair<ll,ll> &a, const pair<ll,ll> &b) {
    return a.first < b.first;
}
 
void solve() {
	ll n, k; cin >> n >> k;
	pair<ll,ll> arr[n];
	FOR(i,0,n) {
		ll a, b; cin >> a >> b;
		arr[i] = make_pair(b,a);
	}
	sort(arr, arr+n);
	multiset<ll> s;
	//cout << endl;
	ll ans = 0;
	FOR(i,0,n) {
		if( s.empty() ) {
			s.insert(arr[i].first); ++ans;
			continue;
		}
		else {
			auto it = s.lower_bound(arr[i].second);
			if( it == s.begin() ) {
				if(*it == arr[i].second) {
					s.erase(it); s.insert(arr[i].first); ++ans; }
				else if( s.size() < k ) {
					s.insert(arr[i].first); ++ans;
				}
				else
					continue;
			}
			else if( it == s.end() ) {
				s.erase(--it); s.insert(arr[i].first); ++ans;
			}
			else if( *it == arr[i].second ) {
				s.erase(it); s.insert(arr[i].first); ++ans;
			}
			else{
				s.erase(--it); s.insert(arr[i].first); ++ans;
			}
		}
		//pvec(s);
	}
	cout << ans;
}
 
int main() {
    ios_base::sync_with_stdio(false); //cin.tie(NULL);
    //auto start = chrono::steady_clock::now();
    solve();
    //auto end = chrono::steady_clock::now();  auto diff = end - start;  cout << chrono::duration <double> (diff).count() << "s" << endl;
}
//??????????????????????????????????????????????
