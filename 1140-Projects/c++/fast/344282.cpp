#include <algorithm>
#include <iostream>
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
 
struct Projekt {
    int starting = 0;
    int ending = 0;
    int reward = 0;
    Projekt() = default;
    Projekt(int s, int e, int r)
        : starting(s)
        , ending(e)
        , reward(r)
    {
    }
    auto operator<(Projekt const& other) const -> bool
    {
        return std::tie(starting, ending, reward) < std::tie(other.starting, other.ending, other.reward);
    }
};
auto main() -> int
{
    int n;
    getnum(n);
    std::vector<Projekt> projekts(n);
    for (auto& [s, e, r] : projekts) {
        getnum(e);
        getnum(s);
        getnum(r);
    }
    sort(projekts.begin(), projekts.end());
    std::vector<int64_t> amount(n);
    amount[0] = projekts.front().reward;
    for (int i = 1; i < n; ++i) {
        auto const [y, x, z] = projekts[i];
        auto k = std::lower_bound(projekts.begin(), projekts.end(), Projekt(x, 0, 0)) - projekts.begin() - 1;
        auto m = amount[i - 1];
        if (k >= 0) {
            m = std::max(m, amount[k] + z);
        } else {
            m = std::max<int64_t>(m, z);
        }
        amount[i] = m;
    }
    std::cout << amount.back() << '\n';
}