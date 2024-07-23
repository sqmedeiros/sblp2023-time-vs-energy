import java.io.*;
import java.util.*;
public class entry_751531 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { return Integer.parseInt(next()); } // reads in the next int
        public long nextLong() { return Long.parseLong(next()); } // reads in the next long
        public double nextDouble() { return Double.parseDouble(next()); } // reads in the next double
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter out= new PrintWriter(System.out);
    public static void main(String[] args) {
        // YOUR CODE HERE //! @ % & * () _ {} # ~ : < > ? "" | ^
 
       int n=r.nextInt();
 
       int x=0;
       HashSet<Integer> set=new HashSet<Integer>();
 
        for (int i=1;i<=n;i++) {
            x=r.nextInt();
            set.add(x);
        }
        out.println(set.size());
        out.close(); // flushes the output once printing is done
    }
}