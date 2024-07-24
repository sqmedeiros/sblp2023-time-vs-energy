import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class DistinctNumbers {
 
        public static void main(String[] args) {
            FastScanner scanner = new FastScanner(System.in);
            Set<Integer> set = new HashSet<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                 set.add( scanner.nextInt());
            }
 
            System.out.println(set.size());
        }
        static class FastScanner {
            BufferedReader br;
            StringTokenizer st;
 
            FastScanner(InputStream stream) {
                try {
                    br = new BufferedReader(new InputStreamReader(stream));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
 
            String next() {
                while (st == null || !st.hasMoreTokens()) {
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
