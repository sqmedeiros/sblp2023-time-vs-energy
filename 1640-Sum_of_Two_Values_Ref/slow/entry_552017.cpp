#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
 
using namespace std;
 
#define FOR(a,b) for(int a=0;a<b;a++)
#define F0R(a,b,c) for(int a = b; a<=c; a++)
#define f first
#define s second
#define m0(x) memset(x,0,sizeof(x))
 
typedef pair<int,int> pi;
typedef long long ll;
typedef vector<int> vi;
typedef vector<pi> vpi;
 
#include <ext/pb_ds/assoc_container.hpp> // for gp_hash_table
using namespace __gnu_pbds;
 
int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0);
    gp_hash_table<int,int> g({},{},{},{},{1<<19});
    int n,x; cin >> n >> x;
    FOR(i,n){
        int a; cin >> a;
        if(a >= x) continue;
        if(g[x-a] != 0){
            cout << g[x-a] << " " << i+1 << endl;
            return 0;
        }
        g[a] = i+1;
    }
    cout << "IMPOSSIBLE" << endl;
    return 0;
}