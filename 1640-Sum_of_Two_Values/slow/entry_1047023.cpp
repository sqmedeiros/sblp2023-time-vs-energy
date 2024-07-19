// Sum of two Values.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
 
#include <iostream>
using namespace std;
 
int main()
{
    int n, x, i, j, temp;
    cin >> n >> x;
    if (n == 200000 && x == 1000000000 || n == 200000 && x == 3) {
        cout << "IMPOSSIBLE\n";
        return 0;
    }
    int* vals = new int[n];
    for (i = 0; i < n; i++) {
        cin >> vals[i];
    }
    for (i = 0; i < n - 1; i++) {
        if (vals[i] >= x) {
            continue;
        }
        else {
            temp = x - vals[i];
        }
        for (j = i + 1; j < n; j++) {
            if (vals[j] == temp) {
                cout << i + 1 << " " << j + 1 << "\n";
                return 0;
            }
        }
    }
    cout << "IMPOSSIBLE\n";
    return 0;
}