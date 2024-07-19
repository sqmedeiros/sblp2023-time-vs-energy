//
//  main.cpp
//  q1 bremly
//
//
//  main.cpp
//  q1 bremly
//
//  Created by Afek on 23/02/2023.
//
 
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <set>
#include <string>
#include <math.h>
#include <list>
//#include "safe_code.h"
using  namespace std;
using ll=unsigned long long;
int main(){
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    ll n;cin>>n;
    ll ans=0;
    ll mod=1000000007;
    for (ll i=1; i*i<n+1; i++) {
        ans=(ans+((n/i)-i)*i)%mod;
        ans=ans+(((n/i)%mod)*(((n/i)+1)%mod)/2)-((i-1)*i/2)%mod;
        ans=ans%mod;
    }
    cout<<ans;
 
}
