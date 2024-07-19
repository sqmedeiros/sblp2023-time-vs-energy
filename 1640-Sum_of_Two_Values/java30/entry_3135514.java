import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class entry_3135514 {
	public static void main(String[]args) throws Exception {
		Kattio in = new Kattio();
		PrintWriter out = new PrintWriter(System.out);
		boolean possible = false;
		int N = in.nextInt();
		int X = in.nextInt();
		Integer[]a = in.readArray(N);
		//Arrays.sort(a);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i ++) {	
			if(map.containsKey(X - a[i])) {
				out.println(map.get(X - a[i])+ 1 + " " + (i+1));
				possible = true;
			}
			map.put(a[i], i);
		}
		
		if(!possible) out.println("IMPOSSIBLE");
		
		out.close();
	}
	
	
	static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
 
        // standard input
        public Kattio() {
            this(System.in, System.out);
        }
 
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
 
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
 
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public String readLine() throws Exception {
            return r.readLine();
        }
 
        public long[] readArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }
 
        public Integer[] readArray(int n) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
 
        public int[]prefixSum(int N, int[]a){
            int[]nw = new int[N];
            nw[0] = a[0];
            for (int i = 1; i < N; i ++) nw[i] = nw[i-1] + a[i];
            return nw;
        }
 
        public int[][] prefixSum(int N, int[][]grid){
            int[][]pfx = new int[grid.length][grid.length];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    pfx[i][j] = grid[i][j]
                            + pfx[i-1][j]
                            + pfx[i][j-1]
                            - pfx[i-1][j-1];
                }
            }
 
            return pfx;
        }
 
        public int prefixSum2D(int x1, int y1, int x2, int y2, int[][]pfx) {
            return pfx[x2][y2] - pfx[x1-1][y2] - pfx[x2][y1-1] + pfx[x1-1][y1-1];
        }
    }
}
