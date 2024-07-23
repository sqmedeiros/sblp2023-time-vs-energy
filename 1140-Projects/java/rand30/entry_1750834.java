//package cses.dynamic_programming;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;
 
public final class entry_1750834 {
 
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt() };
        }
        Arrays.sort(arr, Comparator.comparingInt(val -> val[0]));
        final long[] dp = new long[n];
        Arrays.fill(dp, -1);
        System.out.println(dfs(arr, 0, dp));
    }
 
    private static long dfs(int[][] arr, int idx, long[] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        long res = 0;
        res = Math.max(res, arr[idx][2] + dfs(arr, lowerBound(arr, arr[idx][1] + 1), dp));
        res = Math.max(res, dfs(arr, idx + 1, dp));
        return dp[idx] = res;
    }
 
    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
 
    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();
 
                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }
 
            private static void shuffle(long[] x) {
                final Random r = new Random();
 
                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }
 
            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
 
            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }
 
        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }
 
        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }
 
        private Utils() {}
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
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
 
        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }
 
        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}