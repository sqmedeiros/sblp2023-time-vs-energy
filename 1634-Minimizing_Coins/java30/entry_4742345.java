import java.util.Scanner;
 
public class entry_4742345 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr, n, x));
    }
 
    static int solve(int[] arr, int n, int x){
        int[] dp = new int[x+1];
        dp[0] = 0;
 
        for(int i = 1; i<=x; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<n; j++){
                if(i - arr[j] >= 0 && dp[i-arr[j]] != -1)
                    min = Math.min(min, dp[i - arr[j]]+1);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[x];
    }
}