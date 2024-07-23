#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define ff first
#define ss second
#define pb push_back
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
 
 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, sum; cin >> N >> sum;
    int a[N];
    for(int i = 0; i < N; i++) cin >> a[i];
    set<pair<int, pii>> s;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            if(i == j) continue;
            s.insert({a[i]+a[j], {i, j}});
        }
    }
    for(auto x : s){
        auto it = s.upper_bound({sum-x.ff,{-1, -1}});
        if(it == s.end()) continue;
        set<int> s2;
        s2.insert(x.ss.ff);
        s2.insert(x.ss.ss);
        int sum2 = (*it).ff;
        int i2 = (*it).ss.ff;
        int j2 = (*it).ss.ss;
        s2.insert(i2);
        s2.insert(j2);
        if(x.ff+sum2 == sum && ((int)s2.size()) == 4){
            for(auto p : s2) cout << p+1 << " ";
            return 0;
        }
        it = s.upper_bound({sum-x.ff,{i2, j2}});
        if(it == s.end()) continue;
        s2.clear();
        s2.insert(x.ss.ff);
        s2.insert(x.ss.ss);
        sum2 = (*it).ff;
        i2 = (*it).ss.ff;
        j2 = (*it).ss.ss;
        s2.insert(i2);
        s2.insert(j2);
        if(x.ff+sum2 == sum && ((int)s2.size()) == 4){
            for(auto p : s2) cout << p+1 << " ";
            return 0;
        }
        it = s.upper_bound({sum-x.ff,{i2, j2}});
        if(it == s.end()) continue;
        s2.clear();
        s2.insert(x.ss.ff);
        s2.insert(x.ss.ss);
        sum2 = (*it).ff;
        i2 = (*it).ss.ff;
        j2 = (*it).ss.ss;
        s2.insert(i2);
        s2.insert(j2);
        if(x.ff+sum2 == sum && ((int)s2.size()) == 4){
            for(auto p : s2) cout << p+1 << " ";
            return 0;
        }
    }
    cout << "IMPOSSIBLE";
    return 0;
}
