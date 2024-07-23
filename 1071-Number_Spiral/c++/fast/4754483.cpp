#include <algorithm>
#include <cassert>
#include <cstdio>
 
#define INPUT_LN   22
#define OUTPUT_LN  20
 
using namespace std;
 
inline long long mystrtoll(char *p, char **ep) {
  long long res = *p - '0';
  while (*++p >= '0') {
    res = res * 10 + (*p - '0');
  }
  *ep = ++p;
 
  return res;
}
 
 
inline int countDigits(long long n) {
  if (n < 10) return 1;
  if (n < 100) return 2;
  if (n < 1000) return 3;
  if (n < 10000) return 4;
  if (n < 100000) return 5;
  if (n < 1000000) return 6;
  if (n < 10000000) return 7;
  if (n < 100000000) return 8;
  if (n < 1000000000) return 9;
  if (n < 10000000000) return 10;
  if (n < 100000000000LL) return 11;
  if (n < 1000000000000LL) return 12;
  if (n < 10000000000000LL) return 13;
  if (n < 100000000000000LL) return 14;
  if (n < 1000000000000000LL) return 15;
  if (n < 10000000000000000LL) return 16;
  if (n < 100000000000000000LL) return 17;
  if (n < 1000000000000000000LL) return 18;
  return 19;
}
 
inline char* writeNum(long long n, char *p) {
  char *end = p + countDigits(n);
 
  p = end;
  do
    *--p = n%10 + '0';
  while (n /= 10);
 
  return end;
}
 
 
int main(void) {
  int t;
 
  assert(scanf("%d\n", &t));
 
  char *inbuf = new char[t * INPUT_LN], *p = inbuf;
  assert(fread(inbuf, 1, t * INPUT_LN, stdin));
 
  char *outbuf = new char[t * OUTPUT_LN], *outp = outbuf;
 
  while (t--) {
    long long y = mystrtoll(p, &p);
    long long x = mystrtoll(p, &p);
 
    long long sz = max(x, y);
    long long mid = sz * (sz - 1) + 1;
    mid += (sz % 2) ? (x - y) : (y - x);
 
    outp = writeNum(mid, outp); *outp++ = '\n';
  }
  fwrite(outbuf, 1, outp-outbuf, stdout);
 
  return 0;
}