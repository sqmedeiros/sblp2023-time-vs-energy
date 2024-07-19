#include <bits/stdc++.h>
#define int long long
#define sqr(a) ((a) * (a))
using namespace std;
typedef pair<int, int> pi;
const int mod = 1e9+7;
 
const int N = 21;
int a[N];
int n, k;
 
int dequy(int n, int i, int d) {
    if(i < 0)
        return n * d;
    int ans = 0;
    ans += dequy(n/a[i], i-1, -d);
    ans += dequy(n, i-1, d);
    return ans;
}
 
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    #ifdef LAM_BAO
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif // LAM_BAO
    int n, k;
    cin >> n >> k;
    for(int i = 0; i < k; i++)
        cin >> a[i];
    cout << n-dequy(n, k-1, 1) << "\n";
}
