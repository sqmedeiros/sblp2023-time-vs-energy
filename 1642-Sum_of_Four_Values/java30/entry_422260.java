import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class entry_422260 {
 
    public static void main(String[] args) throws Exception {
        new entry_422260().solve();
    }
 
    private final FastReader in = new FastReader();
 
    private final PrintWriter out = new PrintWriter(System.out);
 
    public void solve() throws Exception {
        final int n = in.nextInt();
        final int expectedSum = in.nextInt();
 
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
 
        final Map<Integer, List<int[]>> sumByPair = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final int sum = a[i] + a[j];
                if (!sumByPair.containsKey(sum)) {
                    sumByPair.put(sum, new ArrayList<>());
                }
 
                sumByPair.get(sum).add(new int[]{i, j});
            }
        }
 
        int[] result = null;
        main: for (Map.Entry<Integer, List<int[]>> firstTerm : sumByPair.entrySet()) {
            final List<int[]> secondTerm = sumByPair.get(expectedSum - firstTerm.getKey());
            if (secondTerm == null) {
                continue;
            }
 
            for (int[] firstPair : firstTerm.getValue()) {
                for (int[] secondPair : secondTerm) {
                    if (firstPair[0] != secondPair[0] && firstPair[1] != secondPair[1] && firstPair[0] != secondPair[1] && firstPair[1] != secondPair[0]) {
                        result = new int[]{firstPair[0], firstPair[1], secondPair[0], secondPair[1]};
                        break main;
                    }
                }
            }
        }
 
        if (result == null) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(String.format("%s %s %s %s", result[0] + 1, result[1] + 1, result[2] + 1, result[3] + 1));
        }
        out.flush();
    }
 
    private static class FastReader {
 
        private final int BUFFER_SIZE = 1 << 24;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public FastReader(String fileName) {
            try {
                din = new DataInputStream(new FileInputStream(fileName));
                buffer = new byte[BUFFER_SIZE];
                bufferPointer = bytesRead = 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
 
        public String readLine() {
            byte[] buf = new byte[1001]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() {
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
 
        public long nextLong() {
            long ret = 0;
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
 
        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
 
        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() {
            try {
                din.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
 
        public int[] fillIntegerArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = nextInt();
            return array;
        }
 
        public long[] fillLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = nextLong();
            return array;
        }
 
        public <T extends List<Long>> T fillList(T list, int n) {
            for (int i = 0; i < n; i++)
                list.add(nextLong());
            return list;
        }
    }
}
