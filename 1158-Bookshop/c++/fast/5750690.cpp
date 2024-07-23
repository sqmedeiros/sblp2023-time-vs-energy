#pragma GCC optimize("O3,unroll-loops")
//#pragma GCC target("avx,avx2,bmi,bmi2,popcnt,lzcnt")
#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e3 + 1;
const int maxx = 1e5 + 1;
int n, x;
int dp[maxx], w[maxn], v[maxn];
inline int readInt()
{
    bool Minus = false;
    int result = 0;
    char ch;
    ch = getchar();
    while(true)
    {
        if (ch == '-') break;
        if (ch >= '0' && ch <= '9') break;
        ch = getchar();
    }
    if (ch == '-') Minus = true;
    else result = ch- '0';
    while(true)
    {
        ch = getchar();
        if (ch < '0' || ch > '9') break;
        result = result * 10 + (ch - '0');
    }
    if (Minus) return -result;
    else return result;
}
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    n = readInt(), x = readInt();
    for(int i = 0 ; i < n ; i++) w[i] = readInt();
    for(int i = 0 ; i < n ; i++) v[i] = readInt();
    for(int i = 0 ; i < n ; i++) for(int j = x ; j >= w[i] ; j--) dp[j] = max(dp[j], dp[j - w[i]] + v[i]);
    cout << dp[x];
    return 0;
}
