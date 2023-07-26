#include <iostream>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <queue>
#include <set>
#include <unordered_map>
#include <map>
#include <vector>
#include <stack>
#include <algorithm>
#define MOD 1000000007
#define forn(a, n) for(tint a = 0; a<(int) (n); ++a)
#define dforn(a, n) for(int a = (n)-1; a>=0; --a)
#define forall(a, all) for(__typeof(all.begin()) a = all.begin(); a != all.end(); ++a)
#define EPS 0.000000000001
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;
typedef long long tint;
typedef vector<tint> vi;
typedef vector<vi> vvi;
typedef vector<vvi> vvvi;
typedef vector<pair<tint,tint>> vp;
typedef vector<vp> vvp;
typedef tree<pair<tint, tint>,null_type,less<pair<tint, tint>>,rb_tree_tag,tree_order_statistics_node_update> indexed_set;
 
int main()
{
	tint n, k;
	cin >> n >> k;
	vi p(k);
	forn(i, k) cin >> p[i];
	
	tint ans = 0;
	forn(mask, (1 << k)) {
		tint prod = 1, s = 1, ov = 0;
		forn(i, k) if(mask & (1<<i)) {
			s *= -1;
			if(log(prod)+log(p[i]) >= log(n+1)) {
				ov = 1;
			}
			prod *= p[i];
		}
		if(!ov) {
			ans += s*(n/prod);
		}
	}
	cout << n-ans << endl;
	
	return 0;
}
