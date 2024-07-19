import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
 
/**
 * Provide prove of correctness before implementation. Implementation can cost a lot of time.
 * Anti test that prove that it's wrong.
 * <p>
 * Do not confuse i j k g indexes, upTo and length. Do extra methods!!! Write more informative names to simulation
 * <p>
 * Will program ever exceed limit?
 * Try all approaches with prove of correctness if task is not obvious.
 * If you are given formula/rule: Try to play with it.
 * Analytic solution/Hardcoded solution/Constructive/Greedy/DP/Math/Brute force/Symmetric data
 * Number theory
 * Game theory (optimal play) that consider local and global strategy.
 * Start writing the hardest code first
 */
public class entry_4897684 {
 
    boolean ONLINE_JUDGE;
 
    {
        try {
            ONLINE_JUDGE = java.lang.System.getProperty("ONLINE_JUDGE") != null;
        } finally {
            ONLINE_JUDGE = true;//most likely we are running in OJ;
        }
    }
 
    final boolean ANTI_TEST_FINDER_MODE = false;
    final Random random = new Random(42);
 
    private int solveOne(int testCase) {
        long n = nextLong();
        int k = nextInt();
        long[] a = nextLongArr(k);
        Set<Long> uniq = new HashSet<>();
        for (long u : a) uniq.add(u);
        if (uniq.size() < k) {
            int p = 0;
            for (long u : uniq) a[p++] = u;
            k = p;
            a = Arrays.copyOf(a, k);
        }
        long ans = 0;
        for (int bit_mask = 0b00001; bit_mask < (1 << k); bit_mask++) {
            long nClone = n;
            for (int bit = 0; bit < k; bit++) {
                if (testOn(bit_mask, bit)) {
                    nClone /= a[bit];
                }
            }
 
            if ((Integer.bitCount(bit_mask) & 1) == 1) {
                //include
                ans += nClone;
            } else {
                //exclude
                ans -= nClone;
            }
 
        }
        System.out.println(ans);
 
        return 0;
    }
 
    boolean testOn(int mask, int bit) {
        return (mask & (1 << bit)) != 0;
    }
 
    private int solveOneNaive(int testCase) {
        return 0;
    }
 
    private void solve() {
        if (ANTI_TEST_FINDER_MODE) {
            int t = 100_000;
            for (int testCase = 0; testCase < t; testCase++) {
                int expected = solveOneNaive(testCase);
                int actual = solveOne(testCase);
                if (expected != actual) {
                    throw new AssertionRuntimeException(
                            this.getClass().getSimpleName(),
                            testCase,
                            expected,
                            actual);
                }
            }
        } else {
            int t = 1;//nextInt();
            for (int testCase = 0; testCase < t; testCase++) {
                solveOne(testCase);
            }
        }
    }
 
    class AssertionRuntimeException extends RuntimeException {
 
        AssertionRuntimeException(String testName,
                                  int testCase,
                                  Object expected,
                                  Object actual, Object... input) {
            super("Testcase: " + testCase + "\n expected = " + expected + ",\n actual = " + actual + ",\n " + Arrays.deepToString(input));
        }
    }
 
    private void assertThat(boolean b) {
        if (!b) throw new RuntimeException();
    }
 
    private void assertThat(boolean b, String s) {
        if (!b) throw new RuntimeException(s);
    }
 
    private int assertThatInt(long a) {
        assertThat(Integer.MIN_VALUE <= a && a <= Integer.MAX_VALUE,
                "Integer overflow long = [" + a + "]" + " int = [" + (int) a + "]");
        return (int) a;
    }
 
    void _______debug(String str, Object... os) {
        if (!ONLINE_JUDGE) {
            System.out.println(MessageFormat.format(str, os));
            System.out.flush();
        }
    }
 
    void _______debug(Object o) {
        if (!ONLINE_JUDGE) {
            _______debug("{0}", String.valueOf(o));
        }
    }
 
