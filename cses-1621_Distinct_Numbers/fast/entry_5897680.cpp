#include <bits/stdc++.h>
 
using namespace std;
 
const int B = 1024;
const int B_SZ = 1000000000/B;
 
inline int r()
{
	int n = 0;
    unsigned char c=0;
	while(c<=9){
        n=n*10+c;
	    c=getchar()-'0';
    }
	return n;
}
 
int main()
{
    int n;
    n = r();
 
    vector<int> v[B];
 
    for (int i=0; i<n; i++)
    {
        int a = r();
        v[a / B_SZ].push_back(a % B_SZ);
    }
 
     bitset<B_SZ> b;
     int count = 0;
     for (int i=0; i<B; i++){
        for (auto a: v[i])
        {
            if (!b[a])
            {
                b[a] = 1;
                count++;
            }
        }
        for (auto a: v[i])
            b[a] = 0;
    }
 
    printf("%d",count);
}