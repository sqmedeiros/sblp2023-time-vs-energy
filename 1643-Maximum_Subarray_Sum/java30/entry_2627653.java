import java.util.*;
import java.lang.*;
import java.io.*;
 
public class entry_2627653{
     static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
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
            } while ((c = read()) >= '0' && c <= '9');
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
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
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
 
    public static long bSearch(List<Long> prices, long searchPrice){
        int low = 0;
        int high = prices.size()-1;
        int mid =  -1;
        long index = -1;
 
        while(low<=high){
            mid = low+(high-low)/2;
            if(prices.get(mid) <= searchPrice){
                index = prices.get(mid);
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
 
        return index;
 
 
    }
 
    public static boolean isMergable(int index, int nextIndex, List<long[]> intervals){
        return (intervals.get(index)[1]>=intervals.get(nextIndex)[0] && intervals.get(index)[1] <= intervals.get(nextIndex)[1]);
    }
 
	public static void main(String[] args) throws IOException
    {
 
        Reader scan = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        FileWriter output = null;
 
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                scan = new Reader("input.txt"); 
                output = new FileWriter("output.txt");
                out = new PrintWriter(output);
            }
            catch (Exception e) {
                
            }
        }
        int n = scan.nextInt();
        long[] arr = new long[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scan.nextLong();
        }
 
        long maxSum = Long.MIN_VALUE;
        long tempSum = 0;
 
        for(int i=0;i<n;i++){
            tempSum += arr[i];
            maxSum = Math.max(tempSum, maxSum);
            tempSum = Math.max(0, tempSum);
        }
        out.println(maxSum);
 
        out.close();
        out.flush();
    }
}
