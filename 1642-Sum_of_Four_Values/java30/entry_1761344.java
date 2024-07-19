import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author akherbouch
 */
public class entry_1761344 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SumOfFourValues solver = new SumOfFourValues();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class SumOfFourValues {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            var a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = in.nextInt();
 
            HashMap<Integer, IntegerPair> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int s = a[i] + a[j];
                    if (map.containsKey(s)) {
                        IntegerPair p = map.get(s);
                        out.println(i + " " + j + " " + p.first() + " " + p.second());
                        return;
                    }
                }
                for (int j = 1; j < i; j++) {
                    map.put(x - a[i] - a[j], new IntegerPair(i, j));
                }
            }
            out.println("IMPOSSIBLE");
        }
 
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = new StringTokenizer("");
        }
 
        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
 
    static class IntegerPair implements Comparable<IntegerPair> {
        private final Integer _first;
        private final Integer _second;
 
        public IntegerPair(Integer f, Integer s) {
            _first = f;
            _second = s;
        }
 
        public int compareTo(IntegerPair other) {
            if (!this.first().equals(other.first()))
                return this.first() - other.first();
            else
                return this.second() - other.second();
        }
 
        public Integer first() {
            return _first;
        }
 
        public Integer second() {
            return _second;
        }
 
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntegerPair that = (IntegerPair) o;
            return _first.equals(that._first) &&
                    _second.equals(that._second);
        }
 
        public int hashCode() {
            return Objects.hash(_first, _second);
        }
 
        public String toString() {
            return "(" + first() + ", " + second() + ")";
        }
 
    }
}
 