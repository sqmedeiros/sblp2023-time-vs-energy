//Dinar Perseüs
#include<bits/stdc++.h>
#define ll long long int
#define fo(i,n) for (int i = 0; i < n; i++)
#define Fo(i,n,m) for(int i=n;n<m?i<m:i>m;n<m?i++:i--)
#define cy cout<<"YES\n"
#define cn cout<<"NO\n"
#define ce cout<<'\n'
#define pu push_back
#define po pop_back
#define vi vector<ll>
const int mod= 1e9+7;
 
using namespace std;
 
bool doub_comp (double a,double b) {
    return (abs(a-b)<0.000000001);
}
 
vi v;
ll c=0;
void p(ll id, int i,int n, int m){
    for(i;i<n;i++){
        ll d=id/v[i];
        c+=(d*m);
        p(d,i+1,n,m*-1);
    }
}
 
 
 
void solve() {
    ll n,x;
    cin>>x>>n;
    
    v.resize(n);
    fo(i,n)cin>>v[i];
    sort(v.begin(),v.end());
    fo(i,n){
        ll id=x/v[i];
        p(id,i+1,n,-1);
        c+=id;
        
    }
    cout<<c;ce;
}
 
int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    /*
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    */
// clock_t z = clock();
    int t=1;
//cin>>t;
    while (t--)solve();
// cerr<<"Run Time : "<<((double)(clock()-z)/CLOCKS_PER_SEC);
    return 0;
}
