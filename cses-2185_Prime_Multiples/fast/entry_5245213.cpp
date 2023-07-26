#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
// int A[22];
ll a[22];
ll ans=0;
ll n,k;
void solve(int i,int cnt,ll x){
    if(i==k){
        if(cnt==0)
            return;
        if(cnt%2)
            ans+=x;
        else
            ans-=x;
        return;
    }
    solve(i+1,cnt+1,x/a[i]);
    solve(i+1,cnt,x);
}
int main(){
    cin>>n>>k;
    for(int i=0;i<k;i++)
        cin>>a[i];
    solve(0,0,n);
    cout<<ans<<endl;
}
