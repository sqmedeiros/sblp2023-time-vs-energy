#include <bits/stdc++.h>
 
using namespace std;
 
#define ar array
#define ll long long
#define tc(t) int t; cin >> t;while(t--)
#define lp(i, x, y) for(ll i = x; i <= y; i++)
#define lpr(i, x, y) for(ll i = x; i >= y; i--)
#define in1(x) ll x; cin >> x
#define in2(x, y) ll x, y; cin >> x >> y
#define in3(x, y, z) ll x, y, z; cin >> x >> y >> z
#define mem(x, y) memset(x, (y), sizeof(x))
#define ite(it, l) for (auto it = l.begin(); it != l.end(); it++)
 
const int MAX = 1e5 + 5;
const int MOD = 1e9 + 7;
const int INF = 1e9;
const ll LINF = 1e18;
 
struct cmp {
    // bool lexical_compare(int a, int b) 
    bool operator() (const tuple<ll, ll, ll> &a, const tuple<ll, ll, ll> &b) const{
        return get<2>(a) < get<2>(b);
    }
};
 
ll rew[200005];
 
int main()
{
    // cin.tie(0); cout.tie(0); freopen("input.txt", "r", stdin); freopen("output.txt", "w", stdout);
 
    in1(n);
    multiset<tuple<ll, ll, ll>, cmp> projs;
    // map<ll, ll> 
    map<ll, ll> days;
    // days[0] = 0;
    lp(i, 0, n-1)
    {
        in3(a, b, c);
        projs.insert(make_tuple(c, a, b));
        days[a] = 0;
        days[b] = 0;
    }
    int cnt = 1;
    ite(it, days)
        it->second = cnt++;
    ll dp[cnt];
    dp[0] = 0;
    // lp(i, )
    // ite(it, days)
    //     cout << it->first << " ";
    auto it = days.begin();
    // auto prev = it;
    // it++;
    while(it != days.end())
    {
        dp[it->second] = dp[it->second-1];
        // auto options = projs.begin();
        auto options = projs.lower_bound(make_tuple(0,0,it->first));
        // cout << options->get()<2>;
        while(get<2>(*options) == it->first)
        {
            ll rew = dp[days[get<1>(*options)]-1] + get<0>(*options);
            if(rew > dp[it->second])
                dp[it->second] = rew;
            options++;
        }
        it++;
    }
    cout << dp[cnt-1] << endl;
}