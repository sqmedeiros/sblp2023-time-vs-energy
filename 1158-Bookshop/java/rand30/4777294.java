import java.util.*;
public class entry_4777294 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0; i<n ; i++){
            h[i]= sc.nextInt();
        }
        int[] s = new int[n];
        for(int j = 0; j<n ; j++){
            s[j]= sc.nextInt();
        }
        int[] dp = new int[x+1];
        // Arrays.sort()
        for(int j  =0; j<n ;j ++){
            for(int i = x; i >=0; i--){
              //  int max = 0;
                if (h[j] <=i){
                    dp[i] = Math.max(dp[i-h[j]] + s[j] , dp[i]);
                }
            }
        }
        // for (int i  : dp){
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        int max =0;
        for(int i  = 1; i<=x ; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
 
 
    }
    
}