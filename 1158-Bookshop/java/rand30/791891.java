import java.io.*;
import java.util.*;
//import java.lang.*;
 
public class entry_791891 {
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
                catch (IOException  e) 
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
	public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt(),x=in.nextInt();
        int[][] dp = new int[n+1][x+1];
        int[] cost = new int[n+1];
        int[] noOfPages = new int[n+1];
        for(int i=1;i<=n;i++)
        	cost[i] = in.nextInt();
        for(int i=1;i<=n;i++)
        	noOfPages[i] = in.nextInt();
        for(int i=1;i<=n;i++) {
        	for(int j=0;j<=x;j++) {
        		dp[i][j] = dp[i-1][j];
        		if((j-cost[i])>=0) {
        			dp[i][j] = Math.max(dp[i][j],dp[i-1][j-cost[i]]+noOfPages[i]);
        		}
        	}
        }
//        for(int i=0;i<=n;i++) {
//        	for(int j=0;j<=x;j++) {
//        		out.print(dp[i][j]+" ");
//        	}
//        	out.println();
//        }
        out.println(dp[n][x]);
        out.close();
	}
}