#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <set>
#include <list>
#include <map>
using namespace std;
typedef long long ll;
ll mod = 1e9 + 7;
ll max_N = 1e6;
 
ll getEditDistance(string &src, string &goal, vector<vector<ll>> &dp, ll i, ll j)
{
    if (i == src.size()) return goal.size() - j;
    if (j == goal.size()) return src.size() - i;
    if (dp[i][j] != -1) return dp[i][j];
    ll mini = getEditDistance(src, goal, dp, i, j+1)+1;
    mini = min(mini, getEditDistance(src, goal, dp, i+1, j)+1);
    if (src[i] != goal[j]) mini = min(mini, getEditDistance(src, goal, dp, i+1,j+1)+1);
    else mini = min(mini, getEditDistance(src, goal, dp, i+1, j+1));
    dp[i][j] = mini;
    return mini;
}
 
int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
 
    string src, dst;
    cin >> src >> dst;
    vector<vector<ll>> dp;
    for (ll i = 0; i < src.size();i++)
    {
        dp.push_back(vector<ll>(dst.size(),-1));
    }
    cout << getEditDistance(src, dst, dp, 0,0) << "\n";
}