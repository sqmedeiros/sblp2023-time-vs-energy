#include<iostream>
#define int unsigned long long
using namespace std;
const int P = 1e9 + 7;
 
int f(int n)
{
    return (int)((n + 1ll) * n / 2ll) % P;
}
signed main()
{
    int n;
    cin >> n;
    int ans = 0;
    for(int i = 1; i * i <= n; i++)
    {
        int a = n / i - i + 1;
        a %= P;
        ans += i * a;
        //ans %= P;
        ans += i * a + (f(a - 1));
        ans -= i;
        ans %= P;
        //cout << ans << endl;
    }
    cout << ans << endl;
    return 0;
}
