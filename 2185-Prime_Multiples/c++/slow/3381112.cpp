#include<bits/stdc++.h>
#define faster() ios_base::sync_with_stdio(false); cin.tie(0);
#define fi first
#define se second
#define ll unsigned long long
#define el '\n'
#define ii pair<int, int>
#define li pair<ll, short>
#define MS(n,k) memset(n ,k, sizeof(n));
#define Fname "Prime_Multiples"
#define bit(x,n) (((x) >> (n))&1)
template <class T> inline bool maxx(T &A,T B){return A < B ? (A = B,1) : 0;}
template <class T> inline bool minn(T &A,T B){return A > B ? (A = B,1) : 0;}
using namespace std;
void files() {
    #ifndef ONLINE_JUDGE
        freopen(Fname".inp", "r", stdin);
        freopen(Fname".out", "w", stdout);
    #endif // ONLINE_JUDGE
}
const int N = 25;
const ll oo = 1e18;
ll a[N], n, x[N], res = 0, k;
ll lcm(ll a, ll b)
{
    ll tmp = __gcd(a, b);
    if(n > oo / tmp) return - 1;
    if((n * tmp) / a < 1) return - 1;
    if((n * tmp / a) / b < 1) return - 1;
    return (a / tmp * b);
}
void solve()
{
    ll pos = -1, tmp = 0;
    for(int i = 1;i <= k;i++)
    {
        if(x[i] == 1) {
            pos *= -1;
            if(tmp == 0) tmp = a[i];
            else tmp = lcm(tmp, a[i]);
            if(tmp == -1) return;
        }
    }
    if(tmp != 0) res += (n / tmp) * pos;
}
void backtrack(int t)
{
    for(int i = 0;i <= 1;i++)
    {
        x[t] = i;
        if(t == k) solve();
        else backtrack(t + 1);
    }
}
int main(){
    faster();
    files();
    cin >> n >> k;
    for(int i = 1;i <= k;i++) cin >> a[i];
    backtrack(1);
    cout << res;
}
