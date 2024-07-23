// package faltu;
 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;
 
public class entry_4269770 {
	
//	***********************MATHS--STARTS************************************************* //
	
	private static ArrayList<Long> get_divisor(long x) {
		ArrayList<Long>a=new ArrayList<Long>();
		for(long i=1;i*i<=x;i++) {
			if(x%i==0) {
				a.add((long) i);
				if(x/i!=i)a.add(x/i);
			}
		}
		return a;
	}
	static long[] sieve;
    static long[] smallestPrime;
 	public static void sieve()
    {
        int n=4000000+1;
    	sieve=new long[n];
    	smallestPrime=new long[n];
    	sieve[0]=1;
    	sieve[1]=1;
    	for(int i=2;i<n;i++){
    		sieve[i]=i;
    		smallestPrime[i]=i;
    	}
    	for(int i=2;i*i<n;i++){
    		if(sieve[i]==i){
	    		for(int j=i*i;j<n;j+=i){
	    			if(sieve[j]==j)sieve[j]=1;
	    			if(smallestPrime[j]==j||smallestPrime[j]>i)smallestPrime[j]=i;
	    		}
    		}
    	}
    }
 	static long nCr(long n,long r,long MOD) {
 		if(n<r)return 0;
 		if(r==0)return 1;
 		return fact[(int) n]*mod_inv(fact[(int) r],MOD)%MOD*mod_inv(fact[(int) (n-r)],MOD)%MOD;
 	}
 	static long[]fact;
 	static void computeFact(long n,long MOD) {
 		fact=new long[(int)n+1];
 		fact[0]=1;
 		for(int i=1;i<=n;i++)fact[i]=(fact[i-1]*i%MOD)%MOD;
 	}
 	static long bin_expo(long a,long b,long MOD) {
	    if(b == 0)return 1;
	    long ans = bin_expo(a,b/2,MOD);
	    ans = (ans*ans)%MOD;
	    if(b % 2!=0){
	        ans = (ans*a)%MOD;
	    }
	    return ans%MOD;
	}
 	static long mod_add(long a, long b, long m) {a = a % m; b = b % m; return (((a + b) % m) + m) % m;}
 	static long mod_mul(long a, long b, long m) {a = a % m; b = b % m; return (((a * b) % m) + m) % m;}
 	static long mod_sub(long a, long b, long m) {a = a % m; b = b % m; return (((a - b) % m) + m) % m;}
 	
