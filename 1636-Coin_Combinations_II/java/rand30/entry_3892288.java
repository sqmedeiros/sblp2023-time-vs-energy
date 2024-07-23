import java.io.*;
import java.util.*;
public class entry_3892288
{
	public static void main(String args[])throws IOException
	{
		BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(x.readLine());
		int n=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(x.readLine());
		int arr[]=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		System.out.println(function(t,arr));
	}
	static int function(int n, int coins[])
	{
		int dp[]=new int[n+1];
		dp[0]=1;
		int mod=1000000007;
		// Arrays.sort(coins);
		for(int coin:coins)
		{
			for(int sum=coin; sum<=n; sum++)
			{
				int temp=sum-coin;
				// if(temp<0)continue;
				// if(temp>coin)break;
				dp[sum]=(dp[sum]+dp[temp])%mod;
			}
		}
 
		// System.out.println();
		// for(long  i:dp)System.out.print(i+" ");
 
		return dp[n];
	}
}