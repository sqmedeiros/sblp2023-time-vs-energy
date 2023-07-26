#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>
#include <fstream>
 
#define ll long long
#define MAX 100000
 
using namespace std;
 
// int main()
// {
//   fstream ifs;
//   string in;
//   bool isEnd = false;
//   ifs.open("text.txt");
//   ifs >> in;
//   ll count['Z' - 'A'] = {0};
//   for (ll i = 0; i < in.length(); i++)
//   {
//     count[in[i] - 'A']++;
//   }
//   ll countOdd = 0;
//   char checkOdd = NULL;
//   for (ll i = 0; i < 'Z' - 'A'; i++)
//   {
//     if (count[i] != 0)
//     {
//       if ((count[i] % 2) && (countOdd >= 1))
//       {
//         cout << "NO SOLUTION";
//         isEnd = true;
//         i = 'Z' - 'A';
//       }
//       else if (count[i] % 2)
//       {
//         countOdd += 1;
//         checkOdd = i + 1;
//       }
//     }
//   }
//   ll curr = 0;
//   if (isEnd != true)
//   {
//     for (ll i = 0; i < 'Z' - 'A'; i++)
//     {
//       if (count[i] != 0)
//       {
//         for (ll step = 0; step < count[i] / 2; step++)
//         {
//           in[curr] = i + 'A';
//           in[in.length() - 1 - curr] = i + 'A';
//           curr++;
//         }
//       }
//     }
//     if (checkOdd != NULL)
//     {
//       in[curr] = checkOdd -1 + 'A';
//     }
//     cout << in;
//   }
//   ifs.close();
 
//   return 0;
// }
 
int main()
{
  ll n, sum;
  cin >> n >> sum;
  ll* val = new ll[n];
  ll* npos = new ll[n];
  for (int i = 0; i < n; i++)
  {
    cin >> val[i];
    npos[i] = val[i];
  }
  sort(val, val+n);
  int upper = n-1, lower = 0, tempUpper = n-1, tempLower = 0;
  while (tempLower < tempUpper)
  {
    upper = tempUpper;
    lower = tempLower;
    if (val[tempUpper] + val[tempLower] > sum)
    {
      while (lower < upper)
      {
        if (val[upper] + val[lower] > sum)
        {
          upper--;
        }
        else if (val[upper] + val[lower] == sum)
        {
          for (int i = 0; i < n; i++)
          {
            if (val[upper] == npos[i])
            {
              cout << i + 1 << " ";
              npos[i] = 0;
            }
          }
          for (int i = 0; i < n; i++)
          {
            if (val[lower] == npos[i]) cout << i + 1;
          }
          return 0;
        }
        else
        {
          break;
        }
      }
      if  (upper == lower)
      {
        cout << "IMPOSSIBLE";
        return 0;
      }
      else
      {
        tempUpper--;
      }
    }
    else if (val[tempUpper] + val[tempLower] < sum)
    {
      while (lower < upper)
      {
        if (val[upper] + val[lower] < sum)
        {
          lower++;
        }
        else if (val[upper] + val[lower] == sum)
        {
          for (int i = 0; i < n; i++)
          {
            if (val[upper] == npos[i])
            {
              cout << i + 1 << " ";
              npos[i] = 0;
            }
          }
          for (int i = 0; i < n; i++)
          {
            if (val[lower] == npos[i]) cout << i + 1;
          }
          return 0;
        }
        else
        {
          break;
        }
      }
      if  (upper == lower)
      {
        cout << "IMPOSSIBLE";
        return 0;
      }
      else
      {
        tempLower++;
      }
    }
    else
    {
      for (int i = 0; i < n; i++)
          {
            if (val[upper] == npos[i])
            {
              cout << i + 1 << " ";
              npos[i] = 0;
            }
          }
          for (int i = 0; i < n; i++)
          {
            if (val[lower] == npos[i]) cout << i + 1;
          }
          return 0;
    }  
  }
  cout << "IMPOSSIBLE";
  return 0;
}