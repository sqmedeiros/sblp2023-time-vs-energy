#include <bits/stdc++.h>
 
using namespace std;
#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
#define ll                long long
#define pb                push_back
#define all(c)            (c).begin(),(c).end()
#define EPS               1.0e-3
template<typename A> ostream& operator<<(ostream &cout, vector<A> const &v);
template<typename A, typename B> ostream& operator<<(ostream &cout, pair<A, B> const &p) { return cout << "(" << p.f << ", " << p.s << ")"; }
template<typename A> ostream& operator<<(ostream &cout, vector<A> const &v) {
    cout << "["; for(int i = 0; i < v.size(); i++) {if (i) cout << ", "; cout << v[i];} return cout << "]";
}
template<typename A, typename B> istream& operator>>(istream& cin, pair<A, B> &p) {
    cin >> p.first;
    return cin >> p.second;
}
ll fastpow(ll base, ll power, ll M){
    if(power == 0) return 1;
    if (power == 1) return base;
    ll val = fastpow(base, power / 2, M);
    return (power % 2 == 0) ? (val * val) % M : (((val * val) % M) * base) % M;
}
inline void debugMode() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}
const int N = 1e6 + 2;
const int MOD = 1e9 + 7;
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
int dp[N], n, k;
vector<int> arr;
int main(){
    debugMode();
    for(auto& u: dp) u = 1e9;
    cin >> n >> k; arr.resize(n);
    for(auto& u: arr) cin >> u, dp[u] = 1;
    dp[0] = 0;
    for(auto u : arr)
        for(int i = u; i < N; i++)
            dp[i] = min(dp[i], dp[i - u] + 1);
    cout << (dp[k] == 1e9 ? -1 : dp[k]) << '\n';
    return 0;
}
