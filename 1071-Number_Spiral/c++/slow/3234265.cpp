#include <bits/stdc++.h>
#define test \
  int t;     \
  cin >> t;  \
  while (t--)
#define init(arr, val) memset(arr, val, sizeof(arr))
#define loop(i, a, b) for (int i = a; i < b; i++)
#define loopr(i, a, b) for (int i = a; i >= b; i--)
#define loops(i, a, b, step) for (int i = a; i < b; i += step)
#define looprs(i, a, b, step) for (int i = a; i >= b; i -= step)
#define ull unsigned long long int
#define ll long long int
#define P pair
#define PLL pair<long long, long long>
#define PII pair<int, int>
#define PUU pair<unsigned long long int, unsigned long long int>
#define L list
#define V vector
#define D deque
#define ST set
#define MS multiset
#define M map
#define UM unordered_map
#define mp make_pair
#define pb push_back
#define pf push_front
#define FAST                        \
  ios_base::sync_with_stdio(false); \
  cin.tie();                        \
  cout.tie();
#define all(a) a.begin(), a.end()
#define deb(x) cerr << #x << ' ' << '=' << ' ' << x << '\n'
const int mod = 1e9 + 7;
const int MOD = 998244353;
inline int add(int x, int y)
{
  x += y;
  if (x >= mod)
    x -= mod;
  return x;
}
inline int sub(int x, int y)
{
  x -= y;
  if (x < 0)
    x += mod;
  return x;
}
inline int mul(int x, int y) { return (x * 1ll * y) % mod; }
using namespace std;
 
const ll maxn = 1e5;
const ll inf = 1e9;
const double pi = acos(-1);
ll n, m, a, b, c, d, p, q, x, y, z, minn, maxx;
 
void solve()
{
 
  cin >> x >> y;
 
  ll mxm = max(x, y);
  ll valMxm = (mxm * mxm) - (mxm - 1);
  deb(valMxm);
 
  if (mxm % 2 == 0)
  {
    if (x > y)
    {
      cout << valMxm + (mxm - y) << endl;
    }
    else
    {
      cout << valMxm - (mxm - x) << endl;
    }
  }
  else
  {
    if (x > y)
    {
      cout << valMxm - (mxm - y) << endl;
    }
    else
    {
      cout << valMxm + (mxm - x) << endl;
    }
  }
}
 
signed main()
{
  FAST int t = 0;
  cin >> t;
  while (t--)
  {
    solve();
  }
  return 0;
}