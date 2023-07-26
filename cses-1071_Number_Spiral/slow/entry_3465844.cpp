#define boost ios::sync_with_stdio(false); cin.tie(0)
#define ll          long long int
#define fo(i,a,b)   for(int i=a;i<b;i++)
#define vl          vector<long long int>
#define vi          vector<int>
#define popb        pop_back
#define timetaken cerr<<fixed<<setprecision(10); cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << endl
#define mod         (long long int)(pow(10,9) + 7)
#define scanit(a,n) for(ll indexaa=0; indexaa<n; indexaa++) cin>>a[indexaa];
#define printit(a,n) for(ll indexaa=0; indexaa<n; indexaa++) cout<<a[indexaa]<<" "; cout<<endl;
using namespace std;
#include<bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
    #ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("I.txt", "r", stdin);
    // for writing output to output.txt
    freopen("O.txt", "w", stdout);
#endif
    int t;
    cin>>t;
    while(t--)
    {
    ll x,y;
    cin>>x>>y;
    ll sum=0;
    ll g=max(x,y);
    ll s=min(x,y);
    sum+=(g-1)*(g-1);
    if(g==x){
        if(g%2==0)
            sum+=g+(g-s);
        else sum+=s;
    }
    else{
        if(g%2==0)
            sum+=s;
        else sum+=g+(g-s);
    }
    cout<<sum<<endl;
 timetaken;
}
}