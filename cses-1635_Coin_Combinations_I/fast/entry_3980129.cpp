#include <bits/stdc++.h>
 
typedef long long ll;
typedef std::vector<int> vi;
typedef std::pair<int,int> pi;
#define F first
#define S second
#define PB push_back
#define MP make_pair
#define REP(i,a,b) for (int i = a; i < b; i++)
 
#pragma GCC optimize("Ofast")
//#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")
 
#define kons 1000000007
 
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
 
  int N, x;
  std::cin >> N >> x;
 
  int coins[N];
 
  for (int i = 0; i < N; ++i) {
    std::cin >> coins[i];
  }
 
  int v[1000002];
  std::fill(std::begin(v), std::end(v), 0);
  // memset(v, 0, sizeof(int)*1000002);
  v[0] = 1;
 
  for (int i = 1; i <= x; ++i) {
    long long tmp = 0;
    for (int j = 0; j < N; ++j) {
      int c = coins[j];
      if (i >= c) {
        tmp += v[i-c];
      }
    }
    v[i] = tmp % kons;
  }
 
  std::cout << v[x] << "\n";
 
  return 0;
}
