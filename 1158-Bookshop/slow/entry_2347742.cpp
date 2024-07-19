#include <bits/stdc++.h>
 
using namespace std;
 
int main()
{
    int n, x;
    cin >> n >> x;
    int h[n], s[n];
    for (int i = 0; i < n; i++) {
        cin >> h[i];
    }
    int m = 0;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
        m += s[i];
    }
 
    vector <pair<int, int>> v;
    v.push_back({0, 0});
    for (int i = 0; i < n; i++) {
        v.push_back({s[i], h[i]});
    }
 
 
    bool possible[m+1];
    int price[m+1], INF = 1000000000;
    for (int i = 0; i <= m; i++) {
        possible[i] = false;
        price[i] = INF;
    }
    possible[0] = true;
    price[0] = 0;
    for (int k = 1; k <= n; k++) {
        for (int c = m-v[k].first; c >= 0; c--) {
            possible[c+v[k].first] |= possible[c];
            if (possible[c+v[k].first]) {
                price[c+v[k].first] = min(price[c+v[k].first],
                                          price[c] + v[k].second);
            }
        }
    }
 
    int ans = -1;
    for (int i = m; i >= 0; i--) {
        if (possible[i] && price[i] <= x && ans == -1) {
            ans = i;
        }
    }
 
    cout << ans;
 
    return 0;
}