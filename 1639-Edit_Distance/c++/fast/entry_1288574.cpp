#include<bits/stdc++.h>
using namespace std;
int levenshteinDistance(string s, string t) {
    int m = s.size(), n = t.size();
    // create two work vectors of integer distances
    vector<int> v0(n + 1), v1(n + 1);
 
    // initialize v0 (the previous row of distances)
    // this row is A[0][i]: edit distance for an empty s
    // the distance is just the number of characters to delete from t
    iota(begin(v0),end(v0),0);
    int substitutionCost, deletionCost, insertionCost;
    for(int i = 0; i < m; ++i) {
        // calculate v1 (current row distances) from the previous row v0
 
        // first element of v1 is A[i+1][0]
        //   edit distance is delete (i+1) chars from s to match empty t
        v1[0] = i + 1;
 
        // use formula to fill in the rest of the row
        for(int j = 0; j < n; ++j) {
            // calculating costs for A[i+1][j+1]
            deletionCost = v0[j + 1] + 1;
            insertionCost = v1[j] + 1;
            if(s[i] == t[j])
                substitutionCost = v0[j];
            else
                substitutionCost = v0[j] + 1;
 
            v1[j + 1] = min(deletionCost, min(insertionCost, substitutionCost));
        }
 
        // copy v1 (current row) to v0 (previous row) for next iteration
        // since data in v1 is always invalidated, a swap without copy could be more efficient
        v0.swap(v1);
    // after the last swap, the results of v1 are now in v0
    }
    return v0[n];
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string s, t;
    cin >> s >> t;
    cout << levenshteinDistance(s,t);
    return 0;
}
 