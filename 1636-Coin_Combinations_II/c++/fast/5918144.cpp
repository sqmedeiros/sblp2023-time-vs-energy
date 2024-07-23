#pragma GCC optimize("Ofast,unroll-loops")
//#pragma GCC target("avx,avx2,fma,bmi,bmi2")
 
#include <algorithm>
#include <iostream>
#include <vector>
 
const int big_prime {1000000007};
int count[1000001] = {0};
int c[100];
 
int main() {
    int n, x;
    std::cin >> n >> x;
    for (int i {0}; i < n; ++i) {
        std::cin >> c[i];
    }
    // No need to sort, actually.
    //std::sort(c.begin(), c.end()); // Already guaranteed distinct.
    // 2-D array: count[i, j] is the number of ways to make
    // j (= 0, 1, ..., x) using the first i (= 0, 1, ..., n) denominations.
    // We only need to keep the current working row.
    //std::vector<int> count(x+1, 0);
    count[0] = 1; // One way to make 0 using no denominations.
    for (int i {0}; i < n; ++i) {
        for (int j {c[i]}; j <= x; ++j) {
            count[j] += count[j - c[i]];
            if (count[j] > big_prime)
                count[j] -= big_prime;
        }
    }
    /*
    // With sentinel columns (i < 0).
    int skipcols = c[n-1];
    std::vector<int> count((n+1) * (skipcols+x+1), 0);
    count[skipcols] = 1; // One way to make 0 using no denominations.
    for (int i {1}; i <= n; ++i) {
        for (int j {skipcols}; j <= skipcols+x; ++j) {
            count[i*(skipcols+x+1) + j] =
                (count[(i-1)*(skipcols+x+1) + j] +
                 count[i*(skipcols+x+1) + j - c[i-1]])
                % big_prime;
        }
    }*/
    /* Slow traversal order
    count[skipcols*(n+1)] = 1; // One way to make 0 using no denominations.
    for (int i {1}; i <= n; ++i) {
        for (int j {skipcols}; j <= skipcols+x; ++j) {
            count[i + j*(n+1)] =
                (count[(i-1) + j*(n+1)] +
                 count[i + (j - c[i-1])*(n+1)])
                % big_prime;
        }
    }*/
    std::cout << count[x] << std::endl;
    // Space-efficient, but slow.
    /*
    // We only need to save the last c[n-1]+1 columns.
    int width = c[n-1]+1;
    std::vector<int> count((n+1) * width, 0);
    for (int j {0}; j <= x; ++j) {
        // First row: number of ways to make j using no denominations.
        int J = j%width;
        count[J] = (j == 0) ? 1 : 0;
        for (int i {1}; i <= n; ++i) {
            count[i*width + J] =
                count[(i-1)*width + J] +
                count[i*width + (j - c[i-1] + width)%width];
            count[i*width + J] %= big_prime;
        }
    }
    std::cout << count[n*width + x%width] << std::endl;
    */    
    return 0;
}
