//Wed Nov 10 23:48:28 IST 2021
#include <bits/stdc++.h>
using namespace std;
#define vc vector
#define int int64_t
#define mk make_pair
#define pb push_back
#define gh cout<<'\n';
#define PII pair<int,int>
#define all(x) x.begin(),x.end()
#define Fo(i,k,n) for(int i=k;i<=n;i++)
#define Ro(i,n,k) for(int i=n;i>=k;i--)
#define w(x) cout<<'['<<(#x)<<" : "<<(x)<<"]"<<" ";
#define play(A,k,n) cout<<(#A)<<" : ";Fo(i,k,n)cout<<A[i]<<' ';gh;
 
const int mod = 1e9 + 7;
 
void Solve(){
    int n, Final = 0;
    cin >> n;
    set<int> s;
    for(int i=1;i*i<=n;i++){
        s.insert(i);
        s.insert(n/i);
    }
    for(int k: s){
        int L = ((n+1+k)/(k+1))%mod;
        int R = (n/k)%mod;
        // Final = (Final + (((R-(L-1))*(L+R)/2)%mod* k)%mod)%mod;
        int f1 = ((R-(L-1))*(L+R)/2)%mod;
        int f2 = (f1%mod * k%mod)%mod;
        Final = (Final + f2)%mod;
    }
    cout << Final<< endl;
}
 
int32_t main(){
    cin.tie(0)->sync_with_stdio(0);
    int Test=1;//cin >> Test;
    Fo(tc,1,Test){//cout << "Case #" << tc << ": ";
        Solve();
    }
    return 0;
}
