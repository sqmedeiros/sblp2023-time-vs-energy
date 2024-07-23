//package USACO;
import java.util.*;
import java.io.*;
import java.util.Comparator;
public class entry_3689920 {
	static class City{
		int start;
		int end;
	}
	static class comp implements Comparator <City> { 
		public int compare(City c1, City c2) {
			if(c1.end < c2.end) {
				return -1;
			}
			else if(c1.end == c2.end && c1.start < c2.start) {
				return -1;
			}
			return 1;
		}
	}
	public static void main(String[]args) throws IOException{
		FastIO io = new FastIO();
		int n = io.nextInt();
		int x = io.nextInt();
		City[]arr = new City[n];
		for(int i = 0; i < n; i++) {
			arr[i] = new City();
			arr[i].start = io.nextInt();
			arr[i].end = io.nextInt();
		}
		Arrays.sort(arr, new comp());
		TreeMap<Integer, Integer> map = new TreeMap();
		int movieswatched = 0;
		map.put(arr[0].end, 1);
		int pos = 1;
		movieswatched = 1;
		int totalpeoplewatching = 1;
		while(pos < n) {
			Integer temp = map.lowerKey(arr[pos].start+1);
			if(totalpeoplewatching < x && temp == null) {
				if(map.containsKey(arr[pos].end)) {
					map.put(arr[pos].end, map.get(arr[pos].end) + 1);
				}
				else {
					map.put(arr[pos].end, 1);
				}
				movieswatched++;
				totalpeoplewatching++;
			}
			else if(temp != null) {
				if(map.get(temp) == 1){
					map.remove(temp);
				}
				else {
					map.put(temp, map.get(temp) - 1);
				}
				if(map.containsKey(arr[pos].end)) {
					map.put(arr[pos].end, map.get(arr[pos].end) + 1);
				}
				else {
					map.put(arr[pos].end, 1);
				}
				movieswatched++;
			}
			pos++;
		}
		io.println(movieswatched);
		io.close();
	}
	static class FastIO extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1<<16];
		private int curChar, numChars;
 
		// standard input
		public FastIO() { this(System.in,System.out); }
		public FastIO(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}
		// file input
		public FastIO(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}
 
		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars == -1) return -1; // end of file
			}
			return buf[curChar++];
		}
 
		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c; do { c = nextByte(); } while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
			return res.toString();
		}
		public int nextInt() { // nextLong() would be implemented similarly
			int c; do { c = nextByte(); } while (c <= ' ');
			int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = 10*res+c-'0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}
		public double nextDouble() { return Double.parseDouble(next()); }
	}
}
