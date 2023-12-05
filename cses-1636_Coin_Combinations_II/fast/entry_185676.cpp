#include <bits/stdc++.h>
 
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma,tune=native")
 
#ifdef _WIN32
    char next_char() {return _getchar_nolock();}
#else
    static const int BUFFSIZE = 1 << 14;
    char buf[BUFFSIZE];
    int sz = BUFFSIZE - 1;
    char next_char()
    {
        if (sz == BUFFSIZE - 1) {
            fread_unlocked(buf, sizeof(char), BUFFSIZE, stdin);
            sz = -1;
        }
        return buf[++sz];
    }
#endif
 
int read_int()
{
    int ans = 0;
    for (char c = next_char(); c >= '0'; c = next_char())
    {
        ans = 10 * ans + c - '0';
    }
    return ans;
}
 
using namespace std;
 
 
const int MOD = 1e9+7;
array<int, 1000001> DP;
 
int main()
{
    int n = read_int();
    int x = read_int();
    
    vector<int> C(n);
    for (auto &c : C) c = read_int();
    sort(C.begin(), C.end(), greater<int>());
    
    DP[0] = 1;
    
    int counter = 0;
    for (auto c : C) {
        if (++counter == 1) {
            for (int i = c; i <= 1000000; i += c) {
                DP[i] = 1;
            }
        } else if (counter < 4) {
            for (int i = c; i <= 1000000; ++i) {
                DP[i] += DP[i - c];
            }
        } else {
            for (int i = c; i <= 1000000; ++i) {
                DP[i] += DP[i - c];
                if (DP[i] >= MOD)
                    DP[i] -= MOD;
            }
        }
 
    }
    cout << DP[x];
}
