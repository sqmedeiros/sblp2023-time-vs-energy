import java.util.*;
 
public class entry_2179913 {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int x = kb.nextInt();
        int []coins = new int[n];
        for(int i=0; i<n; i++)
            coins[i] = kb.nextInt();
        
        long []dp = new long[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=x; i++){
            for(int j=0; j<n; j++){
                if(i-coins[j] >= 0)
                    dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
            }
        }
        if(dp[x] == Integer.MAX_VALUE)
            dp[x] = -1;
        System.out.println(dp[x]);
    }
}