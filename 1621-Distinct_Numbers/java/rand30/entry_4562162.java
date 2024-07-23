import java.io.*;
import java.util.*;
 
public class entry_4562162 {
    private static MyScanner sc;
    private static PrintWriter out;
 
    public static void main(String[] args) {
        sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start
 
        int n = sc.nextInt();
 
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
 
        out.println(set.size());
 
        // Stop
        out.close();
    }
 
    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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