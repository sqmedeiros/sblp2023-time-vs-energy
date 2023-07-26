#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    string a,b;cin>>a>>b;
    int n=b.length(),m=a.length();
    int t[2][n+1];
    for(int i=0;i<=n;i++)t[0][i]=i;
    int f=0;
    for(int i=1;i<=m;i++){
        f=1-f;
        t[f][0]=i;        
        for(int j=1;j<=n;j++){
            t[f][j] = std::min({t[f][j-1],t[1-f][j],t[1-f][j-1]-(a[i-1]==b[j-1])})+1;
        }
    }
    cout<<t[f][n];
    return 0;
}