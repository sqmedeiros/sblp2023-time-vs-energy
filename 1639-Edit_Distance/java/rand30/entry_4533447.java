import java.util.Scanner;
 
public class entry_4533447 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String target = scanner.nextLine();
        int ans = editDistance(src,target);
        System.out.println(ans);
    }
 
    private static int editDistance(String src, String target) {
        int m = src.length();
        int n = target.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            dp[i][0] =i;
        }
          for (int j = 0; j <=n; j++) {
	           dp[0][j] =j;
          }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] =Integer.MAX_VALUE;
                int bool =1;
                if(src.charAt(i-1)==target.charAt(j-1))
                    bool=0;
                dp[i][j] = Math.min(dp[i-1][j-1]+bool,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        return dp[m][n];
    }
}
