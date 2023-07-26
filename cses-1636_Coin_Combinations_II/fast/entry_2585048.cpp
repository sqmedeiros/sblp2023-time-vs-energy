#pragma GCC optimize ("O3")
#pragma GCC target ("avx,avx2")
 
#include <algorithm>
#include <cassert>
#include <iostream>
#include <memory>
#include <numeric>
 
#include <array>
#include <deque>
#include <map>
#include <set>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>
 
#include <cstring>
#include <ostream>
#include <type_traits>
#include <utility>
#include <chrono>
#include <random>
 
using namespace std;
 
using u64 = uint64_t;
using i64 = int64_t;
using u32 = uint32_t;
using vi = vector<int>;
using vi64 = vector<i64>;
 
 
#define seq(i,a,b) for (int i = (a); i < (b); ++i)
#define rev(i,a,b) for (int i = (b)-1; i >= (a); --i)
#define sz(x) ((int)x.size())
#define all(x) x.begin(), x.end()
#define dbg(x) {cerr << #x << ": " << x << endl;}
 
array<int,10000000> ways;
 
const int mod = 1000000007;
 
int main(int argc, char *argv[])
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int n,x; cin >> n >> x;
 
 
    ways[0] = 1;
    vi C(n);
    for (auto &x : C) cin >> x;
    sort(all(C));
 
    for (int c : C) {
        if (c == 1) {
            fill(ways.begin(), ways.begin() + x + 1, 1);
        } else {
            seq(i,c,x+1) {
                ways[i] += ways[i-c];
                if (ways[i] >= mod)
                    ways[i] -= mod;
            }
        }
    }
    cout << ways[x] << '\n';
}
// #include<bits/stdc++.h>
// using namespace std;
 
// #pragma GCC optimize("Ofast")
// #pragma GCC target("avx,avx2,fma")
// #pragma GCC optimize("unroll-loops")
 
// #define P pair<int, int>
// #define s second
// #define f first
// #define ll long long
// #define int long long int
// const int MAX = 100000 + 2;
// const int HMAX = 1000000007;
 
// void solve(){
//   int n, tar;
//   cin >> n >> tar;
//   int arr[n];
//   for(int i=0; i<n; ++i){cin >> arr[i];}
//   int dp[tar+1];
//   memset(dp, 0, sizeof(dp));
//   dp[0] = 1;
//   for(int i=0;i<n;++i){
//     for(int j=arr[i]; j<=tar; ++j){
//       dp[j] = (dp[j] + dp[j-arr[i]]);
//       if(dp[j] >= HMAX)
//         dp[j] %= HMAX;
//     }
//   }
//   cout << dp[tar] << endl;
//   // cout << finalMod(arr, n, x) << endl;
// }
 
// signed main(){
//   ios_base::sync_with_stdio(false); cin.tie(NULL);
//   int t=1;
//   while(t--){
//     solve();
//   }
// }