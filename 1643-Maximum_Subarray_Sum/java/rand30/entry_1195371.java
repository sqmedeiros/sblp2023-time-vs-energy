import java.util.*;
import java.io.*;
 
class entry_1195371 {
 
    //Reader from https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/?ref=rp
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
 
		public Reader(String file_name) throws IOException { 
			din = new DataInputStream(new FileInputStream(file_name)); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 
 
		public String readLine() throws IOException { 
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
 
		public int nextInt() throws IOException { 
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
			} 
			while ((c = read()) >= '0' && c <= '9'); 
			if (neg) 
				return -ret; 
			return ret; 
		} 
 
		public double nextDouble() throws IOException { 
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
 
    public static void main(String[] args) throws IOException { 
		Reader s=new Reader(); 
        int n = s.nextInt(); 
        int[] a = new int[n];
 
        for(int i = 0 ; i < n ; i++) {
            a[i] = s.nextInt();
        }
 
        long ans = a[0], currAns = 0;
 
        for(int i = 0 ; i <  n ; i++) {
            currAns += a[i];
 
            ans = Math.max(ans, Math.max(currAns, a[i]));
            if(currAns < 0) {
                currAns = 0;
            }
        }
 
        System.out.println(ans);
		
	} 
}
