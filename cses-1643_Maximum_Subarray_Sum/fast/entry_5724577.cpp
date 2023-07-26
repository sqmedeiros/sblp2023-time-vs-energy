#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n'
#define pc putchar_unlocked
template <typename T>
void fastscan(T &destination) // faster input
{
    destination = 0;
    int n = getchar_unlocked();
    bool neg{};
    if (n == '-') // negative sign entered
    {
        neg = 1;
        n = getchar_unlocked();
    }
    for (; n >= '0' && n <= '9'; n = getchar_unlocked())
    {
        destination = destination * 10 + n - '0'; // it's merging
    }
    if (neg)
        destination = -1 * destination;
}
template <typename T>
void print(T value) // faster output
{
    if (value < 0) // put negative sign
    {
        putchar_unlocked('-');
        value = -value;
    }
    char digits[10];
    int i{10};
    do
    {
        digits[--i] = value % 10 + '0';
        value /= 10;
    } while (value);
    do
    {
        putchar_unlocked(digits[i]);
    } while (++i < 10);
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);
    int n, i{};
    long long cur_sum{}, max_sum{-1000000001};
    fastscan(n);
    int a[n];
    for (int i = 0; i < n; i++)
    {
        fastscan(a[i]);
    }
    while (i < n)
    {
        cur_sum += a[i++];
        max_sum = std::max(max_sum, cur_sum);
        if (cur_sum < 0)
            cur_sum = 0;
    }
    print(max_sum);
    pc(endl);
}
