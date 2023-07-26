#include <bits/stdc++.h>
// Uncomment them for optimisations
//#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#define GET_MACRO(_1, _2, _3, _4, NAME, ...) NAME
#define range(...)                         \
    GET_MACRO(__VA_ARGS__, r4, r3, r2, r1) \
    (__VA_ARGS__)
#define r4(var, start, stop, step) for (auto var = start; var != stop; var = var + step)
#define r3(var, start, stop) for (auto var = start; var != stop; var++)
#define r2(var, stop) for (ll var = 0; var != stop; var++)
#define r1(stop) for (ll start_from_0 = 0; start_from_0 != stop; start_from_0++)
using namespace std;
#define endl "\n"
#define INF LONG_LONG_MAX
#define INT_INF INT_MAX
#define ll long long
#define ld long double
#define V vector
#define P pair
#define S string
#define MS multiset
#define UM unordered_map
#define US unordered_set
#define MM multimap
#define mp make_pair
#define pb push_back
#define pf push_front
#define fi first
#define se second
#define FAST ios_base::sync_with_stdio(NULL), cin.tie(NULL), cout.tie(NULL);
#define all(a) a.begin(), a.end()
#define db(x) cout << #x << " = " << x << "\n"
#define new_string(str) \
    string str;         \
    cin >> str;
#define new_int_1(t) \
    ll t;            \
    cin >> t;
#define new_int_2(a, b) \
    ll a, b;            \
    cin >> a >> b;
#define new_int_3(a, b, c) \
    ll a, b, c;            \
    cin >> a >> b >> c;
#define new_int_4(a, b, c, d) \
    ll a, b, c, d;            \
    cin >> a >> b >> c >> d;
#define new_int_5(a, b, c, d, e) \
    ll a, b, c, d, e;            \
    cin >> a >> b >> c >> d >> e;
#define new_int_6(a, b, c, d, e, f) \
    ll a, b, c, d, e, f;            \
    cin >> a >> b >> c >> d >> e >> f;
const ll mod = 1000000007;
const ll mod2 = 998244353;
const ld pi = acos(-1);
typedef vector<string> vs;
typedef vector<ll> vi;
typedef pair<ll, ll> pii;
typedef map<ll, ll> mii;
typedef set<ll> si;
void print(ll &x) { cout << x << endl; }
void print(vi x)
{
    for (auto &i : x)
        cout << i << " ";
    cout << endl;
}
void print(string s) { cout << s << endl; }
ll input()
{
    new_int_1(n);
    return n;
}
vi inputvec(ll n, ll start = 0)
{
    vi vec(n);
    for (ll i = start; i < n; i++)
    {
        vec[i] = input();
    }
    return vec;
}
template <typename T>
bool btn(T a, T b, T c)
{
    if ((a <= b && b <= c) || (a >= b && b >= c))
        return true;
    return false;
}
 
ll func()
{
    // write your code here
    ll n, s;
    cin >> n >> s;
    vector<int> p;
    for (ll i = 0; i < n; i++)
    {
        new_int_1(x);
        p.push_back(x);
    }
    vector<int> bp;
    for (ll i = 0; i < n; i++)
    {
        new_int_1(x);
        bp.push_back(x);
    }
 
    // int dp[s + 1][n + 1];
    vector<vector<int>> dp(s + 1, vector<int>(n + 1));
    for (int i = 0; i <= s; i++)
    {
        dp[i][0] = 0;
    }
 
    for (int i = 0; i <= n; i++)
    {
        dp[0][i] = 0;
    }
 
    for (int i = 1; i <= s; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (i - p[j - 1] >= 0)
            {
                ll a = bp[j - 1] + dp[i - p[j - 1]][j - 1];
                ll b = dp[i][j - 1];
                dp[i][j] = a > b ? a : b;
            }
            else
                dp[i][j] = dp[i][j - 1];
        }
    }
 
    cout << (dp[s][n]) << endl;
 
    return 0;
}
 
int main()
{
    // Uncomment for faster I/O
    // FAST;
 
    {
        func();
    }
}