	static long mod_inv(long n,long p) {return bin_expo(n,p-2,p);}
	static long gcd(long a, long b){if (a == 0) {return b;}return gcd(b % a, a); }
    static int gcd(int a, int b){if (a == 0) {return b; }return gcd(b % a, a); }
    static long lcm(long a,long b){return (a / gcd(a, b)) * b;}
    static ArrayList<String>powof2s;
    static void powof2S() {
    	long i=1;
    	while(i<(long)2e18) {
    		powof2s.add(String.valueOf(i));
    		i*=2;
    	}
    }
    static long power(long a, long b){
    	a %=MOD;long out = 1;
	    while (b > 0) {
	        if((b&1)!=0)out = out * a % MOD;
	        a = a * a % MOD;
	        b >>= 1;
			a*=a;
	    }
	    return out;
    }
    static boolean coprime(int a, long l){return (gcd(a, l) == 1);}
    
    
//	****************************MATHS-ENDS*****************************************************
    
//  ***********************BINARY-SEARCH STARTS***********************************************
	 public static int upperBound(long[] arr, long m, int l, int r) {
	    	while(l<=r) {
	    		int mid=(l+r)/2;
	    		if(arr[mid]<=m) l=mid+1;
	    		else r=mid-1;
	    	}
	    	return l;
    }
    public static int lowerBound(long[] a, long m, int l, int r) {
    	while(l<=r) {
    		int mid=(l+r)/2;
    		if(a[mid]<m) l=mid+1;
    		else r=mid-1;
    	}
    	return l;
    }
    public static long getClosest(long val1, long val2,long target)
	{
		if (target - val1 >= val2 - target)
		return val2;       
		else
		return val1;       
	}
    static void ruffleSort(long[] a) {
		int n=a.length;
		Random r=new Random();
		for (int i=0; i<a.length; i++) {
			long oi=r.nextInt(n), temp=a[i];
			a[i]=a[(int)oi];
			a[(int)oi]=temp;
		}
		Arrays.sort(a);
	}
    static void ruffleSort(int[] a){
		int n=a.length;
		Random r=new Random();
		for (int i=0; i<a.length; i++) {
			int oi=r.nextInt(n), temp=a[i];
			a[i]=a[oi];
			a[oi]=temp;
		}
		Arrays.sort(a);
    }
    int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
    static int  lowerLimitBinarySearch(ArrayList<Long> v,long k) {
		int n =v.size();
		int first = 0,second = n;
		while(first <second) {
			int mid = first + (second-first)/2;
			if(v.get(mid) > k) {
				second = mid;
			}else {
				first = mid+1;
			}
		}
		
		 if(first < n && v.get(first) < k) {
			 first++;
		    }
		return first; //1 index
    }
    public static int searchindex(long arr[], long t){
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
    public static  int[] sort(int[] arr) {
    	ArrayList<Integer> al = new ArrayList<>();
    	for(int i=0;i<arr.length;i++) al.add(arr[i]);
    	Collections.sort(al);
    	for(int i=0;i<arr.length;i++) arr[i]=al.get(i);
    	return arr;
    }
    
//  *******************************BINARY-SEARCH ENDS***********************************************
    
//  *********************************GRAPHS-STARTS****************************************************
    	//    *******----SEGMENT TREE IMPLEMENT---*****
    		//    -------------START---------------
    void buildTree (int[] arr,int[] tree,int start,int end,int treeNode)
    {
    	if(start==end)
    	{
    		tree[treeNode]=arr[start];
    		return;
    	}
    	buildTree(arr,tree,start,end,2*treeNode);
    	buildTree(arr,tree,start,end,2*treeNode+1);
    	tree[treeNode]=tree[treeNode*2]+tree[2*treeNode+1];
    }
    void updateTree(int[] arr,int[] tree,int start,int end,int treeNode,int idx,int value)
    {
    	if(start==end)
    	{
    		arr[idx]=value;
    		tree[treeNode]=value;
    		return;
    	}
    	int mid=(start+end)/2;
    	if(idx>mid)
    	{
    		updateTree(arr,tree,mid+1,end,2*treeNode+1,idx,value);
    	}
    	else
    	{
    		updateTree(arr,tree,start,mid,2*treeNode,idx,value);
    	}
    	tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
    }
    			//  -------------ENDS---------------
    	
//***********************DSU IMPLEMENT START*************************
    static int parent[];
    static int rank[];
    static void makeSet(int n)
    {
    	parent=new int[n];
    	rank=new int[n];
    	for(int i=0;i<n;i++)
    	{
    		parent[i]=i;
    		rank[i]=0;
    	}
    }
    static void union(int u,int v)
    {
    	u=findpar(u);
    	v=findpar(v);
    	if(rank[u]<rank[v])parent[u]=v;
    	else if(rank[v]<rank[u])parent[v]=u;
    	else 
    	{
    		parent[v]=u;
    		rank[u]++;
    	}
    }
    
	private static int findpar(int node)
	{	
		if(node==parent[node])return node;
		return parent[node]=findpar(parent[node]);
	}
	
//    	*********************DSU IMPLEMENT ENDS*************************
	
//	*************************DFS IMPLEMENT START*************************
	static void DFSUtil(int v, boolean[] vis)
	{
		vis[v] = true;
		cnt++;
		Iterator<pair> it = adj.get(v).iterator();
		while (it.hasNext()) {
	       pair n = it.next();
	       if (!vis[(int) n.x]) {
	    	   
	           DFSUtil((int) n.x, vis);
	       }
		}
	}
	static long cnt;
    static long DFS(int n)
    {
    	long ans=0;
        vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
            	cnt=0;
                DFSUtil(i, vis);
            }
        }
        ans%=MOD;
        return ans;
    }
