#include <bitset>
#include <cstdio>
#include <vector>
 
constexpr int MAX_X {1'000'000'000};
constexpr int BSIZE {10'000'000};
constexpr int NBUCKETS {MAX_X / BSIZE};
 
std::vector<int> inputs[NBUCKETS];
 
char *raw_inputs {NULL};
int pos {0};
int readint() {
    int n {0};
    do {
        n = 10*n + (raw_inputs[pos++]-'0');
    } while ('0' <= raw_inputs[pos] && raw_inputs[pos] <= '9');
    ++pos;
    return n;
}
 
int main() {
    int n;
    int input;
    size_t len;
    scanf("%d\n", &n);
    getline(&raw_inputs, &len, stdin);
    for (int i {0}; i < n; ++i) {
        input = readint();
        inputs[input / BSIZE].push_back(input % BSIZE);
    }
    int nunique {0};
    std::bitset<BSIZE> seen;
    for (int i {0}; i < NBUCKETS; ++i) {
        for (auto &x : inputs[i]) {
            if (!seen[x]) {
                ++nunique;
                seen[x] = true;
            }
        }
        for (auto &x : inputs[i]) {
            seen[x] = false;
        }
    }
    printf("%d\n", nunique);
    return 0;
}