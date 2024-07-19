// package cses.dynamicProgramming;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_1990884 {
	public static void main(String args[]) throws Exception {
		// long t1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int coins[] = new int[Integer.parseInt(st.nextToken())];
		int sum = Integer.parseInt(st.nextToken());
 
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i< coins.length; i++) coins[i] = Integer.parseInt(st.nextToken());
		br.close();
 
		System.out.println(getWays(coins, sum));
		// System.out.println((System.currentTimeMillis() - t1) +" ms");
	}
 
 
	private static int getWays(int coins[], int sum){
		int mod = (int)1e9+7;
 
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int i = 0; i < coins.length; i++){ 
			for(int j = coins[i]; j < dp.length; j++){
				dp[j] += dp[j - coins[i]];
				while(dp[j] >= mod) dp[j] -= mod;
			}
 
			// System.out.println(Arrays.toString(dp));
		}
 
		// for(int i = 1; i < dp.length; i++){
		// 	for(int j = 0; j < coins.length; j++){
		// 		if(i - coins[j] > -1){
		// 			dp[i] += dp[i- coins[j]];
		// 		}
		// 	}
 
		// 	if(dp[i] > mod) dp[i] %= mod;
		// 	System.out.println(Arrays.toString(dp));
		// }
 
 
		while(dp[sum] > mod) dp[sum] -= mod;
		return (int)dp[sum];
	}
}