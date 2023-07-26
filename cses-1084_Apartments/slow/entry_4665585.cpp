#include <bits/stdc++.h>
#define ll long long
#define ii pair <int, int>
#define ill pair <int, ll>
#define llll pair <ll, ll>
#define el "\n"
#define modulo (ll)(1e9 + 7)
using namespace std;
//dont call y1 as a variable lol, also remember not to recall stuff lmao
ll n, m, k, a[2 * 100005], b[2 * 100005], ans;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    //freopen("Apartments.inp", "r", stdin);
    //freopen("Apartments.out", "w", stdout);
    ans = 0;
    cin >> n >> m >> k;
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }
    for (int i = 1; i <= m; i++)
    {
        cin >> b[i];
    }
    sort(a + 1, a + 1 + n);
    sort(b + 1, b + 1 + m);
    ll i = 1;
    ll j = 1;
    while (i <= m)
    {
        if (abs(b[i] - a[j]) <= k)
        {
            ans++;
            j++;
        }
        else if (abs(b[i] - a[j]) > k)
        {
            ll temp = j;
            while (b[i] > a[temp])
            {
                temp++;
                if (abs(b[i] - a[temp]) <= k)
                {
                    ans++;
                    j = temp + 1;
                    break;
                }
            }
        }
        i++;
    }
    cout << ans << el;
    return 0;
}