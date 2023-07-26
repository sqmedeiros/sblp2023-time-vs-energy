#include <cstring>
#include <iostream>
 
using namespace std;
 
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")
 
constexpr int kXmax = 1e6+1;
constexpr int mod = 1e9+7;
int dp[kXmax];
 
int n, x;
int c[100];
 
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
 
	cin >> n >> x;
 
	for (int i = 0; i < n; ++i)
		cin >> c[i];
 
	memset(dp, sizeof(dp), 0);
 
	dp[0] = 1;
 
	for (int xx = 1; xx <= x; ++xx)
	{
		long long temp = 0;
 
		for (int i = 0; i < n; ++i)
			if (c[i] <= xx)
				temp += dp[xx-c[i]];
 
		dp[xx] = temp % mod;
	}
 
	cout << dp[x] << endl;
}
 
 
 