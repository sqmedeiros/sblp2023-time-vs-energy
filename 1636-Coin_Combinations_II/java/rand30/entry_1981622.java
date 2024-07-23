import java.util.*;
import java.io.*;
 
public class entry_1981622 {
 
	static int mod = (int) 1e9 + 7;
 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] c = sc.nextIntArr(n);
		int[][] dp = new int[2][x + 1];
		dp[1][0] = 1;
		for (int cur = n - 1; cur >= 0; cur--) {
			for (int rem = 0; rem <= x; rem++) {
				dp[0][rem] = (dp[1][rem] + ((rem - c[cur] < 0) ? 0 : dp[0][rem - c[cur]])) % mod;
			}
			dp[1] = dp[0];
		}
		pw.println(dp[1][x]);
		pw.close();
	}
 
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}
 
	}
 
}