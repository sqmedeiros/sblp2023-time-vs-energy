import java.util.*;
import java.io.*;
 
public class entry_5071087 {
 
    public static PrintWriter pw = new PrintWriter(System.out);
 
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
 
    public static long maxSum(int[] arr, long[] prefixSum) {
 
        long sum = Integer.MIN_VALUE;
        long min_prefix_sum = 0;
 
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum, prefixSum[i] - min_prefix_sum);
            min_prefix_sum = Math.min(min_prefix_sum, prefixSum[i]);
        }
        return sum;
    }
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
 
        long[] prefixSum = new long[n];
        for (int i = 0; i < n; i++) {
            long previous = i - 1 < 0 ? 0 : prefixSum[i - 1];
            prefixSum[i] = arr[i] + previous;
        }
 
        pw.println(maxSum(arr, prefixSum));
 
        pw.close();
 
    }
}
