import java.io.*;
import java.util.*;
import java.util.Comparator;
 
public class entry_1458523 {
 
    static PrintWriter out = new PrintWriter(System.out);
    static Reader fastReader = new Reader();
    static StringBuilder sbr = new StringBuilder();
 
    static void solve() throws IOException {
 
        int tests = fastReader.nextInt();
        int k = fastReader.nextInt();
 
        TMultiset<Integer> set = new TMultiset<>();
        int[][] arr = new int[tests][2];
 
        for (int index = 0; index < tests; index++) {
            arr[index] = new int[]{fastReader.nextInt(), fastReader.nextInt()};
        }
 
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        long res = 0;
 
        for(int[] movie: arr){
            Integer bound = set.floorKey(movie[0]);
            if( bound != null ){
                set.remove(bound);
            }
 
            if( set.size() < k ){
                set.add(movie[1]);
                res++;
            }
        }
 
        print(res);
 
    }
 
 
    private static void solve2() throws IOException {
        int n = fastReader.nextInt();
        int k = fastReader.nextInt();
        int[][] m = new int[n][];
        for (int i = 0; i < n; i++) {
            m[i] = new int[] {fastReader.nextInt(), fastReader.nextInt(), i};
        }
        sort(m, 0, n - 1);
 
        TreeSet<int[]> ms = new TreeSet<>(Comparators.pairIntArr);
        int ans = 0, e, i;
        int[] floorX = new int[] {0, 0};
        for (int[] movie : m) {
            floorX[0] = movie[0];
            e = movie[1];
            i = movie[2];
            int[] rem = ms.floor(floorX);
            if (rem != null) {
                ms.remove(rem);
            }
            if (ms.size() < k) {
                ms.add(new int[] {e, i});
                ++ans;
            }
        }
 
        out.println(ans);
    }
 
    /************************************************************************************************************************************************/
    public static void main(String[] args) throws IOException {
 
        //solve();
        solve2();
        out.close();
    }
 
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
 
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
 
        }
 
        public String next() throws IOException {
 
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
 
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
 
    static void shuffle(int[] aa, int n) {
        Random rand = new Random();
        for (int i = 1; i < n; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = aa[i];
            aa[i] = aa[j];
            aa[j] = tmp;
        }
    }
 
    static void shuffle(int[][] aa, int n) {
        Random rand = new Random();
        for (int i = 1; i < n; i++) {
            int j = rand.nextInt(i + 1);
            int first = aa[i][0];
            int second = aa[i][1];
            aa[i][0] = aa[j][0];
            aa[i][1] = aa[j][1];
            aa[j][0] = first;
            aa[j][1] = second;
        }
    }
 
    /**
     * Tree Multiset utility class *
     */
    static class TMultiset<T extends Number> extends TreeMap<T, Integer> {
        private int size = 0;
 
        void add(T value) {
            Integer count = get(value);
            size++;
            if (count == null) {
                put(value, 1);
            } else {
                put(value, count + 1);
            }
        }
 
        @SuppressWarnings(value = "unchecked")
        @Override
        public Integer remove(Object key) {
            if (!containsKey(key)) {
                return null;
            }
 
            size--;
 
            Integer value = get(key);
            if (value > 1) {
                return put((T) key, value - 1);
            }
 
            return super.remove(key);
        }
 
        @java.lang.Override
        public int size() {
            return size;
        }
    }
 
    /**
     * It is a HashMap
     */
    static class HMap<T> extends HashMap<T, Integer> {
        void add(T key) {
            Integer count = get(key);
            put(key, count == null ? 1 : count + 1);
        }
 
        @SuppressWarnings(value = "unchecked")
        @Override
        public Integer remove(Object key) {
            if (!containsKey(key)) return null;
 
            int count = get(key);
            if (count > 1) return put((T) key, count - 1);
 
            return super.remove(key);
        }
    }
 
    private static void sort(int[][] a, int s, int e) {
        if (e - s < 1) {
            return;
        }
 
        int mid = (e + s) >> 1;
        sort(a, s, mid);
        sort(a, mid + 1, e);
 
        int[][] temp = new int[e - s + 1][];
        int idx = 0;
        int i = s;
        int j = mid + 1;
        while (i <= mid && j <= e) {
            if (a[i][1] <= a[j][1]) {
                temp[idx++] = a[i++];
            } else {
                temp[idx++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = a[i++];
        }
        while (j <= e) {
            temp[idx++] = a[j++];
        }
        for (i = s; i <= e; i++) {
            a[i] = temp[i - s];
        }
    }
 
    static final class Comparators {
        public static final Comparator<int[]> pairIntArr =
                (x, y) -> x[0] == y[0] ? compare(x[1], y[1]) : compare(x[0], y[0]);
 
        private static final int compare(final int x, final int y) {
            return Integer.compare(x, y);
        }
    }
 
    static void print(Object object) {
        out.print(object);
    }
 
    static void println(Object object) {
        out.println(object);
    }
}
