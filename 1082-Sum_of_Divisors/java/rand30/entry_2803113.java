import java.io.*;
import java.util.StringTokenizer;
 
public class entry_2803113 {
    static long sqrt;
    static int mod = (int) 1e9 + 7;
    static long modInv;
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int tests = 1;
        for (int test = 0; test < tests; test++) {
            long n = sc.nextLong();
            long ans = 0;
            for (long i = 1; i * i <= n; i++) {
                ans += (n / i) * i;
                ans %= mod;
            }
            modInv = modPow(2, mod - 2);
            sqrt = (long) Math.sqrt(n);
            for (long i = 1; i * i <= n; i++) {
                long right = n / i;
                if (right <=sqrt)
                    break;
                ans += (i * sum(right)) % mod;
                ans %= mod;
                long left = n / (i + 1) + 1;
                if (left <=sqrt)
                    left = sqrt + 1;
                ans -= (i * sum(left - 1)) % mod;
                ans += mod;
                ans %= mod;
 
            }
            pw.println(ans);
        }
 
        pw.flush();
    }
 
 
    static long sum(long x) {
        x %= mod;
        return (((x * (x + 1)) % mod )* modInv)%mod;
    }
 
 
    private static long modPow(long b, int p) {
        b %= mod;
        long res = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                res *= b;
                res %= mod;
            }
            b *= b;
            b %= mod;
            p /= 2;
        }
        return res;
    }
 
    public static class Scanner {
        StringTokenizer st;
        BufferedReader br;
 
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
 
        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        }
 
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}