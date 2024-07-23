#pragma GCC optimize("O3,unroll-loops")
//#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
#include<bits/stdc++.h>
using namespace std;
int dp[1000001], modder = 1e+9 + 7, coins[100];
 
void processor()
{
  int n, x; cin >> n >> x;
  dp[0] = 1;
  for(int i = 0; i < n; i++)
  cin >> coins[i];
  for(int i = 1; i <= x; i++)
  {
    long long temp = 0;
    for(int j = 0; j < n; j++)
    {
      if(i - coins[j] >= 0)
      {
        temp += dp[i - coins[j]];
      }
    }
    dp[i] = temp % modder;
  }
  cout << dp[x] << endl;
  return;
}
 
/*WhAt ArE dAyS fOr?|----|DaYs ArE wHeRe We LiVe */
/*ThEy CoMe, ThEy WaKe Us|---|TiMe AnD tImE oVeR.*/
/*ThEy--*/int main()
/*aRe tO*/{
/*bE HaP*/  ios_base::sync_with_stdio(false);
/*pY iN.*/  cin.tie(NULL);
/*wHeRe */  int count, counter = 0;
/*cAn wE*/  count = 1;
/*lIvE b*/  while(counter++ < count)
/*Ut dAy*/  {processor();}
/*S. aH,*/  return 0;
/*sOlViN*/}
/*g tHaT qUeStIoN bRiNgS tHe PrIeSt AnD tHe DoCt */
/*Or In ThEiR lOnG cOatS RuNnInG oVeR tHe FiElDs.*/
