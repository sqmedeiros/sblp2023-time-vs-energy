//////////////////////////
// 🙏 🍀 🥇 🐘        //
//                      //
// 🙏 ❌ 🪲 🪳 🐞 🕷  //
//////////////////////////
#include<bits/stdc++.h>
#define up(i,a,b) for(int i=a;i<=b;i++)
#define dw(i,a,b) for(int i=a;i>=b;i--)
#define FOR(i,n) up(i,0,int(n)-1)
#define REP(i,n) dw(i,int(n)-1,0)
#define all(a) a.begin(),a.end()
#define get_bit(vt,bit) ((bit>>vt)&1)
#define on_bit(vt,bit)  (bit^(1<<vt))
#define off_bit(vt,bit) (bit^(1<<vt))
#define count_bit(bit) __builtin_popcountll(bit)
#define sz(a) int(a.size())
#define fi first
#define se second
#define ll long long
 
using namespace std;
mt19937 rd(chrono :: steady_clock :: now().time_since_epoch().count());
ll random(ll l,ll r){
    return rd()%(r-l+1)+l;
}
//____________________________________________<reader>__________________________________________
inline  void read(){;}
template<typename Now,typename ...Next>
inline void read(Now &x,Next &...next){
    char c=getchar();bool am=false;x=0;
    while(!isdigit(c))am=am|(c=='-'),c=getchar();
    while(isdigit(c))x=x*10+c-'0',c=getchar();
    if(am)x=-x;
    read(next...);
}
//____________________________________________<debuger>_________________________________________
inline void show(){;}
template<typename T,typename ...Next>
inline void show(T x,Next ...next){
    cerr<<x;
    if(sizeof ...(next))cerr<<", ",show(next...);
}
#define debug(...) cerr<<"[ "<<#__VA_ARGS__<<" ] = [ ",show(__VA_ARGS__),cerr<<" ]\n";
template<typename T>
inline void show(vector<T> vec){
    for(auto i:vec) cerr << i <<" , " ;
}
template<typename T>
inline void show(set<T> vec){
    for(auto i:vec) cerr << i <<" , " ;
}
template<typename T,typename H>
inline void show(map<T,H> vec){
    for(auto i:vec) cerr <<"["<<i.fi <<","<<i.se<<"] , ";
}
 
//____________________________________________<compair>_________________________________________
template<typename T,typename H>
bool minimize(T &a,H b){if(a>b){a=b;return true;}return false;}
template<typename T,typename H>
bool maximize(T &a,H b){if(a<b){a=b;return true;}return false;}
void time(){cerr<<"time :"<<clock()/1000.00<<"s"<<'\n';}
 
//______________________________________________________________________________________________
 
const int mn=1e6+7;
const int mm=1e4+5;
const int mod=1e9+7;
const int base=26;
const double PI = 3.14159265359;
const ll inf=1e18;
typedef pair<int,int>ii;
 
 
 
int main(int argc, char const *argv[])
{
    #define name ""
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    #ifndef ONLINE_JUDGE
    freopen(name".inp","r",stdin);
    freopen(name".out","w",stdout);
    #endif
 
    int T;
    cin >> T;
    while( T --> 0 ){
        ll x,y;
        cin >> x >> y ;
        ll bef = max(x,y);
        bef--;
        bef *= bef;
        debug(bef);
        ll now = max(x,y);
        now *= now;
        ll ans = 1;
        if(max(x,y)%2){ 
            if(x > y){
                ans = bef + y;
            }
            else{
                ans = now - x + 1;
            }
        }
        else{
            if(x > y ) {
                ans = now - y + 1;
            }
            else ans = bef + x; 
        }
        cout << ans << '\n';
    }
 
    time();
    return 0;
}
/* 
 
    
 
*/