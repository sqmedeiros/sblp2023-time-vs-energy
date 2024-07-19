//package dynammicprogramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class entry_3637127 {
 
	static final FastReader sc = new FastReader();
	static final PrintWriter out = new PrintWriter(System.out);
 
	static int[] sort(int[] arr) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i : arr) {
			a.add(i);
		}
		Collections.sort(a);
		for (int i = 0; i < a.size(); i++) {
			arr[i] = a.get(i);
		}
		return arr;
	}
 
	public static void main(String[] args) {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		int[] dp = new int[x + 1];
		Arrays.fill(dp, (int) 1e9);
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		dp[0] = 0;
		for (int i = 1; i <= x; i++) {
			for (int j = 0; j < n; j++) {
				if (i - c[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - c[j]] + 1);
				}
			}
		}
		out.println((dp[x] == (int)1e9) ? -1 : dp[x]);
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
}
 