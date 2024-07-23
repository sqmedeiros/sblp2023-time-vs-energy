import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;
import java.lang.reflect.Array;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Random;
public class entry_914121 {
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static long MOD = (long)(1e9+7);
	static long MOD2 = MOD*MOD;
	//static long MOD = 998244353;
	static FastReader sc = new FastReader();
	static int pInf = Integer.MAX_VALUE;
	static int nInf = Integer.MIN_VALUE;
	public static void main(String[] args){
		int test = 1;
		//test = sc.nextInt();
		while(test-->0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			long[] a = new long[n];
			long[] b = new long[m];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			for(int i = 0; i < m; i++) {
				b[i] = sc.nextLong();
			}
			sort(a,0,n-1);
			sort(b,0,m-1);
			int l = 0;
			int r = 0;
			int ans = 0;
			while(l<n) {
				while(r<m && b[r]<a[l]-k) {
					r++;
				}
				if(r<m && b[r]<=a[l]+k) {
					ans++;
					r++;
				}
				l++;
			}
			out.print(ans);
		}
		out.close();
	}
	public static int lowerBound(int key, ArrayList<Integer> A) {
		int s = 0;
		int e = A.size()-1;
		if(e==-1) {
			return 0;
		}
		int ans = -1;
		while(s<=e) {
			int m = s+(e-s)/2;
			if(A.get(m)>=key) {
				ans = m;
				e = m-1;
			}
			else {
				s = m+1;
			}
		}
		return ans==-1?s:ans;
	}
	public static int upperBound(int key, ArrayList<Integer> A) {
		int s = 0;
		int e = A.size()-1;
		if(e==-1) {
			return 0;
		}
		int ans = -1;
		while(s<=e) {
			int m = s+(e-s)/2;
			if(A.get(m)>key) {
				ans = m;
				e = m-1;
			}
			else {
				s = m+1;
			}
		}
		return ans==-1?s:ans;
	}
	public static long c2(long n) {
		if((n&1)==0) {
			return mul(n/2, n-1);
		}
		else {
			return mul(n, (n-1)/2);
		}
	}
	public static long mul(long a, long b){
	    return ((a%MOD)*(b%MOD))%MOD;
	}
	public static long add(long a, long b){
	    return ((a%MOD)+(b%MOD))%MOD;
	}
	public static long sub(long a, long b){
	    return ((a%MOD)-(b%MOD))%MOD;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Integer.lowestOneBit(i)   Equals k where k is the position of the first one in the binary
//Integer.highestOneBit(i)  Equals k where k is the position of the last one in the binary
//Integer.bitCount(i)       returns the number of one-bits
//Collections.sort(A,(p1,p2)->(int)(p2.x-p1.x)) To sort ArrayList in descending order wrt values of x.
//            Arrays.parallelSort(a,new Comparator<TPair>() {
//      		public int compare(TPair a,TPair b) {
//        			if(a.y==b.y) return a.x-b.x;
//        			return b.y-a.y;
//        		}
//        	});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//PrimeFactors    
    public static ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        if (n % 2 == 0)
            arr.add((long) 2);
        while (n % 2 == 0)
            n /= 2;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            int flag = 0;
            while (n % i == 0) {
                n /= i;
                flag = 1;
            }
            if (flag == 1)
                arr.add(i);
        }
        if (n > 2)
            arr.add(n);
        return arr;
    }
//Pair Class
	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.x==o.x){
			    return (this.y-o.y);
			}
			return (this.x-o.x);
		}
	}
	static class TPair implements Comparable<TPair>{
		int two;
		int three;
		int prime;
		public TPair(int two, int three, int prime) {
			this.two = two;
			this.three = three;
			this.prime = prime;
		}
		@Override
		public int compareTo(TPair o) {
			if(this.three==o.three){
			    return (this.two-o.two);
			}
			return -1*(this.three-o.three);
		}
	}
//nCr
	static long ncr(long n, long k) {
        long ret = 1;
        for (long x = n; x > n - k; x--) {
            ret *= x;
            ret /= (n - x + 1);
        }
 
        return ret;
    }
	static long finextDoubleMMI_fermat(long n,int M)
    {
        return fastExpo(n,M-2);
    }
 
    static long nCrModPFermat(int n, int r, int p) 
    { 
        if (r == 0) 
            return 1; 
        long[] fac = new long[n+1]; 
        fac[0] = 1;           
        for (int i = 1 ;i <= n; i++) 
            fac[i] = fac[i-1] * i % p;       
        return (fac[n]* finextDoubleMMI_fermat(fac[r], p)% p * finextDoubleMMI_fermat(fac[n-r], p) % p) % p; 
    }
