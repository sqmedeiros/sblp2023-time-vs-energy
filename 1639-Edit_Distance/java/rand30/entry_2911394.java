import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class entry_2911394 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int ed = solve(s1, s2);
		System.out.println(ed);
	}
 
	private static int solve(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[][] dp = new int[n1+1][n2+1];
		for(int i = 0; i <= n1; i++)
		{
			for(int j = 0; j <= n2; j++)
			{
				if(i == 0) { dp[i][j] = j; continue; }
				if(j == 0) { dp[i][j] = i; continue; }
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
		return dp[n1][n2];
	}
}