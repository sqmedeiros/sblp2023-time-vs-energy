#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <vector>
 
using namespace std;
 
inline char *read(int bytes) {
  char *buf = new char[bytes+1];
  cin.read(buf, bytes); buf[cin.gcount()] = 0;
  return buf;
}
 
inline long mystrtol(char *p, char **ep) {
  long res = *p - '0';
  while (*++p >= '0') {
    res = res * 10 + (*p - '0');
  }
  *ep = ++p;
 
  return res;
}
 
int main(void) {
  int nums, sum;
  cin >> nums >> sum;
 
  char *buf = read(nums*11), *p = buf+1;
  vector<int> vals(nums), pos(nums);
 
  for (int i=0; i<nums; i++) {
    pos[i] = vals[i] = mystrtol(p, &p);
  }
  sort(vals.begin(), vals.end());
 
  auto first = vals.begin(), last = vals.end()-1;
  int cursum = *first + *last;
 
  while (last > first && sum != cursum) {
    if (cursum < sum) ++first;
    else --last;
 
    cursum = *first + *last;
  }
 
  if (last > first) {
    int firstpos = 0, lastpos = 0;
 
    for (int i=0; i < nums && !(firstpos && lastpos); i++) {
      if (pos[i] == *first && !firstpos) firstpos = i+1;
      if (pos[i] == *last && !lastpos && firstpos != i+1) lastpos = i+1;
    }
 
/*
    while (++firstpos < nums) {
      if (pos[firstpos] == *first) break;
    }
 
    while (++lastpos < nums) {
      if (pos[lastpos] == *last && lastpos != firstpos) break;
    }
*/
    cout << firstpos << " " << lastpos << endl;
  }
  else
    cout << "IMPOSSIBLE" << endl;
 
  return 0;
}