#pragma GCC optimize ("Ofast")
//#pragma GCC target ("avx2")
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using str = string;
using vi = vector<int>;
using vl = vector<ll>;
using vb = vector<bool>;
using vs = vector<str>;
using pi = pair<int,int>;
using pl = pair<ll,ll>;
using vpi = vector<pair<int,int>>;
#define rsz resize
#define pb push_back
#define sz(x) (int)(x).size()
#define all(x) begin(x),end(x)
#define sor(x) sort(begin(x),end(x));
#define FOR(i,a,b) for(ll i=a; i<(ll)b; ++i)
#define ROF(i,a,b) for(ll i=a-1; i>=b; --i)
#define TRAV(a, x) for(auto& a:x)
#define fi first
#define se second
#define mp make_pair
#define ins insert
#define u_map unordered_map
#define u_set unordered_set
#define u_multiset unordered_multiset
void setPrec() { cout << fixed << setprecision(15); }
void unsyncIO() { cin.tie(0)->sync_with_stdio(0); }
void setIn(str s) { freopen(s.c_str(),"r",stdin); }
void setOut(str s) { freopen(s.c_str(),"w",stdout); }
void setIO(str s = "") {
    unsyncIO(); setPrec();
    if(sz(s)) setIn(s+".in"), setOut(s+".out");
}
 
int main() {
	setIO();
	int n, x; cin >> n >> x;
	vector<int> dp(x+1, 1e9);
	dp[0] = 0;
	while(n--) {
		int c; cin >> c;
		for(int i = 0; i <= x-c; ++i) {
			dp[i+c] = min(dp[i+c], dp[i]+1);
		}
	}
	cout << (dp[x]==1e9 ? -1 : dp[x]) << "\n";
	return 0;
}
