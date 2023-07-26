#include<bits/stdc++.h>
using namespace std;
 
const int MAXN = 2e5 + 10;
 
int n, k;
pair<int, int> v[MAXN];
int seg[8 * MAXN], lz[8 * MAXN];
 
map<int, int> comp;
set<int> auxComp;
 
void refresh(int pos, int ini, int fim);
void update(int pos, int ini, int fim, int p, int q);
int query(int pos, int ini, int fim, int p, int q);
 
int main(){
	scanf("%d %d", &n, &k);
	for(int i = 1; i <= n; i++){
		scanf("%d %d", &v[i].second, &v[i].first);
		auxComp.insert(v[i].first);
		auxComp.insert(v[i].second);
	}
	set<int>::iterator it;
	int cnt = 0;
	for(it = auxComp.begin(); it != auxComp.end(); it++)
		comp[*it] = ++cnt;
	sort(v + 1, v + 1 + n);
	int ans = 0;
	for(int i = 1; i <= n; i++){
		int ini = comp[v[i].second];
		int fim = comp[v[i].first];
		int qnt = query(1, 1, cnt, ini, fim - 1);
		if(qnt < k){
			update(1, 1, cnt, ini, fim - 1);
			ans++;
		}
	}
	printf("%d\n", ans);
}
 
void refresh(int pos, int ini, int fim){
	if(lz[pos] == 0) return;
	seg[pos] += lz[pos];
	if(ini != fim){
		int e = pos << 1, d = e | 1;
		lz[e] += lz[pos];
		lz[d] += lz[pos];
	}
	lz[pos] = 0;
}
 
void update(int pos, int ini, int fim, int p, int q){
	refresh(pos, ini, fim);
	if(ini > q || fim < p) return;
	if(ini >= p && fim <= q){
		lz[pos]++;
		refresh(pos, ini, fim);
		return;
	}
	int mid = (ini + fim) >> 1, e = pos << 1, d = e | 1;
	update(e, ini, mid, p, q);
	update(d, mid + 1, fim, p, q);
	seg[pos] = max(seg[e], seg[d]);
}
 
int query(int pos, int ini, int fim, int p, int q){
	refresh(pos, ini, fim);
	if(ini > q || fim < p) return 0;
	if(ini >= p && fim <= q) return seg[pos];
	int mid = (ini + fim) >> 1, e = pos << 1, d = e | 1;
	return max(query(e, ini, mid, p, q), query(d, mid + 1, fim, p, q));
}