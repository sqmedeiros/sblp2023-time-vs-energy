/*
Author: Racer5x
 ***************************************   UNAUTHORISED COPYING OF CODE PROHIBITED   **********************************
*/
 
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
 
#include<bits/stdc++.h>
#define int         long long
#define double      long double
#define pb          emplace_back
#define pf          emplace_front
#define pii         pair<int,int>
#define vi          vector<int>
#define vii         vector<pii>
#define mi          map<int,int>
#define mii         map<pii,int>
#define all(a)      (a).begin(),(a).end()
#define rall(a)     (a).rbegin(),(a).rend()
#define x           first
#define y           second
#define endl        '\n'
#define hell        998244353 
#define PI          3.141592653589
#define tezz        ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define MAX         2000000000000000000
#define M           1000000007
using namespace std;
 
void add_self(int &a, int b){
    a += b;
    if(a > M) a -= M;
}
 
int diff(int a, int b){
    a %= M, b %= M;
 
    int big = ((b * (b + 1)) / 2) % M;
    int small = ((a * (a + 1)) / 2) % M;
 
    return (big - small + M) % M;
}
 
signed main()
{
    tezz
 
    int n;
    cin>>n;
 
    int sum = 0;
 
    set<int> div;
 
    int curr = 0;
    for(int i=1; i<=sqrtl(n); i++){
        if(n / i > curr){
            div.insert(i);
            div.insert(n / i);
 
            curr++;
        }
    }
 
    curr = 0;
    for(int x:div){
        add_self(sum, ((n / x) * diff(curr, x)) % M);
        curr = x;
    }
 
    cout<<sum;
} 
