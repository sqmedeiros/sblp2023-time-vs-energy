#include <bits/stdc++.h>
 
using namespace std;
 
const int N = 7+1e9;
 
double sqent(long long n)
{
    if (n == 0) { return 0; }
    double a = (double) n;
    while (a * a < n || a * a > n + 1)
    {
        a = (a * a + n) / (2 * a);
    }
    return a;
}
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    long long n, a, b, su;
    cin >> n;
    long long q = (int) sqent(n);
    su = 0;
    for(long long d = 1; d <= q; d++)
    {
        a = (n / d) % N;
        su = (su + d * a + (a*(a+1)-q*(q+1))/2) % N;
    }
    cout << su;
    return 0;
}
