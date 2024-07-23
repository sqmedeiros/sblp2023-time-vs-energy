#include <algorithm>
#include <iostream>
#include <set>
#include <tuple>
#include <vector>
 
[[maybe_unused]] static const auto _ = []() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    return nullptr;
}();
 
template <typename T>
inline void getnum(T& a)
{
    constexpr unsigned char BASE = 10;
    constexpr unsigned char ZERO = 48;
    unsigned char chr = getchar();
    while (isspace(chr)) {
        chr = getchar();
    }
    T sign = 1;
    if (chr == '-') {
        sign = -1;
        chr = getchar();
    }
    a = static_cast<T>(chr - ZERO);
    while (isdigit(chr = getchar())) {
        a = a * BASE + static_cast<T>(chr - ZERO);
    }
    a *= sign;
}
template <typename T>
void out(T x)
{
    constexpr int BASE = 10;
 
    if (x < 0) {
        putchar('-');
        x = -x;
    }
    if (x > BASE - 1) {
        out<T>(x / BASE);
    }
    putchar(x % BASE + '0');
}
template <typename T>
void print_vector(std::vector<T> const& nums)
{
    for (auto n : nums) {
        out<T>(n);
        putchar(' ');
    }
    putchar('\n');
}
 
template <typename T>
void read_vector(std::vector<T>& nums)
{
    for (auto& n : nums) {
        getnum<T>(n);
    }
}
struct Movie {
    int start = 0;
    int end = 0;
    //Movie() = default;
    //Movie(int s, int e)
    //    : start(s)
    //    , end(e)
    //{
    //}
    [[nodiscard]] auto operator<(Movie const& other) const -> bool
    {
        return std::tie(start, end) < std::tie(other.start, other.end);
    }
};
 
auto main() -> int
{
    int n;
    getnum(n);
    int members;
    getnum(members);
    std::vector<Movie> movies(n);
    for (auto& [start, end] : movies) {
        getnum(end);
        getnum(start);
    }
    sort(movies.begin(), movies.end());
    int answer = 0;
    std::multiset<int> sets;
    for (auto const& [start, end] : movies) {
        if (!sets.empty() && *sets.begin() <= end) {
            sets.erase(prev(sets.upper_bound(end - 1)));
            answer++;
            sets.insert(start);
        } else if (members != 0) {
            members--;
            answer++;
            sets.insert(start);
        }
    }
    out(answer);
    return 0;
}