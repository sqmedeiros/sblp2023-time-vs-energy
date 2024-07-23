#include <bits/stdc++.h>
using namespace std;
 
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
 
using ll = long long;
using db = long double;
using str = string;
 
using pi = pair<int, int>;
#define mp make_pair
#define f first
#define s second
 
#define sz(x) int((x).size())
#define all(x) begin(x), end(x)
#define sor(x) sort(all(x))
#define rsz resize
#define pb push_back
#define ft front()
#define bk back()
 
#define FOR(i, a, b) for (int i = (a); i < (b); ++i)
#define F0R(i, a) FOR(i, 0, a)
#define ROF(i, a, b) for (int i = (b)-1; i >= (a); --i)
#define R0F(i, a) ROF(i, 0, a)
#define rep(a) F0R(_, a)
#define each(a, x) for (auto &a : x)
 
inline namespace FastIO {
const int BSZ = 1 << 15;
char ibuf[BSZ];
int ipos, ilen;
char nc() {
    if (ipos == ilen) {
        ipos = 0;
        ilen = fread(ibuf, 1, BSZ, stdin);
        if (!ilen)
            return EOF;
    }
    return ibuf[ipos++];
}
void rs(str &x) {
    char ch;
    while (isspace(ch = nc()))
        ;
    do {
        x += ch;
    } while (!isspace(ch = nc()) && ch != EOF);
}
template <class T> void ri(T &x) {
    char ch;
    int sgn = 1;
    while (!isdigit(ch = nc()))
        if (ch == '-')
            sgn *= -1;
    x = ch - '0';
    while (isdigit(ch = nc()))
        x = x * 10 + (ch - '0');
    x *= sgn;
}
char obuf[BSZ], numBuf[100];
int opos;
void flushOut() {
    fwrite(obuf, 1, opos, stdout);
    opos = 0;
}
void wc(char c) {
    if (opos == BSZ)
        flushOut();
    obuf[opos++] = c;
}
void ws(string s) { each(c, s) wc(c); }
template <class T> void wi(T x, char after = '\0') {
    if (x < 0)
        wc('-'), x *= -1;
    int len = 0;
    for (; x >= 10; x /= 10)
        numBuf[len++] = '0' + (x % 10);
    wc('0' + x);
    R0F(i, len) wc(numBuf[i]);
    if (after)
        wc(after);
}
void initO() { assert(atexit(flushOut) == 0); }
} // namespace FastIO
void setIO(string name = "") {
    initO();
    cin.tie(0), cout.sync_with_stdio(0);
    if (sz(name)) {
        freopen((name + ".in").c_str(), "r", stdin);
        freopen((name + ".out").c_str(), "w", stdout);
    }
}
const int MOD = 1e9 + 7;
const db PI = acos((db)-1);
mt19937 rng(0);
 
int main() {
    setIO();
    int q;
    ri(q);
    ll ans;
    while (q--) {
        ll a, b;
        ri(a);
        ri(b);
        if (a > b) {
            ans = a % 2 == 1 ? (a - 1) * (a - 1) + b : a * a - b + 1;
        } else {
            ans = b % 2 == 0 ? (b - 1) * (b - 1) + a : b * b - a + 1;
        }
        wi(ans);
        wc('\n');
    }
}