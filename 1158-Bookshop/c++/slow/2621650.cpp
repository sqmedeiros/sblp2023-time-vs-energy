using namespace std;
#include <bits/stdc++.h>
#define ll long long
#define rep(i,bbb,ccc) for(ll i = (ll)bbb; i < (ll)ccc; i++)
#define repi(i,bbb,ccc) for(ll i = (ll)bbb; i > (ll)ccc; i--)
#define mod 1000000007
#define inf  100000000000000000
 
//always try examples many times the answer is visible but you realize only after
 
bool isPrime(ll n)                                                          //CHECK IF A NUMBER IS PRIME
{if (n <= 1)return false;if (n <= 3)return true;if (n % 2 == 0 || n % 3 == 0)return false;for (int i = 5; i * i <= n; i = i + 6)if (n % i == 0 || n % (i + 2) == 0)return false;return true;}
 
map<ll,ll> pfac(ll n)                                                       //RETURNS MAP OF PRIME FACTORIZATION OF THE NUMBER
{map<ll,ll> m;if(n%2==0){m.insert(pair<ll,ll>(2,1));n/=2;}while (n % 2 == 0){m.find(2)->second++;n/=2;}for (int i = 3; i <= sqrt(n); i = i + 2){while (n % i == 0){if(m.count(i)>0){m.find(i)->second++;n/=i;}else{m.insert(pair<ll,ll>(i,1));n/=i;}}}if(n>2)m.insert(pair<ll,ll>(n,1));return m;}
 
string convertToString(char* a, int size)                                   //CONVERT CHAR ARRAY TO STRING
{int i;string s = "";for (i = 0; i < size; i++) {s = s + a[i];}return s;}
 
int binaryToDecimal(string n)                                               //CONVERT BINARY TO DECIMAL
{string num = n;int dec_value = 0;int base = 1;int len = num.length();for (int i = len - 1; i >= 0; i--) {if (num[i] == '1')dec_value += base;base = base * 2;}return dec_value;}
 
string decbin(int n)                                                        //TO CONVERT DECIMAL TO BINARY
{int binaryNum[32],x;string s;int i = 0;while (n > 0) {binaryNum[i] = n % 2;n = n / 2;i++;}for (int j = i - 1; j >= 0; j--){x=0;s += char(binaryNum[j] + '0');x++;}return s;}
 
//ll nCk(int n, int k)                                                      //TO FIND nCk OF LARGE NUMBERS ALSO USES MOD
vector<ll> fact, invf;ll powmod(ll a, ll b) { ll res = 1;a %= mod;for (; b; b >>= 1) {if (b & 1)res = res * a % mod;a = a * a % mod;}return res;}void build(int n) {fact = vector<ll>(n+1, 1);invf = vector<ll>(n+1, 1);for (int i = 2; i <= n; i++)fact[i] = fact[i-1] * i % mod;invf[n] = powmod(fact[n], mod-2);for (int i = n-1; i >= 2; i--)invf[i] = invf[i+1] * (i+1) % mod;}ll nCk(int n, int k) {build(2*n);if (n < k)return 0;return fact[n] * invf[k] % mod * invf[n-k] % mod;}
 
void reverseStr(string& str)                                                //TO REVERSE A STRING
{int n = str.length();for (int i = 0; i < n / 2; i++)swap(str[i], str[n - i - 1]);}
 
long long powi(long long x,long long y)                                     //POWER FUNCTION
{long long z=1;for(int i=0;i<y;i++)z*=x;return z;}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
void solve()
{
    int n,x;cin>>n>>x;
    int a[n],b[n],maxi=-1;
    rep(i,0,n)cin>>a[i];
    rep(i,0,n)cin>>b[i];
    int dp[x+1][n+1];
 
    rep(i,0,n+1)
        dp[0][i]=0;
 
    rep(i,0,x+1)
        dp[i][0]=0;
 
    rep(i,1,x+1){
        rep(j,1,n+1){
            if(a[j-1]>i)
                dp[i][j]=dp[i][j-1];
            else
                dp[i][j]=max(dp[i][j-1],b[j-1]+dp[i-a[j-1]][j-1]);
            //if(dp[i][j]>maxi)
                //maxi=dp[i][j];
 
            //cout<<dp[i][j]<<" ";
        }
        //cout<<endl;
    }
    cout<<dp[x][n]<<endl;
}
 
int main()
{
    std::ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
 
    //int t;cin>>t;while(t--)
    solve();
return 0;
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 