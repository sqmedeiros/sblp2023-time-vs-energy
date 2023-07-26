#include <bits/stdc++.h>
using namespace std;
 
typedef pair <int, int> ii;
const int MAX_N = 2e5 + 5;
 
ii a[MAX_N], t[2 * MAX_N];
bool unselected[MAX_N];
 
inline int read_int() {
	register char c;
	while (!isdigit(c = getchar_unlocked()));
	int x = c - 48;
	while (isdigit(c = getchar_unlocked()))
		x = (x << 1) + (x << 3) + c - 48;
	return x;
}
 
priority_queue <ii> heap;
 
int main() {
	int n = read_int();
	int k = read_int();
 
	for (int i = 1; i <= n; ++i) {
        a[i] = {read_int(), read_int()};
		t[i] = {a[i].first, -i};
		t[i + n] = {a[i].second, i};
	}
 
	sort(t, t + 2*n);
 
	int cnt = 0;
	for (int i = 1; i <= 2 * n; ++i) {
		if (unselected[abs(t[i].second)])
			continue;
 
		if (t[i].second > 0)
			--cnt;
		else {
			++cnt;
			heap.emplace(make_pair(a[-t[i].second].second, -t[i].second));
		}
 
		while (t[i].first == t[i + 1].first) {
			++i;
			if (t[i].second < 0) {
                ++cnt;
                heap.emplace(make_pair(a[-t[i].second].second, -t[i].second));
			}
			else if (!unselected[t[i].second])
                --cnt;
		}
 
		while (cnt > k) {
			--cnt;
			unselected[heap.top().second] = true;
			heap.pop();
		}
	}
 
	int res = n;
	for (int i = 1; i <= n; ++i)
		res -= unselected[i];
 
	printf("%d", res);
}