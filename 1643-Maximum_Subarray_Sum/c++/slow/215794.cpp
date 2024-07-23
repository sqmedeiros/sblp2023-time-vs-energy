/*
True champion wasn't born but trained
*/
#include <cmath>
#include <functional>
#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <map>
#include <list>
#include <time.h>
#include <math.h>
#include <random>
#include <deque>
#include <queue>
#include <cassert>
#include <unordered_map>
#include <unordered_set>
#include <iomanip>
#include <bitset>
#include <sstream>
#include <chrono>
#include <cstring>
using namespace std;
#define        int               long long
#define        ld                long double
#define        pb                push_back
#define        mp                make_pair
#define        sz(v)             ((int)(v).size()) 
#define        endl              '\n'
#define        IO                ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define        all(x)            (x).begin(),(x).end()
#define        rall(x)           (x).rbegin(),(x).rend()
#define        gcd(a,b)          __gcd(a,b)
#define        rep(i,a,b)        for(int i=a;i<b;i++)
#define        per(i,a,b)        for(int i=b-1;i>=a;i--)
#define        trav(a,x)         for(auto &a:x)
#define        fs                first
#define        se                second
#define        deb(x)            cerr << #x << "->" << x << endl;
#define        exetime           cerr << "\nTime Elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
#define        INT_MAX           (1<<30)
#define        INT_MIN           -(1<<30)
#define        MOD               1000000007
typedef vector<int> vi;
typedef vector<pair<int,int>> vii;
typedef pair <int, int> pi;
typedef map<int, int> mi;
typedef set <int> si;
typedef set <pair<int,int>> sii;
typedef multiset <int> msi;
typedef unordered_set<int> usi;
typedef unordered_multiset<int> umsi;
template<typename... T>
void rd(T&... args) {
    ((cin >> args), ...);
}
template<typename... T>
void wr(T&&... args) {
    ((cout << args << ' '), ...);
}
template<typename... T>
void wt(T&&... args) {
    ((cout << args << '\n'), ...);
}
 
const int N = 1e9+5;
int n,m,x,y,k,a,b;
 
void solve(){
    rd(n);
    int tmp = INT_MIN, ans = INT_MIN;
    rep(i,0,n){
        cin >> a;
        tmp = max(a, tmp+a);
        ans = max(tmp,ans);
        deb(tmp);
    }
    cout << ans;
}
 
int32_t main(){
    IO;
    int t = 1;
    // cin >> t;
    while(t--){
        solve();
    }
    exetime;
    return 0;
}
