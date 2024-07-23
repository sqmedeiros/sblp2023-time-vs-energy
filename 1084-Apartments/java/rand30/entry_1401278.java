import java.io.*;
import java.util.*;
 
public class entry_1401278 {
	private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));	
	private static final int mod = (int) 1e9 + 7;
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int m = fr.nextInt();
		int k = fr.nextInt();
		// int[] a = new int[n];
		// int[] b = new int[m];
		PriorityQueue<Integer> a = new PriorityQueue<>(n);
		PriorityQueue<Integer> b = new PriorityQueue<>(m);
 
 
		for(int i = 0; i < n; i++) {
			a.add(fr.nextInt());
		}
 
		for(int i = 0; i < m; i++) {
			b.add(fr.nextInt());
		}
 
		solve(a, b, k);
 
		out.flush();
		out.close();
		fr.close();
	}
 
 
	public static void solve(PriorityQueue<Integer> a, PriorityQueue<Integer> b, int k) {
		int maxMatching = 0;
		while(!a.isEmpty() && !b.isEmpty()) {
			if(b.peek() >= a.peek() - k && b.peek() <= a.peek() + k) {
				maxMatching++;
				a.poll();
				b.poll();
			} else if(a.peek() - k > b.peek()) {
				b.poll();
			} else if(a.peek() + k < b.peek()) {
				a.poll();
			}
		}
		out.println(maxMatching);
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