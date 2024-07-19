#include<bits/stdc++.h>
 
using namespace std;
 
//Fast I/O
#define Code ios_base::sync_with_stdio(false);
#define By cin.tie(NULL);
#define Professor cout.tie(NULL);
 
//Macros
#define lld long double
#define ll long long
#define pb push_back
#define ppb pop_back
#define ff first
#define ss second
#define dt decltype
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define mp make_pair
#define pii pair<int, int>
#define pll pair<ll, ll>
#define vll vector<ll>
#define vi vector<int>
#define mii map<int, int>
#define fo(i, n) for (int i = 0; i < n; i++)
#define Fo(i, k, n) for (int i = k; i < n; i++)
#define ps(x, y) fixed << setprecision(y) << x
#define endl "\n"
 
#ifndef debugging
#define deb(x) cerr << #x << "="; print(x); cerr<<endl;
#else
#define deb(x) ;
#endif
 
//debugging funcitons...
template <class T> void print(T x){cerr<<x;}
 
 
//debugging using data_structures...
 
template<class T, class V> void print(pair<T , V> x){print(x.ff); cerr << ':';print(x.ss);}
template<class T> void print(vector<T> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' '; } cerr << ']';}
template<class T> void print(set<T> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' ';}cerr << ']';}
template<class T> void print(set<T,greater<T>> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' '; }cerr << ']';}
template<class T> void print(multiset<T> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' ';}cerr << ']';}
template<class T> void print(multiset<T,greater<T>> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' ';}cerr << ']';}
template<class T> void print(unordered_set<T> &a){cerr << '[' << ' ';for(auto x : a){print(x);cerr << ' ';}cerr << ']';}
template<class T, class V> void print(vector<pair<T, V>> &a){cerr << '[' << ' ';for(auto x : a){print(x.ff);cerr << ":";print(x.ss);cerr << ' ';}cerr << ']';}
template <class T, class V> void print(map <T, V> &a){cerr << "[ ";for (auto i : a){print(i);cerr << " ";}cerr << "]";}
template <class T, class V> void print(unordered_map <T, V> &a){cerr << "[ ";for (auto i : a){print(i);cerr << " ";}cerr << "]";}
template <class T> void print(vector<vector<T>> &a){cerr << "[ ";for (auto i : a){print(i);cerr << " ";}cerr << "]";}
 
 
 
// operator overloads...
template<typename T1, typename T2> // cin >> pair<T1, T2>
istream& operator>>(istream &istream, pair<T1, T2> &p) { return (istream >> p.first >> p.second); }
template<typename T> // cin >> vector<T>
istream& operator>>(istream &istream, vector<T> &v){for (auto &it : v)cin >> it;return istream;}
template<typename T1, typename T2> // cout << pair<T1, T2>
ostream& operator<<(ostream &ostream, const pair<T1, T2> &p) { return (ostream << p.first << " " << p.second); }
template<typename T> // cout << vector<T>
ostream& operator<<(ostream &ostream, const vector<T> &c) { for (auto &it : c) cout << it << " "; return ostream; }
 
 
//some useful namespaces
namespace helper{
string decToBinary(int n){string s="";int i = 0;while (n > 0) {s =to_string(n % 2)+s;n = n / 2;i++;}return s;}
ll binaryToDecimal(string n){string num = n;ll dec_value = 0;int base = 1;int len = num.length();for(int i = len - 1; i >= 0; i--){if (num[i] == '1')dec_value += base;base = base * 2;}return dec_value;}
bool isPrime(ll n){if(n<=1)return false;if(n<=3)return true;if(n%2==0||n%3==0)return false;for(int i=5;i*i<=n;i=i+6)if(n%i==0||n%(i+2)==0)return false;return true;}
bool isPowerOfTwo (int x){return x && (!(x&(x-1)));}
bool isPerfectSquare(ll x){if (x >= 0) {ll sr = sqrt(x);return (sr * sr == x);}return false;}    
}
 
 
//Remember
//n & (1<<i)- for extracting ith bits
//while(n>0){count=count+(n&1); n=n>>1;}//counting set bits
 
class number_spiral
{
    private:void solution()
    {   
         ll row, col;
         cin>>row>>col;
 
         ll k = max(row, col);
         ll temp = (k*k*1ll)-(k-1);
         deb(temp);
         if(row==col){
             cout<<temp<<"\n";
             return;
         }
         if(k&1){
            if(k==col){
                cout<<temp+(k-row)<<'\n';
            }
            else{
                cout<<temp-(k-col)<<'\n';
            }
         }
         else{
             if(k==col){
                 cout<<temp-(k-row)<<'\n';
             }
             else{
                 cout<<temp+(k-col)<<'\n';
             }
         }
    }
 
    public:void code()
    {
        int tc = 1;
        cin >> tc;
        while (tc--)
        {
            solution();
        }
    }
};
 
signed main()
{
    Code By Professor
    number_spiral coder;
 
    coder.code();
    return 0;
}