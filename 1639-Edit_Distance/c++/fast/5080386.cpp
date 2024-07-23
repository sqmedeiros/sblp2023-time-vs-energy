#include <bits/stdc++.h>
#define MOD 1000000007
#define test  \
	int t;    \
	cin >> t; \
	while (t--)
#define init(arr, val) memset(arr, val, sizeof(arr))
#define loop(i, a, b) for (int i = a; i < b; i++)
#define loopr(i, a, b) for (int i = a; i >= b; i--)
#define loops(i, a, b, step) for (int i = a; i < b; i += step)
#define looprs(i, a, b, step) for (int i = a; i >= b; i -= step)
#define ull unsigned long long int
#define ll long long int
#define P pair
#define PLL pair<long long, long long>
#define PII pair<int, int>
#define PUU pair<unsigned long long int, unsigned long long int>
#define L list
#define V vector
#define D deque
#define ST set
#define MS multiset
#define M map
#define UM unordered_map
#define mp make_pair
#define pb push_back
#define pf push_front
#define MM multimap
#define F first
#define S second
#define IT iterator
#define RIT reverse_iterator
#define FAST                          \
	ios_base::sync_with_stdio(false); \
	cin.tie();                        \
	cout.tie()
#define FILE_READ_IN freopen("input.txt", "r", stdin);
#define FILE_READ_OUT freopen("output.txt", "w", stdout);
#define all(a) a.begin(), a.end()
#define ld long double
using namespace std;
const ll maxn = 1e5;
const ll inf = 1e9;
const double pi = acos(-1);
 
int main()
{
	FAST;
	string a, b;
	cin >> a >> b;
	int n = a.size();
	int m = b.size();
	int x[n + 1];
	for (int i = 0; i < n + 1; i++)
	{
		x[i] = i;
	}
	for (int j = 0; j < m; j++)
	{
		int prev = x[0];
		x[0] = j + 1;
		for (int i = 1; i < n + 1; i++)
		{
			int temp = x[i];
			x[i] = x[i - 1] + 1;
			if (a[i - 1] == b[j])
				x[i] = min(x[i], prev);
			else
				x[i] = min(x[i], prev + 1);
			x[i] = min(x[i], temp + 1);
			prev = temp;
		}
	}
	cout << x[n];
	return 0;
}