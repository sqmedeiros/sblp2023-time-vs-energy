
 
//sad sad sad
 
//misaka will carry me to master
#include <iostream>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <utility>
#include <cassert>
#include <algorithm>
#include <vector>
#include <functional>
#include <numeric>
#include <set>
#include <map>
 
#define ll long long
#define lb long double
#define sz(vec) ((int)(vec.size()))
#define all(x) x.begin(), x.end()
#define pb push_back
#define mp make_pair
#define kill(x, s) {int COND = x; if(COND){ cout << s << "\n"; return ; }}
 
const lb eps = 1e-9;
const ll mod = 1e9 + 7, ll_max = 1e18;
//const ll mod = (1 << (23)) * 119 +1, ll_max = 1e18;
const int MX = 'HUG', int_max = 0x3f3f3f3f;
 
struct {
  template<class T>
  operator T() {
    T x; std::cin >> x; return x;
  }
} in;
 
using namespace std;
 
#define lc c[0]
#define rc c[1]
#define ile(u) (tr[tr[u].par].lc != u)
struct splay_tree{
	struct value{
		int val, sz;
		ll aggr;
		value(){val = sz = 0; aggr = 0ll;}
		value(int c, ll b, int s){val = c, aggr = b, sz = s; }
 
	};
	struct tag{
		int add, mul, rev;
		tag(int a, int b, int c){ add = a, mul = b, rev = c; }
		tag(){ add = 0, mul = 1, rev = 0;}
		tag operator * (const tag& b) const{
			return tag( (1ll*mul*b.add%mod + add)%mod, 1ll*mul*b.mul%mod, rev^b.rev);
		}
		value operator + (const value& b) const{
			return value((1ll*b.val*mul%mod +add)%mod, (1ll*b.aggr*mul%mod +add)%mod, b.sz);
		}
	};
	struct node{
		int par;
		int c[2];
		value v;
		tag t;
		node(){ par =c[0] = c[1] = 0; }
	};
	vector<node> tr;
	void pull(int u){
		//assert(u);
		tr[u].v.aggr = tr[tr[u].lc].v.aggr + tr[tr[u].rc].v.aggr + tr[u].v.val;
		tr[u].v.sz = tr[tr[u].lc].v.sz + tr[tr[u].rc].v.sz + 1;
	}
	void apply(int u, const tag& t){
		if(!u) return ;
		assert(t.mul == 1 && t.add == 0);
		tr[u].t = t * tr[u].t;
		tr[u].v = t + tr[u].v;
	}
	void push(int u){
		if(tr[u].t.rev){
			swap(tr[u].lc, tr[u].rc);
		}
		apply(tr[u].lc, tr[u].t);
		apply(tr[u].rc, tr[u].t);
		tr[u].t = tag();
	}
	splay_tree(){
		node zero = node();
		zero.v = value();
		tr.pb(zero);
	}
	
	void pr(int u){
		static string t;
		if(u == 0 || sz(t) > 5){ cout << t << "\n"; return ; }
		cout << t << tr[u].v.val << "\n";
		t += "\t";
		pr(tr[u].lc);
		pr(tr[u].rc);
		t.pop_back();
	}
 
	void rotate(int u, int dir){
 
		int r = u;
		int g = tr[u].c[dir];
		int a = tr[tr[u].c[dir]].c[dir^1];
		//order of pushing: tr[u].par, u, g
		//changes to c
		push(tr[u].par);
		push(u);
		push(g);
		if(tr[r].par){
			if(!ile(r)) tr[tr[r].par].lc = g;
			else tr[tr[r].par].rc = g;
		}
		assert(r && g);
		tr[g].c[dir^1] = r; 
		tr[r].c[dir] = a;
		//changes to par
		tr[g].par = tr[r].par;
		tr[r].par = g;
		if(a) tr[a].par = r;
		//order of pulling: r, g, tr[g].par	
		pull(r);
		pull(g);
		if(tr[g].par) pull(tr[g].par);
	}
	void splay(int u){
		while(tr[u].par){
			int p = tr[u].par, gp = tr[p].par;
			if(gp == 0){
				//zig
				rotate(p, ile(u));
			}else if(ile(p)^ile(u)){
				//zig zag
				rotate(p, ile(u));
				rotate(gp, ile(u));
			}else{
				//zig zig
				rotate(gp, ile(p));
				rotate(p, ile(u));
			}
 
		}		
		assert(tr[0].lc == tr[0].rc && tr[0].rc == 0);
	}
 
	int find(int& rt, int key){
		int u = rt;
		int ans = 0;
		while(u != 0){
			//push(u);
			if(tr[u].v.val == key){
				ans = u;
			}
			if(key < tr[u].v.val){
				u = tr[u].lc;
			}else{
				u = tr[u].rc;
			}
		}
		if(ans){
			splay(ans);
			rt = ans;
		}
		return ans; //leftmose occurance?
	}
	
	//no split and merge :flushed:
	
	int insert(int& rt, int key){
		if(find(rt, key)) return 0;
		int u = rt;
		int v;
		while(1){
			//push(u);
			int dir = key >= tr[u].v.val;
			//if(key == tr[u].v.val){ cout << "wave\n"; v = 0; break; }
			if(tr[u].c[dir] == 0 || rt == 0){
				node nv = node();
				nv.par = u;
				nv.v = value(key, key, 1);
				nv.t = tag();
				if(u) tr[u].c[dir] = sz(tr);
				v = sz(tr);
				tr.pb(nv);
				break ;
			}
			u = tr[u].c[dir];
		}
		for(int j = tr[v].par; j; j = tr[j].par){
			//pull(j);
		}
		if(v){
			splay(v);
			rt = v;
		}
		return v; 
	}
 
	int erase(int& rt, int key){
		if(find(rt, key) == 0) return 0;
		
		int l = tr[key].lc, r = tr[key].rc;
		tr[l].par = tr[r].par = 0; //f
		int v = r;
		while(tr[v].lc) v = tr[v].lc;
		splay(v);
		tr[v].lc = l;
		tr[l].par = v;
		return 1;
	}
 
};
#undef lc
#undef rc
#undef ile
 
void solve(){
	int q;
	cin >> q;
	splay_tree bbst = splay_tree();
	int rt = 0;
	for(int i = 1; i<= q; i++){
		int a = in;
		bbst.insert(rt, a);
	}
	cout << bbst.tr[rt].v.sz << "\n";
}
 
int main(){
  cin.tie(0) -> sync_with_stdio(0);
 
  int T = 1;
  //cin >> T;
  for(int i = 1; i<=T; i++){
		solve();
	}
  return 0;
}
 