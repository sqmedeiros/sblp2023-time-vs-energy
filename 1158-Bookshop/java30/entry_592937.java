import java.util.*;
import java.lang.*;
 
public class entry_592937
{
	
static int mxN=100000,M=1000000000+7;
static int dp[] = new int[mxN+1];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int h[] = new int[n];
		int s[] = new int[n];
		
		for(int i=0;i<n;i++)
			h[i] = sc.nextInt();
		
		for(int i=0;i<n;i++)
			s[i] = sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			for(int j=x;j>=h[i];--j)
			{
				dp[j] = (dp[j] > dp[j-h[i]]+s[i]) ? dp[j] : dp[j-h[i]]+s[i];
			}
		}
 
		System.out.println(dp[x]);
	}
}