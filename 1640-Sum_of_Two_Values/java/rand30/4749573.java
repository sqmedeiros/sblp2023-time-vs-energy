import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
 
import java.util.Map;
import java.util.HashMap;
 
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
 
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }
 
    public boolean hasMoreTokens() {
        return peekToken() != null;
    }
 
    public int getInt() {
        return Integer.parseInt(nextToken());
    }
 
    public double getDouble() {
        return Double.parseDouble(nextToken());
    }
 
    public long getLong() {
        return Long.parseLong(nextToken());
    }
 
    public String getWord() {
        return nextToken();
    }
 
    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;
 
    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }
 
    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
 
 
class Pair<X, Y> { 
    X _first;
    Y _second;
 
    public Pair(X f, Y s) { _first = f; _second = s; }
 
    X first() { return _first; }
    Y second() { return _second; }
 
    void setFirst(X f) { _first = f; }
    void setSecond(Y s) { _second = s; }
 
    public String toString() {
        return "[" + _first + ", " + _second + "]";
    }
}
 
public class entry_4749573 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int m = io.getInt();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = io.getInt();
            if (mp.containsKey(m - x)) {
                io.println(i + " " + mp.get(m - x));
                io.close();
                return;
            }
            mp.put(x, i);
        }
        io.println("IMPOSSIBLE");
        io.close();
    }
}
