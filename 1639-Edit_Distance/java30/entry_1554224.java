/******************************************************************************
 
                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.
 
*******************************************************************************/
import java.util.*;
public class entry_1554224
{
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i = 0; i <= a.length(); i++) dp[i][0] = i;
		for(int i = 0; i <= b.length(); i++) dp[0][i] = i;
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					int temp = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.min(dp[i-1][j-1], temp)+1;
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}
}