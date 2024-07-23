import  java.lang.*;
import java.util.*;
public class entry_5643148 {
    public static void main(String[] args) {
        
        Scanner test = new Scanner(System.in);
        int n = test.nextInt();
        int mod = (int) 1e9 + 7;
        int sum = test.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = test.nextInt();
        }
        // int[][] dp=new int[n][sum+1];
        int[] prev = new int[sum + 1];
        prev[0]=1;
 
        for (int ind = 0; ind < n; ind++) {
            // int[] cur = new int[sum + 1];
            for (int target = 0; target <= sum; target++) {
                // int not_pick = prev[target]%mod;
                // int pick = 0;
                if (target - arr[ind] >= 0) {
                    prev[target] += prev[target - arr[ind]];
                    prev[target]=prev[target]%mod;
 
                }
                
                // out.print(dp[ind][target]+" ");
            }
            // prev = cur;
            // out.println();
 
        }
 
        System.out.println(prev[sum]);
    }
}