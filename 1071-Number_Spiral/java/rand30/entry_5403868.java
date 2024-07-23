// Author: Jun Wang
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class entry_5403868 {
 
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
 
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            long row = sc.nextLong();
            long col = sc.nextLong();
            out.println(find(row, col));
        }
 
        out.close();
    }
 
    static long find(long row, long col) {
        if (col > row) {
            if (col % 2 == 1) {
                return col * col - row + 1;
            } else {
                return (col - 1) * (col - 1) + row;
            }
        } else {
            if (row % 2 == 1) {
                return (row - 1) * (row - 1) + col;
            } else {
                return row * row - col + 1;
            }
        }
    }
 
    /* ----- Pre-defined Resources ----- */
    static final int mod = 1_000_000_007;
 
    static long add(long a, long b) {
        return (a + b) % mod;
    }
 
    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }
 
    static long mul(long a, long b) {
        return (a * b) % mod;
    }
 
    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }
 
    static class MyScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens())
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
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }
}