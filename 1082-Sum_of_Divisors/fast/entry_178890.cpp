#include <stdio.h>
#include <math.h>
 
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
 
#define MODN 1000000007
#define REV2 500000004
 
int main( void )
{
  az_int64_t n;
  int i, sq, sq2, sq3, sum = 0;
  scanf( "%" F64 "d", &n);
  sq = (int) sqrt( n );
  sq2 = (int) (((az_int64_t) sq * sq) % MODN);
  sq3 = (int) (((az_int64_t) sq2 * sq) % MODN);
  for( i = 1; i <= sq; i++)
  {
    az_int64_t v = (n / i) % MODN;
    sum += (int) ((v * v + (2 * i + 1) * v) % MODN);
    if( sum >= MODN ) sum -= MODN;
  }
  sum -= sq2; if( sum < 0 ) sum += MODN;
  sum -= sq3; if( sum < 0 ) sum += MODN;
  sum = (int) (((az_int64_t) sum * REV2) % MODN);
  printf( "%d\n", sum);
  return 0;
}
