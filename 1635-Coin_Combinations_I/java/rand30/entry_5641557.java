import java.io.*;
import java.util.*;
 
public class entry_5641557 {
    final static FastReader fr = new FastReader();
    final static PrintWriter out = new PrintWriter(System.out);
    static final long mod = (long) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] coins = new int[n] ;
        for (int i = 0; i < n; i++){
            coins[i] = fr.nextInt();
        }
        int[] dp = new int[x+1] ;
        dp[0] = 1 ;
        for(int cur = 1; cur <= x; cur++){
            for(int coin: coins){
                if(cur-coin >= 0){
                    dp[cur] += dp[cur-coin] ;
                    dp[cur] %= mod;
                }
            }
        }
        out.println(dp[x]);
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
    }
}
 