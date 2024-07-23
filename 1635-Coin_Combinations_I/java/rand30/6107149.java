import java.util.Scanner;
 
public class entry_6107149 {
    private static final int MOD = (int) (1e9 + 7);
 
    public static int caminhos(int[] coins, int x) {
        int n = coins.length;
        int[] dp = new int[x + 1];
        dp[0] = 1;
 
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
                }
            }
        }
 
        return dp[x];
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
 
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
 
        int num = caminhos(coins, x);
 
        System.out.println(num);
 
        scanner.close();
    }
}