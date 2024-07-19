#include <algorithm>
#include <cstdio>
 
typedef long long ll;
using namespace std;
 
int n;
 
void scan(int &a){
	char c=getchar_unlocked();
	bool neg=0;
	if(c=='-'){
		neg=1;
		c=getchar_unlocked();
	}
	while(c>='0' && c<='9'){
		a*=10;
		a+=c-'0';
		c=getchar_unlocked();
	}
	if(neg){
		a*=-1;
	}
}
 
int main(){
	ll mini=0, maxi=-1e9;
	ll sum=0;
	int a, maksi=-1e9;
	scan(n);
	for(int i=0; i<n; i++){
		a=0;
		scan(a);
		maksi=max(maksi, a);
		sum+=a;
		mini=min(mini, sum);
		maxi=max(maxi, sum-mini);
	}
	if(maksi<0){
		printf("%d\n", maksi);
	}
	else{
		printf("%lld\n", maxi);
	}
	return 0;
}
