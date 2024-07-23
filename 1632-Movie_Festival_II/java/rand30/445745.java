import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.Comparator;
 
public class entry_445745 {
    public static void main(String[] args) throws IOException {
        FastReader br = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
 
        int n = br.nextInt();
        int k = br.nextInt();
 
        List<Long> movies = new ArrayList<>();
 
        for(int i = 0; i < n; i++) {
            int a = br.nextInt();
            int b = br.nextInt();
            movies.add(((long) a << 32) | b);
        }
 
        Collections.sort(movies, Comparator.comparing(interval -> (int) (interval & 0xFFFFFFFF)));
 
        TreeMap<Integer, Integer> tm = new TreeMap<>();
 
        int ans = 0;
 
        tm.put(0, k);
 
        for(int i = 0; i < movies.size(); i++) {
            long movie = movies.get(i);
            int curStart = (int) (movie >> 32);
            int curEnd = (int) (movie & 0xFFFFFFFF);
 
            Integer chosenEnd = null;
 
            if(tm.containsKey(curStart)) {
                chosenEnd = curStart;
            } else {
                chosenEnd = tm.lowerKey(curStart);
            }
 
            if(chosenEnd != null) {
                int chosenCnt = tm.get(chosenEnd);
                if(chosenCnt == 1) {
                    tm.remove(chosenEnd);
                } else {
                    tm.put(chosenEnd, chosenCnt - 1);
                }
                ans++;
                tm.put(curEnd, tm.getOrDefault(curEnd, 0) + 1);
            }
        }
 
        out.println(ans);
 
        br.close();
        out.close();
    }
 
    static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
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
 
        public double nextDouble() throws IOException
        {
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
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
