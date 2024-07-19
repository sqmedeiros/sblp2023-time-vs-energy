import java.util.*;
import java.io.*;
 
public class entry_2011921 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
//        BufferedReader in = new BufferedReader(new FileReader("in.in"));
//        PrintWriter out = new PrintWriter(new FileWriter("out.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int numCoins = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] coins = new int[numCoins];
        StringTokenizer stc = new StringTokenizer(in.readLine());
        for (int i = 0; i < numCoins; i++) {
            coins[i] = Integer.parseInt(stc.nextToken());
        }
        Arrays.sort(coins);
        int[] numWays = new int[sum + 1];
        numWays[0] = 1;
        // finds all money sums with the largest coin as coins[cIndex]
        for (int cIndex = 0; cIndex < numCoins; cIndex++) {
            for (int i = coins[cIndex]; i <= sum; i++) {
                numWays[i] = (numWays[i] + numWays[i - coins[cIndex]]) % 1000000007;
            }
        }
        out.println(numWays[sum]);
        out.close();
    }
}