/*
 * akshaygupta26
 */
import java.io.*;
import java.util.*;
public class entry_2198420
{ 
	
    public static void main(String[] args) 
	{ 
			FastReader sc=new FastReader(); 
			PrintWriter pw=new PrintWriter(new BufferedOutputStream(System.out));
			
			int dp[][]=new int[1005][100001];
			
			int n=sc.nextInt(),x=sc.nextInt();
			int pr[]=new int[n+1];
			int pa[]=new int[n+1];
			for(int i=0;i<n;i++) pr[i+1]=sc.nextInt();
			for(int i=0;i<n;i++) pa[i+1]=sc.nextInt();
			
			for(int i=1;i<=n;i++) {
				for(int j=0;j<=x;j++) {
					if(j<pr[i]) {
						dp[i][j]=dp[i-1][j];continue;
					}
					dp[i][j]=Math.max(dp[i-1][j], pa[i]+dp[i-1][j-pr[i]]);
				}
			}
			
			pw.println(dp[n][x]);
			pw.close();
	} 
 
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
 
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
 
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
 
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
 
 
} 
