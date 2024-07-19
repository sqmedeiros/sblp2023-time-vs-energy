#include <bits/stdc++.h>
using namespace std;
#define ft              first
#define sd              second
#define ll          long long
#define pb              push_back
#define mkp           make_pair
#define pll             pair<ll,ll>
#define vll             vector<int>
#define mll             map<ll,ll>
#define pqg             priority_queue<ll>
#define pqs             priority_queue<ll,vll,greater<ll>>
#define vectorbits(x)      __builtin_popcountll(x)
#define zrobits(x)      __builtin_ctzll(x)
#define mod          1000000007
#define inf             1e18
#define ps(x,y)         fixed<<vectorprecision(y)<<x
void online_judge()
{
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    freopen("error.txt", "w", stderr);
#endif
}
 
void ISO()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}
ll binarySearch(pair<ll,ll> a[], ll l, ll r, ll k)
{
    while (l <= r)
    {
        ll mid = l + (r - l) / 2;
        if (a[mid].first == k)
        {
            return a[mid].second;
        }
        else if (a[mid].first < k)
        {
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    return -1;
}
int main() {
 
    ISO();
    online_judge();
    int t;
    t = 1;
    while (t--)
    {
 
 
        int n;
        cin >> n;
        ll a[n];
        ll int ans = INT_MIN;
        for (int i = 0; i < n; ++i)
        {
            ll z;
            cin >> z;
            a[i] = z;
            ans = max(ans,a[i]);
        }
        ll sum = 0;
        
        if(ans < 0)
        {
            cout << ans <<"\n";
            return 0;
        }
        for(int i=0;i<n;++i)
        {
            cerr << sum <<" ";
            ans = max(ans,a[i]);
            if((sum + a[i]) < 0)
            {
                ans = max(sum,ans);
                sum = 0;
            }
            else
            {
                sum += a[i];
                ans = max(sum,ans);
            }
        }
        ans = max(sum,ans);
        cout << ans <<"\n";
    }
 
 
    cerr << "Time elapsed: " << clock() / 1000 << " ms" << endl;
    return 0;
}
