#include <bits/stdc++.h>
#include <iostream>
using namespace std;
typedef long long ll;
#define F first
#define S second
#define pb push_back
#define ve vector<ll>
#define vc vector<char>
#define vs vector<string>
#define sortve(v) sort(all(v))
#define vp vector<pair<ll, ll>>
#define deb(x) cout << x << " "
#define all(v) (v).begin(), (v).end()
#define meme(a) memset(a, -1, sizeof(a))
#define deb2(x, y) cout << x << " " << y
#define rsrt(v) sort(v.rbegin(), v.rend())
#define f(i, n) for (ll i = 0; i < n; i++)
#define f2(i, a, b) for (ll i = a; i < b; i++)
#define f1(i, n) for (ll i = 1; i < n + 1; i++)
#define rev(i, n) for (ll i = n - 1; i >= 0; i--)
#define precision(x) cout << fixed << setprecision(x);
#define tc    \
    ll t;     \
    cin >> t; \
    while (t--)
#define fast                      \
    ios_base::sync_with_stdio(0); \
    cin.tie(nullptr);             \
    cout.tie(nullptr)
#define bas cout << "\n";
const ll PI = 3.1415926535897932384626;
const ll mod = 1000000007;
const ll FMOD = 998244353;
ll dx[4] = {1, -1, 0, 0};
ll dy[4] = {0, 0, 1, -1};
const ll N = 100005;
const double eps = 1e-9;
 
// Let's Go 😇
 
int main()
{
    ll n, b;
    cin >> n >> b;
    vector<ll> a(n);
    f(i, n) cin >> a[i];
    vector<ll> temp = a;
    map<int, vector<pair<int, int>>> m;
 
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            m[a[i] + a[j]].push_back({i, j});
        }
 
        for (int j = i + 1; j < n; j++)
        {
            int sum = temp[i] + temp[j];
            if (b < sum)
            {
                continue;
            }
            vector<pair<int, int>> v = m[b - sum];
            for (auto it : v)
            {
                int x = it.first, y = it.second;
 
                if (i == x || i == y || j == x || j == y)
                    continue;
                i++, j++, x++, y++;
                cout << i << ' ' << j << ' ' << x << ' ' << y;
                return 0;
            }
        }
    }
 
       cout << "IMPOSSIBLE";
 
    return 0;
}
 
/* SERIOUSLY, It ⬇ ain't a JOKE ⬇ */
 
/* The problem  is either
   in conditional statements
   or the increments or %mod or
   endl or you are printing
   something else, try for n=0,n=1*/
