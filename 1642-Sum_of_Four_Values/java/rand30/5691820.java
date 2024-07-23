import java.io.*;
import java.util.*;
 
public class entry_5691820 {
 
    public static int[] indices = {-1, -1, -1, -1};
    
	public static void main(String[] args) throws IOException {
		FastIO io = new FastIO();
		PrintWriter out = new PrintWriter(System.out);
		
		int N = io.nextInt();
		int X = io.nextInt();
		
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
		    nums[i] = io.nextInt();
		}
		
		HashMap<Integer, int[]> map = new HashMap<>();
		 
		for (int i = 0; i < N; i++) {
		    for (int j = i + 1; j < N; j++) {
		        map.put(X - nums[i] - nums[j], new int[] {i, j});
		    }
		}
		
		for (int i = 0; i < N; i++) {
		    for (int j = i + 1; j < N; j++) {
		        int term = nums[i] + nums[j];
		        if (map.containsKey(term)) {
		            int[] res = map.get(term);
		            if (res[0] != i && res[0] != j && res[1] != i && res[1] != j) {
		                io.print((i + 1) + " " + (j + 1) + " " + (res[0] + 1) + " " + (res[1] + 1));
		                io.close();
		                return;
		            }
		        }
		    }
		}
		
		io.print("IMPOSSIBLE");
		io.close();
	}
	
	public static void findSol(int[] nums, int num, int index) {
	    for (int i = 0; i < nums.length; i++) {
	        if (i == indices[0] || i == indices[1] || i == indices[2] || i == indices[3]) continue;
	        if (nums[i] == num) {
	            indices[index] = i;
	            return;
	        }
	    }
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