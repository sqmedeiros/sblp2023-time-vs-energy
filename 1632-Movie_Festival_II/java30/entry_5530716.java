import java.util.*;
import java.io.*;
import java.util.Comparator;
 
public class entry_5530716 {
    public static void main(String[] args) {
        FastIO s = new FastIO();
 
        int n = s.nextInt();
        int k = s.nextInt();
 
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Movie[] movies = new Movie[n];
 
        for(int i = 0; i < n; i++) {
            int st = s.nextInt();
            int end = s.nextInt();
 
            movies[i] = new Movie(st, end);
        }
 
        Arrays.sort(movies, Comparator.comparingInt(movie -> movie.end));
        map.put(0, k);
        int ans = 0;
 
        for(Movie movie : movies) {
 
            // gets the most recently finished movie
            Integer lower = map.floorKey(movie.start);
 
            if(lower != null) {
                ans++;
                if(map.get(lower) == 1) {
                    map.remove(lower);
                } else {
                    map.put(lower, map.get(lower) - 1);
                }
 
                map.put(movie.end, map.getOrDefault(movie.end, 0) + 1);
            }
        }
 
        System.out.println(ans);
    }
 
    static class Movie {
        int start;
        int end;
 
        public Movie(int a, int b) {
            start = a;
            end = b;
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
}
