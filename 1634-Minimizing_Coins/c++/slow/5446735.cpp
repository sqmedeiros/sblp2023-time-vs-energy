#include <bits/stdc++.h>
using namespace std;
#include <iostream>
#define Sa7afy_H333 ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define cin(v) for (auto&i:v) cin >> i;
#define cout(v) for (auto&i:v) cout << i << " ";cout<<e;
#include <algorithm>
#include <vector>
#define ll long long int
#define e '\n'
#define PI acos(-1)
#define PHI (long double)1.61803398875 //golden ratio
#define sin(a) sin((a)*PI/180)
#define cos(a) cos((a)*PI/180)
#define tan(a) tan((a)*PI/180)
#define ones(x) __builtin_popcountll(x)
#define all(v) v.begin(), v.end()
#define allr(v) v.rbegin(), v.rend()
#define pii pair<ll,ll>
#define vi vector<int>
#define vll vector<ll>
using std::cout;
using std::array; using std::fill;
using std::fill_n;
#include <set>
#include <deque>
#define d2v vector<vector<int>>
typedef pair<int,int> Pii;
#define  pb push_back
 
int dx[]={1,0,-1,0,1,1,-1,-1};
int dy[]={0,1,0,-1,1,-1,-1,1};
#define Time cerr << "Time Taken: " << (float)clock() / CLOCKS_PER_SEC << " Secs" << "\n";
const int o=1e5+10;
ll mod=1e9+7;
string dir = "DURL";
ll mult(ll a, ll b){ return ((a % mod) * (b % mod)) % mod; }
ll add(ll a, ll b) { return ((a % mod) + (b % mod)) % mod; }
ll sub(ll a, ll b) { return ((a % mod) - (b % mod) + mod) % mod; }
vector <ll> sqrt_divisors(ll n) {
    vector<ll> res;
    for (ll i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            res.pb(i);
            if (n / i != i) { res.pb(n / i); }
        }
    }
    sort(all(res));
    return res;
}
vector<ll> prime_factorization(ll n) {
    vector<ll> res;
    for (ll i = 2; i * i <= n; i += 1 + (1 & i)) {
        while (n % i == 0) {
            res.push_back(i);
            n /= i;
        }
    }
    if (n > 1)res.push_back(n);
    return res;
}
bool in(int i,int j,int n,int m) {
    return !(i < 0 || i > n - 1 || j < 0 || j > m - 1);
}
 
ll lcm(ll a, ll b) {
    return (a / __gcd(a, b)) * b;
}
ll n,tar;
const int N=1e6+2;
vi coins(105);
vector<vi>dp(102,vi(N,-1));
int go(int i ,int sum) {
    if (i == n || sum == 0)return 0;
    if (~dp[i][sum])return dp[i][sum];
    dp[i][sum] = 1e9;
    for (int c = 0; c < n; c++) {
        if (sum - coins[c] >= 0) {
            dp[i][sum] = min(dp[i][sum], go(i, sum - coins[c]) + 1);
        }
    }
    return dp[i][sum];
}
void solve() {
    cin >> n >> tar;
    for (int i = 0; i <  n; i++){
        cin>>coins[i];
    }
    ll ans= go(0, tar);
    cout <<(ans==1e9?-1:ans)<<e;
}
 
signed main() {
    Sa7afy_H333
    int tests = 1;
   // cin >> tests;
    for (int i = 1; i <= tests; i++) {
        /*cout<<"Case #"<<i<<": ";*/
        solve();
    }
    Time
}