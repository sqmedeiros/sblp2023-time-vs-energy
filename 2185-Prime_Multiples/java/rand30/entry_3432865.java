 
import java.io.*;
import java.util.*;
 
 
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
public class entry_3432865 {
    
	public static void main(String[] args) throws IOException{
		Reader sc= new Reader();
		PrintWriter out = new PrintWriter(System.out);
		long n = sc.nextLong();
		int k = sc.nextInt();
		long prime[]= new long[k];
		for(int i=0;i<prime.length;i++) {
			prime[i]= sc.nextLong();
		}
		long ans=0;
		int totalSubSets = 1<<k;
		for(int i=1;i<totalSubSets;i++) {
			long val = n,count= 0;
			for(int j=0;j<k;j++) {
				if((i&(1<<j))!=0) {
					count++;
					 val /=prime[j];
				}
			}
			if(count%2!=0) {
				ans +=val;
			}else {
				ans -= val;
				//System.out.println(ans+" orjje");
			}
		}
		out.println(ans);
		out.close();
 
	}
 
}