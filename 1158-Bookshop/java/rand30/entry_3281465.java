import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//https://cses.fi/problemset/task/1158
public class entry_3281465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int x = Integer.parseInt(token.nextToken());
		
		int[] h = new int[n];
		int[] s = new int[n];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(token.nextToken());
		}
 
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(token.nextToken());
		}
		
		int[] dp = new int[x+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = x; j >= h[i-1]; j--) {
				dp[j] = Math.max(dp[j], s[i-1] + dp[j-h[i-1]]);
			}
		}
		
		System.out.println(dp[x]);
	}
 
}