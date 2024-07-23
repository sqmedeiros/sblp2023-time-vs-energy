import java.io.BufferedReader; import java.io.IOException; import java.io.InputStreamReader; import java.io.PrintWriter; import java.util.*;
 
public class entry_2685080 {
    static final FastScanner fs = new FastScanner();
    static final PrintWriter out = new PrintWriter(System.out, true);
 
     public static void main(String[] args) {
        int n = fs.getInt();
        long[] nums = fs.getLongArray(n);
        long curMax = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);
        }
        out.print(maxSum);
        out.close();
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st = new StringTokenizer("");
        String get() { while (!st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); }  catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); }
        String getLine() { String str = ""; try { str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } return str; }
        int getInt() { return Integer.parseInt(get()); }
        int[] getIntArray(int n) { int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = getInt(); return a; }
        long getLong() { return Long.parseLong(get()); }
        long[] getLongArray(int n) { long[] a = new long[n]; for (int i = 0; i < n; i++) a[i] = getLong(); return a; }
    }
}
