import java.util.Arrays;
import java.util.Scanner;
public class entry_3863672 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int denoms = s.nextInt(), sum = s.nextInt();
        int[] coins = new int[denoms], dp = new int[sum+1];
        for(int i=0;i<denoms;i++)
            coins[i]=s.nextInt();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<denoms;j++)
                if(coins[j]<=i && dp[i-coins[j]] < Integer.MAX_VALUE) //i is the num at that array index
                    dp[i]=Math.min(dp[i-coins[j]] + 1, dp[i]);
        if(dp[sum]==Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(dp[sum]);
    }
}