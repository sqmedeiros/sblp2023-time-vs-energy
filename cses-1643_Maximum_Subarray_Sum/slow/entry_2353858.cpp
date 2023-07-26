/*   __               (\_/)
  ._( .)<(MEOW) (WOOF)('V')
   \____)             (U U)
*/
#include <bits/stdc++.h>
#define name "cses" //pls dont forget your task's name
#define maxn 101001
#define cut cout << endl
#define ll long long
#define boost() ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
#define forup(i, start, end) for (int i = start; i <= end; ++i)
#define forupIn(i, start, end, in) for (int i = start; i <= end && cin >> in; ++i)
#define forupChar(i, start, end) for (char i = start; i <= end; ++i)
#define fordown(i, start, end) for (int i = start; i >= end; --i)
#define fordownChar(i, start, end) for (char i = start; i >= end; --i)
#define Fin(name) freopen(name ".inp", "r", stdin)
#define Fout(name) freopen(name ".out", "w", stdout)
const void IO()
{
    Fin(name);
    Fout(name);
}
using namespace std;
 
int main()
{
    boost();
    // IO();
    int n(0), cp(0);
    cin >> n;
 
    map<ll, ll> f;
    forup(i, 1, n)
    {
        cin >> f[i];
        f[i] += f[i - 1];
    }
    ll res(INT_MIN);
    ll mn(INT_MAX);
    forup(i, 1, n)
    {
        mn = min(mn, f[i - 1]);
        res = max(res, f[i] - mn);
    }
    cout << res;
    return 0;
}
