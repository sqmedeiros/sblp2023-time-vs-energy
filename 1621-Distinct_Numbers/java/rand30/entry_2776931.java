import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class entry_2776931 {
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
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
 
        int n = fr.nextInt();
        int x = fr.nextInt();
 
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            arr[i][0] = fr.nextInt();
            arr[i][1] = i+1;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
 
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int left = j+1;
                int right = n-1;
                while (left < right) {
                    int cur = arr[j][0] + arr[i][0] + arr[left][0] + arr[right][0];
                    if (cur == x) {
                        System.out.println(arr[i][1] + " " + arr[j][1] + " " + arr[left][1] + " " + arr[right][1]);
                        return;
                    }
                    if (cur > x) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
 
        System.out.println("IMPOSSIBLE");
    }
}