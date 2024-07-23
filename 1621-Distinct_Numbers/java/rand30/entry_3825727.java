	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.*;
	public class entry_3825727 {
	    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    static StringTokenizer st;
	    static Scanner sc = new Scanner(System.in);
	    public static void main(String[] args) throws IOException {
	    	
	    	Set<Integer> set = new HashSet<Integer>();
	    	int n = readInt();
	    	for(int i=0; i<n; i++) {
	    		set.add(readInt());
	    	}
	    	System.out.println(set.size());
	    }
	    
	    static String next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine().trim());
	        return st.nextToken();
	    }
	 
	    static long readLong() throws IOException {
	        return Long.parseLong(next());
	    }
	 
	    static int readInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	 
	    static double readDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	 
	    static char readCharacter() throws IOException {
	        return next().charAt(0);
	    }
	 
	    static String readLine() throws IOException {
	        return br.readLine().trim();
	    }
	}