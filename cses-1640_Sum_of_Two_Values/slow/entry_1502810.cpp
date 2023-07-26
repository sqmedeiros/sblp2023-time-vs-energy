#include <iostream>
#include <unordered_map>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace::std;
 
int N, X;
 
int main(void) {
	//unordered_map<int, int> M;
	gp_hash_table<int,int> M({},{},{},{},{1<<18}); 
 
	scanf("%d%d", &N, &X);
	for (int i = 1, A; i <= N; i++) {
		scanf("%d", &A);
		if (M[X - A] > 0) {
			cout << M[X - A] << ' ' << i << '\n';
			return 0;
		}
		M[A] = i;
	}
	cout << "IMPOSSIBLE\n";
}