 
import java.util.*;
 
public class entry_2860240 {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int x = scanner.nextInt();
        int[]c = new int[n];
        int[]dp = new int[x+1];
        Arrays.fill(dp, (int) 1e7);
        dp[0] = 0;
        for (int i=0;i<n;i++){
            c[i] = scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            for (int j=c[i];j<=x;j++){
                dp[j] = Math.min(dp[j],dp[j-c[i]]+1);
            }
        }
        if (dp[x]==1e7){
            System.out.println(-1);
        }else
            System.out.println(dp[x]);
    }
}