//Kadane's Algorithm    
    static long maxSubArraySum(ArrayList<Long> a) { 
    	if(a.size()==0) {
    		return 0;
    	}
    	long max_so_far = a.get(0); 
    	long curr_max = a.get(0); 
    	for (int i = 1; i < a.size(); i++) { 
           curr_max = Math.max(a.get(i), curr_max+a.get(i)); 
           max_so_far = Math.max(max_so_far, curr_max); 
    	} 
    	return max_so_far; 
    } 
//Shuffle Sort
    static final Random random=new Random();
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
//Merge Sort
	static void merge(long arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        long L[] = new long [n1];
        long R[] = new long [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(long arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
//Brian Kernighans Algorithm
    static long countSetBits(long n){
        if(n==0) return 0;
        return 1+countSetBits(n&(n-1));
    }
//Factorial
    static long factorial(long n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 6;
        return n*factorial(n-1);
    }
//Euclidean Algorithm
    static long gcd(long A,long B){
        if(B==0) return A;
        return gcd(B,A%B);
    }
//Modular Exponentiation
    static long fastExpo(long x,long n){
        if(n==0) return 1;
        if((n&1)==0) return fastExpo((x*x)%MOD,n/2)%MOD;
        return ((x%MOD)*fastExpo((x*x)%MOD,(n-1)/2))%MOD;
    }
//AKS Algorithm
    static boolean isPrime(long n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i<=Math.sqrt(n);i+=6)
            if(n%i==0 || n%(i+2)==0) return false;
        return true;
    }
//Reverse an array
    static <T> void reverse(T arr[],int l,int r){
    	Collections.reverse(Arrays.asList(arr).subList(l, r));
    }
  //Print array
    static void print1d(int arr[]) {
    	out.println(Arrays.toString(arr));
    }
    static void print2d(int arr[][]) {
    	for(int a[]: arr) out.println(Arrays.toString(a));
    }
//Sieve of eratosthenes
    static int[] findPrimes(int n){
        boolean isPrime[]=new boolean[n+1];
        ArrayList<Integer> a=new ArrayList<>();
        int result[];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;++i){
            if(isPrime[i]==true){
                for(int j=i*i;j<=n;j+=i) isPrime[j]=false;
            }
        }
        for(int i=0;i<=n;i++) if(isPrime[i]==true) a.add(i);
        result=new int[a.size()];
        for(int i=0;i<a.size();i++) result[i]=a.get(i);
        return result;
        
    }
//Indivisual factors of all nos till n
    static ArrayList<Integer>[] indiFactors(int n){
    	ArrayList<Integer>[] A = new ArrayList[n+1];
    	for(int i = 0; i <= n; i++) {
    		A[i] = new ArrayList<>();
    	}
    	int[] sieve = new int[n+1];
    	for(int i=2;i<=n;i++) {
       		if(sieve[i]==0) {
       			for(int j=i;j<=n;j+=i) if(sieve[j]==0) {
       				//sieve[j]=i;
       				A[j].add(i);
       			}
       		}
       	}
    	return A;
    }
//Segmented Sieve
    static boolean[] segmentedSieve(long l, long r){
    	boolean[] segSieve = new boolean[(int)(r-l+1)];
    	Arrays.fill(segSieve, true);
    	int[] prePrimes = findPrimes((int)Math.sqrt(r));
    	for(int p:prePrimes) {
    		long low = (l/p)*p;
    		if(low < l) {
    			low += p;
    		}
    		if(low == p) {
    			low += p;
    		}
    		for(long j = low; j<= r; j += p) {
    			segSieve[(int) (j-l)] = false;
    		}
    	}
    	if(l==1) {
    		segSieve[0] = false;
    	}
    	return segSieve;
    }
//Euler Totent function
    static long countCoprimes(long n){
        ArrayList<Long> prime_factors=new ArrayList<>();
        long x=n,flag=0;
        while(x%2==0){
            if(flag==0) prime_factors.add(2L);
            flag=1;
            x/=2;
        }
        for(long i=3;i*i<=x;i+=2){
            flag=0;
            while(x%i==0){
                if(flag==0) prime_factors.add(i);
                flag=1;
                x/=i;
            }
        }
        if(x>2) prime_factors.add(x);
        double ans=(double)n;
        for(Long p:prime_factors){
            ans*=(1.0-(Double)1.0/p);
        }
        return (long)ans;
    }
	static long modulo = (long)1e9+7;
	public static long modinv(long x){
	    return modpow(x, modulo-2);
	}
	public static long modpow(long a, long b){
	    if(b==0){
	        return 1;
	    }
	    long x = modpow(a, b/2);
	    x = (x*x)%modulo;
	    if(b%2==1){
	        return (x*a)%modulo;
	    }
	    return x;
	}
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		//it reads the data about the specified point and divide the data about it ,it is quite fast
		//than using direct 
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());//converts string to integer
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
}
