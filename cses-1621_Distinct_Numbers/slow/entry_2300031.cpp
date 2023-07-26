#include <iostream>
#include <set>
#include <unordered_set>
using namespace std;
int main() {
int n;
cin>>n;
int x[n];
unordered_set<int> s;
s.max_load_factor(0.25);
    for (int i = 0; i < n; i++) {
        cin>>x[i];
        s.insert(x[i]);
    }
    cout << s.size();
}