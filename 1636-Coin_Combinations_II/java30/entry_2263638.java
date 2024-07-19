import java.io.*;
import java.util.*;
 
public class entry_2263638 implements Runnable {
 
    int mod = 1000_000_007;
 
    public void solve() throws IOException  {
        int n = readInt();
        int x = readInt();
        SortedSet<Integer> sa = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            sa.add(readInt());
        }
        int a[] = sa.stream().mapToInt(Integer::intValue).toArray();
        n = a.length;
 
        int[][] result = new int[2][x + 1];
 
        for (int j = 0; j < n; j++) {
            int aj = a[j];
            int jmod = j % 2;
            int njmod = (j + 1) % 2;
            for (int i = 0; i <= x; i++) {
                if (!(i - aj < 0)) {
                    result[jmod][i] = result[jmod][i - aj];
                } else {
                    result[jmod][i] = i == 0 && j == 0 ? 1 : 0;
                }
                result[jmod][i] += result[njmod][i];
                result[jmod][i] %= mod;
            }
        }
 
        out.println(result[(n - 1) % 2][x]);
    }
 
    /////////////////////////////////////////
 
    boolean trackTime = false;
 
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
                out.println("time = " + (System.currentTimeMillis() - time));
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
        new Thread(null, new entry_2263638(), "", 256 * (1L << 20)).start();
    }
 
}
