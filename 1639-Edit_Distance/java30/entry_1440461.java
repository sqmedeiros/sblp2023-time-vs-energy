import java.util.*;
import java.io.*;
 
public class entry_1440461 {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String first = in.next();
        String last = in.next();
        int[][] dp = new int[first.length() + 1][last.length() + 1];
        for (int i = 0; i <= first.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= last.length(); j++) dp[0][j] = j;
 
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= last.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (first.charAt(i - 1) == last.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.min(Math.min(dp[i][j] - 1, dp[i - 1][j]), Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }
        out.println(dp[first.length()][last.length()]);
        out.close();
 
    }
 
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                return nextLine();
            }
 
            String ret = "";
            while (st.hasMoreTokens()) {
                ret += st.nextToken();
            }
            return ret;
        }
        public int[] nextIntArr(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
        public long[] nextLongArr(int size) throws IOException {
            long[] arr = new long[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
        public double[] nextDoubleArr(int size) throws IOException {
            double[] arr = new double[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }
    }
}