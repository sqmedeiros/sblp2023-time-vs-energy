import java.io.*;
import java.util.*;
 
public class entry_2287893 {
	private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));	
	private static final int mod = (int) 1e9 + 7;
	private static final FastReader fr = new FastReader();
	public static void main(String[] args) throws IOException {
		int n = fr.nextInt();
		Set<Long> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(fr.nextLong());
		}
		out.println(set.size());
 
 
 
		out.flush();
		out.close();
		fr.close();
	}
 
	public static void solve() {
 
	}
 
 
	private static class FastReader {
		private final int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public FastReader(String fileName) throws IOException {
			din = new DataInputStream(new FileInputStream(fileName));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String nextLine() throws IOException {
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) { 
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
			do { 
				ret = ret * 10 + c - '0'; 
			}  while ((c = read()) >= '0' && c <= '9'); 
 
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