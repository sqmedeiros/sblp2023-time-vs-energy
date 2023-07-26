#include <bits/stdc++.h>
 
using namespace std;
 
vector<int> solve(vector<pair<int, int>>& v, int from, int to, int target, int size) {
    if (size == 2) {
        while (from < to && v[to].first + v[to - 1].first >= target && v[from].first + v[from + 1].first <= target) {
            int sum = v[from].first + v[to].first;
            if (sum > target) to -= 1;
            else if (sum < target) from += 1;
            else return {v[from].second, v[to].second};
        }
    } else {
        for (int i = from + size - 1; i <= to; i++) {
            auto res = solve(v, 0, i - 1, target - v[i].first, size - 1);
            if (res.size()) {
                res.push_back(v[i].second);
                return res;
            }
        }
    }
    return {};
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    size_t n;
    int target;
    cin >> n >> target;
 
    vector<pair<int,int>> vi(n);
    for (size_t i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        vi[i] = {tmp, i+1};
    }
    sort(vi.begin(), vi.end());
    auto sol = solve(vi, 0, n-1, target, 4);
    if (sol.size()) {
        cout << sol[0] << ' ' << sol[1] << ' ' << sol[2] << ' ' << sol[3] << endl;
    } else {
        cout << "IMPOSSIBLE" << endl;
    }
}
