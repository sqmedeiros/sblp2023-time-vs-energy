#include <iostream>
#include <math.h>
#include <vector>
using namespace std;
 
int main(){
    const long long mod = 1e9+7;
    long long n, s=0, j;
    cin >> n;
    for(long long i=1; i*i<=n; i++){
        j = (n/i)%mod;
        s += (j-i)*(3*i+j+1)/2+i;
        s %= mod;
    }
    cout << s << '\n';
}
