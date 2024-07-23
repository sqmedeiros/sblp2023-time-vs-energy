#include<bits/stdc++.h>
using namespace std;
using namespace std::chrono; 
 
typedef long long int ll;
#define endl "\n" 
#define mp make_pair
#define pb push_back
#define all(v) v.begin(),v.end()
#define rall(v) v.rbegin(),v.rend()
#define MOD 1000000007
 
vector<int> sieve(ll n){
   vector<int> prime(n+1,0);
   vector<int> primes(n+1,0);
   int index=0;
   for(int i=2;i<=n;i++){
       if(prime[i]==0){
           prime[i]=i;
           primes[index]=i;
           index++;
       }
       for(int j=0;j<index && primes[j]<=prime[i] && i*primes[j]<=n; j++){
           prime[primes[j]*i] = primes[j];
           if (i % primes[j] == 0) break;
       }
   }
   return prime;
}
 
template <typename T>
ostream& operator<< (ostream& out, const vector<T>& v) {
   if ( !v.empty() ) {
       copy (v.begin(), v.end(), ostream_iterator<T>(out, " "));
       out << "\n";
   }
   return out;
}
 
template <typename T> 
ostream& operator<<(ostream& os, const set<T>& v)
{
for (auto it : v) {
os << it; 
if (it != *v.rbegin()) 
os << " " ;
}
os << "\n"; 
return os; 
}
 
template <typename T> 
ostream& operator<<(ostream& os, const multiset<T>& v)
{
for (auto it : v) {
os << it; 
if (it != *v.rbegin()) 
os << " " ;
}
os << "\n"; 
return os; 
}
 
template <typename T, typename S>
ostream& operator<<(ostream& os, const pair<T, S>& v)
{
os << v.first << " " << v.second << "\n";
return os;
}
 
template <typename T, typename S> 
ostream& operator<<(ostream& os, const map<T, S>& v)
{
for (auto it : v)
os << it.first << " : " << it.second << "\n";
return os; 
}
 
ll power(ll a, ll n) {
    ll p = 1;
    while (n > 0) {
       if(n%2) {
          p = p * a;
       } n >>= 1; a *= a;
    }
    return p;
}
 
ll powermodulo(ll a, ll n, ll mod) {
ll p = 1;
while (n > 0) {
       if(n%2) {
         p = p * a; p %= mod;
       } n >>= 1;
         a *= a; a %= mod;
    } 
    return p % mod;
}
 
class DSU{
   public:
   ll n;
   vector<ll> parent;
   vector<ll> size;
   void init(ll x){
       n=x;
       for(ll i=0;i<x+1;i++){
           parent.pb(i);
           size.pb(1);
       }
   }
   ll root(ll x){
       if(parent[x] == x)
           return x;
       return parent[x] = root(parent[x]);
   }
   void Union(ll x, ll y){
       x = root(x);
       y = root(y);
       if(x != y){
           if(size[x] < size[y])
               swap(x, y);
           size[x] += size[y];
           parent[y] = x;
       }
   }
};
 
int main(){
 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    #ifdef LoneWolfKJ
    auto start = high_resolution_clock::now(); 
    freopen("in.txt", "rt", stdin);
    freopen("out.txt", "wt", stdout);
    #endif
    //int t; cin >> t; while(t--){}
    int n,x;
    cin >> n >> x;
    vector<int> coins(n);
    for(int i=0;i<n;i++){
        cin >> coins[i];
    }
    vector<int> v[n+1];
    for(int i=0;i<=n;i++){
        for(int j=0;j<=x;j++){
            v[i].pb(0);
        }
    }
    v[0][0]=1;
    for(int i=1;i<=n;i++){
        for(int j=0;j<=x;j++){
            v[i][j]=v[i-1][j];
            int poss=j-coins[i-1];
            if(poss>=0){
                v[i][j] += ((v[i][poss])%MOD);
                v[i][j] = (v[i][j])%MOD;
            }
        }
    }
    cout << (v[n][x])%MOD;
    #ifdef LoneWolfKJ
    auto stop = high_resolution_clock::now(); 
    auto duration = duration_cast<milliseconds>(stop - start); 
    cout << "Time Elapsed : " << duration.count() << " ";
    #endif
 
}