#include <bits/stdc++.h>
#include <unistd.h>
#define ull unsigned long long
using namespace std;
 
char buf[10000000];
ull idx = 0;
 
ull read_int() {
    ull ret = 0;
    while (buf[idx] & 16) {
        char n = buf[idx] & 15;
        ret *= 5;
        ret <<= 1;
        ret += n;
        idx++;
    }
    idx++;
    return ret;
}
 
int main() {
	read(0, buf, 10000000);
 
	ull n, x;
	n = read_int();
	x = read_int();
 
	pair<ull, ull> a[n];
	for (ull i = 0; i < n; i++) {
		a[i].first = read_int();
		a[i].second = i + 1;
	}
 
	sort(a, a + n, [](pair<ull, ull> a, pair<ull, ull> b) {
		return a.first < b.first;
	});
 
	ull j = n - 1;
	for (ull i = 0; i < j; ) {
		ull sum = a[i].first + a[j].first;
		if (sum == x) {
			cout << a[i].second << " " << a[j].second << endl;
			return 0;
		}
		if (sum > x) {
			j--;
			continue;
		}
		i++;
	}
 
	cout << "IMPOSSIBLE" << endl;
 
	return 0;
}