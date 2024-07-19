import java.io.*;
import java.util.StringTokenizer;
 
public class entry_413525 {
 
    public static void main(String[] args) throws IOException {
        init();
        n = nextLong();
        long ans = 0;
        long floor = 1;
        long oppFlow = n;
        while (floor < oppFlow) {
            ans = (ans + intermediateSum(floor, findStart(floor), findEnd(floor))) % mod;
            ans = (ans + intermediateSum(oppFlow, findStart(oppFlow), findEnd(oppFlow))) % mod;
            floor++;
            oppFlow = n / floor;
        }
        if (floor == oppFlow) ans = (ans + intermediateSum(floor, findStart(floor), findEnd(floor))) % mod;
 
        System.out.println(ans);
    }
 
    private static final long mod = 1000000007;
    private static long n;
 
    private static long findEnd(long floor) {
        return n / floor;
    }
 
    private static long findStart(long floor) {
        return n / (floor + 1) + 1;
    }
 
    private static long intermediateSum(long floor, long start, long end) {
        long k = end - start + 1;
        if (k == 0) System.out.println(floor);
        k %= mod;
        start %= mod;
        floor %= mod;
        long firstTerm = ((start + mod - 1) * k) % mod;
        long secondTerm = ((k * (k + 1))/2) % mod;
        return ((firstTerm + secondTerm) * floor) % mod;
    }
 
    //Input Reader
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
 
    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }
 
    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }
 
        return tokenizer.nextToken();
    }
 
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}