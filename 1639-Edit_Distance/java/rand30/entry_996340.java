import java.util.*;
import java.io.*;
 
public class entry_996340 {
	static final FastReader in = new FastReader();
	static final PrintWriter out = new PrintWriter(System.out);
 
	public static void main(String[] args) {
		char[] a = in.next().toCharArray(), b = in.next().toCharArray();
		
		int n = a.length, m = b.length;
		int[][] dp = new int[n+1][m+1];
		
		for(int i=n; i>=0; i--) {
			for(int j=m; j>=0; j--) {
				if(i == n && j==m) {
					dp[i][j] = 0;
					continue;
				}
				if(i == n) {
					dp[i][j] = Math.abs(m-j);
					continue;
				}
				if(j==m) {
					dp[i][j] = Math.abs(n-i);
					continue;
				}
				
				if(a[i] == b[j]) {
					dp[i][j] = dp[i+1][j+1];
				}else {
					dp[i][j] = Collections.min(Arrays.asList(dp[i+1][j],dp[i][j+1],dp[i+1][j+1]))+1;
				}
			}
		}
		
		out.println(dp[0][0]);
//		for(int i=0; i<=n; i++) {
//			out.println(Arrays.toString(dp[i]));
//		}
		out.close();
	}
 
	static long power(long a, long b, int mod) {
		if (b == 0)
			return 1;
 
		long res = power(a, b / 2, mod);
		res = res * res % mod;
		if (b % 2 == 1)
			res = res * a % mod;
		return res;
	}
 
	static class Pair implements Comparable<Pair> {
		public int x;
		public int y;
 
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
 
		@Override
		public int compareTo(Pair o) {
			if (x == o.x)
				return Integer.compare(y, o.y);
 
			return Integer.compare(x, o.x);
		}
 
		@Override
		public String toString() {
			String val = "(" + x + "," + y + ")";
			return val;
		}
 
		@Override
		public int hashCode() {
			return 31 * x + y;
		}
 
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null)
				return false;
			if (this.getClass() != o.getClass())
				return false;
 
			Pair p = (Pair) o;
			return (x == p.x && y == p.y);
		}
	}
 
	static int[] readArr(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		return a;
	}
 
	static long[] readLongArr(int n) {
		long a[] = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextLong();
		return a;
	}
 
	static int[][] readMat(int n, int m) {
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = in.nextInt();
 
		return a;
	}
 
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}