import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
 
public class entry_5773909 {
 
    static class Pair {
        int s;
        int e;
 
        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
 
        public int getS() {
            return s;
        }
 
        public int getE() {
            return e;
        }
 
        @Override
        public String toString() {
            return "(" + s + ", " + e + ")";
        }
 
    }
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), k = sc.nextInt();
        List<Pair> movies = new ArrayList<>();
        TreeMap<Integer, Integer> availability = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            movies.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        availability.put(0, k);
        movies.sort(Comparator.comparing(Pair::getE));
        // System.out.println("movies "+ movies);
        int cnt = 0;
        for (Pair movie : movies) {
            var entry = availability.lowerEntry(movie.s + 1);
            if (entry != null) {
                cnt += 1;
                availability.put(movie.e, availability.getOrDefault(movie.e, 0) + 1);
                if (entry.getValue() == 1)
                    availability.remove(entry.getKey());
                else
                    availability.put(entry.getKey(), entry.getValue() - 1);
            }
        }
        System.out.println(cnt);
    }
 
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
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
 
        public int nextInt() {
            try {
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
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }
    }
 
}