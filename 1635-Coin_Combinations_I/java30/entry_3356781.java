/*
1,5,7
*/
import java.io.*;
import java.util.*;
 
public class entry_3356781 {
	
	static final int MOD = (int)1e9+7;
	
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		/******  CODE STARTS HERE  *****/
		//--------------------------------------------------------------------------------------------------------
		int n = fs.nextInt(), x=fs.nextInt();
		int[] a = fs.readArray(n);
		int[] dp = new int[x+1];
		dp[0] = 1;
		for(int i=1; i<=x; i++)
			for(int j: a)
				if(i>=j)dp[i] = (dp[i]+dp[i-j])%MOD;
		out.println(dp[x]);
		out.close();
	}
    
	//******  CODE ENDS HERE  *****
	//----------------------------------------------------------------------------------------------------------------
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	
	//----------- FastScanner class for faster input---------------------------
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}