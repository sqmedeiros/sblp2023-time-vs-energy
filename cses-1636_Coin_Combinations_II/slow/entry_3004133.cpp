/*coder : shital basavraj kallole*/
//2*10^9   -- int
//9*10^18  -- long long int
//10^38    -- __int128_t 
/* when we read string sometime you need to mug up
	cin>>ws; <- use this to mug up
	-to read one line string use - getline(cin,data[i]);
*/
//we also have long double
/*A better way to compare ﬂoating point numbers is to assume that 
two numbers are equal if the difference between them is less than ε, where ε is a small number.(ε=10−9) */
 
#include<bits/stdc++.h>
using namespace std;
 
typedef unsigned long long int ull;
typedef long long int ll;
#define endl "\n"
#define sp " "
#define PI 3.14159265358979323846264338327950L
 
 
vector<vector<int>> fourDirection = {{-1,0},{0,1},{1,0},{0,-1}};
vector<vector<int>> eightDirection = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
 
//const ll M=1e9+7;
 
//to handle when remainder is -neg we add + M
//but when rem is +pos that time also we add so use %M
//so it will work for both
ll mod(ll n, ll M){
	return (n%M + M)%M;	
}
ll modAdd(ll a, ll b, ll M){
	return mod(mod(a,M)+mod(b,M),M);
}
ll modMul(ll a, ll b, ll M){
	return mod(mod(a,M)*mod(b,M),M);
}
ll modMinus(ll a, ll b, ll M){
	return mod(mod(a,M)-mod(b,M),M);
}
ll modpow(ll x, ll n, ll M) 
{ 
	if (n == 0) 
		return 1%M;
	if (n == 1)
		return x%M; 
	ll u = modpow(x,n/2,M); 
	u = modMul(u,u,M); 
	if (n%2) 
		u = modMul(u,x,M); 
	return u; 
}
//to find out gcd
ll gcd(ll a,ll b){
	if(b==0)
		return a;
	return gcd(b,a%b);
}
//to find out gcd and coefficients : ax+by = g
ll extendedGcd(ll a,ll b,ll &x,ll &y){
	if(b==0){
		x=1;
		y=0;
		return a;
	}
	ll x1,y1;
	ll g = extendedGcd(b,a%b,x1,y1);
	x = y1;
	y = x1 - y1*(a/b);
	return g;
}
//mod inverse is present only for coprime numbers that is gcd(a,m)=1
ll modInverse(ll a, ll m){
	ll g,x,y;
	g = extendedGcd(a,m,x,y);
 
	if(g==1){
		return (x%m+m)%m;
	}
	return -1;
}
ll modDiv(ll a, ll b, ll M){
	//as we know modular division is not same as add,sub or mul
	//1.we need to find inverse of divisor and M i.e inverse of b and M
	ll inverse = modInverse(b,M);
	//2.multiply inverse with dividend i.e a
	return modMul(inverse,a,M);
}
//Chinese Remainder Theorem
ll crt(vector<ll> &P, vector<ll> &R){
	int n = P.size();
	vector<ll> X(n);
 
	ll productOfAllP=1;
 
	for(int i=0;i<n;i++)
		productOfAllP*=P[i];
 
	//each iteration calulates X[i]
	for(int i=0;i<n;i++){
		X[i]=R[i];
		ll mulOfInverse = 1;
		ll mul=1;
		for(int j=0;j<i;j++){
			mulOfInverse = modMul(mulOfInverse,modInverse(P[j],P[i]),P[i]);
			X[i] = modMinus(X[i],modMul(X[j],mul,P[i]),P[i]);
			mul = modMul(mul,P[j],P[i]);
		}
		X[i] = modMul(X[i],mulOfInverse,P[i]);
	}
 
	//calculating final X value
	ll finalX = 0;
	ll mul = 1;
 
	for(int i=0;i<n;i++){
		finalX = modAdd(finalX,modMul(X[i],mul,productOfAllP),productOfAllP);
		mul = modMul(mul,P[i],productOfAllP);
	}
 
	return finalX;
}
//check number is prime or not
bool isPrime(ll n){
	for(int i=2;i*i<=n;i++)
		if(n%i==0)
			return false;
	return true;
}
 
//disjoint set union
int getParent(vector<int>&parent,int s){
	if(parent[s]==s)
		return s;
	return getParent(parent,parent[s]);
}
 
 
//get prime numbers from 2 to 1e5
vector<int> primeNumbers;
void sieve(){
	int limit=1e5;
	vector<bool> prime(limit,true);
	for(ll i=2;i<limit;i++){
		if(prime[i]){
			primeNumbers.push_back(i);
			for(ll j=i*i;j<limit;j=j+i)
				prime[j]=false;
		}
	}
}
 
//the below function will return prime factor and fre of each factor for value provided in function
vector<pair<int,int>> primeFactors(ll tQ){
	vector<pair<int,int>> pf;
	for(ll i=2;i*i<=tQ;i++){
		if(tQ%i==0){
			int cnt = 0;
			while(tQ%i==0)
			{
				cnt+=1;
				tQ/=i;
			}
			pf.push_back({i,cnt});
		}
	}
	if(tQ!=1){
		pf.push_back({tQ,1});
	}
	return pf;
}
 
//new co-ordinate must be valid
bool insideGrid(int x,int y,int n,int m){
	if(x>=0 && x<n && y>=0 && y<m)
		return true;
	return false;
}
/*
ll M = 1e9+7;
ll total = (2*1e5)+1;
vector<ll> facts(total);
void calFac(){
	facts[0]=1;
	facts[1]=1;
	for(int i=2;i<total;i++){
		facts[i]=modMul(facts[i-1],i,M);
	}
}
ll nCr(ll n, ll r){
	//return n!/(n-r)!
	return modDiv(facts[n],facts[n-r],M);
}
*/
 
void solve(){
	int n,x;
	cin>>n>>x;
 
	int M = 1e9+7;
 
	vector<int> data(n+1);
	for(int i=1;i<=n;i++)
		cin>>data[i];
 
	sort(data.begin(),data.end());
	vector<vector<int>> dp(n+1,vector<int>(x+1));
 
 
 
	for(int i=1;i<=x;i++){
		int total = 0;
		for(int j=1;j<=n;j++){
			//here we just fill all n blocks
			int pre = i-data[j];
			if(pre<0){
				dp[j][i]=dp[j-1][i];
			}
			else if(pre==0){
				//total = (total + dp[j][pre])%M;
				//dp[j][i]=total;
 
				total=(total+1)%M;
				dp[j][i]=total;
			}
			else
			{
				total = (total + dp[j][pre])%M;
				dp[j][i]=total;
				//total=(total+1)%M;
				//dp[j][i]=total;
			}
		}
	}
 
	cout<<dp[n][x]<<endl;
	
}
 
int main(){
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    // freopen("inputf.txt","r",stdin);
    // freopen("outputf.txt","w",stdout);
      
    int t=1;
    //cin>>t;
 
    while(t--){
		solve();
    }
    return 0;
}