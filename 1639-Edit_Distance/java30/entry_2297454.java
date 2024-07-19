//https://cses.fi/problemset/task/1639
//Edit Distance
import java.util.*;
import java.io.*;
public class entry_2297454{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
 
		String s = br.readLine();
		int m = s.length();
		String s1 = br.readLine();
		int n = s1.length();
 
		int dp[][] = new int[m+1][n+1];
		for(int i=1;i<=m;i++)
			dp[i][0] = i;
		for(int j=1;j<=n;j++)
			dp[0][j] = j;
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
				if(s.charAt(i-1)!=s1.charAt(j-1))
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
				else
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
			}
		}
					
		pw.print(dp[m][n]);
		pw.flush();
		pw.close();
	}
}