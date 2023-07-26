#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
void scan(int &n){
    char c; n = 0;
    c = getchar();
    if(c <= 47 || c >= 58) c = getchar();
    for(; c > 47 && c < 58; c = getchar())
        n = n * 10 + c - 48;
}
struct project{
    int s, e;
    ll w;
    bool operator < (project &r) {
        return e < r.e;
    }
};
ll mx, idx;
int n;
vector<project> v;
vector<ll> dp;
ll money[200001];
 
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
 
    scan(n);
    for(int i = 0; i < n; i++){
        int s, e, w; scan(s), scan(e), scan(w);
        v.push_back({s,e,w});
    }
    sort(v.begin(), v.end());
    dp.emplace_back(0);
    money[0] = 0;
    for(auto &[s, e, w]: v){
        int it = lower_bound(dp.begin(), dp.end(), s) - dp.begin() - 1;
        w += money[it];
        if(mx >= w) continue;
        mx = max(mx, w);
        money[++idx] = w;
        dp.emplace_back(e);
    }
    cout << mx;
 
    return 0;
}