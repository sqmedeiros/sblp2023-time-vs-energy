#include <cstdio>
#include <cstring>
#include <algorithm>
 
char s[5005], t[5005];
int f[2][5005];
int main() {
    scanf("%s%s", s, t);
    int cur = 0, pre = 1;
    int n = std::strlen(s), m = std::strlen(t);
    for (int i = 0; i <= m; ++i)
        f[pre][i] = i;
    for (int i = 1; i <= n; ++i) {
        f[cur][0] = i;
        for (int j = 1; j <= m; ++j) {
            f[cur][j] = std::min(f[pre][j], f[cur][j - 1]) + 1;
            f[cur][j] = std::min(f[cur][j], f[pre][j - 1] + (s[i - 1] != t[j - 1]));
        }
        std::swap(cur, pre);
    }
    printf("%d\n", f[pre][m]);
    return 0;
}