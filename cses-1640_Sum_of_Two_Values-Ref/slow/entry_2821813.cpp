#include <bits/stdc++.h>
#define ll long long
#define pb push_back
#define vll vector<ll>
#define vpll vector<pair<ll, ll>>
#define fo(i, k, n) for (ll i = k; i < n; i++)
#define fo1(i, k, n) for (ll i = k; i <= n; i++)
#define rr return
#define Endl endl
#define ff first
#define ss second
#define all(X) (X).begin(), (X).end()
 
#define setbits(x) __builtin_popcountll(x)
#define zrobits(x) __builtin_ctzll(x)
#ifndef ONLINE_JUDGE
#define debug(x) cerr << #x << " " << x << endl;
#else
#define debug(x)
#endif
using namespace std;
 
void io()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    // #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin);
    // freopen("error.txt","w",stderr);
    // freopen("output.txt", "w", stdout);
    // #endif
}
 
ll mod = 1e9 + 7, mxn = 3e5 + 5;
void deb(vector<ll> v)
{
    for (auto t : v)
        cerr << t << " ";
    cerr << "\n";
}
ll mul(ll a, ll b, ll mod)
{
    a %= mod;
    b %= mod;
    a *= b;
    a += mod;
    return a % mod;
}
 
bool sortbysecdesc(const pair<int, int> &a,
                   const pair<int, int> &b)
{
    return a.second > b.second;
}
bool check_sorted(vll a)
{
    ll n = a.size();
    for (ll i = 1; i < n; i++)
    {
        if (a[i] >= a[i - 1])
            continue;
        return false;
    }
    return true;
}
vll fact(2e5 + 5, 1);
ll binPow(ll a, ll b)
{
    if (b == 0)
        return 1;
    if (b == 1)
        return a;
    ll ret = binPow(a, b / 2);
    if (b % 2 == 0)
        return (ret * ret) % mod;
    return ((ret * ret) % mod * a) % mod;
}
ll inv(ll a)
{
    return (binPow(a, mod - 2) % mod + mod) % mod;
}
ll binom(ll a, ll b)
{
    // before t
    //  for (int i = 1;i<=2e5;i++)fact[i] = (i * fact[i - 1])%mod;
    if (b < 0 or a < 0)
        return 0;
    return (((fact[a] * inv(fact[b])) % mod * inv(fact[a - b])) % mod + mod) % mod;
}
// CONDITION && cout << "YES" || cout << "NO"; cout << '\n';
vector<int> sieveOfEratosthenes(int N)
{
    bool primes[N + 1];
    memset(primes, true, sizeof(primes));
    vector<int> arr;
 
    for (int i = 2; i * i <= N; i++)
        if (primes[i] == true)
        {
            for (int j = i * i; j <= N; j += i)
                primes[j] = false;
        }
 
    for (int i = 2; i <= N; i++)
        if (primes[i])
            arr.emplace_back(i);
 
    return arr;
}
void prime_fact(ll n, vector<ll> &res)
{
    while (n % 2 == 0)
    {
        res.pb(2);
        n = n / 2;
    }
 
    for (ll i = 3; i <= sqrt(n); i = i + 2)
    {
        while (n % i == 0)
        {
            res.pb(i);
            n = n / i;
        }
    }
    if (n > 2)
    {
        res.pb(n);
    }
}
bool valid_coordinate(ll x, ll y, ll n, ll m)
{
    if (x < 0 || y < 0)
        return false;
 
    else if (x >= n || y >= m)
        return false;
 
    else
        return true;
}
int sod(int n)
{
    int sum = 0;
    while (n)
    {
        sum += (n % 10);
        n /= 10;
    }
    return sum;
}
 
bool isPowerOfTwo(ll n)
{
    return n && (!(n & (n - 1)));
}
 
void solve()
{
    ll n, x;
    cin >> n >> x;
    // if (x >)
    vll a(n);
 
    map<ll, ll> m;
    ll sum = 0;
    fo(i, 0, n)
    {
 
        cin >> a[i];
        sum += a[i];
        m[a[i]] = i + 1;
    }
    vll b(n);
    for (ll i = 0; i < n; i++)
    {
        // debug(a[i]);
        b[i] = a[i];
    }
    sort(b.begin(), b.end());
    deb(b);
    if (n == 1)
    {
        cout << "IMPOSSIBLE" << endl;
        rr;
    }
    if (b[n - 1] + b[n - 2] < x)
    {
        cout << "IMPOSSIBLE" << endl;
        rr;
    }
    // sort(a.begin(), a.end());
    // if (x > sum)
    for (ll i = 0; i < n; i++)
    {
        // if (m.find(x - a[i]) != m.end())
        // {
        //     if ((i + 1) != m[x - a[i]])
        //     {
        //         cout << i + 1 << " " << m[x - a[i]] << Endl;
        //         rr;
        //     }
        // }
        if (m[x - a[i]] && ((i + 1) != m[x - a[i]]))
        {
            // debug(a[i]);
            cout << i + 1 << " " << m[x - a[i]] << endl;
            rr;
        }
    }
    cout << "IMPOSSIBLE" << Endl;
    rr;
}
int main()
{
    io();
    // solve();
    ll t = 1;
    // ll t;
    // cin >> t;
    while (t--)
    {
        solve();
    }
 
    // cout<<setprecision(10)
    return 0;
}