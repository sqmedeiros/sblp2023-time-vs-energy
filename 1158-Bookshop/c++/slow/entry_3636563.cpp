#include<bits/stdc++.h>
using namespace std;
 
int knapsack(vector<int>& values, vector<int>& weights, int W) {
  int len = values.size();
  vector<vector<int>> dp(W+1, vector<int>(len+1, 0));
 
  // dp[w][k] = max value we can get for weight w with first k items.
  // we can either pick or drop an item in our set. if we pick then we have find
  // a proper knapsack to put it into, if we drop then get max value for
  // [w][k-1]
  for (int i=1; i <= W; i++) {
    for (int j=0; j < len; j++) {
      int witem = weights[j];
      auto addstate = i-witem >= 0 ? dp[i-witem][j] + values[j] : 0;
      dp[i][j+1] = max(dp[i][j], addstate);
    }
  }
  return dp[W][len];
}
 
int main() {
  int N,W;
  cin >> N >> W;
  vector<int> v(N,0), w(N,0);
  for (auto& vi : v)
    cin >> vi;
  for (auto& wi : w)
    cin >> wi;
  cout << knapsack(w, v, W) << endl;
  return 0;
}