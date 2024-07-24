import java.util.*;
import java.io.*;
 
class A {
	static final FastReader in = new FastReader();
	static final PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		int n = in.nextInt();
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<n; i++) set.add(in.nextInt());
		
		out.println(set.size());
		out.close();
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
 
	static int power(int a, int b, int mod) {
		if (b == 0)
			return 1;
		long res = power(a, b / 2, mod);
		res = res * res % mod;
		if (b % 2 == 1)
			res = res * a % mod;
		return (int) res;
	}
 
	static class Pair{
		public int x;
		public int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}