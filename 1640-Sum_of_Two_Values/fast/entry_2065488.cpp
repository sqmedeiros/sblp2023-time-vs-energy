#include<bits/stdc++.h>
using namespace std;
//#pragma GCC target ("avx2")
#pragma GCC optimization ("O3")
#pragma GCC optimization ("unroll-loops")
template <typename T> T getczary(){//magia!
  int ujemna = false, znak = getchar_unlocked();
  T wynik = (T)0;
  while(!isdigit(znak)){
    if(znak == '-')
      ujemna = true;
    znak = getchar_unlocked();
  }
  while(isdigit(znak)){
    wynik *= 10;
    wynik += znak - '0';
    znak = getchar_unlocked();
  }
  if(ujemna)
    wynik *= -1;
  return wynik;
}
#define pc(x) putchar_unlocked(x);
inline void kout(int n){  
  int N = n, rev, count = 0;
  rev = N;
  if (N == 0) { pc('0'); pc('\n'); return ;}
  while ((rev % 10) == 0) { count++; rev /= 10;}
  rev = 0;
  while (N != 0) { rev = (rev<<3) + (rev<<1) + N % 10; N /= 10;}
  while (rev != 0) { pc(rev % 10 + '0'); rev /= 10;}
  while (count--) pc('0');
//   pc('\n');
}
 
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n = getczary<int>(), x = getczary<int>();
  pair<int, int> t[n];
  for(int i = 0;i < n;i++)
    t[i] = make_pair(getczary<int>(), i + 1);
  
  sort(t, t + n);
  n--;
  for(int i = 0;i < n;i++){
    while(t[i].first + t[n].first > x) n--;
    if(n > i && t[i].first + t[n].first == x){
      kout(t[i].second);
      pc(' ');
      kout(t[n].second);
      return 0;
    }
  }
  
  
  puts("IMPOSSIBLE");
}
