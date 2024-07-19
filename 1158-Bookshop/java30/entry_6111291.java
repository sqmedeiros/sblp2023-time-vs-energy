import java.util.Scanner;
 
public class entry_6111291 {
    static final int mod = (int) 1e9 + 7;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int h[] = new int[n];
        int s[] = new int[n];
        int dp[] = new int[x + 1];
        for (int i = 0; i < n; i++){
            h[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = x; j >= h[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - h[i]] + s[i]);
            }
        }
 
        System.out.println(dp[x]);
    }
}
 
