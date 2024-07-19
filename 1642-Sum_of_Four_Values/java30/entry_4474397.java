import java.io.*;
import java.util.*;
public class entry_4474397 {
    static pair[] nums;
    static int n;
    static long x;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        x = io.nextInt();
        nums = new pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new pair(io.nextInt(), i+1);
        }
        Arrays.sort(nums, (n1, n2) -> Integer.compare(n1.value, n2.value));
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                long partial = nums[i].value + nums[j].value;
                int idx1 = j+1;
                int idx2 = n-1;
                while (idx1 < idx2) {
                    long v = partial + nums[idx1].value + nums[idx2].value;
                    if (v == x) {
                        io.println(nums[i].pos + " " + nums[j].pos + " " + nums[idx1].pos + " " + nums[idx2].pos);
                        io.close();
                        return;
                    } else if (v < x) {
                        idx1++;
                    } else {
                        idx2--;
                    }
                }
            }
        }
        io.println("IMPOSSIBLE");
        io.close();
    }
 
    static class pair {
        int value, pos;
        pair(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
 
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in,System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName+".out");
            r = new BufferedReader(new FileReader(problemName+".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
    
}