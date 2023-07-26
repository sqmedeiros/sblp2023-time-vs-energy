/**
 *    author:  Tanbin_Hasan
 *    created: 17.06.2021 01:32:43
**/
#include <bits/stdc++.h>
 
using namespace std ;
 
vector<vector<int64_t>> val(5001 , vector<int64_t> (5001 , -1)) ;
int64_t MinEdit(string &a , string &b , int64_t n , int64_t m , int64_t i , int64_t j) {
  if (i == n && j == m) {
    return 0 ;
  } else if (i == n) {
    return m - j ;
  } else if (j == m) {
    return n - i ;
  }
  if (val[i][j] != -1) {
    return val[i][j] ;
  }
  int64_t choice1 = MinEdit(a , b , n , m , i , j + 1) + 1 ;
  int64_t choice2 = MinEdit(a , b , n , m , i + 1 , j) + 1 ;
  int64_t choice3 = MinEdit(a , b , n , m , i + 1 , j + 1) + (a[i] != b[j]) ;
  return val[i][j] = min({choice1 , choice2 , choice3}) ;
}
 
int main(void) {
  ios::sync_with_stdio(false) ; cin.tie(0) ;
  string a , b ;
  cin >> a >> b ;
  int64_t n = (int) a.size() ;
  int64_t m = (int) b.size() ;
  cout << MinEdit(a , b , n , m , 0 , 0) ;
  return 0 ;
}