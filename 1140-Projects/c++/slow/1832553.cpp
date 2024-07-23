#include <iostream>
#include <cstdio>
#include <vector>
#include <utility>
#include <cmath>
#include <algorithm>
#include <array>
#include <set>
#include <climits>
#include <map>
#include <memory>
#include <string>
using namespace std;
 
#define input "problem.in"
#define output "problem.out"
#define int long long
#define pii pair<int, int>
int n;
set<int> times;
map<int, int> id;
vector<tuple<int, int, int>> departures;
vector<pair<int, vector<pii>>> dp; // also has all of the departures at that time.
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    //freopen(input, "r", stdin);
    //freopen(output, "w", stdout);
    cin >> n; departures.reserve(n);
    for (int i=0;i<n;i++) {
        int a, b, p;
        cin >> a >> b >> p;
        times.insert(a); times.insert(b+1);
        departures.push_back(make_tuple(a, b+1, p));
        //cout << a << ' ' << b+1 << ' ' << p << endl;
    }
    int s=0;
    for (auto t: times) {
        id[t]=s;
        s++;
    }
    dp.reserve(s);
    for (int i=0;i<s;i++) {
        dp.push_back({0, vector<pii>(0)});
    }
    for (int i=0;i<n;i++) {
        tuple<int, int, int> dep=departures[i];
        dp[ id[get<1>(dep)] ].second.push_back(make_pair(id[get<0>(dep)] , get<2>(dep))); 
    }
    for (int i=1;i<s;i++) {
        int deps_m=0;
        for (pii dep: dp[i].second) {
            deps_m=max(deps_m, dp[dep.first].first + dep.second);
        }
        dp[i].first=max(dp[i-1].first, deps_m);
        //cout << dp[i].first << endl;
    }
    cout << dp[s-1].first << endl;
}