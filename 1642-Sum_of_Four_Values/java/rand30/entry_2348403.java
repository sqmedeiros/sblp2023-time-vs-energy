import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import static java.lang.Math.pow;
import static java.lang.Math.log;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.math.BigInteger;
 
public class entry_2348403 {
 
	static FastReader sc;
    static PrintWriter out;
    
	
	 static class FastReader 
 
	    { 
	        BufferedReader br; 
	        StringTokenizer st; 
	  
	        public FastReader() 
	        { 
	            br = new BufferedReader(new
	                     InputStreamReader(System.in)); 
	        } 
	  
	        String next() 
	        { 
	            while (st == null || !st.hasMoreElements()) 
	            { 
	                try
	                { 
	                    st = new StringTokenizer(br.readLine()); 
	                } 
	                catch (IOException  e) 
	                { 
	                    e.printStackTrace(); 
	                } 
	            } 
	            return st.nextToken(); 
	        } 
	  
	        int nextInt() 
	        { 
	            return Integer.parseInt(next()); 
	        } 
	  
	        long nextLong() 
	        { 
	            return Long.parseLong(next()); 
	        } 
	  
	        double nextDouble() 
	        { 
	            return Double.parseDouble(next()); 
	        } 
	  
	        String nextLine() 
	        { 
	            String str = ""; 
	            try
	            { 
	                str = br.readLine(); 
	            } 
	            catch (IOException e) 
	            { 
	                e.printStackTrace(); 
	            } 
	            return str; 
	        } 
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
	static void ruffleSort(int[] a) {
			int n=a.length;
			Random r=new Random();
			for (int i=0; i<a.length; i++) {
				int oi=r.nextInt(n), temp=a[i];
				a[i]=a[oi];
				a[oi]=temp;
			}
			Arrays.sort(a);
		}
	 
	 
	 static int gcd(int a, int b)
	    {
	      if (b == 0)
	        return a;
	      return gcd(b, a % b);
	    }
	 
	 static int lowerBound(int[] a, int low, int high, int element) {
		    while (low < high) {
		        int middle = low + (high - low) / 2;
		        if (element > a[middle]) {
		            low = middle + 1;
		        } else {
		            high = middle;
		        }
		    }
		    return low;
		}
 
		static int upperBound(int[] a, int low, int high, int element) {
		    while (low < high) {
		        int middle = low + (high - low) / 2;
		        if (a[middle] > element) {
		            high = middle;
		        } else {
		            low = middle + 1;
		        }
		    }
		    return low;
		}
	 
	 static class Pair {
		    int x;
		    long y;
		  
		   
		public Pair(int x, long y)
		    {
		        this.x = x;
		        this.y = y;
		    }
		}
	 public void solve() {
			int t=1;
			while(t-->0) {
				cal();
		    }
		 }
	static void cal() {
		int n=sc.nextInt();
		long x=sc.nextLong();
		Pair[] arr=new Pair[n];
		for(int i=0;i<n;i++) {
			long e=sc.nextLong();
			arr[i] = new Pair(i,e);
		}
		Arrays.sort(arr, (a,b) -> Long.compare(a.y, b.y));
//		for(int i=0;i<n;i++) {
//			System.out.print(arr[i].y+" ");
//		}
//		System.out.println();
		for(int i=0;i<n-3;i++) {
			for(int j=i+1;j<n-2;j++) {
				long curr_sum = x-(arr[i].y+ arr[j].y);
				int l=j+1,r=n-1;
				while(l<r) {
					if((arr[l].y+arr[r].y)>curr_sum) {
						r--;
					}
					else if((arr[l].y+arr[r].y)<curr_sum) {
						l++;
					}
					else {
//						System.out.println(curr_sum + " "+arr[l].y+" "+arr[r].y);
//						System.out.println(arr[i].y+" "+arr[j].y);
						int a = arr[i].x +1;
						int b = arr[j].x +1;;
						int c = arr[l].x +1;
						int d = arr[r].x +1;
						out.print(a+" "+b+" "+c+" "+d+"\n");
					//	System.out.println(i+" "+j+" "+l+" "+r);
						return;
					}
				}
			}
		}
		out.print("IMPOSSIBLE\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		sc = new FastReader();
	    out = new PrintWriter(System.out);
	    new entry_2348403().solve();
	    out.flush();
	}
 
}
