#include<bits/stdc++.h>
 
using namespace std;
 
#define FIO ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0)
#define mod 1000000007
#define INF 1e18
#define endl "\n"
#define pb  push_back
#define ppb pop_back
#define mp  make_pair
#define mt  make_tuple
#define ff  first
#define ss  second
#define pii pair<int,int>
#define vi  vector<int>
#define mii map<int,int>
#define pqb priority_queue<int>//priority queue big
#define pqs priority_queue<int,vi,greater<int> >//priority queue small
#define setbits(x)      __builtin_popcountll(x)//couts set bits
#define clz(x)          __builtin_clz(x)//counts leading zeros 
#define ctz(x)          __builtin_ctz(x)//counts trailing zeros
#define ps(x,y)         fixed<<setprecision(y)<<x
#define range(a,b)      substr(a,b-a+1)
#define w(x)            int x; cin>>x; while(x--)
#define PI 3.141592653589793238462
mt19937                 rng(chrono::steady_clock::now().time_since_epoch().count());
//shuffle(arr,arr+n,rng) to shuffle array elements
 
#define set_bits __builtin_popcountll
#define sz(x) ((int)(x).size())
#define all(x) (x).begin(), (x).end()
 
typedef long long ll;
typedef unsigned long long ull;
typedef long double lld;
 
 
#ifndef ONLINE_JUDGE
#define debug(x) cerr << #x <<" "; _print(x); cerr << endl;
#else
#define debug(x)
#endif
 
void _print(ll t) {cerr << t;}
void _print(int t) {cerr << t;}
void _print(string t) {cerr << t;}
void _print(char t) {cerr << t;}
void _print(lld t) {cerr << t;}
void _print(double t) {cerr << t;}
void _print(ull t) {cerr << t;}
 
template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T, class V> void _print(pair <T, V> p) {cerr << "{"; _print(p.ff); cerr << ","; _print(p.ss); cerr << "}";}
template <class T> void _print(vector <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(set <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(multiset <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T, class V> void _print(map <T, V> v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}
 
 
 
int32_t main()
{
    FIO;
#ifndef ONLINE_JUDGE
    freopen("Error.txt", "w", stderr);
 
#endif
    // w(t)
    // {
    int n, m, k;
    cin >> n >> m >> k;
    vi des(n);
    for (int i = 0; i < n; i++)
        cin >> des[i];
    vi pre(m);
    for (int i = 0; i < m; i++)
        cin >> pre[i];
    sort(all(des));
    sort(all(pre));
    _print(des);
    _print(pre);
    int i = 0, j = 0;
    int cnt = 0;
    while (i < n and j < m)
    {
        if ( pre[j] >= des[i] - k and des[i] + k >= pre[j])
        {
            cnt++; i++; j++;
        }
        else if (des[i] > pre[j])
        {
            j++;
        }
        else if (des[i] < pre[j])
        {
            i++;
        }
    }
    cout << cnt << endl;
    // }
    return 0;
}