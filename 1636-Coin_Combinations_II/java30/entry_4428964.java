import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
 
 
public class entry_4428964 {
	
	static int n;
	static int x;
	static long []coins;
	
	static final long mod=(long) (1e9+7);
	
	
	public static void main (String []args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		coins=new long[n];
		
	    
		
		
	    st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			coins[i]=Long.parseLong(st.nextToken());
	
		
 
		
		
		long []ans=new long[x+1];
		ans[0]=1;
		for(int i=0;i<n;i++) 
		{
			
			for(int j=1;j<x+1;j++)
			{
				if(coins[i]<=j)
					ans[j]=(ans[j]+ans[(int) (j-coins[i])])%mod;	
			}
			
		}
		System.out.println(ans[x]);
		
		
		
		
		
		
		
	}
 
	
 
	
	
	
	
	
 
 
	
	
}