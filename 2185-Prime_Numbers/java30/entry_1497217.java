import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class entry_1497217 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
        thread.start();
        thread.join();
    }
 
    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            PrimeMultiples solver = new PrimeMultiples();
            solver.solve(1, in, out);
            out.close();
        }
    }
 
    static class PrimeMultiples {
        Debug debug = new Debug(false);
 
        public void solve(int testNumber, FastInput in, FastOutput out) {
            long n = in.rl();
            int k = in.ri();
            long[] a = new long[k];
            in.populate(a);
            long sum = 0;
            for (int i = 1; i < 1 << k; i++) {
                long contrib = n;
                for (int j = 0; j < k; j++) {
                    if (Bits.get(i, j) == 0) {
                        continue;
                    }
                    contrib /= a[j];
                }
                if (Integer.bitCount(i) % 2 == 0) {
                    contrib = -contrib;
                }
                debug.debug("i", i);
                debug.debug("contrib", contrib);
                sum += contrib;
            }
            out.println(sum);
        }
 
    }
 
    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;
 
        public FastInput(InputStream is) {
            this.is = is;
        }
 
        public void populate(long[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readLong();
            }
        }
 
        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }
 
        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }
 
        public int ri() {
            return readInt();
        }
 
        public int readInt() {
            int sign = 1;
 
            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }
 
            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }
 
            return val;
        }
 
        public long rl() {
            return readLong();
        }
 
        public long readLong() {
            int sign = 1;
 
            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }
 
            long val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }
 
            return val;
        }
 
    }
 
    static class Debug {
        private boolean offline;
        private PrintStream out = System.err;
 
        public Debug(boolean enable) {
            offline = enable && System.getSecurityManager() == null;
        }
 
        public Debug debug(String name, int x) {
            if (offline) {
                debug(name, "" + x);
            }
            return this;
        }
 
        public Debug debug(String name, long x) {
            if (offline) {
                debug(name, "" + x);
            }
            return this;
        }
 
        public Debug debug(String name, String x) {
            if (offline) {
                out.printf("%s=%s", name, x);
                out.println();
            }
            return this;
        }
 
    }
 
    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 1 << 13;
        private final Writer os;
        private StringBuilder cache = new StringBuilder(THRESHOLD * 2);
 
        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }
 
        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }
 
        private void afterWrite() {
            if (cache.length() < THRESHOLD) {
                return;
            }
            flush();
        }
 
        public FastOutput(Writer os) {
            this.os = os;
        }
 
        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }
 
        public FastOutput append(char c) {
            cache.append(c);
            afterWrite();
            return this;
        }
 
        public FastOutput append(long c) {
            cache.append(c);
            afterWrite();
            return this;
        }
 
        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }
 
        public FastOutput println(long c) {
            return append(c).println();
        }
 
        public FastOutput println() {
            return append(System.lineSeparator());
        }
 
        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }
 
        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
 
        public String toString() {
            return cache.toString();
        }
 
    }
 
    static class Bits {
        private Bits() {
        }
 
        public static int get(int x, int i) {
            return (x >>> i) & 1;
        }
 
    }
}
 