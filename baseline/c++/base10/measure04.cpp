#include <unistd.h>
#include <iostream>

using namespace std;

const int N = 4;

int main(void)         
{
  int x;
  cin >> x;
  usleep(N * x);    
  return 0;
}
