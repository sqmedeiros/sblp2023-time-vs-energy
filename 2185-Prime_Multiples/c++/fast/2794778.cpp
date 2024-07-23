#include <stdio.h>
 
#if defined( _WIN32 )
typedef __int64 az_int64_t;
typedef unsigned __int64 az_uint64_t;
#define I64(x) x ## I64
#define F64 "I64"
#else
typedef long long az_int64_t;
typedef unsigned long long az_uint64_t;
#define I64(x) x ## ll
#define F64 "ll"
#endif
 
#define MAXN 20
 
int k;
az_int64_t n, sum = 0, p[MAXN], limit[MAXN];
 
void bt( int id, az_int64_t v, int add)
{
  if( id >= k ) return;
  bt( id+1, v, add);
  if( v > limit[id] ) return;
  v *= p[id];
  if( add ) sum += n / v; else sum -= n / v;
  bt( id+1, v, !add);
}
 
int main( void )
{
  int i;
  scanf( "%" F64 "d %d", &n, &k);
  for( i  = 0; i < k; ++i) scanf( "%" F64 "d", &p[i]), limit[i] = n / p[i];
  bt( 0, 1, 1);
  printf( "%" F64 "d\n", sum);
  return 0;
}
