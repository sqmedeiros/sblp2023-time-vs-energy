#include <algorithm>
#include <iostream>
#include <iterator>
#include <sstream>
#include <fstream>
#include <cassert>
#include <climits>
#include <cstdlib>
#include <cstring>
#include <string>
#include <cstdio>
#include <vector>
#include <cmath>
#include <queue>
#include <deque>
#include <stack>
#include <list>
#include <map>
#include <set>
#include <bitset>
#include <iomanip>
#include <unordered_map>
 
#include <tuple>
#include <random>
#include <chrono>
using namespace std;
#define el "\n"
 
#define DBG(x) cerr <<#x<<"="<<x<<"\n";
#define RAYA   cerr <<"==================================="<<"\n";
 
 
 
long long middlesum(vector<long long> &A,int low, int mid,int high){
  long long left_sum = LLONG_MIN;
  long long sum = 0;
  for(int i = mid; i >= low; --i){
    sum = sum + A[i];
    if(sum > left_sum){
      left_sum = sum;
    }
  }
  long long right_sum = LLONG_MIN;
  sum = 0;
  for(int i = mid + 1; i <= high; ++i){
    sum = sum + A[i];
    if(sum > right_sum){
      right_sum = sum;
    }
  }
  return (left_sum) + (right_sum);
}
 
 
long long maxsubarray(vector<long long> &A, int low, int high){
  if(low == high) return A[low];
  else{
    int mid=low + (high - low)/2;
    long long sumleft=maxsubarray(A,low,mid);
    long long sumright=maxsubarray(A,mid+1,high);
    long long sumacross=middlesum(A,low,mid,high);
    DBG(sumright + sumleft)
    return max(max(sumleft,sumright),sumacross);
  }
 
}
 
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
 
  int n; cin >> n;
 
  vector <long long> v(n);
  for(int i=0; i<n; ++i) cin >> v[i];
 
  vector<long long> psum(n);
  psum[0]=0;
 
  for(int i=1; i<n; ++i){
    psum[i] = v[i] - v[i - 1];
  }
  long long ans= maxsubarray(v,0,n-1);
  cout<<ans<<el;
 
  return 0;
 
}
