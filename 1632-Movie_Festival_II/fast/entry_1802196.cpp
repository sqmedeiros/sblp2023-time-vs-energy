#include <bits/stdc++.h>
 
#define endl "\n"
#define debug(statement) \
    if (debugging)       \
    cerr << statement << endl
#define debug_variable(var) \
    if (debugging)          \
    cerr << (#var) << ": " << var << endl
 
const bool debugging = 1;
 
using namespace std;
 
template <class T>
ostream &operator<<(ostream &os, vector<T> V)
{
    for (auto v : V)
    {
        os << v << " ";
    }
    return os << "";
}
 
template <class T>
ostream &operator<<(ostream &os, set<T> S)
{
    for (auto s : S)
    {
        os << s << " ";
    }
    return os << "";
}
 
template <class L, class R>
ostream &operator<<(ostream &os, pair<L, R> P)
{
    return os << P.first << " " << P.second;
}
 
template <class L, class R>
ostream &operator<<(ostream &os, map<L, R> M)
{
    os << endl;
    for (auto m : M)
    {
        os << m << endl;
    }
    return os << "";
}
 
void fastscan(int &number)
{
    //variable to indicate sign of input number
    bool negative = false;
    int c;
 
    number = 0;
 
    // extract current character from buffer
    c = getchar();
    if (c == '-')
    {
        // number is negative
        negative = true;
 
        // extract the next character from the buffer
        c = getchar();
    }
 
    // Keep on extracting characters if they are integers
    // i.e ASCII Value lies from '0'(48) to '9' (57)
    for (; (c > 47 && c < 58); c = getchar())
        number = number * 10 + c - 48;
 
    // if scanned input has a negative sign, negate the
    // value of the input number
    if (negative)
        number *= -1;
}
 
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, K;
    fastscan(N);
    fastscan(K);
    vector<pair<int, int>> elements(N);
    for (int i = 0; i < N; i++)
    {
        fastscan(elements[i].second);
        fastscan(elements[i].first);
    }
    sort(elements.begin(), elements.end());
 
    int ans = 0;
    multiset<int> current;
    for (int i = 0; i < N; i++)
    {
        auto it = current.upper_bound(elements[i].second);
        if (it != current.begin())
        {
            current.erase(--it);
            current.insert(elements[i].first);
            ans++;
        }
        else if (current.size() < K)
        {
            current.insert(elements[i].first);
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}