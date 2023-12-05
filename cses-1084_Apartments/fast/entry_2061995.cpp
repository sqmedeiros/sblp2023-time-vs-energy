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
 
 
constexpr int MAX_N = 200007;
int applicants[MAX_N], rooms[MAX_N];
int main(){
  int n = getczary<int>(), m = getczary<int>(), k = getczary<int>();
  for(int i = 0;i < n;i++)
    applicants[i] = getczary<int>();
  for(int i = 0;i < m;i++)
    rooms[i] = getczary<int>();
  
  sort(applicants, applicants + n);
  sort(rooms, rooms + m);
  
  int id = 0, res = 0;
  for(int i = 0;i < n && id < m;i++){
    while(id < m && rooms[id] < applicants[i] - k)
      id++;
    if(id == m || rooms[id] > applicants[i] + k)
      continue;
    res++;
    id++;
  }
  kout(res);
}
