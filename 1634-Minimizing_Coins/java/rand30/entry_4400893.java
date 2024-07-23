import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class entry_4400893 {
	static int n, t, w;
	static long cnt, mod = (int) 1e9 + 7;
	static int[] arr;
	static int[] memo, rem;
	static String s1, s2, s3 = "";
	static int wady, x;
	static PrintWriter pw = new PrintWriter(System.out);
 
	public static void solve() {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] < x + 1)
				rem[arr[i]] = 1;
		for (int i = 0; i < x + 1; i++) {
			if (rem[i] == 1)
				continue;
			rem[i] = (int) 1e7;
			// System.out.println(n);
			for (int j = 0; j < n; j++) {
				if (i - arr[j] > 0)
					rem[i] = Math.min(rem[i], 1 + rem[i - arr[j]]);
			}
		}
		if(rem[x]==(int )1e7)
			pw.print(-1);
		else
		pw.print(rem[x]);
 
	}
 
	public static void main(String[] args) throws Exception {
 
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		rem = new int[x + 1];
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		// Arrays.sort(arr, Collections.reverseOrder());
 
		// Arrays.fill(rem, Integer.MAX_VALUE);
 
		solve();
		pw.close();
	}
 
	static int dp(int i, int remaining) {
		if (remaining == 0)
			return 0;
 
		if (i == arr.length)
			return (int) 1e8;
 
		if (rem[remaining] != -1)
			return rem[remaining];
		int take = (int) 1e8, leave = (int) 1e8;
		if (remaining - arr[i] >= 0)
			take = 1 + dp(i, remaining - arr[i]);
 
		leave = dp(i + 1, remaining);
		// leave2 = dp(i, j + 1);
		return rem[remaining] = Math.min(take, leave);
 
	}
 
	static void build(int i, int j) {
 
		if (i == s1.length() || j == s2.length())
			return;
 
		int ans = -1, leave1 = 0, leave2 = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
 
			ans = 1 + dp(i + 1, j + 1);
		}
		leave1 = dp(i + 1, j);
		leave2 = dp(i, j + 1);
		int res = Math.max(ans, Math.max(leave1, leave2));
		if (res == ans) {
			pw.print(s1.charAt(i));
			build(i + 1, j + 1);
		} else if (res == leave1) {
			build(i + 1, j);
		} else
			build(i, j + 1);
		// return memo[i][j] = Math.max(ans, Math.max(leave1, leave2));
 
	}
 
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
	}
 
}