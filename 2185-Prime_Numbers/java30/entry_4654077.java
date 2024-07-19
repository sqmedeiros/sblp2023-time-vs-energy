import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
 
 
 
public class entry_4654077 {
     public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int tt = 1;
        while(tt-->  0) {
            long n  = fastReader.nextLong();
            int k = fastReader.nextInt();
            long a[] = fastReader.rla(k);
            long val []  = new long[k+1];
            for(int i = 1; i < (1<<k) ; i++){
                int numberOfSetBits = 0;
                long tmp = n;
                for(int j = 0 ; j < k ; j++){
                    if((i&(1<<j)) > 0){
                        numberOfSetBits++;
                        tmp/=a[j];
                    }
                }
                val[numberOfSetBits]+=tmp;
            }
            long ans = 0 ;
            for(int i = 1; i <= k ; i++){
                if(i%2 == 0){
                    ans-=val[i];
                }else{
                    ans+=val[i];
                }
 
            }
            out.println(ans);
        }
 
 
 
         out.close();
     }
 
 
 
 
 
 
    static class Pair{
        int x;
        int len;
        Pair(int x, int len){
            this.x  = x;
            this.len = len;
        }
 
        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", len=" + len +
                    '}';
        }
    }
 
 
    // constants
    static final int IBIG = 1000000007;
    static final int IMAX = 2147483647;
    static final long LMAX = 9223372036854775807L;
    static Random __r = new Random();
 
    // math util
    static int minof(int a, int b, int c) {
        return min(a, min(b, c));
    }
 
    static int minof(int... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return min(x[0], x[1]);
        if (x.length == 3)
            return min(x[0], min(x[1], x[2]));
        int min = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] < min)
                min = x[i];
        return min;
    }
 
    static long minof(long a, long b, long c) {
        return min(a, min(b, c));
    }
 
    static long minof(long... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return min(x[0], x[1]);
        if (x.length == 3)
            return min(x[0], min(x[1], x[2]));
        long min = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] < min)
                min = x[i];
        return min;
    }
 
    static int maxof(int a, int b, int c) {
        return max(a, max(b, c));
    }
 
    static int maxof(int... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return max(x[0], x[1]);
        if (x.length == 3)
            return max(x[0], max(x[1], x[2]));
        int max = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] > max)
                max = x[i];
        return max;
    }
 
    static long maxof(long a, long b, long c) {
        return max(a, max(b, c));
    }
 
    static long maxof(long... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return max(x[0], x[1]);
        if (x.length == 3)
            return max(x[0], max(x[1], x[2]));
        long max = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] > max)
                max = x[i];
        return max;
    }
 
    static int powi(int a, int b) {
        if (a == 0)
            return 0;
        int ans = 1;
        while (b > 0) {
            if ((b & 1) > 0)
                ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }
 
    static long powl(long a, int b) {
        if (a == 0)
            return 0;
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0)
                ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }
 
    static int fli(double d) {
        return (int) d;
    }
 
    static int cei(double d) {
        return (int) ceil(d);
    }
 
    static long fll(double d) {
        return (long) d;
    }
 
    static long cel(double d) {
        return (long) ceil(d);
    }
 
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
 
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
 
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
 
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
 
    static int[] exgcd(int a, int b) {
        if (b == 0)
            return new int[] { 1, 0 };
        int[] y = exgcd(b, a % b);
        return new int[] { y[1], y[0] - y[1] * (a / b) };
    }
 
    static long[] exgcd(long a, long b) {
        if (b == 0)
            return new long[] { 1, 0 };
        long[] y = exgcd(b, a % b);
        return new long[] { y[1], y[0] - y[1] * (a / b) };
    }
 
    static int randInt(int min, int max) {
        return __r.nextInt(max - min + 1) + min;
    }
 
    static long mix(long x) {
        x += 0x9e3779b97f4a7c15L;
        x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >> 27)) * 0x94d049bb133111ebL;
        return x ^ (x >> 31);
    }
 
    public static boolean[] findPrimes(int limit) {
        assert limit >= 2;
 
        final boolean[] nonPrimes = new boolean[limit];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
 
        int sqrt = (int) Math.sqrt(limit);
        for (int i = 2; i <= sqrt; i++) {
            if (nonPrimes[i])
                continue;
            for (int j = i; j < limit; j += i) {
                if (!nonPrimes[j] && i != j)
                    nonPrimes[j] = true;
            }
        }
 
        return nonPrimes;
    }
 
    // array util
    static void reverse(int[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            int swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    static void reverse(long[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            long swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    static void reverse(double[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            double swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    static void reverse(char[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            char swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    static void shuffle(int[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            int swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    static void shuffle(long[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            long swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    static void shuffle(double[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            double swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    static void rsort(int[] a) {
        shuffle(a);
        sort(a);
    }
 
    static void rsort(long[] a) {
        shuffle(a);
        sort(a);
    }
 
    static void rsort(double[] a) {
        shuffle(a);
        sort(a);
    }
 
    static int[] copy(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    static long[] copy(long[] a) {
        long[] ans = new long[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    static double[] copy(double[] a) {
        double[] ans = new double[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    static char[] copy(char[] a) {
        char[] ans = new char[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    static class FastReader {
 
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] ria(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(next());
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        long[] rla(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = Long.parseLong(next());
            return a;
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
    }
}