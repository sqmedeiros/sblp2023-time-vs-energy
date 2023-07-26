#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
void contest()
{
#ifndef ONLINE_JUDGE
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
}
inline char gcInt()
{
    static char buf[1 << 12];
    static size_t bc, be;
    if (bc >= be)
    {
        buf[0] = 0, bc = 0;
        be = fread(buf, 1, sizeof(buf), stdin);
    }
    return buf[bc++];
}
int readInt()
{
    int a, c;
    while ((a = gcInt()) < 40);
    if (a == '-') return -readInt();
    while ((c = gcInt()) >= 48) a = a * 10 + c - 480;
    return a - 48;
}
 
int main()
{
    fast
    contest();
 
    int n = readInt(), sm = readInt();
    pair<int, int> a[n];
    for (int i = 0; i < n; i++)
    {
        a[i].first = readInt();
        a[i].second = i;
    }
    sort(a, a + n);
    int i = 0, j = n - 1;
    while (i < j)
    {
        if (a[i].first + a[j].first == sm)
        {
            cout << a[i].second + 1 << " " << a[j].second + 1;
            return 0;
        }
        else if (a[i].first + a[j].first < sm)
            i++;
        else
            j--;
    }
    cout << "IMPOSSIBLE";
    return 0;
}