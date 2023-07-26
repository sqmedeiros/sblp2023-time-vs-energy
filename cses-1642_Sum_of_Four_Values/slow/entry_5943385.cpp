#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define pb push_back
#define ss second
#define ff first
map<ll,bool>vis;
ll arr[2000];
ll n,x,m;
map<ll,ll>mp;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin>>n>>x;
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            ll sum=arr[i]+arr[j];
            vis[sum]=1;
            mp[sum]=i*10000+j;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int sum=x-(arr[i]+arr[j]);
            if(sum>1){
                if(vis[sum]==1){
               set<int>s;
               s.insert(i);
               s.insert(j);
               s.insert(mp[sum]/10000);
               s.insert(mp[sum]%10000);
               if(s.size()==4){
                   cout<<i+1<<" "<<j+1<<" "<<mp[sum]/10000+1<<" "<<mp[sum]%10000+1;
                   return 0;
               }
           }
            }
           
           
        }
    }
    cout<<"IMPOSSIBLE";
}
