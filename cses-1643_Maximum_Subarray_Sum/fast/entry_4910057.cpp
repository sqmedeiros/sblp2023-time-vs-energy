#include <cstdio>
 
char *p1, *p2, buf[1<<20];
#define getchar() (p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1<<20, stdin), p1 == p2)? EOF : *p1++)
 
inline int static read(){
    int n = 0;
    char c = getchar();
    int k = 0;
    while (c < '0' || c > '9'){
        if (c == '-'){
            k = 1;
            c = getchar();
            break;
        }
        c = getchar();
    }
    while (c >= '0' && c <= '9'){
        n = (n * 10) + (c - '0');
        c = getchar();
    }
    return (k)? (-1) * n : n;
}	
 
 
#include <iostream>
#include <vector>
 
using namespace std;
 
typedef long long ll;
 
int main(){
    int n = read();
    vector<int> a(n);
    for (int& aa : a) aa = read();
 
    ll res = (ll)a[0];
    ll dp = (ll)a[0];
    for (int i = 1; i < n; ++i){
        if (dp + (ll)a[i] > (ll)a[i])
            dp += (ll)a[i];    
        else 
            dp = (ll)a[i];
 
        res = max(res, dp);
    }
    cout << res;
 
    return 0;
}
