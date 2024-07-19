import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author krobin_93
 */
public class entry_2220798 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        TestCaseReader in = new TestCaseReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CoinCombinationsI solver = new CoinCombinationsI();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class CoinCombinationsI {
        static final int modulo = 1000000000 + 7;
 
        public void solve(int testNumber, TestCaseReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
//        HashSet<Integer> uniqueCoinsSet = new HashSet<>();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
//            uniqueCoinsSet.add(in.nextInt());
                coins[i] = in.nextInt();
            }
//        int numberOfWays = countWays(uniqueCoinsSet, x);
            int numberOfWays = countWays(coins, x);
 
            out.println(numberOfWays);
        }
 
        private int countWays(int[] coins, int sum) {
            int[] dp = new int[sum + 1];
 
            dp[0] = 1;//empty set when the coin and sum are same in which case the sub-problem will be of sum=0
 
            for (int i = 1; i <= sum; i++) {
                for (int j = 0; j < coins.length; j++) {
                    int coin = coins[j];
                    if (i - coin >= 0 && dp[i - coin] > 0) {
                        dp[i] = (dp[i] + dp[i - coin]) % modulo;
                    }
                }
            }
 
            return dp[sum] % modulo;
        }
 
    }
 
    static class TestCaseReader {
        private static final int MAX_BUFFER = 65536;
        private DataInputStream dataInputStream;
        private byte[] buffer;
        private int current;
        private int byteCount;
 
        public TestCaseReader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[MAX_BUFFER];
        }
 
        public TestCaseReader(String file_name) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[MAX_BUFFER];
        }
 
        public TestCaseReader(DataInputStream dis) throws IOException {
            this.dataInputStream = dis;
            buffer = new byte[MAX_BUFFER];
        }
 
        public TestCaseReader(InputStream inputStream) {
            this.dataInputStream = new DataInputStream(inputStream);
            buffer = new byte[MAX_BUFFER];
        }
 
        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public byte read() {
            if (byteCount == -1)
                throw new InputMismatchException();
            if (current >= byteCount) {
                current = 0;
                try {
                    byteCount = dataInputStream.read(buffer, current, MAX_BUFFER);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (byteCount <= 0)
                    return -1;
            }
            return buffer[current++];
        }
 
    }
}
 