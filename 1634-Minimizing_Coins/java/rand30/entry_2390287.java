import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
 
public class entry_2390287 {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
 
        int n = reader.nextInt();
        int x = reader.nextInt();
 
        int[] coinValues = new int[n];
        for (int i = 0; i < n; i++) {
            coinValues[i] = reader.nextInt();
        }
 
        long[] coinSums = new long[x + 1];
        for (int i = 1; i <= x; i++) {
            coinSums[i] = x + 1;
            for (int j = 0; j < n; j++) {
                if (coinValues[j] <= i) {
                    coinSums[i] = Math.min(coinSums[i], coinSums[i - coinValues[j]] + 1);
                }
            }
        }
        System.out.println(coinSums[x] > x ? -1 : coinSums[x]);
    }
 
    static class InputReader {
        public int bufferLength = 0, bufferPointer = 0;
        public InputStream is;
        private byte[] inputBuffer = new byte[1 << 20];
 
        public InputReader(InputStream stream) {
            try {
                inputBuffer = new byte[2 << 23];
                bufferLength = 0;
                bufferPointer = 0;
                is = stream;
                bufferLength = is.read(inputBuffer);
            } catch (Exception ignored) {
            }
        }
 
        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                bufferPointer--;
                return true;
            }
            return false;
        }
 
        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
 
        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
 
        private int readByte() {
            if (bufferLength == -1)
                throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                return -1;
            }
            return inputBuffer[bufferPointer++];
        }
 
        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
 
        private double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public Character nextChar() {
            return skip() >= 0 ? (char) skip() : null;
        }
 
        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }
 
        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
 
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
 
        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
 
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}