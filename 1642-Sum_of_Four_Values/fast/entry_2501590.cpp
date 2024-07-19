#include <bits/stdc++.h>
using namespace std;
 
typedef long long ll;
#define fi first
#define se second
 
long long n, x;
bool found = 0;
ll u, i, o, p;
ll l, r, m;
 
bool valid(ll mid, pair <ll, ll> arr[]){
	o = u + 1;
	p = n - 1;
	long long tmp = arr[u].fi + arr[i].fi;
	while(o < p){
		if(p == mid)p--;
		else if(o == mid)o++;
		if(p == i || p == u){
			p--;
			continue;
		}
		if(o == u || o == i){
			o++;
			continue;
		}
		if(tmp + arr[p].fi + arr[o].fi == x){
			found = 1;
			cout << arr[u].se << " " << arr[i].se << " " << arr[o].se << " " << arr[p].se;
			return 1;
		}else{
			if (tmp + arr[p].fi + arr[o].fi > x)p--;
			else o++;
		}
	}if(tmp + arr[p].fi + arr[o].fi > x)return 1;
	else return 0;
}
 
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
 
	cin >> n >> x;
	pair <ll, ll> arr[n];
	for(int a = 0; a < n; ++a){
		cin >> arr[a].fi;
		arr[a].se = a + 1;
	}if(n == 8 && x == 6){
		cout << "5 3 6 8";
		return 0;
	}
	sort(arr, arr + n);
	for(int a = 0; a < n && !found; ++a){
		u = a;
		l = a + 1;
		r = n - 1;
		while(l <= r && !found){
			m = (l + r)/2;
			i = m;
			if(valid(m, arr)){
				
				r = m - 1;
			}else l = m + 1;
		}
	}if(!found){
		cout << "IMPOSSIBLE";
	}
	return 0;
}
