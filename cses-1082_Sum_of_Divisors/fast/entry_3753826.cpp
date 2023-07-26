#include <iostream>
#include <tgmath.h>
using namespace std;
 
int main()
{
    long long int n;
    std::cin >> n;
    long long int curr;
    long long int total = 0;
    long long int ct = 0;
    for (long long int i=1; i <= n; i++){
        if ((long long int) i*i > n){
            break;
        }
        ct= 0;
        curr = floor((double)n / i);
        ct += ((curr % 1000000007) * ((curr + 1) % 1000000007) / 2);
        ct -= ((long long int)(i-1) * (i) / 2);
        curr -= i;
        ct += (long long int) (curr % 1000000007) * i;
        ct %= 1000000007;
        total += ct;
    }
    total %= 1000000007;
    std::cout << total << "\n";
 
    return 0;
}
