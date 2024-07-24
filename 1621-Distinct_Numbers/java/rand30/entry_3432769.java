import java.io.*;
import java.util.*;
 
public class entry_3432769 {
    public static InputReader ir;
    public static PrintWriter pw;
 
    public static void main(String args[]) throws Exception {
        ir = new InputReader(System.in);
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }
 
    public static void solve() throws Exception {
        int n = ir.nextInt();
        TreeSet<Integer> hs = new TreeSet<>();
 
        for (int i = 0; i < n; i++) {
            int x = ir.nextInt();
            hs.add(x);
        }
 
        pw.write(hs.size() + "");
    }
 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
 
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}