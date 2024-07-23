import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class entry_5180480 {
    private static final int mod = (int)1e9+7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int sum = Integer.parseInt(inp[1]);
        int[] coin = new int[n];
        inp = br.readLine().split(" ");
        for(int i=0;i<n;i++) coin[i] = Integer.parseInt(inp[i]);
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 1 ; i <= sum; i++){
            // long p = 0l;
            for(int j = 0; j < n; j++){
                if(coin[j] <= i)
                    // p = dp[i] + dp[i-coin[j]];
                    dp[i] = (dp[i] + dp[i-coin[j]]) % mod;
                    // if(p > mod) p -= mod;
            }
            // dp[i] = (int)p;
        }
        
        System.out.println(dp[sum]);
        br.close();
    }
}