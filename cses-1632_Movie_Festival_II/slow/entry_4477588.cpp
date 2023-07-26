#include<bits/stdc++.h>
#define INF 1000000000000000000
#define ll long long int 
using namespace std;
 
void comp(vector<ll> &v){
    set<ll>st;
    for(auto e:v){
        st.insert(e);
    }
    
    v.clear();
    for(auto e:st)
    v.push_back(e);
}
 
class Segtree{
    ll *sg;
    ll *lazy;
    public: 
    Segtree(ll sz){
        sg = new ll[4*sz+1];
        lazy=new ll[4*sz+1];
        for(ll i=0;i<4*sz+1;i++)
        sg[i]=lazy[i]=0;
    }
    
    void push(ll si,ll ss,ll se){
        if(ss==se)
        return;
        
        sg[(si<<1LL)+1]+=lazy[si];
        sg[(si<<1LL)+2]+=lazy[si];
        lazy[(si<<1LL)+1]+=lazy[si];
        lazy[(si<<1LL)+2]+=lazy[si];
        lazy[si]=0;
    }
    
    void add(ll si,ll ss,ll se,ll l,ll r,ll val){
        if(l>se || r<ss)
        return ;
        
        if(ss>=l && se<=r){
            sg[si]+=val;
            lazy[si]+=val;
            return;
        }
        
        push(si,ss,se);
        ll mid=(ss+se)>>1LL;
        add((si<<1LL)+1,ss,mid,l,r,val);
        add((si<<1LL)+2,mid+1,se,l,r,val);
        
        sg[si]=max(sg[(si<<1LL)+1],sg[(si<<1LL)+2]);
    }
    
    ll get(ll si,ll ss,ll se,ll l,ll r){
        if(l>se||r<ss)
        return -INF;
        
        if(ss>=l && se<=r)
        return sg[si];
        
        push(si,ss,se);
        ll mid=(ss+se)>>1LL;
        return max(get((si<<1LL)+1,ss,mid,l,r),get((si<<1LL)+2,mid+1,se,l,r));
    }
};
 
int main(){
    ll n,k;
    cin>>n>>k;
    
    ll l[n];
    ll r[n];
    vector<ll>v;    
    for(ll i=0;i<n;i++){
        cin>>l[i]>>r[i];
        v.push_back(l[i]);
        v.push_back(r[i]);
    }
    
    comp(v);
    ll mx=0;
    for(ll i=0;i<n;i++){
        auto it=lower_bound(v.begin(),v.end(),l[i])-v.begin();
        it++;
        l[i]=it;
        it=lower_bound(v.begin(),v.end(),r[i])-v.begin();
        it++;
        r[i]=it;
        mx=max({mx,l[i],r[i]});
    }
    
    
    vector<pair<ll,ll>>vv;
    
    for(ll i=0;i<n;i++)
    vv.push_back(make_pair(r[i],l[i]));
    
    sort(vv.begin(),vv.end());
    ll ans=0;
    
    Segtree sg(2*n+1);
    
    for(auto [end,start]:vv){
        // try to add this
        sg.add(0,0,n<<1LL,start,end,1);
        ll mx =sg.get(0,0,n<<1LL,start+1,end);
        if(mx>k){
            sg.add(0,0,n<<1LL,start,end,-1);
        }
        else {
            ++ans;
        }
    }
    
    cout<<ans<<endl;
    // 2*n 
    
 
    return 0;
}