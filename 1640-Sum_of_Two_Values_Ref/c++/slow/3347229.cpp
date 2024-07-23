#include <bits/stdc++.h>
using namespace std;
#define nl '\n'
 
const int mod = 1000000007;
void solve() {
    int n,x; cin>>n>>x;
    map<int, queue<int>>m;
    set<int>s;
    for(int i=0;i<n;i++){
        int a; cin>>a;
        s.insert(a);
        m[a].push(i+1);
    }
    //cout<<m[2].size();
    for(auto it:s){
        //cout<<it.first<<" ";
        int k = m[it].front();
        m[it].pop();
        if(m[x-it].size()>0){
            cout<<k<<" "<<m[x-it].front();
            return;
        }
    }
    cout<<"IMPOSSIBLE";
} 
 
int main() {
    cin.tie(0)->sync_with_stdio(0); 
    cin.exceptions(cin.failbit);
 
    int T = 1;
    //cin >> T;
    while(T--) {
        solve();
    }
 
    return 0;
}