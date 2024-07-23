import java.util.*;
import java.io.*;
 
public class entry_5837683 {
    static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a_, int b_){
            a = a_;
            b = b_;
        }
        public int compareTo(Pair o){
            if(b == o.b){
                return Integer.compare(a, o.a);
            }
            else{
                return Integer.compare(b, o.b);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        FastIO io = new FastIO();
        int n = io.nextInt(); int k = io.nextInt();
        TreeMap<Integer, Integer> people = new TreeMap<>();
        Pair[] movies = new Pair[n];
        people.put(0, k);
        for (int i = 0; i < n; i++) {
            movies[i] = new Pair(io.nextInt(), io.nextInt());
        }
        Arrays.sort(movies);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(people.floorKey(movies[i].a) != null){
                count++;
                int x = people.floorKey(movies[i].a);
                if(people.get(x) == 1){
                    people.remove(x);
                }
                else{
                    people.put(x, people.get(x) - 1);
                }
                people.put(movies[i].b, people.getOrDefault(movies[i].b, 0) + 1);
            }
        }
        io.println(count);
        io.close();
    }
}
 
class FastIO extends PrintWriter {
	private InputStream stream;
	private byte[] buf = new byte[1 << 16];
	private int curChar;
	private int numChars;
 
	// standard input
	public FastIO() { this(System.in, System.out); }
 
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
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars == -1) {
				return -1;  // end of file
			}
		}
		return buf[curChar++];
	}
 
	// to read in entire lines, replace c <= ' '
	// with a function that checks whether c is a line break
	public String next() {
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');
 
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = nextByte();
		} while (c > ' ');
		return res.toString();
	}
 
	public int nextInt() {  // nextLong() would be implemented similarly
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');
 
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = nextByte();
		}
 
		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res = 10 * res + c - '0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}
 
	public double nextDouble() { return Double.parseDouble(next()); }
}