import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author caoash
 */
public class entry_175312 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CSESApartments solver = new CSESApartments();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class CSESApartments {
        public void solve(int testNumber, FastScanner br, PrintWriter pw) {
            int N = br.nextInt();
            int M = br.nextInt();
            int K = br.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            PriorityQueue<Integer> b = new PriorityQueue<Integer>();
            for (int i = 0; i < N; i++) a.add(br.nextInt());
            for (int i = 0; i < M; i++) b.add(br.nextInt());
            Collections.sort(a);
            int ans = 0;
            for (int i = 0; i < N && !b.isEmpty(); ) {
                int curr = b.peek();
                if (Math.abs(a.get(i) - curr) <= K) {
                    ans++;
                    b.poll();
                    i++;
                } else {
                    if (curr < a.get(i)) {
                        b.poll();
                    } else {
                        i++;
                    }
                }
            }
            pw.println(ans);
            pw.close();
        }
 
    }
 
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastScanner.SpaceCharFilter filter;
 
        public FastScanner(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
 
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
 
        }
 
    }
}
 