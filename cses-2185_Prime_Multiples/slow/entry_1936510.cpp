#include <iostream>
#include <cmath>
 
using namespace std;
 
int main(){
    long long int n, k;
    cin >> n >> k;
    long long int a[20];
    for(int i=0;i<k;++i){
        cin >> a[i];
    }
    const int N = (1<<k);
    long long int ans = 0;
    long long int p;
    int cnt;
    bool dead;
    for(int i=1;i<N;++i){
        p = 1;
        cnt = 0;
        dead = false;
        for(int j=0;j<k;++j){
            if ((i>>j)&1){
                ++cnt;
                if (log(p) + log(a[j]) <= log(n+1)) p*=a[j];
                else{
                    dead = true;
                    break;
                }
                if (p > n){
                    dead = true;
                    break;
                }
            }
        }
        if (dead) continue;
        if (cnt%2) ans += n/p;
        else ans -= n/p;
    }
    cout << ans;
    return 0;
}
