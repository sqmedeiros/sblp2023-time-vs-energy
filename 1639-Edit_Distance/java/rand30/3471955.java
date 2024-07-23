 
 
import java.util.Arrays;
import java.util.Scanner;
 
public class entry_3471955 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		 
		
		
		mss(a, b);
	}
	
	public static void mss(String a, String b) {
		
		int[][] dp = new int[a.length()+1][b.length()+1];
 
		for(int i = 0; i < a.length()+1; i++) {
			dp[i][0] = i;
		}
 
		for(int i = 0; i < b.length()+1; i++) {
			dp[0][i] = i;
		}
		
		
		for(int i = 1; i < a.length()+1; i++) {
			for(int j = 1; j < b.length()+1; j++) {
				int d = a.charAt(i-1) == b.charAt(j-1) ? 0 : 1;
				dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+d, dp[i][j-1]+1), dp[i-1][j]+1);
				
			}
		}
		
		
		System.out.println(dp[a.length()][b.length()]);
		
		
	}
	
	
 
}