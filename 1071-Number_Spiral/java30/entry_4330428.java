import java.io.*;
import java.util.*;
 
public class entry_4330428 {
    public static void main(String[] args)
    {
        Kattio io = new Kattio();
        long test = io.nextInt();
        
        for (int i = 0; i < test; i++)
        {
            long y = io.nextInt();
            long x = io.nextInt();
 
            if (x == 1 && y == 1)
            {
                io.println(1);
            }
            else if (x > y)
            {
                if (x % 2 != 0)
                {
                    io.println((x * x) - y + 1);
                }
                else
                {
                    io.println(((x - 1) * (x - 1)) + 1 - 1 + y);
                }
            }
            else
            {
                if (y % 2 == 0)
                {
                    io.println((y * y) - x + 1);
                }
                else
                {
                    io.println(((y - 1) * (y - 1)) + 1 - 1 + x);
                }
            }
            
        }
        
        io.close();
    }
}
 
class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in,System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName+".out");
		r = new BufferedReader(new FileReader(problemName+".in"));
	}
	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) {}
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}