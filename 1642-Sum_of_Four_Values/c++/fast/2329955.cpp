#include <bits/stdc++.h>
using namespace std;
 
#define F first
#define S second
#define PB push_back
#define PF push_front
#define FOR(i, a, b) for(int i = a; i < b; i++)
#define RFOR(i, a, b) for (int i = a-1; i >= b; i--)
 
typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef pair<int, int> pi;
 
template<typename keytype> using setitr = typename set<keytype>::iterator; 
template<typename keytype> using uset = unordered_set<keytype>;
template<typename keytype> using usetitr = typename uset<keytype>::iterator;
template<typename keytype> using mset = multiset<keytype>;
template<typename keytype> using msetitr = typename mset<keytype>::iterator;
template<typename keytype, typename valuetype> using mapitr = typename map<keytype, valuetype>::iterator;
template<typename keytype, typename valuetype> using umap = unordered_map<keytype, valuetype>;
template<typename keytype, typename valuetype> using umapitr = typename umap<keytype, valuetype>::iterator; 
template<typename keytype, typename valuetype> using mmap = multimap<keytype, valuetype>;
template<typename keytype, typename valuetype> using mmapitr = typename mmap<keytype, valuetype>::iterator;
 
/*
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
 
#define ordered_set tree<int, null_type, less<int>, rb_tree_tag,tree_order_statistics_node_update>
*/
 
int main()
{
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    long long n,x;
    cin >> n >> x;
 
    vector<long long> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];
 
    if (n < 4)
    {
        cout << "IMPOSSIBLE" << endl;
        return 0;
    }
 
    vector<long long> temparr = arr;
    sort(temparr.begin(), temparr.end());
    if (temparr[n-1] + temparr[n-2] + temparr[n-3] + temparr[n-4] < x || temparr[0]+temparr[1]+temparr[2]+temparr[3] > x) 
    {
        cout << "IMPOSSIBLE" << endl;
        return 0;
    }
 
    unordered_map<long long, pair<int, int>> dict;
    dict[arr[n-1]+arr[n-2]] = {n-1, n-2};
 
    for (int j = n-3; j >= 1; j--)
    {
        for (int i = 0; i < j; i++)
        {
            long long req = x - (arr[i] + arr[j]);
 
            unordered_map<long long, pair<int, int>>::iterator it = dict.find(req);
            if (it != dict.end())
            {
                cout << i+1 << " " << j+1 << " " << it->second.first+1 << " " << it->second.second+1 << endl;
                return 0;
            }
        }
 
        for (int k = j+1; k < n; k++)
        {
            dict[arr[j]+arr[k]] = {j, k};
        }
    }
 
    cout << "IMPOSSIBLE" << endl;
 
    return 0;
}
