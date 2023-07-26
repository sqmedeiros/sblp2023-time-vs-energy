#include <iostream>
#include <fstream>
#include <cmath>
#include <algorithm>
#include <vector>
 
using namespace std;
 
bool used[100001][1000];
 
int main()
{
    int N, X;
    cin >> N >> X;
 
    vector <int> H(N), S(N);
    for(int i = 0; i < N; ++i){cin >> H[i];}
    for(int i = 0; i < N; ++i){cin >> S[i];}
    // Input Done
 
    int solve[X+1] = {0}, ANS = 0;
    for(int i = 1; i <= X; ++i){
        for(int j = 0; j < N; ++j){
            if(i-H[j] >= 0 && !used[i-H[j]][j]){
                if(solve[i - H[j]] + S[j] > solve[i]){
                    solve[i] = solve[i - H[j]] + S[j];
 
                    for(int k = 0; k < N; ++k){
                        used[i][k] = used[i - H[j]][k];
                    }
 
                    used[i][j] = true;
                }
            }
        }
        ANS = max(ANS, solve[i]);
    }
 
    cout << ANS << endl;
 
    return 0;
}
 