    private int nextInt() {
        return System.in.readInt();
    }
 
    private long nextLong() {
        return System.in.readLong();
    }
 
    private String nextString() {
        return System.in.readString();
    }
 
    private int[] nextIntArr(int n) {
        return System.in.readIntArray(n);
    }
 
    private long[] nextLongArr(int n) {
        return System.in.readLongArray(n);
    }
 
    public static void main(String[] args) {
        new entry_4897684().run();
    }
 
    static class System {
        private static FastInputStream in;
        private static FastPrintStream out;
    }
 
    private void run() {
//        final long startTime = java.lang.System.currentTimeMillis();
        final boolean USE_IO = ONLINE_JUDGE;
        if (USE_IO) {
            System.in = new FastInputStream(java.lang.System.in);
            System.out = new FastPrintStream(java.lang.System.out);
            solve();
            System.out.flush();
        } else {
            final String nameIn = "input.txt";
            final String nameOut = "output.txt";
            try {
                System.in = new FastInputStream(new FileInputStream(nameIn));
                System.out = new FastPrintStream(new PrintStream(nameOut));
                solve();
                System.out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
//        final long endTime = java.lang.System.currentTimeMillis();
//        _______debug("Execution time: {0}", endTime - startTime);
    }
 
    private static class FastPrintStream {
        private static final int BUF_SIZE = 8192;
        private final byte[] buf = new byte[BUF_SIZE];
        private final OutputStream out;
        private int ptr = 0;
 
        private FastPrintStream() {
            this(java.lang.System.out);
        }
 
        public FastPrintStream(OutputStream os) {
            this.out = os;
        }
 
        public FastPrintStream(String path) {
            try {
                this.out = new FileOutputStream(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("FastWriter");
            }
        }
 
        public FastPrintStream print(byte b) {
            buf[ptr++] = b;
            if (ptr == BUF_SIZE) innerFlush();
            return this;
        }
 
        public FastPrintStream print(char c) {
            return print((byte) c);
        }
 
        public FastPrintStream print(char[] s) {
            for (char c : s) {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE) innerFlush();
            }
            return this;
        }
 
        public FastPrintStream print(String s) {
            s.chars().forEach(c -> {
                buf[ptr++] = (byte) c;
                if (ptr == BUF_SIZE) innerFlush();
            });
            return this;
        }
 
        //can be optimized
        public FastPrintStream print0(char[] s) {
            if (ptr + s.length < BUF_SIZE) {
                for (char c : s) {
                    buf[ptr++] = (byte) c;
                }
            } else {
                for (char c : s) {
                    buf[ptr++] = (byte) c;
                    if (ptr == BUF_SIZE) innerFlush();
                }
            }
            return this;
        }
 
        //can be optimized
        public FastPrintStream print0(String s) {
            if (ptr + s.length() < BUF_SIZE) {
                for (int i = 0; i < s.length(); i++) {
                    buf[ptr++] = (byte) s.charAt(i);
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    buf[ptr++] = (byte) s.charAt(i);
                    if (ptr == BUF_SIZE) innerFlush();
                }
            }
            return this;
        }
 
        private static int countDigits(int l) {
            if (l >= 1000000000) return 10;
            if (l >= 100000000) return 9;
            if (l >= 10000000) return 8;
            if (l >= 1000000) return 7;
            if (l >= 100000) return 6;
            if (l >= 10000) return 5;
            if (l >= 1000) return 4;
            if (l >= 100) return 3;
            if (l >= 10) return 2;
            return 1;
        }
 
        public FastPrintStream print(int x) {
            if (x == Integer.MIN_VALUE) {
                return print((long) x);
            }
            if (ptr + 12 >= BUF_SIZE) innerFlush();
            if (x < 0) {
                print((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }
 
        private static int countDigits(long l) {
            if (l >= 1000000000000000000L) return 19;
            if (l >= 100000000000000000L) return 18;
            if (l >= 10000000000000000L) return 17;
            if (l >= 1000000000000000L) return 16;
            if (l >= 100000000000000L) return 15;
            if (l >= 10000000000000L) return 14;
            if (l >= 1000000000000L) return 13;
            if (l >= 100000000000L) return 12;
            if (l >= 10000000000L) return 11;
            if (l >= 1000000000L) return 10;
            if (l >= 100000000L) return 9;
            if (l >= 10000000L) return 8;
            if (l >= 1000000L) return 7;
            if (l >= 100000L) return 6;
            if (l >= 10000L) return 5;
            if (l >= 1000L) return 4;
            if (l >= 100L) return 3;
            if (l >= 10L) return 2;
            return 1;
        }
 
        public FastPrintStream print(long x) {
            if (x == Long.MIN_VALUE) {
                return print("" + x);
            }
            if (ptr + 21 >= BUF_SIZE) innerFlush();
            if (x < 0) {
                print((byte) '-');
                x = -x;
            }
            int d = countDigits(x);
            for (int i = ptr + d - 1; i >= ptr; i--) {
                buf[i] = (byte) ('0' + x % 10);
                x /= 10;
            }
            ptr += d;
            return this;
        }
 
        public FastPrintStream print(double x, int precision) {
            if (x < 0) {
                print('-');
                x = -x;
            }
            x += Math.pow(10, -precision) / 2;
            print((long) x).print(".");
            x -= (long) x;
            for (int i = 0; i < precision; i++) {
                x *= 10;
                print((char) ('0' + (int) x));
                x -= (int) x;
            }
            return this;
        }
 
        public FastPrintStream println(char c) {
            return print(c).println();
        }
 
        public FastPrintStream println(int x) {
            return print(x).println();
        }
 
        public FastPrintStream println(long x) {
            return print(x).println();
        }
 
        public FastPrintStream println(String x) {
            return print(x).println();
        }
 
        public FastPrintStream println(Object x) {
            return print(x.toString()).println();
        }
 
        public FastPrintStream println(double x, int precision) {
            return print(x, precision).println();
        }
 
        public FastPrintStream println() {
            return print((byte) '\n');
        }
 
        public FastPrintStream printf(String format, Object... args) {
            return print(String.format(format, args));
        }
 
        private void innerFlush() {
            try {
                out.write(buf, 0, ptr);
                ptr = 0;
            } catch (IOException e) {
                throw new RuntimeException("innerFlush");
            }
        }
 
        public void flush() {
            innerFlush();
            try {
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException("flush");
            }
        }
    }
 
    private static class FastInputStream {
        private boolean finished = false;
 
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public FastInputStream(InputStream stream) {
            this.stream = stream;
        }
 
        public double[] readDoubleArray(int size) {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = readDouble();
            }
            return array;
        }
 
        public String[] readStringArray(int size) {
            String[] array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = readString();
            }
            return array;
        }
 
        public char[] readCharArray(int size) {
            char[] array = new char[size];
            for (int i = 0; i < size; i++) {
                array[i] = readCharacter();
            }
            return array;
        }
 
        public String readText() {
            StringBuilder result = new StringBuilder();
            while (true) {
                int character = read();
                if (character == '\r') {
                    continue;
                }
                if (character == -1) {
                    break;
                }
                result.append((char) character);
            }
            return result.toString();
        }
 
        public long[] readLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = readLong();
            }
            return array;
        }
 
        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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
 
        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }
 
        public int peekNonWhitespace() {
            while (isWhitespace(peek())) {
                read();
            }
            return peek();
        }
 
        public int readInt() {
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
 
        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public char[] readStringAsCharArray() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            char[] resArr = new char[res.length()];
            res.getChars(0, res.length(), resArr, 0);
            return resArr;
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
 
        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }
 
        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }
 
        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }
 
        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }
 
        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }
 
        public String next() {
            return readString();
        }
 
        public SpaceCharFilter getFilter() {
            return filter;
        }
 
        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
}
