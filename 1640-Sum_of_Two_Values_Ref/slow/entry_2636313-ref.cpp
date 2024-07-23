#include<bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
#define int long long
 
const int mod = 1e9+7;
 
 
bool compare(vector<int>& a, vector<int>& b){
    return a[0]<b[0];
}
 
signed main(){
 
    int n, x;
    cin>>n>>x;
 
    vector<vector<int>> v;
    int a[n];
    for(int i=0; i<n; i++){
        cin>>a[i];
        v.push_back({a[i], i+1});
    }
 
    sort(v.begin(), v.end(), compare);
    
    for(int i=0, j=n-1; i<n; i++){
 
        while(v[i][0]+v[j][0]>x && i<j){
            j--;
        }
 
        if(i<j && (v[i][0]+v[j][0] == x)){
            cout<<v[i][1]<<" "<<v[j][1]<<endl;
            return 0;
        }
    }
 
    cout<<"IMPOSSIBLE"<<endl;
}
