import java.util.*;
class entry_3233258 {
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int sum = sc.nextInt();
  int[] coin = new int[n];
  for(int i = 0; i < n; i++) {
    coin[i] = sc.nextInt();
  }
 
  System.out.println(dynamic(coin, sum));
}
static long dynamic(int[] coin, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for(int i = 0; i < coin.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if(coin[i] > j) continue;
                dp[j] = dp[j] % 1000000007 + dp[j - coin[i]] % 1000000007;
            }
        }
        return dp[sum] % 1000000007;
}
}