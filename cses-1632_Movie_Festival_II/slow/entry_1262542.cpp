#include<bits/stdc++.h>
using namespace std;
const int MAXN = 200010;
 
int n, k, seg[8 * MAXN], lz[8 * MAXN];
int a[MAXN], b[MAXN];
vector<pair<int, int> > m;
 
int N;
set<int> s;
set<int> :: iterator it;
map<int, int> comp;
 
void refresh(int pos, int bg, int ed)
{
	if(!lz[pos])	return;
	
	int LZ = lz[pos];
	lz[pos] = 0;
	seg[pos] += LZ;
 
	if(bg == ed)	return;
	lz[2 * pos]	+= LZ;
	lz[2 * pos + 1] += LZ;
}
 
void upd(int pos, int bg, int ed, int p, int q, int val)
{
	refresh(pos, bg, ed);
	if(q < bg || ed < p)	return;
	if(p <= bg && ed <= q)	
	{
		lz[pos] += val;
		refresh(pos, bg, ed);
		return;
	}
 
	int mid = (bg + ed) >> 1, l = pos << 1, r = (pos << 1) + 1;
	upd(l, bg, mid, p, q, val);
	upd(r, mid + 1, ed, p, q, val);
 
	seg[pos] = max(seg[l], seg[r]);
}
 
int qry(int pos, int bg, int ed, int p, int q)
{
	refresh(pos, bg, ed);
	if(q < bg || ed < p)	return 0;
	if(p <= bg && ed <= q)	return seg[pos];
 
	int mid = (bg + ed) >> 1, l = pos << 1, r = (pos << 1) + 1;
	return max(qry(l, bg, mid, p, q), qry(r, mid + 1, ed, p, q));
}
 
int main ()
{
	scanf("%d %d", &n, &k);
 
	for(int i = 0; i < n; i++)	
	{
		scanf("%d %d", &a[i], &b[i]);
		m.push_back(make_pair(b[i], a[i]));
		s.insert(a[i]);
		s.insert(b[i]);
	}
 
	for(it = s.begin(); it != s.end(); it++)
		comp[*it] = ++N;
 
	sort(m.begin(), m.end());
 
	int ans = 0;
	for(int i = 0; i < n; i++)
	{
		int a = comp[m[i].second];
		int b = comp[m[i].first];
 
		if(qry(1, 1, N, a, b - 1) < k)
		{
			upd(1, 1, N, a, b - 1, 1);
			ans++;
		}	
	}
 
	printf("%d\n", ans);
}