#include <bits/stdc++.h>
using namespace std;
 
const int cm = 1 << 17;
char cn[cm], * ci = cn + cm, ct;
inline char getcha() {
    if (ci - cn == cm) { fread_unlocked(cn, 1, cm, stdin); ci = cn; }
    return *ci++;
}
 
inline int getint() {
    int A = 0;
    if (ci - cn + 16 > cm) while ((ct = getcha()) >= '0') A = A * 10 + ct - '0';
    else while ((ct = *ci++) >= '0') A = A * 10 + ct - '0';
    return A;
}
 
#define ll long long int
#define ld long double
#define PI pair<int, int>
#define Pb push_back
 
#define VI vector<int>
#define VUI vector<unsigned int>
#define VL vector<ll>
#define VB vector<bool>
#define VPI vector<PI>
 
#define VVI vector<VI>
#define VVL vector<VL>
 
#define ALL(XX) XX.begin(), XX.end()
#define READ(XX) do { for (auto& x139874: XX) { cin >> x139874; } } while (0)
#define SORT(XX) do { sort(XX.begin(), XX.end()); } while (0)
 
int gcd(int a, int b)
{
if (b == 0)
return a;
return gcd(b, a % b);
}
 
int main()
{
ios_base::sync_with_stdio(false);
cin.tie(nullptr);
cout.tie(nullptr);
 
int n,sum;
n= getint();
sum= getint();
 
if(n==1)
{
    cout << "IMPOSSIBLE" << "\n";
    return 0;
}
 
vector <pair<int,int>> v;
for(int i=0; i<n; i++)
{
    int temp;
    temp= getint();
    v.Pb(make_pair(temp,i+1));
}
sort(v.begin(),v.end());
int i=0,j=n-1;
while(j-i!=1)
{
    int x= v[i].first;
    int y= v[j].first;
 
    if(x+y==sum)
    {
        cout << v[i].second << " " << v[j].second << "\n";
        return 0;
    }
    else if(x+y>sum)
    {
        j--;
    }
    else if(x+y<sum)
    {
        i++;
    }
}
if(v[i].first + v[j].first == sum)
{
    cout << v[i].second << " " << v[j].second << "\n";
}
else
cout << "IMPOSSIBLE" << "\n";
return 0;
}