import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_1080116 implements AutoCloseable {
    public static void main(String[] args) {
        try(
                entry_1080116 coinCombinations  = new entry_1080116();
        ) {
            coinCombinations.solve();
        }
    }
 
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    PrintWriter output = new PrintWriter(System.out);;
    StringTokenizer tokens;
 
    int INF = (int)1e9+7;
    public void solve() {
        int k = nextInt();
        int total = nextInt();
 
        int[] coins = new int[k];
        for (int i = 0; i < k; i++) {
            coins[i] = nextInt();
        }
 
        //Arrays.sort(coins);
 
        int[] dp = new int[total+1];
        dp[0] = 1;
        for (int j = 1; j <= total; j++) {
            long sum = 0;
            for (int i = 0; i < k; i++) {
                if (j -  coins[i] >= 0) {
                    sum += dp[j - coins[i]];
                }
            }
            dp[j] = (int)(sum % INF);
        }
        printLine(dp[total]);
    }
 
    public void print(Object n) {
        output.print(n);
    }
 
    public void printLine(Object n) {
        output.println(n);
    }
 
    public void close() {
        output.close();
    }
 
    private long nextLong() {
        String token = getString();
        return Long.parseLong(token);
    }
 
    private int nextInt() {
        String token = getString();
        return Integer.parseInt(token);
    }
 
 
    private String getString() {
        if (tokens == null || !tokens.hasMoreTokens()){
            getLineTokenizer();
        }
 
        return tokens.hasMoreTokens() ? tokens.nextToken(): null;
 
    }
    private boolean getLineTokenizer() {
        try {
            String line = reader.readLine();
 
            tokens = new StringTokenizer(line);
            return tokens.hasMoreTokens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
 
