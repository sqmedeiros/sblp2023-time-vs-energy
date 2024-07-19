import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class entry_1328123 {
    public static void main(String[] args) throws IOException {
 
        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();
 
        List<Integer> desiredSizes = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            desiredSizes.add(scn.nextInt());
        }
        for (int i = 0; i < m; i++) {
            sizes.add(scn.nextInt());
        }
 
        desiredSizes.sort(Integer::compareTo);
        sizes.sort(Integer::compareTo);
 
        int res = 0;
        int jj = 0;
 
        for (int i = 0; i < n; i++) {
            if (jj >= m)
                break;
            int desiredSize = desiredSizes.get(i);
            boolean down = (desiredSize - k) <= sizes.get(jj);
            boolean top = (desiredSize + k) >= sizes.get(jj);
 
            if (down && top) {
                res++;
                jj++;
            } else {
                while (!down) {
                    jj++;
                    if (jj >= m)
                        break;
                    down = (desiredSize - k) <= sizes.get(jj);
                    if ((desiredSize + k) >= sizes.get(jj) && down) {
                        res++;
                        jj++;
                        break;
                    }
                }
            }
        }
 
        System.out.print(res);
    }
 
    static Reader scn = new Reader();
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
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
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
}