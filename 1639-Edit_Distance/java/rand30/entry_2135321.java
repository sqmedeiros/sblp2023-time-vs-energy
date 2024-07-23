import java.util.Scanner;
 
public class entry_2135321 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) dp[i][0] = i;
        for(int j = 1; j <= m; j++) dp[0][j] = j;
 
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
 
 
/**
 * 
 * 
 * we can maintain states as we traverse through the strings
 * 
 * dp[i][j] denotes the string a is traversed through length 0 to i-1 and b is traversed
 * through length 0 to j-1
 * 
 * dp[n][m] is the answer after traversing both the strings complete
 * 
 * dp[i][j] = if(a[i] == b[j]) -> dp[i-1][j-1]
 *          = else             -> min of dp[i-1][j] or dp[i][j-1] or dp[i-1][j-1]
 * 
 * dp[0][0] = 0
 * dp[0][i] = i
 * dp[i][0] = i
 * 
 * space complexity = O(n*m)
 * time complexity = O(n*m)
 */