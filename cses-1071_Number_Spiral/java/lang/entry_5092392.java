import java.io.*;
import java.util.*;
 
public class entry_5092392 {
 
    public static void main(String[] args) {
 
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
 
 
 
 
        FastReader scn = new FastReader();
        int np = scn.nextInt();
 
        for (int l = 0; l < np; l++) {
            long x = scn.nextLong();
            long y = scn.nextLong();
            long max = Math.max(x, y) * Math.max(x, y);
            long maxminusone = Math.max(x - 1, y - 1) * Math.max(x - 1, y - 1);
            if (Math.max(x, y) % 2 == 0) { // ended in left bottom
 
                if (x < y) {
                    System.out.println(maxminusone + x);
                } else {
                    System.out.println(max - y + 1);
                }
            } else { // ended on top right
                if (x < y) {
                    System.out.println(max - x + 1);
                } else {
                    System.out.println(maxminusone + y);
                }
            }
 
        }
 
    }
 
    static int mod = (int)10e8 + 7;
 
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
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
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
 
 
 
