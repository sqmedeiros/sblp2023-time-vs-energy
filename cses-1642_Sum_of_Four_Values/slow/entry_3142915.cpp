#include <bits/stdc++.h>
 
using namespace std;
 
const int N = 1e6 + 5;
 
map < int, int > mp;
vector < pair < int, int > > sums[N];
 
int a[N];
 
int main()
{
    int n, x;
 
    scanf("%d%d", &n, &x);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i]);
    }
    int cnt = 0;
    for (int i = 1; i <= n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
            int sum = a[i] + a[j];
            if (mp[sum] == 0) {
                mp[sum] = ++cnt;
            }
            sums[mp[sum]].push_back({i, j});
        }
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
            if (a[i] + a[j] >= x) {
                break;
            }
            int dif = x - (a[i] + a[j]);
            for (auto v : sums[mp[dif]]) {
                if (i != v.first && i != v.second && j != v.first && j != v.second) {
                    printf("%d %d %d %d\n", i, j, v.first, v.second);
                    return 0;
                }
            }
        }
    }
    printf("IMPOSSIBLE\n");
    return 0;
}
