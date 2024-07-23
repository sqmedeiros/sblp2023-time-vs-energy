import java.util.*;
import java.io.*;
 
public class entry_1782058 {
    static Reader sc = new Reader();
    static PrintWriter out = new PrintWriter(System.out);
 
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        shuffleSort(a);
        shuffleSort(b);
        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            // out.println(a[i] + " " + b[j]);
            if (Math.abs(a[i] - b[j]) <= k) {
                ans++;
                i++;
                j++;
            } else {
                if (a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        out.println(ans);
        out.close();
    }
 
    private static void shuffleSort(int[] arr) {
        // shuffle
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        Arrays.sort(arr);
    }
 
    public static final class Reader {
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
 
        public String nextLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = next()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = next();
            while (c <= ' ') {
                c = next();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = next();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = next()) >= '0' && c <= '9');
 
            if (neg) {
                return -ret;
            }
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = next();
            while (c <= ' ') {
                c = next();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = next();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = next()) >= '0' && c <= '9');
 
            if (neg) {
                return -ret;
            }
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = next();
            while (c <= ' ') {
                c = next();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = next();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = next()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = next()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte next() throws IOException {
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
 
}