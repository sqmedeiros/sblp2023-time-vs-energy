//package Concepts.CSES;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class entry_2747499 {
    static long mod = (long) 1e9 + 7;
 
    public static void main(String[] args) {
        fs = new FastScanner();
        long n = fs.nextLong();
        long ans = 0;
        for (long i = 1, j; i <= n; i = j) {
 
            long q = n / i;
            j = n / q + 1;
 
            long x = j - i, y = i + j - 1; // x*y/2 = sum(i..j-1)
 
            if (x % 2 == 0) x /= 2;
 
            else y /= 2;
 
            x %= mod;
            y %= mod;
            ans = (ans + q % mod * x % mod * y % mod) % mod;
        }
        System.out.println(ans);
    }
 
    static PrintWriter out;
    static FastScanner fs;
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}