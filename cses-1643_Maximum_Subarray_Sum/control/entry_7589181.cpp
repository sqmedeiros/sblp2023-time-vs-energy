#include <bits/stdc++.h>
using namespace std;
#define ll long long int
 
int main(){
 
ios_base::sync_with_stdio(false);
cin.tie (NULL);
#ifndef ONLINE_JUDGE
freopen("input.txt", "r", stdin);
freopen("output.txt", "w", stdout);
#endif
 
    ll n; cin >> n;
    vector <int> arr(n);
    for (int i = 0; i < n; i++){
        cin >> arr[i];
    }
 
    ll maxi = INT_MIN;
    ll sum = 0;
    for (int i = 0; i < n; i++){
        if (sum < 0){
            sum = 0;
        }
        sum += arr[i];
        maxi = max(sum, maxi);
    }
    cout << maxi;
    return 0;
}