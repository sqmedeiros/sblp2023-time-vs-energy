import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class entry_2316765
{
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
	public static void main (String[] args) throws java.lang.Exception
	{
	    br=new BufferedReader(new InputStreamReader(System.in));
	 out=new PrintWriter(System.out);   
		next();
		int n=readInt();
			int sum=readInt();
			int m=1000000007;
			int[] arr=new int[n];
			readLine(arr,n);
			int[] dp=new int[sum+1];
			dp[0]=1;
			for(int i=0;i<n;i++)
			{
			    for(int j=arr[i];j<=sum;j++)
			    {
			        dp[j]=(dp[j-arr[i]]+dp[j])%m;
			    }
			}
			out.print(dp[sum]+"\n");
			
		out.flush();
		
	}
	
	public static int nextInt()throws Exception 
	{
	    return Integer.parseInt(br.readLine());
	}
	public static long nextLong()throws Exception 
	{
	    //br=new BufferedReader(new InputStreamReader(System.in));
	    return Long.parseLong(br.readLine());
	}
	public static void readLine(int[] arr,int n)throws Exception 
	{
	    //    br=new BufferedReader(new InputStreamReader(System.in));
	        st=new StringTokenizer(br.readLine());
	        for(int i=0;i<n;i++)
	        {
	            arr[i]=Integer.parseInt(st.nextToken());
	        }
	}
	public static void next()throws Exception
	{
	        st=new StringTokenizer(br.readLine());
	    
	}
	public static int readInt()throws Exception
	  {
	        return Integer.parseInt(st.nextToken());
	  }
	public static long readLong()throws Exception
	  {
	        return Long.parseLong(st.nextToken());
	  }
	
}