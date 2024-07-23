#include <iostream>
#include <vector>
#include <cmath>
#define ll long long
#define quick(); ios_base::sync_with_stdio(false); cin.tie(NULL);
using namespace std;
 
ll UPBOUND = 1e18 + 1;
 
ll lcm(vector<ll>& pnums, ll& n, int& k, int& key, int& cnt)
{
    ll res = 1;
    for(int i  = 0; i < k; i++)
    {
        if( (key & (1 << i)) != 0 )
        {
            if(log10((long double)res) + log10((long double)pnums[i]) <= 18.0  && res*pnums[i] <= n)
            {
                res *= pnums[i];
                cnt++;
            }
            else
            {
                return n + 1; // cannot divisable
            }
        }
        
    }
    return res;
}
 
int main()
{
    quick();
    ll n; int k;
    cin >> n >> k;
    vector<ll> primes(k);
    int totalComb = 1 << k;
    for(int i = 0; i < k; i++)
        cin >> primes[i];
    
    ll sum = 0;
    for(int i = 1; i < totalComb; i++)
    {
        //vector<ll> chosen;
        //choosePerm(primes, chosen, k, i);
        //for(auto x: chosen)
        //    cout << x << " ";
        //cout << endl;
        int cnt = 0;
        ll mylcm = lcm(primes, n, k, i, cnt);
        //cout << mylcm << endl;
        if((int)cnt % 2 == 1)
            sum += n / mylcm;
        else
            sum -= n / mylcm;
    }
    cout << sum << endl;
 
    return 0;
}
