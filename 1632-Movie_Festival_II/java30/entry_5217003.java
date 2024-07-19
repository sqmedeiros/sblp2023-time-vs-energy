import java.io.*;
import java.util.*;
 
public class entry_5217003 {
	public static class Movie implements Comparable<Movie> {
		Integer start;
		Integer end;
		public Movie (int s, int e) {
			start = s;
			end = e;
		}
		public int compareTo (Movie x) {
			if (end == x.end) {return Integer.compare(x.start, start);}
			return Integer.compare(end, x.end);
		}
	}
	public static void main(String[] args) throws IOException {
		
		FastIO io = new FastIO();
		int N = io.nextInt();
		int numP = io.nextInt();
		List<Movie> movies = new ArrayList<Movie>();
		for (int n = 0; n < N; n++) {
			movies.add(new Movie((Integer) io.nextInt(), (Integer) io.nextInt()));
		}
		
		Collections.sort(movies);
		/*
		for (int n = 0; n < N; n++) {
			out.println(movies.get(n).start + " " + movies.get(n).end);
		}
		*/
		TreeMap<Integer, Integer> finishTimes = new TreeMap<Integer, Integer>();
		finishTimes.put(0, numP);
		int n = 0;
		int ans = 0;
		Movie movie = movies.get(n);
		Integer satisfies = 0;
		while (n < N) {
			movie = movies.get(n);
			satisfies = finishTimes.floorKey(movie.start);
			if (satisfies != null) {
				finishTimes.put(satisfies, finishTimes.get(satisfies)-1);
				if (finishTimes.get(satisfies) == 0) {
					finishTimes.remove(satisfies);
				}
				ans++;
				//Add person back with their expected ending time
				if (finishTimes.containsKey(movie.end)) {
					finishTimes.put(movie.end, finishTimes.get(movie.end)+1);
				} else {
					finishTimes.put(movie.end, 1);
				}
			}
			//Remove person that can watch the movie
			
			n++;
		}
		//out.println(finishTimes);
		io.println(ans);
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