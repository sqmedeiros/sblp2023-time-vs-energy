#include <bits/stdc++.h>
 
using namespace std;
 
const int N = 1e6;
 
struct kdl
{
  long long val; int des;
}sum[N];
 
long long res = -1 * 1e17;
int n,f[N];
 
bool how(kdl x , kdl y)
{
  return (x.val < y.val);
}
 
void filein()
{
  cin >> n;
  long long tmp;
  for (int i =1 ; i <= n ; i++)
    {
        cin >> tmp;
        sum[i].val = sum[i-1].val + tmp;
        res = max(res,sum[i].val);
        sum[i].des = i;
    }
  sort(sum+1,sum+1+n,how);
  f[1] = sum[1].des;
  for (int i =2 ; i <= n ; i++) f[i] = min(f[i-1],sum[i].des);
}
 
bool check(long long tmp , int dd , long long x)
{
  int ress = 0;
  int l =1;
  int r = n;
  int mid;
  while (l <= r)
    {
        mid = (l+r)/2;
        if (tmp - sum[mid].val >= x)
          {
            ress = max(ress,mid);
            l = mid + 1;
          }
        else r = mid - 1;
    }
  if (ress == 0) return false;
  if (f[ress] < dd) return true;
  return false;
}
 
bool test(long long x)
{
    for (int i =1 ; i <= n ; i++)
      {
          if (check(sum[i].val,sum[i].des,x))
            {
              return true;
            }
      }
    return false;
}
 
void solve()
{
  long long l = -1 * 1e17;
  long long r = 1 * 1e17;
  long long mid;
  while (l <= r)
    {
        mid = (l+r)/2;
        if (test(mid))
          {
            res = max(res,mid);
            l = mid + 1;
          }
        else r = mid -1;
    }
  cout << res;
}
 
int main()
{
  ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
  filein();
  solve();
 
  return 0;
}
