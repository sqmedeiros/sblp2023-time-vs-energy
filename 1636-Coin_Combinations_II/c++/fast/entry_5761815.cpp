#pragma GCC optimize("O3,unroll-loops")
//#pragma GCC target("avx,avx2,fma,bmi,bmi2")
#include<bits/stdc++.h>
using namespace std;
 
int n, x;
int coin[101];
int CB_1row[1000001];
int MOD = 1e9+7;
int mol(int x){ if(x<MOD){return x;} else{return x-MOD;}}
 
int main()
{ios::sync_with_stdio(0); cin.tie(0);
	cin>>n>>x;
	coin[0]=0;
	for(int i=1; i<=n; i++){ cin>>coin[i]; }
 
	CB_1row[0]=1;
	for(int i=1; i<=n; i++){
		for(int j=coin[i]; j<=x; j++){
			if(j>=coin[i]){
				CB_1row[j] = mol( CB_1row[j] + CB_1row[j-coin[i]] );
			}else{
				CB_1row[j] = CB_1row[j] + 0;
			}
		}
	}
	cout << CB_1row[x] << "\n";
}
 
