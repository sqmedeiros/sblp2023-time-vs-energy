import java.util.*;
import java.io.*;
public class entry_3331068 {
	public static void main(String[] args) throws IOException {
		FastIO io = new FastIO();
 
		int n = io.nextInt();
		int k = io.nextInt();
 
		Movie[] movies = new Movie[n];
		for(int i = 0; i < n; i++) {
			int b = io.nextInt();
			int e = io.nextInt();
			movies[i] = new Movie(b, e);
		}
		Arrays.sort(movies);
 
		int ans = 0;
 
		TreeMap<Integer,Integer> watching = new TreeMap<Integer,Integer>();
		Map.Entry<Integer,Integer> found;
		watching.put(0, k);
		
		for(int i = 0; i < n; i++) {
			if(watching.floorKey(movies[i].begin) != null) {
				found = watching.floorEntry(movies[i].begin);
				if(found.getValue() == 1) {
					watching.remove(found.getKey());
				} else {
					watching.put(found.getKey(), found.getValue() - 1);
				}
 
				watching.put(movies[i].end, watching.getOrDefault(movies[i].end, 0) + 1);
				ans++;
			}
		}
		io.println(ans);
		
		io.close();
	}
 
	static class Movie implements Comparable<Movie> {
		int begin;
		int end;
		public Movie(int b, int e) {
			begin = b;
			end = e;
		}
 
		public int compareTo(Movie m) {
			if(end == m.end) {
				return Integer.compare(begin, m.begin);
			}
			return Integer.compare(end, m.end);
		}
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
 
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st = new StringTokenizer("");
		private String token;
	
		// standard input
		public Kattio() { this(System.in,System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException { 
			super(new FileWriter(problemName+".out"));
			r = new BufferedReader(new FileReader(problemName+".in"));
		}
	
		private String peek() {
			if (token == null)
				try {
					while (!st.hasMoreTokens()) {
						String line = r.readLine();
						if (line == null) return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) { }
			return token;
		}
		public boolean hasMoreTokens() { return peek() != null; }
		public String next() {
			String ans = peek(); 
			token = null;
			return ans;
		}
		
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}