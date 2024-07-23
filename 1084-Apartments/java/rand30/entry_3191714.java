import java.util.*;
import java.io.*;
 
class Kattio extends PrintWriter {
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
 
public class entry_3191714 {
	static Kattio io = new Kattio();
	public static void main(String[] args) {
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();
 
        int c = 0;
 
		int l = 0;
		int j = 0;
 
 
        ArrayList<Integer> a = new ArrayList<Integer>();
 
        for (int i = 0; i < n; i++) {
            a.add(io.nextInt());
        }
 
        ArrayList<Integer> b = new ArrayList<Integer>();
 
        for (int ii = 0; ii < m; ii++) {
            b.add(io.nextInt());
        }
		
		Collections.sort(a);
		Collections.sort(b);
 
        while (l < n && j < m) {
            if (Math.abs(b.get(j) - a.get(l)) <= k) {
                c++;
				l++;
				j++;
            } else if (a.get(l) > b.get(j)) {
                j++;
            } else {
                l++;
            }
        }
 
        io.println(c);
		
        io.close();
	}
}