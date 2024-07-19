#include<bits/stdc++.h>
#include <cstdio>
using namespace std;
#define xi first
#define yi second
#define endl '\n'
#define MAX 5000000
typedef long double ld;
typedef long long ll;
const long double PI = 3.14159265359;
//long long const md = (ll) 998244353 ;
long long gcd(long long a, long long b) {
    return (a % b) ? gcd(b, a % b) : b;
}
//vector<bool> ch(MAX);
//vector<int> sp(MAX);
/*void Sieve(){
    for (long long i = 2; i < MAX; i += 2) sp[i]=2;
    for (long long i = 3; i < MAX; i += 2){
        if (!ch[i]){
            sp[i] = i;
            for (long long j = i; (j*i) < MAX; j += 2){
                if (!ch[j*i])
                    ch[j*i] = true, sp[j*i] = i;
            }
        };
    }
}*/
//vector<vector<vector<int>>>v(2, vector<vector<int>>(2, vector<int>(2)));
/*class myComparator {
public:
    bool operator() (const pair<int, int> &p1, const pair<int, int> &p2) {
        if(p1.first == p2.first) return p1.second > p2.second;
        return p1.first < p2.first;
    }
};
*/
/*bool comp(const pair<int, int> &x, const pair<int, int> &y)
{
    if (x.first==y.first) return x.second > y.second;
    return x.first < y.first;
}*/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
   // cout.tie(NULL);
    //freopen("convention.in", "r", stdin);
    //freopen("convention.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
   /* int n;
    cin>>n;
    unordered_map<int, unordered_map<int, int>>mp;
    map<int, int>s;
    for(int x=0;x<n;x++){
        int i, j, p;
        cin>>i>>j>>p;
        mp[i][j]=max(mp[i][j], p);
        s[i], s[j], s[j+1];
    }
    vector<long long>dp(s.size());
    vector<vector<int>>idx(s.size());
    int ii=0, sz=s.size();
    for(auto x:s) x.yi=ii++;
    for(auto i:s){
        for(auto j:mp[i.xi])
            idx[i.yi][s[j.xi]]=j.yi;
    }
    for(int x=0;x<sz;x++){
 
    }*/
    int n;
    cin>>n;
    unordered_map<int, vector<pair<int, int>>>mp;
    map<int, long long>dp;
    for(int x=0;x<n;x++){
        long long  i, j, p;
        cin>>i>>j>>p;
        mp[i].push_back({j+1, p});
        dp[i], dp[j+1];
    }
    auto it=dp.begin();
    it++;
    for(auto i:dp){
        for(auto j:mp[i.xi])
            dp[j.xi]=max(dp[j.xi], j.yi+dp[i.xi]);
        if(it!=dp.end())
            dp[it->xi]=max(dp[i.xi], dp[it->xi]), it++;
    }
    cout<<dp.rbegin()->yi<<endl;
    return 0;
}