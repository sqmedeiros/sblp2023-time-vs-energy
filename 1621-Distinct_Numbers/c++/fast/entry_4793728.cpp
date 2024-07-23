#include <iostream>
#include <bitset>
#include <vector>
 
#define NBUCKETS 100
#define BUCKETSZ (1000000000 / NBUCKETS)
 
using namespace std;
 
inline long mystrtol(char *p, char **ep) {
  long res = *p - '0';
  while (*++p >= '0')
    res = res * 10 + (*p - '0');
  *ep = ++p;
 
  return res;
}
 
int main(void) {
  int n;
  cin >> n;
 
  vector<int> nums[NBUCKETS];
  char *buf = new char[n * 11], *p = buf+1;
  cin.read(buf, n * 11);
 
  for (int i=0; i < n; i++) {
    long val = mystrtol(p, &p);
    nums[val / BUCKETSZ].push_back(val % BUCKETSZ);
  }
 
  int distinct = 0;
  bitset<BUCKETSZ> bits;
  for (int i=0; i < NBUCKETS; i++) {
    for (auto j : nums[i])
      if (!bits[j]) {
        bits.set(j); distinct++;
      }
 
    for (auto j : nums[i]) 
      bits.reset(j);
  }
 
  printf("%d\n", distinct);
  return 0;
}