
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
 
public class entry_646963 {
    final static long MOD = 1000000007;
    static StringBuilder last = new StringBuilder();
    static long counter = 0;
    public static void main(String args[]) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
 
        int n = fs.nextInt();
 
        long [] a = fs.nextLongArray(n);
 
        HashSet<Long> hs = new HashSet<>();
 
        Arrays.stream(a).forEach(hs::add);
        out.println(hs.size());
        out.flush();
        out.close();
    }
 
 
    static String repeat(char ch, int n) {
        StringBuilder sb = new StringBuilder(n);
        counter++;
        for(int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                //                br = new BufferedReader(new FileReader("file2.txt"));
                st = new StringTokenizer("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        public String next() {
            if (st.hasMoreTokens())
                return st.nextToken();
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }
 
        public char nextChar() {
            return next().charAt(0);
        }
 
        public Integer[] nextIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
 
        public char[] nextCharArray() {
            return nextLine().toCharArray();
        }
    }
 
}
 
 