import java.util.Scanner;
 
public class entry_785063 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int x = s.nextInt();
    int[] prices = new int[n];
    int[] pages = new int[n];
    for (int i = 0; i < n; i++) prices[i] = s.nextInt();
    for (int i = 0; i < n; i++) pages[i] = s.nextInt();
 
    int[] dp = new int[x+1];
    for (int i = 0; i < n; i++) {
      for (int j = x; j >= 1; j--) {
        if (j >= prices[i]) dp[j] = Math.max(dp[j], dp[j-prices[i]] + pages[i]);
      }
    }
 
    System.out.println(dp[x]);
  }
}