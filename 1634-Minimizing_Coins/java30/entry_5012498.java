/**
 * author: kevy15
 * date: 11/22/2022
 */
 
import java.io.*;
import java.util.*;
 
public class entry_5012498 {
 
    static int max = (int) 1e9;
 
    public static void solve() {
        int N = in.nextInt();
        int X = in.nextInt(); // desired sum of money
        int[] coinValues = new int[N];
        for (int i = 0; i < N; i++) {
            coinValues[i] = in.nextInt();
        }
        Arrays.sort(coinValues);
 
        int[] dp = new int[X + 1];
        Arrays.fill(dp, max);
        for (int c : coinValues) {
            if (c <= X) { // BUG: throw out coin values that are too big, bigger than sum needed
                dp[c] = 1;
            }
        }
 
        for (int i = coinValues[0]; i <= X; i++) {
            if (dp[i] != max) continue;
 
            int minCoins = max;
            for (int c : coinValues) {
                if (i - c >= coinValues[0]) {
                    minCoins = Math.min(minCoins, dp[i - c]);
                }
            }
 
            if (minCoins == max) {
                dp[i] = max;
            } else {
                dp[i] = minCoins + 1;
            }
        }
 
//        System.out.println(Arrays.toString(dp));
        pw.println(dp[X] == max ? -1 : dp[X]);
    }
 
 
    // region CP-BOILERPLATE
    // CP BOILERPLATE TEMPLATE
 
    static InputReader in;
    static PrintWriter pw;
 
    public static void main(String[] args) throws IOException {
        in = new InputReader();
        pw = new PrintWriter(System.out);
 
        solve();
        pw.close();
    }
 
    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;
 
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public InputReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }
 
        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    //endregion
}