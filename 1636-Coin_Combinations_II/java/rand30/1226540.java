//package backtrackingAndDP;
 
import java.util.Scanner;
 
public class entry_1226540 {
 
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int length=sc.nextInt();
		int sum=sc.nextInt();
		
		int coins[]=new int[length];
		for(int index=0;index<length;index++)
		{
			coins[index]=sc.nextInt();
		}
		int ways=coinCombs(length,sum,coins);
		System.out.println(ways);
	}
 
	private static int coinCombs(int length, int sum, int[] coins) {
		
		int dp[]=new int[sum+1];
		dp[0]=1;
		for(int i=0;i<length;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(coins[i]>j)continue;
				dp[j]=(dp[j]+dp[j-coins[i]])%1000000007;
			}
		}
		return dp[sum]%1000000007;
	}
}