#pragma GCC optimize("Ofast", "unroll-loops")
//#pragma GCC target("popcnt", "avx2")
#include <bits/stdc++.h>
 
using namespace std;
 
const int N = 1e7 + 5, M = (1e9 + N - 1) / N;
 
int n, x, ans;
 
bitset<N> btst;
 
vector<int> v[M];
 
static constexpr int buf_sz = (int)2e5 * 11 + 10;
char buf[buf_sz];
int buf_i = -1;
 
int read() {
  int x = 0;
  while (++buf_i, buf[buf_i] >= '0' && buf[buf_i] <= '9')
    x = 10*x + buf[buf_i]-'0';
  return x;
}
 
int main(){
    std::fread(buf, 1, sizeof(buf), stdin);
 
    n = read();
 
    for(int i = 1; i <= n; i++){
        x = read();
 
        v[x / N].push_back(x % N);
    }
 
    for(int j = 0; j < M; j++){
        for(int i = 0; i < v[j].size(); i++){
            if(!btst[v[j][i]]) btst[v[j][i]] = true, ans++;
        }
 
        for(int i = 0; i < v[j].size(); i++) btst[v[j][i]] = false;
    }
 
    cout << ans;
}
