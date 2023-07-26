// This program was written
// by Mircea Rebengiuc
// for problem Projects
// on 12.01.2022
 
#include <stdio.h>
#include <ctype.h>
 
#include <algorithm>
 
#define magic_sauce inline __attribute__((always_inline))
using ll = long long;
 
magic_sauce int fgetint(){
  int n = 0, ch;
 
  while( !isdigit( ch = fgetc( stdin ) ) );
  do
    n = n * 10 + ch - '0';
  while( isdigit( ch = fgetc( stdin ) ) );
 
  return n;
}
 
template<typename T> magic_sauce T max( T a, T b ){ return a > b ? a : b; }
 
const int MAXN = 2e5;
 
struct Event {
  int x, type, idx;
} evt[2 * MAXN];
 
const int START = 0;
const int END = 1;
 
ll best[MAXN];
int cost[MAXN];
 
int main(){
  int n, i, j;
  ll max_prev;
 
  j = 0;
  n = fgetint();
  for( i = 0 ; i < n ; i++ ){
    evt[j++] = { fgetint(), START, i };
    evt[j++] = { fgetint(), END, i };
    cost[i] = fgetint();
  }
 
  std::sort( evt, evt + j, []( const Event &a, const Event &b ) -> bool {
    if( a.x != b.x )
      return a.x < b.x;
    return a.type < b.type; // nu uita sa modifici
  } );
 
  max_prev = 0;
  for( i = 0 ; i < j ; i++ )
    if( evt[i].type == START )
      best[evt[i].idx] = max_prev + cost[evt[i].idx];
    else // if( evt[i].type == END ){
      max_prev = max( best[evt[i].idx], max_prev );
 
  printf( "%lld\n", max_prev );
 
  return 0;
}