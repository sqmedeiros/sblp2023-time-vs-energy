import java.util.*;
import java.io.*;
 
public class entry_4147361 {
    final static int MOD = (int)1e9+7;    
    final static int INT_MAX = (int)1e8; 
    final static long LONG_MAX = (long)1e16;
    public static void main(String[] args) throws IOException{
        Reader rs = new Reader();
        
            int n = rs.nextInt();
            int x = rs.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = rs.nextInt();
            }
            long[] prev = new long[x+1];
            long[] curr = new long[x+1];
            Arrays.fill(prev, LONG_MAX);
            prev[0] = 0;
            for(int i=1; i<=n; i++){
                for(int j=1; j<=x; j++){
                    long ans = LONG_MAX;
                    if(arr[i-1]<=j){
                        ans = Math.min(ans, curr[j-arr[i-1]]+1);//f(arr, n, x-arr[n-1])+1);
                    }
                    ans = Math.min(ans, prev[j]);//f(arr, n-1, x));
                    curr[j] = ans;
                }
                prev = curr;
            }
            
            System.out.println(curr[x]>=LONG_MAX?-1:curr[x]);
        
        
        rs.close();
    }
    static int f(int[] arr, int n, int x, int[][] dp){
        if(x==0) return 0;
        if(n==0 || x<0) return INT_MAX;
        if(dp[n][x]!=-1)
            return dp[n][x];
        int ans = INT_MAX;
        if(arr[n-1]<=x){
            ans = Math.min(ans, f(arr, n, x-arr[n-1], dp)+1);
        }
        ans = Math.min(ans, f(arr, n-1, x, dp));
        return dp[n][x] = ans;
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
        
        public String nextLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == 10)    // ascii of newLine = 10
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        
        public String next() throws IOException {
            byte[] buf = new byte[64]; // line length
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