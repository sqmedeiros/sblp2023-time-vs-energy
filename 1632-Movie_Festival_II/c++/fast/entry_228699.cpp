#pragma GCC optimize ("-O2")
#include <bits/stdc++.h>
using namespace std;
typedef long long int  ll;
#define fast ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0)
#define mem(a,b) memset(a,b,sizeof(a))
 
template<class T>inline bool read(T &x){
    int c=getchar();int sgn=1;
    while(~c&&c<'0'||c>'9'){if(c=='-')sgn=-1;c=getchar();}
    for(x=0;~c&&'0'<=c&&c<='9';c=getchar())x=x*10+c-'0';
    x*=sgn; return ~c;
}
///START HERE
 
int main(){
    ///read()+printf
    //fast;
    int n, k;
    read(n);
    read(k);
    pair<int, int> arr[n];
    for (int i = 0; i != n; ++i){
        read(arr[i].second);
        read(arr[i].first);
    }
    sort(arr, arr + n);
    int ans = 0;
    multiset<int> kek;
    for (int i = 0; i != n; ++i){
        if (!kek.empty() && *kek.begin() <= arr[i].second){
            kek.erase(prev(kek.upper_bound(arr[i].second  - 1)));
            ans++;
            kek.insert(arr[i].first);
        }
        else if (k){
            k--;
            ans++;
            kek.insert(arr[i].first);
        }
    }
    printf("%d",ans);
}