#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt,fma,tune=native")
 
#include <iostream>
#include <limits>
#include <vector>
 
using namespace std;
 
#define MAXN 1000
#define MAXX 100'000
 
static int dp[MAXX+1];
static int cost[MAXN];
static int pages[MAXN];
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
 
    int n, x;
    cin >> n >> x;
 
    for (int i = 0; i < n; ++i)
    {
        cin >> cost[i];
    }
    for (int i = 0; i < n; ++i)
    {
        cin >> pages[i];
    }
 
    for (int i = 0; i < n; ++i)
    {
        for (int j = x; j >= cost[i]; --j)
        {
            dp[j] = max(dp[j], dp[j - cost[i]] + pages[i]);
        }
    }
 
    int ans = 0;
    for (int j = 0; j <= x; ++j)
    {
        ans = max(ans, dp[j]);
    }
    cout << ans << "\n";
}