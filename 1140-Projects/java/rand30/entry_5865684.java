import java.util.*;
import java.io.*;
 
public class entry_5865684 {
    public static void main(String[] args) throws IOException{
        FastIO io = new FastIO();
        int n = io.nextInt();
        int[][] info = new int[n][3];
        for (int i = 0; i < n; i++) {
            int a = io.nextInt(); int b = io.nextInt();int c = io.nextInt();
            info[i][0] = a; info[i][1] = b; info[i][2] = c;
        }
        Arrays.sort(info, (a, b) -> Long.compare(a[1], b[1]));
        TreeMap<Integer, Long> ans = new TreeMap<>();
        long max = 0;
        for (int i = 0; i < info.length; i++) {
            long left = 0L;
            if(ans.lowerKey(info[i][0]) != null){
                left = ans.get(ans.lowerKey(info[i][0]));
            }
            max = Math.max(max, left + info[i][2]);
            ans.put(info[i][1], max);
        }
        io.println(max);
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