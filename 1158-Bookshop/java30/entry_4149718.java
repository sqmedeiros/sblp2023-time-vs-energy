import java.util.*;
import java.io.*;
 
public class entry_4149718 {
    final static int MOD = (int)1e9+7;    
    final static int INT_MAX = (int)1e8;  
    final static int INT_MIN = -(int)1e8; 
    final static long LONG_MAX = (long)1e16;
    static int n;
    public static void main(String[] args) throws IOException{
        Reader rs = new Reader();
        
            int n = rs.nextInt();
            int x = rs.nextInt();
            int[] price = new int[n];
            int[] page = new int[n];
            for(int i=0;i<n;i++){
                price[i] = rs.nextInt();
            }
            for(int i=0;i<n;i++){
                page[i] = rs.nextInt();
            }
            int[] prev = new int[x+1];
            int[] curr = new int[x+1];
            prev[0] = 0;
            for(int i=1; i<=n; i++){
                for(int j=1; j<=x; j++){
                    int ans = INT_MIN;
                    if(price[i-1]<=j)
                        ans = Math.max(ans, prev[j-price[i-1]]+page[i-1]);//f(i-1, j-price[i-1], price, page, dp)+page[i-1]);
                    ans = Math.max(ans, prev[j]);//f(i-1, j, price, page, dp));
                    curr[j] = ans;
                }
                prev = curr.clone();
            }
            System.out.println(curr[x]);
 
            // int[][] dp = new int[n+1][x+1];
            // for(int i=0; i<=n; i++){
            //     Arrays.fill(dp[i], -1);
            // }
            // System.out.println(f(n, x, price, page, dp));
        
        
        rs.close();
    }
    static int f(int n, int x, int[] price, int[] page, int[][] dp){
        if(x==0 || n==0)
            return 0;        
        if(dp[n][x]!=-1)
            return dp[n][x];
        int ans = INT_MIN;
        if(price[n-1]<=x)
            ans = Math.max(ans, f(n-1, x-price[n-1], price, page, dp)+page[n-1]);
        ans = Math.max(ans, f(n-1, x, price, page, dp));
        return dp[n][x] = ans;
    }
    
    
    
    
    
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        private int lineLength = (int)1e6;
        private int wordLength = (int)1e3;
        
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public String nextLine() throws IOException {
            byte[] buf = new byte[lineLength]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == 10)    // ascii of newLine = 10
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        
        public String next() throws IOException {
            byte[] buf = new byte[wordLength]; // word length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == 32 || c == 10)      // ascii of space = 32 and newLine = 10 
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
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        
        public double nextDouble() throws IOException{
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }while ((c = read()) >= '0' && c <= '9');
            if (c == '.'){
                while ((c = read()) >= '0' && c <= '9'){
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
            if (din != null)
                din.close();
        }
    }
}