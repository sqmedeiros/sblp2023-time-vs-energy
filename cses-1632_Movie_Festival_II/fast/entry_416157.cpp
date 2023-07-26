#include <iostream>
#include <algorithm>
#include <map>
#include <set>
#include <string>
#include <queue>
#include <cmath>
#include <fstream>
#include <list>
#include <stdio.h>
#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
typedef vector<int> vi;
typedef vector<pii> vii;
typedef vector<pll> vll;
typedef priority_queue<int, vi, greater<int>> min_heap ;
 
#define pb push_back
#define mp make_pair
#define ub upper_bound
#define lb lower_bound
#define pq priority_queue
#define ii <int,int>
#define ff first
#define ss second
#define ninja ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define pc putchar
#define getchar getchar_unlocked
 
inline int read(){
	int t = 0;
	char c;
	int neg = 1;
	while((c=getchar())!='\n'&&c!=' '&&c!=EOF){
		if(c == '-'){
			neg = -1;
			c = getchar();
		}
		t=t*10+c-48;
	}
 
	return neg*t;
}
 
inline void putNL(){
	pc('\n');
}
inline void putnum(unsigned long long a) {
    int count = 1;
    char to_print[30];
    to_print[0] = a % 10 + '0';
    while (a /= 10) {
        to_print[count++] = (char) (a % 10) + '0';
    }
    for (int i = count - 1; i >= 0; i--) pc(to_print[i]);
    pc(' ');
}
inline void putString(string s){
	for(auto x: s){
		pc(x);
	}
	putNL();
}
 
bool sortByEnd(const  pair<int,int> &a, const pair<int,int> &b){
	return(a.second < b.second);
}
 
 
int main() {
 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	fstream fin("test_input.txt", fstream::in);
	int n = read(); int k = read();
	//int n; int k;
	//fin >> n >> k;
	vector<pair<int,int>> intervals;
	int s, e;
	for(int i = 0; i < n; i++){
		s = read(); e = read();
		//fin >> s>>e;
		intervals.pb((mp(s,e)));
	}
 
	sort(intervals.begin(),intervals.end(), sortByEnd);
 
	//pq<int, vector<int>, greater<int>> heap;
	multiset<int> heap;
 
	int start, ends;
	int ans=0;
 
	for(int i = 0; i < n; i++){
		start = intervals[i].first;
		ends = intervals[i].second;
 
		if(!heap.empty() && *heap.begin() <= start){
			heap.erase(--(heap.upper_bound(start)));
			heap.insert(ends); //give label of original end time
			ans++;
		}
		else if(heap.size() < k){
 
			heap.insert((ends));
			ans++;
		}
 
	}
 
	cout << ans << endl;
	return 0;
}