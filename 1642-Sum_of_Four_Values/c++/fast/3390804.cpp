#include <iostream>
#include <set>
#include <algorithm>
#include <vector>
#include <array>
#include <unordered_map>
#include <map>
#include <bitset>
#define int long long int
#define endl '\n'
#define ar array
using namespace std;
const int mxN = 2e5;
 
signed main(){
    // freopen("/Users/ishan/Code/CP/cses/input.txt", "r", stdin);
    // freopen("/Users/ishan/Code/CP/cses/output.txt", "w", stdout);
    int inp,n,target;
    cin>>n>>target;
    vector<array<int,2>> nums(n);
    for (int i=0;i<n;i++) {
        cin>>inp;
        nums[i] = {inp,i};
    }
    sort(nums.begin(),nums.end());
    if (nums[n-1][0]+nums[n-2][0]+nums[n-3][0]+nums[n-4][0]>=target) {
        unordered_map<int,array<int,2>> mp;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int find = target - (nums[i][0]+nums[j][0]);
                auto it = mp.find(find);
                if (it!=mp.end()) {
                    cout<<nums[i][1]+1<<" "<<nums[j][1]+1<<" "<<(*it).second[0]+1<<" "<<(*it).second[1]+1<<endl;
                    return 0;
                }
            }
            for (int j=0;j<i;j++) {
                mp[nums[i][0]+nums[j][0]] = {nums[i][1],nums[j][1]};
            }
        }
    }
    cout<<"IMPOSSIBLE"<<endl;
    return 0;
 
}
