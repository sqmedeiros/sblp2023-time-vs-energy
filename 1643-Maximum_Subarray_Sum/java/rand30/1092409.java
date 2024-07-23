import java.io.*;
import java.util.*;
 
public class entry_1092409 {
 
    public static void main(String[] args) throws IOException {
        new entry_1092409().run();
    }
 
    private void run() throws IOException {
        Reader in = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
 
        solve(in, pw);
        pw.close();
    }
 
    class Pair {
        int x, y;
 
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        int y() {
            return y;
        }
 
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }
 
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
 
    static class Reader {
        BufferedReader br;
        StringTokenizer st;
 
        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        Reader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }
 
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        String nextLine() throws IOException {
            return br.readLine();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
 
    private void solve(Reader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
 
        int[] a = new int[n];
        long res = -2_000_000_000_000_000_000L;
        long sum = -2_000_000_000_000_000_000L;
        for(int i = 0; i < n; i++) {
            long e = in.nextInt();
            sum = Math.max(e, e+sum);
            res = Math.max(res, sum);
 
        }
        out.println(res);
    }
}
