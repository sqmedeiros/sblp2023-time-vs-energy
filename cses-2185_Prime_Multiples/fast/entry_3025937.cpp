#pragma GCC optimize("unroll-loops")
#pragma GCC optimize ("O3")
#pragma GCC target ("sse4")
#pragma GCC optimize("Ofast")
 
#include <bits/stdc++.h>
using namespace std;
 
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
typedef tree<int,null_type,less<int>,rb_tree_tag, tree_order_statistics_node_update> indexed_set;
 
#define r(i ,n) for (int64_t (i) = 0; (i) < (n); (i)++)
#define f(i,a,b) for(int64_t (i) = (a); (i) < (b); (i)++)
#define fd(i,a,b) for(int64_t (i) = (a); (i) > (b); (i)--)
#define int int64_t
#define all(x) (x).begin(), (x).end()
#define F first
#define S second
#define ln cout<<"\n";
const int mod = 1e9+7;
const int N = 200005;
const double pi = 3.14159265358979323846;
 
vector<int> a;
int n,k;
int solve(int num, int pos){
    int t=n/num;
    int m=0;
    for(int i=0; i<pos; i++){
        if(num*a[i]>n) break;
        m+=solve(num*a[i], i);
    }
    return t-m;
}
signed main(){
	ios_base::sync_with_stdio(false);cin.tie(0);
	
	 cin>>n>>k;
	for(int i=0; i<k; i++){
        int t;
        cin>>t;
        a.push_back(t);
    }
    sort(a.begin(), a.end());
    int ans=0;
    for(int i=0; i<k; i++){
        ans+=solve(a[i], i);
    }
    cout<<ans;
}
