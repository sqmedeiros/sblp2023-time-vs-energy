import java.io.*;
import java.util.*;
 
public class entry_1241112 {
 
	static tuple t[];
	static int i, low, mid, high, xx;
 
	static class tuple implements Comparable<tuple> {
		int x, y, z;
		tuple(int a, int b, int c){ x = a; y = b; z = c; }
		int first() { return x; }
		int second() { return y; }
		int cost() { return z; }
		@Override
		public int compareTo(tuple o) {
			if(o.second() - this.second()>0)
				return -1;
			else if(o.second() - this.second()<0)
				return 1;
			else {
				if(o.first() - this.first()>0)
					return -1;
				else if(o.first() - this.second()<0)
					return 1;
				else 
					return 0;
			}
		}
	
	}
 
	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int tt = in.nextInt(), n = tt, ind = 0;
        t = new tuple[n];
        while(tt-->0){ 
        	int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        	t[ind++] = new tuple(x,y,z);
        }
        Arrays.sort(t);
        long dp[] = new long[n];
        for(i=0;i<n;i++){
        	if(i>0) dp[i] = dp[i-1];
        	int x = lowerBound();
        	if(x>=0) dp[i] = Math.max(dp[i],dp[x]+t[i].cost());
        	else dp[i] = Math.max(dp[i],t[i].cost());
        }
        out.println(dp[n-1]);
        out.flush();
	}
 
	static int lowerBound(){
		low = 0; high = i-1; xx = t[i].first();
		while(low<=high){
			mid = (low+high)/2;
			if(xx>t[mid].second()) low = mid+1;
			else high = mid-1;
		}
		return low-1;
	}
 
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}
}