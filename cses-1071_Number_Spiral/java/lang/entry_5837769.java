import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
 
public class entry_5837769 {
	public static void main(String[] args) throws IOException{
		Kattio sc = new Kattio(System.in, System.out);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		for(int i =0;i<t;i++) {
			long r = sc.nextLong();
			long c = sc.nextLong();
			long cur=0;
			if(c>=r) {
				if(c==r) {
					cur = c*c;
					cur-=r-1;
				}
 
				else if(c%2==1) {
					cur = c*c;
					cur-=r-1;
				}
				//may not work
				else if(c%2==0) {
					cur = (c-1)*(c-1)+1;
					cur+=r-1;
				}
			}
			if(c<r) {
				if(r%2==0) {
					cur = r*r;
					cur-=c-1;
				}
				if(r%2==1) {
					cur = (r-1)*(r-1)+1;
					cur+=c-1;
				}
			}
			output.write(String.valueOf(cur+"\n"));
		}
		output.flush();
	}
	static class Kattio extends PrintWriter {
	    private BufferedReader r;
	    private StringTokenizer st;
	    // standard input
	    public Kattio() { this(System.in, System.out); }
	    public Kattio(InputStream i, OutputStream o) {
	        super(o);
	        r = new BufferedReader(new InputStreamReader(i));
	    }
	    // USACO-style file input
	    public Kattio(String problemName) throws IOException {
	        super(problemName + ".out");
	        r = new BufferedReader(new FileReader(problemName + ".in"));
	    }
	    // returns null if no more input
	    public String next() {
	        try {
	            while (st == null || !st.hasMoreTokens())
	                st = new StringTokenizer(r.readLine());
	            return st.nextToken();
	        } catch (Exception e) { }
	        return null;
	    }
	    public int nextInt() { return Integer.parseInt(next()); }
	    public double nextDouble() { return Double.parseDouble(next()); }
	    public long nextLong() { return Long.parseLong(next()); }
	}
}
