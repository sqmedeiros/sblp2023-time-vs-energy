import java.io.*;
import java.util.*;
 
import static java.lang.Math.*;
 
public class entry_5434616 {
 
    private static final int MOD = 1000000007;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
 
        String s1 = br.readLine();
        String s2 = br.readLine();
 
        int n = s1.length();
        int m = s2.length();
        long[][] dp = new long[n + 1][m + 1];
 
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
//        System.err.println(Arrays.deepToString(dp));
 
        PrintWriter writer = new PrintWriter(System.out);
        writer.println(dp[n][m]);
        writer.close();
    }
}