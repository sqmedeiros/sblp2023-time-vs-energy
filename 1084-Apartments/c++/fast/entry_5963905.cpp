#include <algorithm>
#include <iostream>
#include <vector>
 
char *line {NULL};
int pos {0};
void reset_readint() {
    free(line);
    line = NULL;
    pos = 0;
}
int readint() {
    int n {0};
    do {
        n = 10*n + (line[pos++]-'0');
    } while ('0' <= line[pos] && line[pos] <= '9');
    ++pos;
    return n;
}
 
int main() {
    int n, m, k;
    size_t len;
 
    getline(&line, &len, stdin);
    n = readint();
    m = readint();
    k = readint();
    reset_readint();
 
    std::vector<int> a (n);
    getline(&line, &len, stdin);
    for (int i {0}; i < n; ++i) {
        a[i] = readint();
    }
    reset_readint();
 
    std::vector<int> b (m);
    getline(&line, &len, stdin);
    pos = 0;
    for (int j {0}; j < m; ++j) {
        b[j] = readint();
    }
    reset_readint();
 
    std::sort(a.begin(), a.end());
    std::sort(b.begin(), b.end());
    int i {0};
    int j {0};
    int count {0};
    while (i < n && j < m) {
        if (a[i] - k <= b[j] && b[j] <= a[i] + k) {
            ++count;
            ++i;
            ++j;
        } else if (a[i] + k < b[j]) {
            ++i;
        } else {
            ++j;
        }
    }
    std::cout << count << std::endl;
    return 0;
}