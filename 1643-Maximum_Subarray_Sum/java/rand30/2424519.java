import java.io.*;
import java.util.*;
 
public class entry_2424519 implements Runnable {
 
    public void solve() throws IOException  {
        n = readInt();
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
        }
        long[] pre = new long[n + 1];
        long[] pos = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + a[i];
        }
        for (int i = n; i > 0; i--) {
            pos[i - 1] = pos[i] + a[i - 1];
        }
 
        long curMin = 0;
        long curMax = pre[1];
        for (int i = 1; i < n + 1; i++) {
            if (pre[i] - curMin > curMax) {
                curMax = pre[i] - curMin;
            }
            if (pre[i] < curMin) {
                curMin = pre[i];
            }
        }
        out.println(curMax);
//
//        int premini = findMini(pre, n + 1);
//        int premaxi = findMaxi(pre, n + 1);
//        int posmini = findMini(pos, n + 1);
//        int posmaxi = findMaxi(pos, n + 1);
//
//        if (premini <= premaxi) {
//            out.println(pre[premaxi] - pre[premini]);
//        } else {
//            out.println(pos[posmaxi] - pos[posmini]);
//        }
 
    }
    int n;
 
    /////////////////////////////////////////
 
    boolean trackTime = true;
 
    int JIT = 1000;
 
    int mod = 1000_000_007;
 
    int findMini(int[] a, int n) {
        int mini = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                mini = i;
            }
        }
        return mini;
    }
 
    int findMini(long[] a, int n) {
        int mini = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                mini = i;
            }
        }
        return mini;
    }
 
    int findMaxi(int[] a, int n) {
        int maxi = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                maxi = i;
            }
        }
        return maxi;
    }
 
    int findMaxi(long[] a, int n) {
        int maxi = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
                maxi = i;
            }
        }
        return maxi;
    }
 
    @Override
    public void run() {
        try {
            if (ONLINE_JUDGE || !new File("input.txt").exists()) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                reader = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            long time = 0;
            if (trackTime) {
                time = System.currentTimeMillis();
            }
            solve();
            if (trackTime) {
                System.err.println("time = " + (System.currentTimeMillis() - time));
            }
 
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // nothing
            }
            out.close();
        }
    }
 
    private String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
 
    @SuppressWarnings("unused")
    private int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
 
    @SuppressWarnings("unused")
    private long readLong() throws IOException {
        return Long.parseLong(readString());
    }
 
    @SuppressWarnings("unused")
    private double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
 
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private PrintWriter out;
 
    public static void main(String[] args) {
        new Thread(null, new entry_2424519(), "", 256 * (1L << 20)).start();
    }
 
}
