import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class entry_5053516 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = scan.nextInt();
        }
        long value[] = new long[t+1];
        value[0] = 0;
 
        for(int i = 1; i<=t; i++){
            value[i] = Integer.MAX_VALUE;
 
            for(int c:coins){
                if(i-c>=0){
                    value[i] = Math.min(value[i], value[i-c]+1);
                }
            }
        }
        System.out.println(value[t]==Integer.MAX_VALUE ? -1: value[t]);
    }
 
//   dice combinations list#6
//    static int MOD = (int)Math.pow(10, 9) +7;
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int sum = scan.nextInt();
//        int[] dp = new int[sum+1];
//        dp[0] = 1;
//
//        for(int i = 1; i<=sum; i++){
//            for(int j = 1; j<=6; j++) {
//                if (i - j >= 0) {
//                    dp[i] += dp[i - j];
//                    dp[i]%= MOD;
//
//                }
//            }
//
//        }
//        System.out.println(dp[sum]);
//
//    }
}