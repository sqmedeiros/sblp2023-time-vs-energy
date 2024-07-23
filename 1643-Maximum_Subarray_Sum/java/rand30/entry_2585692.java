import java.io.*;
import java.util.*;
 
public class entry_2585692 {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.nextInt();
 
		long[] best = new long[n+1];
		best[0] = 0;
		long ans = Integer.MIN_VALUE;
 
		for (int i=0; i<n; i++) {
			long x = io.nextInt();
			best[i+1] = Math.max(x, best[i]+x);
			ans = Math.max(ans, best[i+1]);
		}
		io.println(ans);
		io.close();
	}
 
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
    }
 
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
 
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
 
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
 
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
