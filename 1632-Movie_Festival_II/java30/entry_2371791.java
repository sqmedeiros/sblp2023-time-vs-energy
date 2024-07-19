import java.io.*;
import java.util.*;
 
/* TreeSet to manipulate available time of all friends. Alternative to manipulate multiple values of a key
 * Greedy: choose the friend who has closest available time to movie.start
 */
public class entry_2371791 {
	public static void main(String[] args) {
		int n = ni(), k = ni();
		Movie[] movies = new Movie[n];
		for (int i = 0; i < n; i++) {
			movies[i] = new Movie(ni(), ni());
		}
		Arrays.sort(movies);
 
		TreeMap<Integer, Instance> availableTimes = new TreeMap<>();
		availableTimes.put(0, new Instance(k));
 
		int count = 0;
		for (Movie movie : movies) {
			Map.Entry<Integer, Instance> floorEntry = availableTimes.floorEntry(movie.start);
			if (floorEntry != null) {
				count++;
				floorEntry.getValue().instance--;
				if (floorEntry.getValue().instance == 0) {
					availableTimes.remove(floorEntry.getKey());
				}
 
				Instance entry = availableTimes.getOrDefault(movie.end, Instance.Default);
				if (entry != Instance.Default) {
					entry.instance++;
				} else {
					availableTimes.put(movie.end, new Instance(1));
				}
			}
		}
		System.out.println(count);
	}
 
	static class Instance {
		public int instance = 0;
 
		public Instance(int instance) {
			this.instance = instance;
		}
 
		static Instance Default = new Instance(0);
	}
 
	static class Movie implements Comparable<Movie> {
		public int start;
		public int end;
 
		public Movie(int start, int end) {
			this.start = start;
			this.end = end;
		}
 
		@Override
		public int compareTo(Movie o) {
			return end - o.end;
		}
 
		@Override
		public String toString() {
			return start + " " + end;
		}
	}
 
	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;
 
	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
 
	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}
 
	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}
 
	static double nd() {
		return Double.parseDouble(ns());
	}
 
	static char nc() {
		return (char) skip();
	}
 
	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
 
	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
 
	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
 
	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}