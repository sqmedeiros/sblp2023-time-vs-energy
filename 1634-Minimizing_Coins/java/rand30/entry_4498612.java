import java.io.*;
import java.util.InputMismatchException;
 
public class entry_4498612 {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int k = io.nextInt();
        int sum = 0;
        int coins[] = new int[n];
        int[] dp = new int[k + 1];
                for (int i = 0; i < n; i++)
                {
                    coins[i] = io.nextInt();
                }
                for (int i = 0; i <= k; i++) {
                    dp[i] = (int)1000000000;
                }
                dp[0] = 0;
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j <= k; j++) {
                        if (j - coins[i - 1] >= 0) {
                            dp[j] = Integer.min(dp[j], dp[j - coins[i - 1]] + 1);
                            //При выполнении условия curWeight(j by k) - coin[i](curr coin from array)
                            //DP[curWeight] = min(DP[curWeight], DP[curWeight - coin[i]] + 1). */
                        }
                    }
                };
        System.out.println(dp[k] == 1000000000 ? -1 : dp[k]);
            }
 
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;
 
        // standard input
        public FastIO() {
            this(System.in, System.out);
        }
 
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
 
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
 
        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }
 
        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
 
        public int nextInt() { // nextLong() would be implemented similarly
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}