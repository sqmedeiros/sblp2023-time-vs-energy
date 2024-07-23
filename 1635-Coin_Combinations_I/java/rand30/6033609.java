//package DpPatterns;
import java.util.Arrays;
import java.util.Scanner;
 
public class entry_6033609 {
 
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int x = s.nextInt();
		
		int[] coins = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = s.nextInt();
		}
		
		int ans = coinCombinations(coins,x);
		
		System.out.println(ans);
		
 
	}
	
	
	
	
			
		private static int coinCombinations(int[] coins, int x) {
			
			int[] dp = new int[x+1];
			
			dp[0] = 1;
			
			
			for(int i=1; i<=x; i++) {
				for(int j=0; j<coins.length; j++) {
					
					if(i>=coins[j]) {
						dp[i] = (dp[i]+dp[i-coins[j]])%1000000007;
					}
				}
			}		
			return dp[x];	
		}
			
		
 
}