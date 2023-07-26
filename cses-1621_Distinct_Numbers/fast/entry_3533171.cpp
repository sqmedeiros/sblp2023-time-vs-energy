#pragma GCC optimize "Ofast"
#pragma GCC optimize "unroll-loops"
#include <iostream>
#include <stdio.h>
#include <bitset>
#include <chrono>
#include <random>
using namespace std;
typedef long long ll;
static constexpr int buf_sz = (int)2e5 * 11 + 10;
char buf[buf_sz];
int buf_i = -1;
int read() {
    int x = 0;
    while (++buf_i, buf[buf_i] >= '0' && buf[buf_i] <= '9')
        x = 10*x + buf[buf_i]-'0';
    return x;
}
 
 
std::mt19937 rng(std::chrono::steady_clock::now().time_since_epoch().count());
template<class I> I rnd(I l,I r){return std::uniform_int_distribution<I>(l,r)(rng);}
 
template<int blocks, int logB, int logM> struct simple_tabulation {
    unsigned nums[blocks][1<<logB];
    const unsigned mask = (1<<logB) - 1;
    simple_tabulation() {
        for(int i=0;i<blocks;++i) for(int j=0;j<(1<<logB);++j) {
            nums[i][j] = rnd(0,(1<<logM)-1);
        }
    }
    unsigned operator()(int a) const {
        unsigned res=0;
        for(int i=0;i<blocks;++i) {
            res^=nums[i][a&mask];
            a>>=logB;
        }
        return res;
    }
};
const int logM = 24;
const int hashes=4;
simple_tabulation<3,10,logM> h[hashes] = {};
bitset<1<<logM> bs = {};
bool insert(int i) {
    unsigned a[hashes];
    for(int j=0;j<hashes;++j) a[j]=h[j](i);
    bool nw = false;
    for(auto j : a) {
        nw|=!bs[j];
        bs[j]=true;
    }
    return nw;
}
 
int main() {
    std::fread(buf, 1, sizeof(buf), stdin);
    int n = read();
    int ans=0;
    while(n--) {
        int a = read();
        ans+=insert(a);
    }
    cout << ans;
}