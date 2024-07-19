import java.util.Scanner;
 
public class entry_6107063 {
    private static final int MOD = 1000000007;
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
 
        int sum = input.nextInt();
        int[] coins = new int[number];
        for (int i = 0; i < number; i++) {
            coins[i] = input.nextInt();
        }
        int combination = calcWays(coins, sum);
 
        System.out.println(combination);
    }
 
    public static int calcWays(int[] coins, int sum) {
        int[] ways = new int[sum + 1];
 
        ways[0] = 1;
        for (int i = 1; i <= sum; i++) {
 
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
 
                    ways[i] = (ways[i] + ways[i - coins[j]]) % MOD;
                }
            }
 
        }
        return ways[sum];
    }
}