import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.MappedByteBuffer;
import java.util.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
 
/**
 *
 * @author nagaraj_poojari
 *
 */
 
public class entry_5679658{
 
    static StringBuilder sb;
    static PrintWriter pw;
    static int mod = (int) (1e9 + 7);
    static long[] fact = new long[(int) 1e6 + 10];
    static int MAXN = (int) 1e5;
    static boolean[] prime = new boolean[MAXN];
 
    // **************************************************************************//
 
    static void solve() {
        int n=i(),x=i();
        int[] pr=readArray(n);
        int[] p=readArray(n);
        int[] dp=new int[x+1];
        for(int i=1;i<=n;i++){
            int[] curr=new int[x+1];
            for(int j=1;j<=x;j++)
                if(pr[i-1]>j) curr[j]=dp[j] ;
                else curr[j]=Math.max(dp[j],p[i-1]+dp[j-pr[i-1]]);
            dp=curr;
        }
        System.out.println(dp[x]);
    }
 
    
    /** MAIN **/
    public static void main(String[] args) {
        sb = new StringBuilder();
        pw = new PrintWriter(System.out);
        int i = 1;
        //long t=System.currentTimeMillis();
        while (i-- > 0) {
            solve();
        }
        //System.out.println(System.currentTimeMillis()-t);
        pw.close();
    }
 
    // -------------------------------------------------------------
 
    static long pow(long a, long n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0) {
            long p = pow(a, n / 2);
            return p * p;
        } else
            return a * pow(a, n - 1);
    }
 
    static <T> void pr(T t) {
        pw.println(t);
    }
 
    static void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
 
    /** Print Array **/
    static void debug(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
 
    /** CUSTOM INPUT **/
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int Int() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String String() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public char Character() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next() {
            return String();
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
    static class OutputWriter {
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
 
        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }
 
        public void close() {
            writer.close();
        }
 
        public void flush() {
            writer.flush();
        }
    }
 
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
 
    public static int i() {
        return in.Int();
    }
 
    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }
 
    public static String s() {
        return in.String();
    }
 
    public static int[] readArray(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i();
        }
        return A;
    }
 
    public static char c() {
        return in.Character();
    }
 
    public static long[] readArraylong(int n) {
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = l();
        }
        return A;
    }
 
}