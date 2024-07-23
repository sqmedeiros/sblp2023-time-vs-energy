import java.io.*;
import java.util.*;
 
class entry_794331 {
 
    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }
 
    private static void solve() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        Queue<Integer> da = new PriorityQueue<>();
        for (int i = 0; i < n; i++) da.add(scan.nextInt());
        Queue<Integer> a = new PriorityQueue<>();
        for (int i = 0; i < m; i++) a.add(scan.nextInt());
        int output = 0;
        while (da.size() > 0 && a.size() > 0) {
            if (Math.abs(da.peek() - a.peek()) <= k) {
                output++;
                da.poll();
                a.poll();
            } else if (da.peek() < a.peek()) {
                da.poll();
            } else {
                a.poll();
            }
        }
        out.println(output);
    }
 
 
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
    public static MyScanner scan = new MyScanner();
 
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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
    //--------------------------------------------------------
 
}