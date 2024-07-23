import java.util.*;
import java.lang.*;
import java.io.*;
 
class entry_5087927
{
    static BufferedWriter put = new BufferedWriter(new OutputStreamWriter(System.out));
    static int intmax = Integer.MAX_VALUE;
    static int intmin = Integer.MIN_VALUE;
    static long mod = 1000000007L;
    
    public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader get = new FastReader();
	    
	    int T = get.nextInt();
	    
	    while(T-->0)
	    {
	    	long i = get.nextLong();
	    	long j = get.nextLong();
	    	
	    	ans(i, j);
	    	
	    	put.flush();
	    }
	    
	    put.close();
	}
	
	public static void ans( long i, long j ) throws java.lang.Exception
	{
		long ans = 0;
		
		if(i>j)
		{
			if(i%2==0) ans= i*i -(j-1);
			else ans = (i-1)*(i-1) +1+(j-1);
		}
		else
		{
			if(j%2!=0) ans= j*j -(i-1);
			else ans = (j-1)*(j-1) +1+(i-1);
		}
		
		put.write(ans+"\n");
	}
}
 
class FastReader
{
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
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