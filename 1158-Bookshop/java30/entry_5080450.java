//package dynamic_programming.book_shop;
 
import java.io.BufferedInputStream;
import java.io.PrintWriter;
 
class FastReader {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;
 
    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }
 
    // dont' use this to read chars.
    private char readChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }
 
    public int readInt() {
        return (int) readLong();
    }
 
    public int[] readInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) readLong();
        }
        return res;
    }
 
    public long[] readLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = readLong();
        }
        return res;
    }
 
    public long readLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = readChar();
        for (; (c < '0' || c > '9'); c = readChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = readChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }
 
    public double nextDouble() {
        double cur = readLong();
        return c != '.' ? cur : cur + readLong() / cnt;
    }
 
    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }
 
    public String readString() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c > 32) {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }
 
    public String readLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c != '\n') {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }
 
    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = readChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}
 
public class entry_5080450 {
    private PrintWriter writer;
    private FastReader reader;
    private long solveKnapsack(int[] value, int[] weight, int totalWeightLimit){
        long[] prev = new long[totalWeightLimit+1];
        long[] next = new long[totalWeightLimit+1];
        for (int i = 0; i < value.length; i++){
            int v = value[i];
            int w = weight[i];
            for (int totalWeight = 1; totalWeight <= totalWeightLimit; totalWeight++){
                long choosingValue = w <= totalWeight ? v +  prev[totalWeight-w]:0;
                long notChoosingValue = prev[totalWeight];
                next[totalWeight] = Math.max(choosingValue, notChoosingValue);
            }
            long[] temp = next;
            next = prev;
            prev = temp;
        }
        return prev[totalWeightLimit];
 
    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        int totalPrice = reader.readInt();
        int[] prices = reader.readInts(n);
        int[] pages = reader.readInts(n);
        long maxPages = solveKnapsack(pages, prices, totalPrice);
        writer.println(maxPages);
        writer.close();
 
    }
 
    public static void main(String[] args) {
        new entry_5080450().solve();
    }
}
