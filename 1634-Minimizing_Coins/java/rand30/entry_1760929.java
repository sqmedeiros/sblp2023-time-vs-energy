//https://cses.fi/problemset/task/1634
 
import java.util.*;
 
public class entry_1760929 {
 
    public static void main(String[] args) {
 
        long[] dp = new long[1000001];
        for (int i = 0; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
 
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
 
        dp[0] = 0;
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = s.nextInt();
 
        for (int value = 1; value <= x; value++) {
            for (int id = 0; id < n; id++) {
                if (value - coins[id] >= 0) {
                    dp[value] = Math.min(dp[value], dp[value - coins[id]] + 1);
                }
            }
        }
 
        if (dp[x] == Integer.MAX_VALUE) dp[x] = -1;
        System.out.println(dp[x]);
    }
}