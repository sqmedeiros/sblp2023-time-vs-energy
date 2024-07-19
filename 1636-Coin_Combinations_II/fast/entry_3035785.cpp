#include <cstring>
#include <algorithm>
#include <iostream>
 
#pragma GCC optimize ("O3")
//#pragma GCC target ("avx,avx2,fma")
#pragma GCC optimize ("unroll-loops")
 
using namespace std;
 
constexpr int mod = 1e9+7;
 
int n;
int x;
int c[101];
 
int dp[1'000'001u];
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
 
    cin >> n >> x;
    for (int i = 0; i < n; ++i)
        cin >> c[i];
 
    memset(dp, 0, sizeof(dp));
 
    dp[0] = 1;
 
    int istart = 0;
    int xstart = 1;
 
    sort(begin(c), begin(c) + n);
 
    if (c[0] == 1)
    {
        fill_n(begin(dp)+1, x, 1);
        istart = 1;
    }
    else if (c[0] == 2)
    {
        for (int xx = 2; xx <= x; xx += 2)
            dp[xx] = 1;
        istart = 1;
        xstart = 4;
    }
    else for (int cc = 3; cc <= 9; ++cc)
    {
        if (c[0] == cc)
        {
            for (int xx = cc; xx <= x; xx += cc)
                dp[xx] = 1;
 
            istart = 1;
            xstart = 2*cc;
            break;
        }
    }
 
    for (int i = istart; i < n; ++i)
        for (int xx = xstart; xx <= x; ++xx)
        {
            if (c[i] <= xx)
            {
                if ((dp[xx] += dp[xx-c[i]]) >= mod)
                    dp[xx] -= mod;
            }
        }
 
    cout << dp[x] << endl;
}
