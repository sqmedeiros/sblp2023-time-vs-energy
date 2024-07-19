#include <bits/stdc++.h>
using namespace std;
#define int       long long int
#define vi        vector<int>
#define vii       vector<pii>
#define pii       pair<int, int>
#define mii       map<int, int>
#define pb        push_back
#define rev(v)    reverse(v.begin(), v.end())
#define all(v)    v.begin(), v.end()
#define rall(v)   v.rbegin(), v.rend()
#define endl      '\n'
#define F         first
#define S         second
#define PI        3.14159265359
#define MAXN      1000007
 
int32_t main()
{
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
 
    int n, m, k;
    cin >> n >> m >> k;
    vector<int> v1(n), v2(m);
    for (int i = 0; i < n; ++i)
    {
        cin >> v1[i];
    }
 
    for (int i = 0; i < m; ++i)
    {
        cin >> v2[i];
    }
 
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
 
    for (int u : v1) cerr << u << " ";
    cerr << endl;
    for (int u : v2) cerr << u << " ";
    cerr << endl;
 
    int ans = 0;
 
    int i = 0, j = 0;
    while (i < n and j < m)
    {
        // if (abs(v1[i] - v2[j]) <= k)
        // {
        //     ++ans;
        //     ++i, ++j;
        // }
        // else if (v1[i] > v2[j] + k) ++j;
        // else if (v1[i] < v2[j] - k) ++i;
 
        while (v1[i] < v2[j] - k and i < n) ++i;
        while (v1[i] > v2[j] + k and j < m) ++j;
        if (v1[i] >= v2[j] - k and v1[i] <= v2[j] + k)
            ++ans, ++i, ++j;;
 
    }
    cout << ans;
    return 0;
}