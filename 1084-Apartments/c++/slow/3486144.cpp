#include <bits/stdc++.h>
using namespace std;
 
#define ll long long
#define vi vector<int>
#define rep(i, a, b) for (long long i = a; i < b; i++)
#define nl "\n"
#define mp make_pair
#define all(a) a.begin(), a.end()
#define pb push_back
#define pii pair<int, int>
#define mod 1000000007
 
#ifndef me_poojan23
#define debug(x) cerr << #x << " "; _print(x); cerr << endl;
#else
#define debug(x)
#endif
 
void _print(ll t)
{
    cerr << t;
}
void _print(int t) { cerr << t; }
void _print(string t) { cerr << t; }
void _print(char t) { cerr << t; }
void _print(long double t) { cerr << t; }
void _print(double t) { cerr << t; }
void _print(unsigned ll t) { cerr << t; }
 
template <class T, class V> void _print(pair<T, V> p);
template <class T> void _print(vector<T> v);
template <class T> void _print(set<T> v);
template <class T, class V> void _print(map<T, V> v);
template <class T> void _print(multiset<T> v);
template <class T, class V> void _print(pair<T, V> p){ cerr << "{"; _print(p.first);cerr << ",";_print(p.second);cerr << "}";}
template <class T> void _print(vector<T> v){cerr << "[ "; for (T i : v) { _print(i);cerr << " ";}cerr << "]";}
template <class T> void _print(set<T> v) {cerr << "[ "; for (T i : v) { _print(i);cerr << " ";}cerr << "]";}
template <class T> void _print(multiset<T> v) { cerr << "[ ";for (T i : v) { _print(i);cerr << " ";}cerr << "]";}
template <class T, class V> void _print(map<T, V> v) { cerr << "[ "; for (auto i : v) { _print(i); cerr << " ";}cerr << "]";}
 
 
vector<int> dx{0, 0, -1, 1};
vector<int> dy{-1, 1, 0, 0};
// left,right,up,down
 
ll binpow(ll a, ll n)
{
    if (n == 0)
    {
        return 1;
    }
    if (n % 2 == 0)
    {
        ll value = binpow(a, n / 2);
        return (value * value);
    }
    else
    {
        ll value = binpow(a, n / 2);
        return ((value * value)) * a;
    }
}
 
 
void solve()
{
    int n,m,k;
    cin>>n>>m>>k;
    multiset<int> arr,value;
    for(int i=0;i<n;i++)
    {
        int x;
        cin>>x;
        arr.insert(x);
    }
    for(int j=0;j<m;j++)
    {
        int x;
        cin>>x;
        value.insert(x);
    }
    int cnt = 0;
    multiset<int>::iterator ptr;
    for(ptr = value.begin();ptr != value.end();ptr++)
    {
        multiset<int>::iterator itr = arr.lower_bound(*ptr - k);
        debug(*itr)
        if(itr != arr.end() && *itr <= *ptr + k)
        {
            cnt++;
            arr.erase(itr);
        }
    }
    cout<<cnt<<"\n";
}
 
 
int main()
{
 
#ifndef me_poojan23
    freopen("error.txt", "w", stderr);
#endif
 
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    ll t;
    // cin >> t;
    // while (t--)
        solve();
    return 0;
}