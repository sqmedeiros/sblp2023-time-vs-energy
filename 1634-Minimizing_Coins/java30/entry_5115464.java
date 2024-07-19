import java.util.*;
import java.lang.*;
import java.io.*;
 
class entry_5115464
{
    static BufferedWriter put = new BufferedWriter(new OutputStreamWriter(System.out));
    static int intmax = Integer.MAX_VALUE;
    static int intmin = Integer.MIN_VALUE;
    static long mod = 1000000007L;
    
    public static void main (String[] args) throws java.lang.Exception
	{
	    Reader get = new Reader();
	    
	    int T = 1;
	    
	    while(T-->0)
	    {
	    	int n=get.nextInt(), k=get.nextInt();
	    	int[] arr = new int[n];
	    	for(int i=0; i<n; i++) arr[i]=get.nextInt();
	    	
	    	long[] dp = new long[1000001];
	    	dp[0]=0;
	    	
	    	for(int i=1; i<=k; i++) 
	    	{
	    		dp[i]=intmax;
	    		
	    		for(int j=0; j<n; j++)
	    		{
	    			if(i>=arr[j]) dp[i]= Math.min(dp[i], dp[i-arr[j]]+1);
	    		}
	    	}
	    	
	    	if(dp[k]==intmax) put.write("-1\n");
	    	else put.write(dp[k]+"\n");
	    	
	    	put.flush();
	    }
	       
	    put.close();
	}
}
 
class Reader {
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