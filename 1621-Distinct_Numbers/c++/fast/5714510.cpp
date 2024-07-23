#include <iostream>
#define endl '\n'
#define pc putchar_unlocked
inline void radix_sort(int *a, int n)
{
    int cnt[32768] = {0};
    int tmpa[n];
    for (int i = 0; i < n; i++)
        cnt[a[i] & 32767]++;
    for (int i = 1; i < 32768; i++)
        cnt[i] += cnt[i - 1];
    int temp;
    for (int i = n - 1; i >= 0; i--)
    {
        temp = a[i] & 32767;
        cnt[temp]--;
        tmpa[cnt[temp]] = a[i];
    }
 
    int cnt2[32768] = {0};
    for (int i = 0; i < n; i++)
        cnt2[(tmpa[i] >> 15) & 32767]++;
    for (int i = 1; i < 32768; i++)
        cnt2[i] += cnt2[i - 1];
 
    for (int i = n - 1; i >= 0; i--)
    {
        temp = (tmpa[i] >> 15) & 32767;
        cnt2[temp]--;
        a[cnt2[temp]] = tmpa[i];
    }
    return;
}
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
    int n, count{1};
    fastscan(n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        fastscan(arr[i]);
    }
    radix_sort(arr, n);
    for (int i = 1; i < n; i++)
        if (arr[i] != arr[i - 1])
            count++;
    print(count);
    pc(endl);
}