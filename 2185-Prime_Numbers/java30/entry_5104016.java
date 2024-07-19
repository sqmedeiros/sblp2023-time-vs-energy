import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class entry_5104016 {
    static Main2 admin = new Main2();
 
    public static void main(String[] args) {
        admin.start();
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
 
    BigInteger bi (long n) {return BigInteger.valueOf(n);}
 
    void solve() {
        long n = nl();
        int k = ni();
        long[] primes = nal(k);
        int N = (1 << k);
        long ans = 0;
        BigInteger cmp = bi(n);
        for(int i = 1; i < N; i++) {
            long made = 1;
            boolean f = false;
            for(int j = 0; j < k; j++) {
                if(((i >> j) & 1) == 1) {
                    BigInteger bi = bi(made).multiply(bi(primes[j]));
                    if(bi.compareTo(cmp) > 0) {
                        f = true;
                        break;
                    }
                    made *= primes[j];
                }
            }
            if(!f) {
                int freq = Integer.bitCount(i);
                ans += ((freq % 2 == 0) ? -1 : 1) * (n / made);
            }
        }
        p(ans);
    }
}