//    ***********************DFS IMPLEMENT END*************************
//  *********************************GRAPHS-ENDS****************************************************
 
    
    
    static int[][] dirs8 = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    static int[][] dirs4 = {{1,0},{-1,0},{0,1},{0,-1}};
    static long MOD=(long) (1e9+7);
    static int prebitsum[][];
    static ArrayList<Integer>arr;
    static boolean[] vis;
    static ArrayList<ArrayList<pair>>adj;
    static FastReader s = new FastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out, false);
    public static void main(String[] args) throws IOException
    {
//    	sieve();
//    	computeFact((int)1e7+1,MOD);
//    	prebitsum=new int[2147483648][31];
//    	presumbit(prebitsum);
//    	powof2S();
//        int tt = s.nextInt();
        int tt=1;
        while(tt-->0) {
        	solver();
        }
	}
    
	private static void solver() {
		int n=s.nextInt();
		long[]endspoints=new long[n];
		long[][]job=new long[n][3];
		for(int i=0;i<n;i++) {
			job[i][0]=s.nextLong();
			job[i][1]=s.nextLong();
			job[i][2]=s.nextLong();
			endspoints[i]=job[i][1];
		}
		
		Arrays.sort(job, (a, b)->(int)a[1] - (int)b[1]);
		long[]dp=new long[n+1];
		dp[0]=job[0][2];
		for(int i=1;i<n;i++) {
			long choose=job[i][2];
			int idx=find(job,i);
			if(idx!=-1)choose+=dp[idx];
			dp[i]=Math.max(dp[i-1], choose);
		}
		System.out.println(dp[n-1]);
	}
	static int find(long[][] job,int ind)//Find the latest job that comes before the job no. i.
	{
	    int l = 0,h = ind-1;
	    while(l <= h) {
	        int mid = (l+h)/2;
	        if(job[mid][1] < job[ind][0]){
	            if(job[mid+1][1] < job[ind][0])
	            l = mid + 1;
	            else return mid;
	        }
	        else h = mid - 1;
	 
	    }
	    return -1;
	}
//  *********************BITS && TOOLS &&DEBUG STARTS***********************************************
    static void presumbit(int[][]prebitsum) {
    	for(int i=1;i<=200000;i++) {
			int z=i;
			int j=0;
			while(z>0) {
				if((z&1)==1) {
					prebitsum[i][j]+=(prebitsum[i-1][j]+1);
				}else {
					prebitsum[i][j]=prebitsum[i-1][j];
				}
				z=z>>1;
				j++;
			}
		}
    }
    static void countOfSetBit(long[]a) {
    	for(int j=30;j>=0;j--) {
			int cnt=0;
			for(long i:a) {
				if((i&1<<j)==1)cnt++;
			}
//			printing the current no set bit in all array element
			System.out.println(cnt);
		}
    }
    public static String revStr(String str){
        String input = str;
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1.reverse();
        return input1.toString();
    }
	
    static boolean issafe(int i, int j, int r,int c, char ch){
		if (i < 0 || j < 0 || i >= r || j >= c|| ch!= '1')return false;
		else return true;
    }
    static void pc2d(char[][]a) {
    	int n=a.length;
    	int m=a[0].length;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    static void pi2d(long[][] d) {
    	int n=d.length;
    	int m=d[0].length;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			System.out.print(d[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
//  *****************BITS && TOOLS &&DEBUG ENDS***********************************************
	
	
//    **************************I/O*************************
    static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
class decrease implements Comparator<Long> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(long a, long b)
    {
        return (int) (b - a);
    }
 
	@Override
	public int compare(Long o1, Long o2) {
		// TODO Auto-generated method stub
		return (int) (o2-o1);
	}
}
 
class pair{
	long x;
	long y;
	public pair(long x,long y) {
		this.x=x;
		this.y=y;
	}
}