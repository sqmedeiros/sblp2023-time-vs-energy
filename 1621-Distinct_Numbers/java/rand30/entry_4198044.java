import java.util.*;
import java.io.*;
 
public class entry_4198044 {
    static FastReader sc;
 
    static void solve() {
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        System.out.println(set.size());
    }
 
    public static void main(String[] args) throws IOException {
        sc = new FastReader();
        int tt = 1;// sc.nextInt();
        while (tt-- > 0) {
            solve();
        }
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
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
    }
}
