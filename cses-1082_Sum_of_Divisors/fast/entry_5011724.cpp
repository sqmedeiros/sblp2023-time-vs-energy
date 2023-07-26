#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define modulo 1000000007
ll powmod(ll a,ll b,ll MOD){ll res=1;a%=MOD;assert(b>=0);for(;b;b>>=1){if(b&1)res=res*a%MOD;a=a*a%MOD;}return res;}
 
//void divisor(){
//    for(int i=2;i<=1000000;i++){
//        int x=1;
//        int total=0;
//        while(i*x<=1000000){
//            total+=A[i*x];
//            if(total>=2){mx=i;break;}
//            x++;
//        }
//    }
//}
 
 
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll n;
    cin>>n;
//    ll sq=sqrt(n);
    ll total=0;
    for(ll i=1;i*i<=n;i++){
        ll div=n/i;
        if(div>i-1)total+=(div-(i-1))*i;
        if(i+1<=div){
            ll f=((i+1+div%modulo)*(div%modulo-i))/(ll)2;
            total+=f;
        }
        total%=modulo;
    }
    cout<<total<<endl;
    
    
}
 
 
//////////////////////////////////INVERSE//////////////////////////////////////////////////////////////////////////////////////////
//powmod(N,modulo-2,modulo)
//////////////////////////////////MOD//////////////////////////////////////////////////////////////////////////////////////////
/*
 ll powmod(ll a,ll b,ll MOD){
     ll res=1;a%=MOD;assert(b>=0);for(;b;b>>=1){if(b&1)res=res*a%MOD;a=a*a%MOD;}
     return res;
 }
 */
 
 
/////////////////////////////////Prime Factorization (squre root +log n)////////////////////
/*
 vector<int>PrimeFacorizationVector(int n){
     vector<int>v;
     while(factor[n]!=-1){
         v.push_back(factor[n]);
         n=n/factor[n];
     }
     return v;
     
 }
 void PrimeFacorization(int n){
     memset(factor,-1,sizeof factor);
     for(int i=2;i*i<=n;i++){
         if(factor[i]==-1){
             for(int j=i;j<=n;j+=i){
                 if(factor[j]==-1)factor[j]=i;
             }
         }
     }
     
 }
 */
 
 
///////////////////////////////////////////////TOTAL DIVISOR//////////////////////////////////////
/*
 void divisor(){
     int s=1000000;
     for(int i=1;i<=s;i++){
         int m=1;
         while(i*m<=1000000){A[i*m]++;m++;}
     }
 }
 */
