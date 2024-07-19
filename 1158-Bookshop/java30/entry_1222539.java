import java.util.*;
import java.io.*;
 
public class entry_1222539 {
 
	static int find(int pri[],int pgs[],int sum,int n)
	{
		int dp[][] = new int[n+1][sum+1];
 
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(pri[i-1]<=j)
				{
					dp[i][j] = Math.max(pgs[i-1]+dp[i-1][j-pri[i-1]],dp[i-1][j]);
				}else dp[i][j] = dp[i-1][j];
			}
		}
 
		return dp[n][sum];
	}
	//00 01 02 03
	//10 11 12 13
	//20 21 22 23
	//30 31 32 33
 
	public static void main(String[] args) {		
		Scanner sc = new Scanner();
 
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int pri[] = new int[n];
		int pages[] = new int[n];
 
		for(int i=0;i<n;i++)
			pri[i]=sc.nextInt();
 
		for(int i=0;i<n;i++)
			pages[i]=sc.nextInt();
 
		out.println(find(pri,pages,sum,n));
		out.close();
		
	}
	/////////////////DONT TOUCH THiS//////////////////////////////////////////////////////////////////
	static PrintWriter out=new PrintWriter(System.out);
	static class Scanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
}