#include <bits/stdc++.h>
using namespace std ;
#define int long long
#define all(a) a.begin(), a.end()
#define alr(a) a.rbegin(), a.rend()
int n, m;
vector < int > a;
int lcm(int a, int b){
    return (a / __gcd(a, b)) * b;
}
int rec(int idx, int cnt, int pro){
    if(idx == n) {
        if(!cnt) return 0;
        // cout << cnt << ' ' << pro << endl;
        return (cnt % 2 == 0? -1 : 1) * pro;
    }
    return (rec(idx + 1, cnt, pro) + rec(idx + 1, cnt + 1, pro/a[idx]));
}
signed main(){
    ios_base::sync_with_stdio(0); cin.tie(0);cout.tie(0);
 
    cin >> m >> n;
    a = vector < int > (n);
    for(int &i : a) cin >> i;
    cout << rec(0, 0, m) << endl;
    return 0 ;
}
