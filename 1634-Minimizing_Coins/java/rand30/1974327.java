import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_1974327 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int coins[] = new int[n];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		System.out.println(getMinCoinsOptimized(coins, sum));
	}
 
	private static int getMinCoinsOptimized(int coins[], int sum){
		int dp[] = new int[sum+1];
		Arrays.fill(dp, Integer.MAX_VALUE- coins[0]);
		dp[0] = 0;
 
		for(int i = 1; i < dp.length; i++){
			for(int j = 0; j < coins.length; j++){
				if(i - coins[j] >= 0 )dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		
		return dp[sum] == Integer.MAX_VALUE - coins[0] ? -1:dp[sum];
	}
}