#include<bits/stdc++.h>
using namespace std;
#define ll long long
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
typedef tree<int,null_type,less<int>,rb_tree_tag, tree_order_statistics_node_update> indexed_set;
 
 
 
int main(){
ios_base::sync_with_stdio(false);
cin.tie(NULL);
cout.tie(NULL);
 
    ll n, s;
    cin>>n>>s;
    vector<pair<ll,ll>> a;
    vector<ll> cp(n);
    for(int i=0;i<n; i++){
        ll g;
        cin>>g;
        a.push_back({g,i+1});
        cp[i]=g;
        
    }
    ll b[4];
    b[0]=0;
    b[1]=0;
    b[2]=0;
    b[3]=0;
    sort(a.begin(), a.end());
    // for(int i=0; i<n; i++){
    //     cout<<a[i].first<<" "<<a[i].second<<endl;
    // }
    int flag=0;
    
    for(int j=0; j<n; j++){
      ll y=s-a[j].first;
      ll cl_sum=a[j].first;
      ll low=j+1;
      ll high=n-1;
      ll mid;
      while(low<high){
        mid=(low+high)>>1;
        ll lo=0;
        ll hi=n-1;
        while(lo!=hi && lo<n && hi>=0){
          ll x=y-a[mid].first;
          if(a[mid].first+a[lo].first+a[hi].first==y && lo!=mid && hi!=mid && lo!=j&& hi!=j){
            b[0]=a[j].second, b[1]=a[mid].second, b[2]=a[lo].second,b[3]=a[hi].second;
              flag=1;
              break;
          }else if(a[lo].first+a[hi].first>=x){
              hi--;
          }else lo++;
        }
        cl_sum+=a[mid].first+a[lo].first+a[hi].first;
        if(flag)break;
        else{
          if(cl_sum<s){
            low=mid+1;
          }else{
            high=mid;
          }
        }
      }
      
      
      if(flag)break;
    }
    if(n<4)flag=0;
    if(flag){
      cout<<b[0]<<" "<<b[1]<<" "<<b[2]<<" "<<b[3]<<endl;
      // ll sum=cp[b[0]-1]+cp[b[1]-1]+cp[b[2]-1]+cp[b[3]-1];
      // cout<<sum<<endl;
    }
    else cout<<"IMPOSSIBLE";
 
return 0;
}
