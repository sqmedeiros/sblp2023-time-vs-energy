import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import java.util.stream.Collectors;
 
public class entry_1259502 {
 
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        //he or she will accept any apartment whose size is between x−k and x+k.
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
 
        int t = 0;
 
        int[] a = new int[n];
        int[] b = new int[m];
 
        for (int i = 0; i < n; i++)
            a[i] = fs.nextInt();
 
        for (int j = 0; j < m; j++){
            b[j] = fs.nextInt();
        }
 
        ruffleSort(a);
        ruffleSort(b);
 
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < m && b[j] < a[i]-k){
                j++;
            }
 
            if (j < m && b[j] <= a[i]+k){
                ++t;
                ++j;
            }
 
        }
        System.out.println(t);
    }
 
    static final Random random = new Random();
 
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
 
    static void ruffle(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        // Arrays.sort(a);
    }
 
    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;
 
        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }
 
        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
 
            return tokenizer.nextToken("\n");
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
 
}