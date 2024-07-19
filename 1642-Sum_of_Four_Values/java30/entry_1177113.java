import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class entry_1177113 {
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
            PrintWriter out = new PrintWriter(outputStream);
            SumOfFourValues solver = new SumOfFourValues();
            solver.solve(1, in, out);
            out.close();
        }
    }
 
    static class SumOfFourValues {
        public void solve(int testNumber, FastInput in, PrintWriter out) {
            int n = in.readInt();
            long x = in.readInt();
            int[] p = new int[n];
            in.populate(p);
            LongHashMap hm = new LongHashMap(n * n, false);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long sum = p[i] + p[j];
                    long req = x - sum;
                    long ans = hm.getOrDefault(req, -1);
                    if (ans != -1) {
                        out.println(DigitUtils.highBit(ans) + 1);
                        out.println(DigitUtils.lowBit(ans) + 1);
                        out.println(i + 1);
                        out.println(j + 1);
                        return;
                    }
                }
                for (int j = 0; j < i; j++) {
                    hm.put(p[i] + p[j], DigitUtils.asLong(i, j));
                }
            }
            out.println("IMPOSSIBLE");
        }
 
    }
 
    static class LongHashMap {
        private int now;
        private int[] slot;
        private int[] version;
        private int[] next;
        private long[] keys;
        private long[] values;
        private int alloc;
        private boolean[] removed;
        private int mask;
        private int size;
        private boolean rehash;
        private Hasher hasher = new Hasher();
 
        public LongHashMap(int cap, boolean rehash) {
            now = 1;
            this.mask = (1 << (32 - Integer.numberOfLeadingZeros(cap - 1))) - 1;
            slot = new int[mask + 1];
            version = new int[slot.length];
            next = new int[cap + 1];
            keys = new long[cap + 1];
            values = new long[cap + 1];
            removed = new boolean[cap + 1];
            this.rehash = rehash;
        }
 
        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            keys = Arrays.copyOf(keys, newSize);
            values = Arrays.copyOf(values, newSize);
            removed = Arrays.copyOf(removed, newSize);
        }
 
        public void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
            removed[alloc] = false;
            size++;
        }
 
        private void rehash() {
            int[] newSlots = new int[Math.max(16, slot.length * 2)];
            int[] newVersions = new int[newSlots.length];
            int newMask = newSlots.length - 1;
            for (int i = 0; i < slot.length; i++) {
                access(i);
                if (slot[i] == 0) {
                    continue;
                }
                int head = slot[i];
                while (head != 0) {
                    int n = next[head];
                    int s = hash(keys[head]) & newMask;
                    next[head] = newSlots[s];
                    newSlots[s] = head;
                    head = n;
                }
            }
            this.slot = newSlots;
            this.version = newVersions;
            now = 0;
            this.mask = newMask;
        }
 
        private int hash(long x) {
            return hasher.hash(x);
        }
 
        public void put(long x, long y) {
            put(x, y, true);
        }
 
        public void put(long x, long y, boolean cover) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                alloc();
                slot[s] = alloc;
                keys[alloc] = x;
                values[alloc] = y;
            } else {
                int index = findIndexOrLastEntry(s, x);
                if (keys[index] != x) {
                    alloc();
                    next[index] = alloc;
                    keys[alloc] = x;
                    values[alloc] = y;
                } else if (cover) {
                    values[index] = y;
                }
            }
            if (rehash && size >= slot.length) {
                rehash();
            }
        }
 
        public long getOrDefault(long x, long def) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                return def;
            }
            int index = findIndexOrLastEntry(s, x);
            return keys[index] == x ? values[index] : def;
        }
 
        private int findIndexOrLastEntry(int s, long x) {
            int iter = slot[s];
            while (keys[iter] != x) {
                if (next[iter] != 0) {
                    iter = next[iter];
                } else {
                    return iter;
                }
            }
            return iter;
        }
 
        private void access(int i) {
            if (version[i] != now) {
                version[i] = now;
                slot[i] = 0;
            }
        }
 
        public LongEntryIterator iterator() {
            return new LongEntryIterator() {
                int index = 1;
                int readIndex = -1;
 
 
                public boolean hasNext() {
                    while (index <= alloc && removed[index]) {
                        index++;
                    }
                    return index <= alloc;
                }
 
 
                public long getEntryKey() {
                    return keys[readIndex];
                }
 
 
                public long getEntryValue() {
                    return values[readIndex];
                }
 
 
                public void next() {
                    if (!hasNext()) {
                        throw new IllegalStateException();
                    }
                    readIndex = index;
                    index++;
                }
            };
        }
 
        public String toString() {
            LongEntryIterator iterator = iterator();
            StringBuilder builder = new StringBuilder("{");
            while (iterator.hasNext()) {
                iterator.next();
                builder.append(iterator.getEntryKey()).append("->").append(iterator.getEntryValue()).append(',');
            }
            if (builder.charAt(builder.length() - 1) == ',') {
                builder.setLength(builder.length() - 1);
            }
            builder.append('}');
            return builder.toString();
        }
 
    }
 
    static interface LongEntryIterator {
        boolean hasNext();
 
        void next();
 
        long getEntryKey();
 
        long getEntryValue();
 
    }
 
    static class DigitUtils {
        private static long LONG_TO_INT_MASK = (1L << 32) - 1;
 
        private DigitUtils() {
        }
 
        public static long asLong(int high, int low) {
            return (((long) high) << 32) | (((long) low) & LONG_TO_INT_MASK);
        }
 
        public static int highBit(long x) {
            return (int) (x >> 32);
        }
 
        public static int lowBit(long x) {
            return (int) x;
        }
 
    }
 
    static class Hasher {
        private long time = System.nanoTime() + System.currentTimeMillis() * 31L;
 
        public int shuffle(long z) {
            z += time;
            z = (z ^ (z >>> 33)) * 0x62a9d9ed799705f5L;
            return (int) (((z ^ (z >>> 28)) * 0xcb24d0a5c88c35b3L) >>> 32);
        }
 
        public int hash(long x) {
            return shuffle(x);
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
 
        public void populate(int[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readInt();
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
 
    }
}
 