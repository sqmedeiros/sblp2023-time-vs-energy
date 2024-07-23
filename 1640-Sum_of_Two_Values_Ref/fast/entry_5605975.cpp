# include <bits/stdc++.h>
using namespace std;
//# define int long long
const int N = 200005;
 
int n, x;
struct node
{
	int num;
	int id;
	bool operator < (const node &t) const
	{
		return num < t.num;
	}
} a[N];
int read ()
{
	int s = 0, w = 1;
	char c = getchar ();
	while (c < '0' || c > '9')
	{
		if (c == '-')
			w = -1;
		c = getchar();
	}
	while (c >= '0' && c <= '9')
	{
		s = s * 10 + c - '0';
		c = getchar();
	}
	return s * w;
}
signed main ()
{
//	freopen ("test.in", "r", stdin);
//	freopen ("test.out", "w", stdout);
	
	n = read (), x = read ();
	for (int i = 1; i <= n; i ++ )
		a[i].num = read (),
		a[i].id = i;
	sort (a + 1, a + 1 + n);
	int l = 1, r = n;
	while (l < r)
	{
		if (a[l].num + a[r].num == x)
		{
			printf ("%d %d", min (a[l].id, a[r].id), max (a[l].id, a[r].id));
			return 0;
		}
		else if (a[l].num + a[r].num > x)
			r -- ;
		else
			l ++ ;
	}
	printf ("IMPOSSIBLE");
	return 0;
}