#include <bits/stdc++.h>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/pb_ds/assoc_container.hpp>
 
using namespace std;
using namespace __gnu_pbds;
 
template <class T>
using Tree = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
 
#ifdef ONLINE_JUDGE
#pragma GCC optimize("Ofast","unroll-loops","omit-frame-pointer","inline","O3")
#endif // ONLINE_JUDGE
 
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define uni(x) (x).erase(unique(all(x)), (x).end())
#define rnk(x, y) upper_bound(all((x)), (y)) - (x).begin()
 
template <class T = int>
using ii = pair<T, T>;
template <class T = int>
using tri = tuple<T, T, T>;
 
typedef long double ld;
typedef long long ll;
// typedef __int128 LL;
 
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
 
static int rnd(int lo, int hi)
{
    return uniform_int_distribution<int>(lo, hi)(rng);
}
 
int Get(int k, vector<int> &p)
{
    return p[k] == k ? k : p[k] = Get(p[k], p);
}
 
typedef vector<vector<ll>> mat;
 
// global variables
 
const ld eps = 1e-9;
const ll oo = 2e18 + 100;
 
const int MAX = 1e5+10;
const ll mod = 1e9+7;
 
ll complete_search(vector<ll> &vec, ll n, int i = 0, int count = 0)
{
    if(i==vec.size()){
        return 0;
    }
    ll ans = n/vec[i];
    ans -=complete_search(vec, n/vec[i], i+1, count+1);
    ans +=complete_search(vec, n, i+1, count);
    return ans;
}
 
void solve()
{
    ll n, k; cin >> n >> k;
    vector<ll> vec(k);
    for(int i=0;i<k;i++){
        cin >> vec[i];
    }
    cout << complete_search(vec, n) << "\n";
}
 
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("in.txt", "r", stdin);
#endif // ONLINE_JUDGE
    int t = 1;
    for (int i = 1; i <= t; i++){
        solve();
    }
 
    return 0;
}
