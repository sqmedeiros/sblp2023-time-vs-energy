#include <bits/stdc++.h>
 
#define forn(i,n) for(int i = 0; i < int(n); i++)
#define forsn(i,s,n) for(int i = int(s); i < int(n); i++)
#define dforn(i,n) for (int i = int(n)-1; i >= 0; i--)
#define dforsn(i,s,n) for(int i = int(n)-1; i >= int(s); i--)
#define all(c) (c).begin(),(c).end()
#define pb push_back
#define fst first
#define snd second
#define FAST_IO ios::sync_with_stdio(false);cin.tie(nullptr);
 
using namespace std;
typedef vector<int> vi;
typedef long long ll;
typedef pair<int,int> ii;
 
const int MAXN = 2e5+2;
 
struct pt {
    int l,r,v;
 
    bool operator< (const pt &o) const{
        return r < o.r;
    }
};
 
pt endings[MAXN];
ll bst[MAXN];
 
void fastscan (int &num) {
    int c; num = 0;
    c=getchar();
    for(; c>='0' && c<='9'; c=getchar())
        num = num*10 + c-'0';
}
 
int main() {
    int n; fastscan(n);
 
    forn(i,n) {
        int a,b,p; fastscan(a); fastscan(b); fastscan(p);
        endings[i] = {a,b,p};
    }
 
    sort(endings,endings+n);
 
    ll maxi = 0;
    forn(i,n) {
        int loc = lower_bound(endings,endings+n,endings[i].l,[](const pt &a, const int &b){return a.r < b;})-endings;
        bst[i] = max(maxi,endings[i].v+bst[loc-1]);
        maxi = max(maxi,bst[i]);
    }
 
    printf("%lld",maxi);
 
    return 0;
}
 
/// ESCRIBÍ en vez de tanto dar vueltas
/// si te parece que no va PROBALO PRIMERO!
/// CODEA LO BÁSICO PRIMERO!
/// HACE C-A-S-O-S D-E P-R-U-E-B-A.A.A.A.A!!!