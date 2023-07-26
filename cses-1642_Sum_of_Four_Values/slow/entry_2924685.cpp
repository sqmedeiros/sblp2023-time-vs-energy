#include <bits/stdc++.h>
#define ll long long int
#define ull unsigned long long int
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define scc(x) scanf("%[^\n]s",x); 
#define u_m unordered_map<ll,ll>
#define loop(i,n) for(ll i=0;i<(n);i++)
#define forb(i,a,b) for(ll i=(a);i<=(b);i++)
#define forr(i,a,b) for(ll i=(a);i>=(b);i--)
#define all(v) (v).begin(),(v).end()
#define allr(v) (v).rbegin(),(v).rend() 
#define file_read(filename)  freopen("input.txt","r",stdin);
#define file_write(filename)  freopen("output.txt","w",stdout);
 
using namespace std;
int mod = 1e9 + 7 ;
 
vector<ll> arr , st ;
int gcd(int a, int b)
{
	if (b == 0)
		return a;
	return gcd(b, a % b); 
	
}
int LCM(int x,int y){
   /*https://codeforces.com/contest/1542/problem/C*/
    return (x/gcd(x,y))*y;
}
 
 
map<int,int> prime_factors(int a){
       map<int,int> mp;
      /*** function to return exponents of every prime in prime factorization of a number ***/ 
       while(a%2==0){
          mp[2]++;
          a/=2;}
       for(int i = 3 ; i <= sqrt(a) ; i=i+2){
          while(a%i==0){
            mp[i]++;
            a/=i;}
       }
       if(a>2)
         mp[a]++;
    
    return mp ;
}
bool isvalid(int x ,int y , vector<vector<int> > &dis){
     
     if(x <= 0 || x > 8 || y <= 0 || y > 8)
       return false ;
     if(dis[x][y])
       return false ;
     return true ;  
}
void dfs(int x, int y , vector<vector<int> > &dis , int d){
       
     vector<int> dx{-2,-1,1,2,2,1,-1,-2} ;
     vector<int> dy{-1,-2,-2,-1,1,2,2,1} ; 
     
     dis[x][y] = d ;
     if(d==64)
       return ;
     for(int i = 0 ; i < 8 ; i++){
        if(isvalid(x + dx[i] , y + dy[i] , dis)){
           dfs(x + dx[i] , y + dy[i] , dis , d + 1) ;
             break;}
     }
      
}
/*int find(int a)
{   
    if(par[a] < 0) return a;
 
    return par[a] = find(par[a],par);
}
 
void Union(int a , int b)
{
    a = find(a,par) ;
    b = find(b,par) ;
    
    
    if(rank[a] > rank[b]){
         par[b] = a;
         rank[a] = rank[a] + rank[b];
         same = false ;
         ans = rank[a] ;
    }else{
         par[a] = b;
         rank[b] = rank[b] + rank[a] ;
         same = false ;
         ans = rank[b] ;
    }
}*/
 
void build_seg_tree(int si , int ss , int se){
     
     if(ss==se){
        st[si] = arr[ss] ;
        return ;
     }
      
     int mid = ss + (se - ss)/2 ;
     
     build_seg_tree(2*si , ss , mid) ;
     build_seg_tree(2*si + 1 , mid + 1 , se) ;
     
     st[si] = min(st[2*si] , st[2*si + 1]) ;
     
}
ll findans(int si , int ss , int se , int qs , int qe){
        
        
      if(qs > se || qe < ss)
        return INT_MAX ;
      if(qs <= ss && qe >= se)
        return st[si] ;
      
      int mid = ss + (se - ss)/2 ;
      
      return min(findans(2*si,ss,mid,qs, qe) , findans(2*si+1,mid + 1 , se , qs, qe)) ;
}
void updatevalue(int si , int ss , int se , int ind , int val){
         if(ss==se){
            st[si] = val ;
            return ;
         }
        
        int mid = (ss + se)/2 ;
        if(ind <= mid) updatevalue(2*si , ss , mid , ind , val) ;
        else          updatevalue(2*si + 1 , mid + 1 , se , ind , val) ;
        
        st[si] = min(st[2*si] , st[2*si + 1]) ;
        
} 
 
 
void solve(){
     
    ll n , x , val , fir = -1 , sec = -1 , thir = -1, four = -1;
    cin >> n >> x ;
    
    vector<pair<ll,ll>> vec ;
    
    for(int i = 0 ; i < n ; i++){
       cin >> val ;
       vec.pb({val,i + 1}) ;
    }
    
    sort(all(vec)) ;
    
    for(int i = 0 ; i < n ; i++){
       ll sum = 0 ;
       for(int m = i + 1 ; m < n ; m++){
          for(int j = m + 1 , k = n - 1; j < k ; ){
             sum = vec[i].first + vec[m].first + vec[j].first + vec[k].first ;
               if(sum==x){
		     fir = vec[i].second ;
		     sec = vec[m].second ;
		     thir = vec[j].second ;
		     four = vec[k].second ;
		     break ;
              }else if(sum > x)
                   k-- ;
              else if(sum < x)
                   j++ ;
       }
       
       if(fir!=-1)
         break ; 
      }
      if(fir!=-1)
         break ;
    }   
    
    if(fir!=-1)
      cout << fir << " " << sec << " " << thir << " " << four << endl; 
    else 
      cout << "IMPOSSIBLE" << endl;  
       
}
 
 
int main() {
     ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
     
    #ifdef LOCAL
    freopen("input.txt", "r" , stdin);
    freopen("output.txt", "w", stdout);
    #endif
     
     ll t  = 1;
     /*cin >> t ;*/
  int i = 1 ;
  while (t--) {
    solve();
  }
}
