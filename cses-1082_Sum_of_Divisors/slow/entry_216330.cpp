#pragma GCC optimize("O3", "unroll-loops")
#pragma GCC target("avx2")
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define int long long
#define double long double
#define endl "\n"
#define fastio ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define pb push_back
#define mp make_pair
#define ms(v,x) memset(v,x,sizeof(v))
#define pii pair<int,int>
#define ff first
#define ss second
#define REP(i,a,b) for(int i=a;i<=b;i++)
#define td(v) v.begin(),v.end()
#define inf 1000000000 // 1e9
#define M   1000000007 // 1e9 + 7
using namespace std;
inline int mod(int n, int m){ int ret = n%m; if(ret < 0) ret += m; return ret; }
int gcd(int a, int b){return (b == 0 ? a : gcd(b, a%b));}
int lcm(int a,int b){return (a*b)/gcd(a,b);}
int exp(int a,int b,int m){
    if(b==0) return 1;
    if(b==1) return mod(a,m);
    int k = mod(exp(a,b/2,m),m);
    if(b&1){
        return mod(a*mod(k*k,m),m);
    }
    else return mod(k*k,m);
}
const int inv2 = exp(2,M-2,M);
int pa(int n){
    n%=M;
    return mod(mod(n * (n+1),M) * inv2,M);
}
int get_range(int l,int r){
    return pa(r) - pa(l-1);
}
int32_t main(){
    fastio;
    int n;
    cin >> n;
    int l = 1,r = n+1;
    int m;
    int ans = 0;
    for(;l<r;){
        int nl = l;
        int nr = r;
        int np = inf;
        int val = n/l;
        while(nl <= nr){
            m = nl + nr >> 1;
            if(n/m == val){
                np = m;
                nl = m+1;
            }
            else nr = m-1;
        }
        val%=M;
        ans = mod(ans + (get_range(l,np) * val % M),M);
        l = np+1;
    }
    cout << ans << endl;
}   
