import java.util.*;
import java.io.*;
 
public class entry_5138435 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[x + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= x; j++) {
				if (j - arr[i] >= 0) {
					dp[j] += dp[j - arr[i]];
					dp[j] %= 1000000007;
				}
			}
		}
		out.println(dp[x]);
		out.close();
		f.close();
	}
 
}