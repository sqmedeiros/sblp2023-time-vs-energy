import java.util.*;
public class entry_5883143 {
	public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        String word2=sc.next();
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int j=0;j<=m;j++) {dp[0][j]=j;}
        for(int i=0;i<=n;i++) {dp[i][0]=i;}
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else 
                {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(
                                      dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        int ans=dp[n][m];
        System.out.println(ans);
        
        
    }
}
      
 