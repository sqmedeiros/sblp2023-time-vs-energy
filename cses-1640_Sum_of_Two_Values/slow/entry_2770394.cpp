#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,s;cin>>n>>s;
    map<ll,deque<ll>>mp;
    set<ll>st;
    for(ll i=0;i<n;i++){
    ll c;cin>>c;
    mp[c].push_back(i+1);st.insert(c);
    }
    ll r=0;
    while(st.size()){
        auto it=*st.begin();
        if(mp[it].size()>=2){
            if(it*2==s){
                cout<<mp[it].front()<<" "<<mp[it].back()<<endl;
                return 0;
            }
        }
        else{
            ll d=mp[s-it].size();
            if(d>0&&((s-it)!=it)){
                cout<<mp[it].back()<<" "<<mp[s-it].back()<<endl;
                return 0;
            }
        }
        st.erase(it);
    }
    cout<<"IMPOSSIBLE"<<endl;
}