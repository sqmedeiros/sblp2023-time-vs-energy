#include "bits/stdc++.h"
#include <algorithm>
#include <map>
using namespace std;
// clang-format off
using i64 = int64_t;
using i32 = int32_t;
#define all(x) x.begin(), x.end()
// #define int i64
template <class T, typename U> constexpr inline bool exist(const T &s, const U &e) { return s.find(e) != s.end(); }
template <class T> constexpr inline i32 SZ(const T &x) { return x.size(); }
template <class T> constexpr inline bool rmn(T &a, T b) { return a > b ? (a = b, true) : false; }
template <class T> constexpr inline bool rmx(T &a, T b) { return a < b ? (a = b, true) : false; }
const char el = '\n'; const i32 MOD = 1e9 + 7, INF = 0x3f3f3f3f; const i64 INFLL = ((i64)INF << 32) | INF;
 
#ifdef LOCAL // debugging swiss knife
template <typename Ostream, typename Cont> enable_if_t<is_same<Ostream, ostream>::value, Ostream &> operator<<(Ostream &os, const Cont &v) { os << "{"; for (const auto &x : v) os << x << ", "; return os << "}"; }
template <typename Ostream, typename... Ts> Ostream &operator<<(Ostream &os, const pair<Ts...> &p) { return os << "(" << p.first << ", " << p.second << ")"; }
template <class... Args> void dbg_out(Args... args) { ((std::cerr << "\033[32m" << args << "\033[37m, "), ...); }
#define dbg(...) cerr << "\033[1;31m" << __LINE__ << ": [" << #__VA_ARGS__ << "]\033[37m  = ", dbg_out(__VA_ARGS__), cerr << "\033[0m" << endl;
#else
#define dbg(...) ;
#endif
// clang-format on
////////////////////////////////// TEMPLATE ENDS /////////////////////////////////
vector<vector<i32>> adj;
vector<i32> vis, color;
 
// Original author: Burunduk1; Optimizations by madhur4127
// Works only on Linux based systems. NOT on CodeForces.
// See FastIO.hpp for usage
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>
static struct input {
    struct stat ip_stat;
    char *ptr;
    int pos, len;
    input() {
        fstat(0, &ip_stat);
        pos = 0, len = ip_stat.st_size, ptr = (char *)mmap(NULL, len, PROT_READ, MAP_PRIVATE, 0, 0);
    }
} ip;
char getChar() {
    // assert(ip.pos < ip.len);
    return ip.ptr[ip.pos++];
}
template <typename T = int> inline T read() {
    char s = 1, c = read<char>();
    T x = 0;
    if (c == '-') s = -1, c = getChar();
    while ('0' <= c && c <= '9')
        x = x * 10 + c - '0', c = getChar();
    return s == 1 ? x : -x;
}
template <> inline char read<char>() {
    char c = getChar();
    while (c <= 32)
        c = getChar();
    return c;
}
template <> inline string read<string>() {
    read<char>();
    int start = ip.pos - 1;
    for (; ip.ptr[ip.pos] > ' '; ++ip.pos)
        ;
    return string(ip.ptr + start, ip.ptr + ip.pos);
}
 
/** Write */
static const int buf_size = 1 << 16;
static int write_pos = 0;
static char write_buf[buf_size];
uint32_t digits10(uint64_t v) {
    int len = 1;
    while (v >= 10000)
        v /= 10000, len += 4;
    return len + (v < 100 ? v >= 10 : 2 + (v >= 1000));
}
unsigned u64ToAsciiTable(uint64_t value) {
    static const char digits[201] = "00010203040506070809101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596979899";
    uint32_t const length = digits10(value);
    uint32_t next = length - 1;
    char *dst = &write_buf[write_pos];
    for (; value >= 100; next -= 2, value /= 100) {
        auto const i = (value % 100) * 2;
        dst[next] = digits[i + 1], dst[next - 1] = digits[i];
    }
    // Handle last 1-2 digits
    if (value < 10) {
        dst[next] = '0' + value;
    } else {
        auto i = uint32_t(value) * 2;
        dst[next] = digits[i + 1], dst[next - 1] = digits[i];
    }
    return length;
}
template <typename T = int> inline void write(T x, char end = 0) {
    if (__builtin_expect(write_pos + 21 >= buf_size, 0)) fwrite(write_buf, 1, write_pos, stdout), write_pos = 0;
    if (x < 0) write<char>('-'), x = -x;
    write_pos += u64ToAsciiTable(x);
    if (end) write<char>(end);
}
template <> inline void write<char>(const char x, char) {
    if (__builtin_expect(write_pos == buf_size, 0)) fwrite(write_buf, 1, buf_size, stdout), write_pos = 0;
    write_buf[write_pos++] = x;
}
template <> inline void write<string>(const string s, char end) {
    for (const char c : s)
        write<char>(c);
    if (end) write<char>(end);
}
struct Flusher {
    ~Flusher() {
        if (write_pos) fwrite(write_buf, 1, write_pos, stdout), write_pos = 0;
    }
} flusher;
 
int32_t main() {
    ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
    cout << fixed << setprecision(13), cerr << fixed << setprecision(3);
 
    int n = read(), m = read(), k = read();
    vector<int> need(n), hai(m);
    generate(all(need), read<>);
    generate(all(hai), read<>);
    int ans = 0;
    sort(all(need));
    sort(all(hai));
    dbg(need, hai);
    for (int i = 0, j = 0; i < n && j < m; ++i) {
        while (j < m && hai[j] < need[i] - k)
            ++j;
        if (j < m && hai[j] <= need[i] + k) ans++, ++j;
        dbg(i, j, ans);
    }
    write(ans, el);
 
    return 0;
}