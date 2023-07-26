#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt")
#define NDEBUG
#include <bits/stdc++.h>
using namespace std;
using ui = unsigned int;
using ll = long long int;
using ull = unsigned long long int;
#define pb push_back
#define pf push_front
#define pob pop_back
#define pof pop_front
#define ep emplace
#define epb emplace_back
#define mp make_pair
#define mt make_tuple
#define rep(i, a, b) for (auto i{a}; i < static_cast<decltype(a)>(b); ++i)
#define rev(i, a, b) for (auto i{a}; i >= static_cast<decltype(a)>(b); --i)
#define all(cont) for (auto &&el : cont)
#define call(cont) for (const auto &&el : cont)
#define endl '\n'
inline static void solve() noexcept;
int main() {
    ios_base::sync_with_stdio(false);
    // setvbuf(stdin, nullptr, _IOFBF, BUFSIZ << 4);
    // setvbuf(stdout, nullptr, _IOFBF, BUFSIZ << 4);
    cin.tie(nullptr), cout.tie(nullptr);
#ifdef LOCAL
    auto t1 = chrono::high_resolution_clock::now();
#endif
    solve();
#ifdef LOCAL
    auto t2 = chrono::high_resolution_clock::now();
    auto time = chrono::duration<double, std::nano>(t2 - t1).count();
    cout.precision(5);
    cout << endl
         << endl
         << "------------------------------" << endl
         << "RUNNING TIME:" << endl
         << time / 1e9 << " s" << endl
         << time / 1e6 << " ms" << endl
         << time << " ns" << endl;
#endif
    // cout.flush();
}
 
inline static void solve() noexcept {
    string lhs, rhs;
    cin >> lhs >> rhs;
    vector<int> prev(rhs.size() + 1), curr(rhs.size() + 1);
    // D(i, j) denotes N[0:i), M[0:j)
    // base case
    iota(prev.begin(), prev.end(), 0);
 
    for (auto i{1ul}; i <= lhs.size(); ++i) {
        curr.front() = static_cast<int>(i);
        for (auto j{1ul}; j <= rhs.size(); ++j) {
            curr[j] = min(min(curr[j - 1], prev[j]) + 1,
                          prev[j - 1] + (lhs[i - 1] != rhs[j - 1]));
        }
        prev = curr;
    }
    cout << prev.back();
}