#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
 
using namespace std;
 
template <typename T> inline T get_num()
{
	T sign = 1;
	T num = 0;
	char input = getchar_unlocked();
	while(!(48 <= input && input <= 57))
	{
		if(input == '-')
         sign = -1;
		input = getchar_unlocked();
	}
	while((48 <= input && input <= 57))
   {
		num = (num << 3) + (num << 1) + input - 48;
      input = getchar_unlocked();
   }
	return num * sign;
}
 
template <typename T> inline void write_num(T &num, int blank, int flagnl)
{
   std::string numstr = to_string(num);
   for (unsigned long i = 0; i < numstr.size(); i++)
      putchar_unlocked(numstr[i]);
   if (blank)
      putchar_unlocked(' '); 
   if (flagnl)
      putchar_unlocked('\n');   
}
 
inline void write_string(string s, int blank, int flagnl)
{
	for(char x: s)
		putchar_unlocked(x);
   if (blank)
      putchar_unlocked(' '); 
   if (flagnl)
      putchar_unlocked('\n');
}
 
 
int main()
{ 
   int n = get_num<int>(); 
   int x = get_num<int>();
  
   vector<pair<int, int>> arr(n);
   for (int i = 0; i < n; i++)
   {
      arr[i].first = get_num<int>();
      arr[i].second = i + 1;
   }
   sort(arr.begin(), arr.end());
 
   int i = 0, j = n - 1;
   while (i < j)
   {
      if (arr[i].first + arr[j].first == x)
      {
         write_num<int>(arr[i].second, 1, 0);
         write_num<int>(arr[j].second, 0, 0);
         return 0;
      }
      if (arr[i].first + arr[j].first < x)
      {
         i++;
      }
      else
      {
         j--;
      }
   }
   write_string("IMPOSSIBLE", 0, 0);
}