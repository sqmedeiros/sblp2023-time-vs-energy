import java.io.*;
import java.util.*;
 
public class entry_2811118 {
	public static void main(String[] args) throws FileNotFoundException,IOException,Exception {
        boolean isFile = true;
        isFile &= false;
        ScanReader in;PrintWriter out;
 
        if(isFile) {
            InputStream inputStream = new FileInputStream("input.txt");
            in = new ScanReader(inputStream,new BufferedReader(new FileReader("input.txt")));
            out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
 
        } else {
            InputStream inputStream = System.in;
            in = new ScanReader(inputStream,new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(System.out);
        }
 
        Palindrome solver = new Palindrome();
 
        int t = 1;
        // t = in.nextInt();
 
        for (int i = 0; i < t; i++) {
            solver.solve(i + 1, in, out);
        }
 
        out.close();
	}
 
    static class Palindrome {
        static long mod = 1000000007;
        static long maxX = (long) 1e18;
        static long mod2 = 998244353;
 
        //  Check for boundary Condition because you are not Sehwag..
        //  For multiple Test cases take all input -> do not use return while taking input.
        //  at least check constraint for once it can be done in nested loops.
        //  Think simple and short
        //  check for proof of solution
        //  Read editorial after contest.....
 
        void solve(int testNumber, ScanReader in, PrintWriter out) throws Exception {
        	long n = in.nextLong();
 
        	int k = in.nextInt();
 
        	long[] a = new long[k];
 
        	for(int i =0;i<k;i++)
        		a[i] = in.nextLong();
 
 
        	long ans = 0;
 
        	for(int i = 1; i < (1<<k);i++) {
        		int c = 0;
        		long mul = 1;
        		for(int j = 0;j<k;j++) {
        			if( (i&(1<<(j))) > 0 ) {
        				c++;
 
        				if(mul> n/a[j]) {
        					mul = n+1;
        					break;
        				}
 
        				mul *= a[j];
        			}
        		}
 
        		long p = n/mul;
 
        		ans += (c%2 == 0? -p : p);  
        	}
 
        	out.print(ans);
        }
    }
 
    
    static class ScanReader {
        private final InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br;
 
        public ScanReader(InputStream stream,BufferedReader br) {
        this.stream = stream;
            this.br = br;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
 
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
 
        public int nextInt() {
            int c = read(); 
 
            while (isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-') {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next() {
            return readString();
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}