#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
typedef long double ld;
#define modulo 1000000007;
ll play(vector<ll> &v, vector<ll> &c, vector<bool> &checked, ll x)
{
    if (checked[x - 1])
    {
        return v[x - 1] % modulo;
    }
    for (int i = 0; i < c.size(); i++)
    {
        if (x < c[i])
        {
            break;
        }
        else
        {
            if (x != c[i])
                v[x - 1] = (play(v, c, checked, x - c[i]) + v[x - 1]) % modulo;
        }
    }
    checked[x - 1] = 1;
    return v[x - 1] % modulo;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll n, x;
    cin >> n >> x;
    vector<ll> c(n);
    vector<ll> v(x);
    vector<bool> checked(x);
    for (ll i = 0; i < x; i++)
    {
        v[i] = 0;
        checked[i] = 0;
    }
    for (ll i = 0; i < n; i++)
    {
        cin >> c[i];
        if (c[i] <= x)
            v[c[i] - 1] = 1;
    }
    sort(c.begin(), c.end());
    cout << play(v, c, checked, x) % modulo;
}