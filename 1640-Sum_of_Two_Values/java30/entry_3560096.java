import java.io.*;
import java.util.*;
 
public class entry_3560096 {
	
	public static void main (String[] args) {
		Kattio io = new Kattio();
 
		int n = io.nextInt();
		int target = io.nextInt();
		int[] values = new int[n];
	
		// use a map to avoid using a very large array
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			values[i] = io.nextInt();
		}
 
		for (int i = 0; i < n; i++) {
			// target minus a number is the other number
			if (map.containsKey(target - values[i])) {
				io.println((i + 1) + " " + map.get(target - values[i]));
				// remember to close here before exiting to avoid
				// blank output
				io.close();
				System.exit(0);
			}
			map.put(values[i], i + 1);
		}
		io.println("IMPOSSIBLE");
		io.close();
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
			super(problemName + ".out");
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
