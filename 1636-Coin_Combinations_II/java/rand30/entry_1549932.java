import java.util.*;
class entry_1549932 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int k = obj.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = obj.nextInt();
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j - num[i] >= 0) dp[j] += dp[j - num[i]];
                dp[j]%=1000000007;
            }
        }
        System.out.println(dp[k]);
    }
}