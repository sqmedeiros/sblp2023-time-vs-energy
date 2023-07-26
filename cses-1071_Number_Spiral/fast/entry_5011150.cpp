 
 
#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#pragma comment(linker, "/STACK:268435456")
#pragma warning( disable : 6031)
#pragma warning( disable : 4244)
#pragma warning( disable : 26451)
#ifndef _MSC_VER
#pragma GCC target ("sse4.2")
#endif
#ifdef _MSC_VER
#  include <intrin.h>
#  define __builtin_popcount __popcnt
#  define __builtin_popcountll __popcnt64
#endif
#include <bits/stdc++.h>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <cstdint>
#include <climits>
#include <cassert>
#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <stack>
#include <set>
#include <queue>
#include <numeric>
#include <algorithm>
#include <random>
#include <utility>
#include <bitset>
#include <cmath>
#include <sstream>
#include <functional>
#include <iomanip>
#include <random>
#include <unordered_map>
#include <unordered_set>
#include <chrono>
 
#define all(a) (a).begin(),(a).end()
#define sz(a) (int)(a).size()
#define eps (1e-15)
 
using namespace std;
 
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
 
typedef long long ll;
typedef vector<int> vi;
typedef vector< vi > vvi;
typedef vector<double> vd;
typedef vector< vd > vvd;
typedef vector< string > vs;
typedef pair< int, int > pii;
typedef pair<ll, ll> pll;
typedef vector< pii > vpii;
typedef vector< pll > vpll;
typedef vector<ll> vl;
typedef vector<vector<long long>> vvl;
typedef vector<bool> vb;
typedef vector<vb> vvb;
typedef tuple<int, int, int> tiii;
const long long mod = int(1e9) + 7;
const int INF = 1e9;
const ll LINF = 1e18;
 
#include <cstdio>
#include <iostream>
using namespace std;
#ifdef WIN32
// no getchar_unlocked on Windows so call _getchar_nolock
inline int getchar_unlocked() { return _getchar_nolock(); }
#endif
long get_num() {
	int chr = getchar_unlocked();
	long a = chr - '0';
	while (true) {
		chr = getchar_unlocked();
		if (chr < '0') return a;
		a = a * 10 + chr - '0';
	}
}
void put_num(long long a) {
	long id = 0;
	char num_str[20];
	num_str[0] = a % 10 + '0';
	while (a /= 10) 
		num_str[++id] = (char)(a % 10) + '0';
	for (int i = id; i >= 0; i--)
		putchar_unlocked(num_str[i]);
}
 
int main() {
 
	ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0); cout << setprecision(18) << fixed;
	int n,i,j;
	n =  get_num();
	//cout << (n>2) ? 1:2<<end;
 
 
	
 
 
	while (n--){
		ll y,x,a,b,res;
		//cin >>y>>x;
		x = get_num();
		y = get_num();
		a = max(x,y); b = min(x,y);
		i = (a%2)? -1:1;
		j = (a==y)? 1:-1;
		//cout <<  ((a-1)*(a-1) + a*a + 1)/2 -   i*j * (a-b)<<endl;
		res = ((a-1)*(a-1) + a*a + 1)/2 -   i*j * (a-b);
		put_num(res);
		putchar_unlocked('\n');
	}
	
 
}