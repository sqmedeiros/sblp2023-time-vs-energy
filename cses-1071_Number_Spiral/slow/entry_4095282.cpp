#include <bits/stdc++.h>
using namespace std;
 
#define int long long
const int INF = 1000000010;
const int mod = 1000000007;
const int nMax = 2*1e5+10;
#define endl '\n'
#define siz(x) (int)(x).size()
#define gri greater<int>()
#define bitCount(x) __builtin_popcount(x)
#define all(x) (x).begin(), (x).end()
#define inarr(x) for (auto &i : x) cin >> i;
#define printarr(x) for (auto &i : x) cout << i << ' '; cout << endl;
bool comparePair(const pair<int, int> &a, const pair<int, int> &b)
{
    return a.first > b.first;
    return a.second < b.second;
}
//------------------------------------------//
 
 
 
void solve()
{
    int x, y; cin >> x >> y;
    int ans = 0;
 
    if (x > y)
    {
        if (!(x&1))
        {
            ans += x*x;
            ans -=(y-1);
            cout << ans;return;
        }
        else{
            ans+= (x-1)*(x-1) +1;
            ans +=(y-1);
            cout << ans;return;
        }
    }
    else
    {
        if (y&1)
        {
            ans += y*y;
            ans -= (x-1);
        }else
        {
            ans += (y-1)*(y-1)+1;
            ans += (x-1);
        }
            cout << ans;
        
    }
    
 
    
}
 
 
 
 
 
signed main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("in2.in", "r", stdin);
    freopen("out.in", "w", stdout);
    freopen("error.in", "w", stderr);
#endif
    cout << fixed << setprecision(6);
    int t = 1, test = 1;
    cin >> test;
 
 
    while (test >= t)
    {
        cerr << "TEST-" << t++ << endl;
        solve();
        cout << endl;
        cerr << endl;
    }
    return 0;
}