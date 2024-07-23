#include<bits/stdc++.h>
using namespace std;
 
int main () {
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    int n, m, k, ans = 0;
    cin >> n >> m >> k;
    int pre[n], app[m], ind = 0;
 
    for (int i = 0; i < n; i++) cin >> pre[i];
    for (int i = 0; i < m; i++) cin >> app[i];
 
    sort(pre, pre + n);
    sort(app, app + m);
 
    for (int i = 0; i < m; i++) {
        for (int j = ind; ind < n; j++) {
            if (abs(app[i] - pre[j]) > k && pre[j] > app[i]) break;
 
            if (abs(app[i] - pre[j]) <= k) {
                ans++;
                ind = j+1;
                break;
            }
        }
    }
 
    cout << ans;
}
