 
#include <bits/stdc++.h>
using namespace std;
 
#define ll                       long long
#define F                        first
#define S                        second
#define pii                      pair<int, int>
#define pb                       push_back
#define pf                       push_front
#define arr_fill(a, n)           for(ll i = 0 ; i < n ; i++){cin >> a[i];}
#define arr_fill_sum(a,n,sum)    for (ll i = 0 ; i < n ; i++){cin >> a[i];sum+=a[i];}
#define arr_out(a,n)             for (ll i = 0 ; i < n ; i++){cout << a[i] <<" ";}
#define fast                     ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
#define int ll
const ll MAXN = 1e6 + 56;
const ll MOD = 1e9 + 7;
const ll INF = 1e18 + 7;
ll pw(ll a, ll b){return b == 0 ? 1LL : (pw(a * a  , b / 2) * (b % 2 == 0 ? 1LL : a));}
pair<pii, int> p[MAXN];
vector <pii> End[MAXN];
map<int, int> mp;
set<int> v;
int dp[MAXN];
 
int32_t main()
{
	fast
    int n; cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> p[i].first.first >> p[i].first.second >> p[i].second;
        v.insert(p[i].first.first);
        v.insert(p[i].first.second);
    }
    int rnk = 1;
    for (int x : v)
    {
        mp[x] = rnk;
        rnk++;
    }
    for (int i = 0; i < n; i++)
    {
        End[mp[p[i].F.S]].pb({mp[p[i].first.first], p[i].second});
    }
    dp[0] = 0;
    for (int i = 1; i <= rnk; i++)
    {
        dp[i] = dp[i - 1];
        for (int j = 0; j < End[i].size(); j++)
        {
            int st = End[i][j].first, pr = End[i][j].second;
            dp[i] = max(dp[i], dp[st - 1] + pr);
            ///cout << i <<' ' << st - 1 <<' ' << dp[st - 1] << ' ' << pr << ' ' << dp[i] <<'\n';
        }
        ///cout << i << ' ' << dp[i] <<'\n';
    }
    cout << dp[rnk - 1] << '\n';
}
 
///Thanks GOD