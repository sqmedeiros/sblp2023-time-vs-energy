import java.io.*;
import java.util.*;
 
public class entry_2760257 {
    static FastScanner fs;
    static PrintWriter pw;
 
    public static void main(String[] args) {
        fs = new FastScanner();
        pw = new PrintWriter(System.out);
 
//        for (int i = 0, j = fs.nextInt(); i < j; i++)
            solve();
 
 
        pw.close();
    }
 
    public static void solve() {
        long n = fs.nextLong();
        long ans = 0;
        int MOD = 1000000007;
        for (long i = 1, j; i <= n; i = j) {
            long q = n/i; j = n/q+1;
            long x = j-i, y = i+j-1;
            if (x%2 == 0) x /= 2;
            else y /= 2;
            x %= MOD;
            y %= MOD;
            ans = (ans+q%MOD*x%MOD*y%MOD)%MOD;
        }
        pw.println(ans);
    }
 
    //    static int k;
//    static int par(int curr) {
//        return (1<<k)-1-(((1<<k)-1-curr)/2);
//    }
//    static int left(int curr) {
//        return (1<<k)-1-(2*((1<<k)-1-curr)+1);
//    }
//    static int right(int curr) {
//        return (1<<k)-1-(2*((1<<k)-1-curr));
//    }
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
 
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
 
    static final Random random = new Random();
 
    static class FastScanner {
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
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
    static int[] reverse(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = a[n - 1 - i];
        return res;
    }
}