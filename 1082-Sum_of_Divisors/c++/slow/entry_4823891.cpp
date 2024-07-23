#include <bits/stdc++.h>
#define int long long
#define endl "\n"
 
using namespace std;
 
 
// attempts:
// 1) sigma(i) can be found in constant time, but even then we would have to iterate over n values
// 2) consider the contribution of i to the answer: i * floor(n / i)
 
// sum over i to get sum, this is still O(N)
// optimization:
 
// Fact to remember:
// Number of distinct values of floor(N / i) for i in range(1, N) = O(sqrt(N))
// Proving is easy, after knowing the fact.
 
// Proof:
// k = floor(N / i), consider
// 1) k <= sqrt(N) (as it suggests, k < O(sqrt(N)))
// 2) k > sqrt(N) ==> i < sqrt(N) ==> even for one one mapping, only i distinct values of k are posisble ==> k < O(sqrt(N))
 
 
// how to use this fact:
// floor(n / i) will be fixed over a range, there will be O(sqrt(N)) ranges
// for each range contribution can be found in constant time
// binary search or use math
 
const int M = 1e9 + 7, MOD_INV_2 = 500000004; // MOD_INV_2 * 2 ~ 1 (mod M) ==> guess MOD_INV_2
 
 
// if a > M or b > M, b*b > long long range, so take mod first
int sum(int a, int b) {
    a %= M; b %= M;
    return (((b * (b + 1) % M) * MOD_INV_2 % M) - (((a * (a - 1) % M)) * MOD_INV_2 % M) + M) % M;
}
 
signed main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
 
    int T = 1;
    // cin >> T;
    for (int t = 1; t < T + 1; t ++) {
        int n;
        cin >> n;
        int k = n, i = 1, ans = 0;
 
        // with binary search: O(sqrt(n) * log(n))
        while (i <= n) {
            int l = i, r = n + 1; // find first index where n / i != k
            while (l < r) {
                int m = (l + r) >> 1;
                if (n / m == n / i) {
                    l = m + 1;
                }
                else {
                    r = m;
                }
            }
 
            // cout << l << endl;
 
            int next = l;
            ans = (ans + k * sum(i, min(next - 1, n)) % M) % M;
            i = next;
            k = n / i;
        }
        cout << ans << endl;
    }
 
    return 0;
}
