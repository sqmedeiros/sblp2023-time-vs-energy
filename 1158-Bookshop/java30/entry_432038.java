import java.util.Scanner;
 
public class entry_432038 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] dp = new int[x + 1];
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = x; j > 0; j--) {
                if (j - prices[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - prices[i]] + pages[i]);
                }
            }
        }
        System.out.println(dp[x]);
    }
}