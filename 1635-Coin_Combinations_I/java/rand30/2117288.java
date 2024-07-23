import java.io.*;
import java.util.*;
public class entry_2117288 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		long[] dp = new long[x + 1];
		dp[0] = 1;
		int[] arr = new int[n];
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= x; i ++) {
			if((long) dp[i] == 0L) continue;
			for(int j = 0; j < n; j ++) {
				if(i + arr[j] <= x) {
					dp[i + arr[j]] += (long) dp[i];
					dp[i + arr[j]] %= 1000000007;
				}
			}
 		}
		System.out.println(dp[x]);
	}
}