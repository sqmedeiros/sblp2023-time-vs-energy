#include <bits/stdc++.h>
using namespace std;
 
 
struct project {
    int a, b, p;
    friend bool operator<(const project &l, const project &r) {
        return tie(l.a, l.b, l.p) < tie(r.a, r.b, r.p);
    }
};
 
inline void getnum(int &a) {
    int chr = getchar_unlocked();
    if (isspace(chr))
        chr = getchar_unlocked();
 
    a = chr - '0';
    while (isdigit(chr = getchar_unlocked()))
        a = a * 10 + chr - '0';
}
 
int main() {
    int n;
    getnum(n);
 
    vector<project> projects(n);
    for (auto &proj : projects)
        getnum(proj.a), getnum(proj.b), getnum(proj.p);
 
    sort(projects.begin(), projects.end());
 
    vector<long long> dp(n + 1);
    for (int i = n - 1; i >= 0; --i)
        dp[i] = max(projects[i].p + dp[upper_bound(projects.begin(), projects.end(), projects[i].b, [](int l, const project &r) {
                                           return l < r.a;
                                       }) -
                                       projects.begin()],
                    dp[i + 1]);
 
    printf("%lld\n", dp[0]);
    return 0;
}