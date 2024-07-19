import java.io.*;
import java.util.*;
 
public class entry_326599 {
	static int mod = 1000000007;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] books = new int[n][2];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n; k++) {
				books[k][i] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dp = new int[x + 1];
		for (int k = 1; k <= n; k++) {
			for (int i = x; i >= 1; i--) {
				if (i - books[k - 1][0] >= 0) {
					dp[i] = Math.max(dp[i], dp[i - books[k - 1][0]] + books[k - 1][1]);
				}
			}
		}
 
		System.out.print(dp[x]);
	}
}