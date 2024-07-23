/*
    lmqzzz : ILS 21 - 24
 
 
        lllllll
        l:::::l
        l:::::l
        l:::::l
         l::::l    mmmmmmm    mmmmmmm      qqqqqqqqq   qqqqqzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
         l::::l  mm:::::::m  m:::::::mm   q:::::::::qqq::::qz:::::::::::::::zz:::::::::::::::zz:::::::::::::::z
         l::::l m::::::::::mm::::::::::m q:::::::::::::::::qz::::::::::::::z z::::::::::::::z z::::::::::::::z
         l::::l m::::::::::::::::::::::mq::::::qqqqq::::::qqzzzzzzzz::::::z  zzzzzzzz::::::z  zzzzzzzz::::::z
         l::::l m:::::mmm::::::mmm:::::mq:::::q     q:::::q       z::::::z         z::::::z         z::::::z
         l::::l m::::m   m::::m   m::::mq:::::q     q:::::q      z::::::z         z::::::z         z::::::z
         l::::l m::::m   m::::m   m::::mq:::::q     q:::::q     z::::::z         z::::::z         z::::::z
         l::::l m::::m   m::::m   m::::mq::::::q    q:::::q    z::::::z         z::::::z         z::::::z
        l::::::lm::::m   m::::m   m::::mq:::::::qqqqq:::::q   z::::::zzzzzzzz  z::::::zzzzzzzz  z::::::zzzzzzzz
        l::::::lm::::m   m::::m   m::::m q::::::::::::::::q  z::::::::::::::z z::::::::::::::z z::::::::::::::z
        l::::::lm::::m   m::::m   m::::m  qq::::::::::::::q z:::::::::::::::zz:::::::::::::::zz:::::::::::::::z
        llllllllmmmmmm   mmmmmm   mmmmmm    qqqqqqqq::::::qzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
                                                    q:::::q
                                                    q:::::q
                                                   q:::::::q
                                                   q:::::::q
                                                   q:::::::q
                                                   qqqqqqqqq
*/
#include<bits/stdc++.h>
#define fi first
#define se second
#define pb push_back
#define lb lower_bound
#define ub upper_bound
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define rep(i,a,b) for(int i = a ; i<= b ; i++)
#define repp(i,a,b) for(int i = a ; i< b ; i++)
#define per(i,a,b) for(int i = a ; i>= b ; i--)
#define perr(i,a,b) for(int i = a ; i> b ; i--)
#define mxx *max_element
#define mnn *min_element
#define cntbit(x) __builtin_popcountll(x)
#define MASK(x) (1ll<<(x))
#define Yes cout << "Yes"
#define YES cout << "YES"
#define No cout << "No"
#define NO cout << "NO"
// TASK
//------------------------------
#define TASK "CC"
//------------------------------
using namespace std;
 
template <typename T> inline void read (T &x) {
    bool b = 0;
    char c;
    while (!isdigit (c = getchar()) && c != '-');
    if (c == '-') {
        c = getchar();
        b = 1;
    }
    x = c - 48;
    while (isdigit(c = getchar())) {
        x = x * 10 + (c - 48);
    }
    if (b) {
        x=-x;
    }
}
 
typedef long double ld;
typedef long long ll;
typedef pair<int,int> ii;
typedef pair<ii,int> piii;
typedef pair<int,ii> ipii;
typedef pair<ll,int> li;
typedef pair<ll,ll> pll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<vi > vvi;
typedef vector<vll > vvl;
typedef vector<ii> vii;
typedef vector<vii> vvii;
 
const int MAXN = 2e6+10, dr[] = {1,0,-1,0} , dc[] = {0,-1,0,1};
const ll base = 277,MOD = 1e9+7;
 
 
 
struct project
{
    int s,t,p;
};
 
ll dp[MAXN];
project a[MAXN];
int n;
map<int,int>mp;
ll T[MAXN];
 
ll Query(int node,int l,int r,int s,int t)
{
    if(l>t||r<s)
        return 0;
    if(s<=l&&r<=t)
        return T[node];
    return max(Query(node*2,l,(l+r)/2,s,t),Query(node*2+1,(l+r)/2+1,r,s,t));
}
 
void Update(int node,int l,int r,int k,ll val)
{
    if(l == r && l == k)
    {
        T[node] = max(T[node],val);
        return;
    }
    if(l>k||r<k)
        return;
    Update(node*2,l,(l+r)/2,k,val);
    Update(node*2+1,(l+r)/2+1,r,k,val);
    T[node] = max(T[node*2],T[node*2+1]);
}
 
void solve()
{
    cin >> n;
    set<int>s;
    rep(i,1,n)
    {
        cin >> a[i].s >> a[i].t >> a[i].p;
        s.insert(a[i].s);
        s.insert(a[i].t);
    }
    int cur = 0;
    for(int i : s)
    {
        mp[i] = ++cur;
    }
    rep(i,1,n) a[i].s = mp[a[i].s],a[i].t = mp[a[i].t];
    sort(a+1,a+n+1,[](auto x,auto y)
        {
            return x.t < y.t;
        });
//    rep(i,1,n)
//    {
//        cout << a[i].s << ' '<< a[i].t << ' ' << a[i].p << '\n';
//    }
    ll res = 0;
    rep(i,1,n)
    {
        ll x = Query(1,1,4e5,1,a[i].s-1);
        res = max(res,x+1ll*a[i].p);
        Update(1,1,4e5,a[i].t,x+1ll*a[i].p);
    }
    cout << res;
}
void prepare()
{
}
 
void gentest()
{
    if (fopen(TASK ".inp", "r"))
        freopen(TASK ".inp","w",stdout);
    srand(time(0));
    int n = 0;
}
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    if (fopen(TASK ".inp", "r")) {
        freopen(TASK ".inp", "r", stdin);
        freopen(TASK ".out", "w", stdout);
    }
//    gentest();
//    return 0;
//    prepare();
    int TT = 1;
//    cin >> TT;
    while(TT--)
    {
        solve();
//        cout << '\n';
    }
 
}