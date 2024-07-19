import java.io.*;
import java.util.*;
 
public class entry_5103564 {
    static Main2 admin = new Main2();
 
    public static void main(String[] args) {
        long start = System.nanoTime();
        admin.start();
        long end = System.nanoTime();
        System.err.println((end - start) * (1E-9));
    }
}
 
class Main2 {
    //---------------------------------INPUT READER-----------------------------------------//
    public BufferedReader br;
    StringTokenizer st = new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens()) {
            try { st = new StringTokenizer(br.readLine());} catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
 
    int ni() { return Integer.parseInt(next()); }
    long nl() { return Long.parseLong(next()); }
    double nd() { return Double.parseDouble(next()); }
    String ns() { return next(); }
 
    int[] na(long n) {int[]ret=new int[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    long[] nal(long n) {long[]ret=new long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
    Integer[] nA(long n) {Integer[]ret=new Integer[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    Long[] nAl(long n) {Long[]ret=new Long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
 
    //--------------------------------------PRINTER------------------------------------------//
    PrintWriter w;
    void p(int i) {w.println(i);} void p(long l) {w.println(l);}
    void p(double d) {w.println(d);} void p(String s) { w.println(s);}
    void pr(int i) {w.print(i);} void pr(long l) {w.print(l);}
    void pr(double d) {w.print(d);} void pr(String s) { w.print(s);}
    void pl() {w.println();}
 
    //--------------------------------------VARIABLES-----------------------------------------//
    long lma = Long.MAX_VALUE, lmi = Long.MIN_VALUE;
    int ima = Integer.MAX_VALUE, imi = Integer.MIN_VALUE;
    long mod = 1000000007;
 
    {
        w = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    //----------------------START---------------------//
    void start() {
        //int t = ni(); while(t-- > 0)
            solve();
 
        w.close();
    }
 
    long mp (long b, long x, long mod) {
        if (x == 0) return 1;
        if (x == 1) return b;
        if (x % 2 == 0) return mp (b * b % mod, x / 2, mod) % mod;
 
        return b * mp (b * b % mod, x / 2, mod) % mod;
    }
 
    long modInv2 = mp(2, mod - 2, mod) % mod;
 
    long sum (long a, long n, long d) {
        a %= mod;
        n %= mod;
        d %= mod;
        long ap = ((n) * (((2 * a) + (n - 1) * d) % mod)) % mod;
        return (ap * modInv2) % mod;
    }
 
    void solve() {
        long n = nl();
        long currentDivisor = 1;
        long ans = 0;
        while(currentDivisor <= n) {
            long amount = (n / currentDivisor);
            long lastDivisor = (n / amount);
            long elems = (lastDivisor - currentDivisor + 1);
            long sum = sum(currentDivisor, elems, 1) % mod;
            currentDivisor = lastDivisor + 1;
            ans += (sum * amount) % mod;
            ans %= mod;
        }
        p(ans);
    }
}