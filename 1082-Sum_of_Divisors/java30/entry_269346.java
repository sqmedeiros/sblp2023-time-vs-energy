import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class entry_269346 {
 
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = 1;
        while (t --> 0) solver.solve(1, scan, out);
        out.close();
    }
 
    static class Task {
        static long MOD = (long) (1e9+7);
 
        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            long n = scan.nextLong();
            long ans = 0;
            for(long i = 1; i*i <= n; i++) {
                ans += (n/i)*i;
                ans %= MOD;
                if(n/i == i) continue;
                long high = n/i;
                long low = n/(i+1) + 1;
                ans += (sum(low, high)*i)%MOD;
                ans %= MOD;
 
            }
            out.println(ans);
        }
 
        static long sum(long a, long b) {
            if(b < a) return 0;
            long diff = b - a + 1;
            BigInteger total = BigInteger.valueOf(a+b);
            total = total.multiply(BigInteger.valueOf(diff));
            total = total.shiftRight(1);
            total = total.mod(BigInteger.valueOf(MOD));
            return Long.parseLong(total.toString());
        }
    }
 
    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
 
    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
    }
}