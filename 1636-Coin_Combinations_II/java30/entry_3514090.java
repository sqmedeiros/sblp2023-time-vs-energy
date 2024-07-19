/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class entry_3514090
{
	public static void main (String[] args) throws java.lang.Exception
	{
	  Scanner sc = new Scanner(System.in);
	  int mod = 1000000007;
      int n = sc.nextInt();
      int sum = sc.nextInt();
      int[] coin = new int[n];
      for(int i =0;i<n;i++){
          coin[i]=sc.nextInt();
      }
      int [] dp = new int[sum+1];
      Arrays.fill(dp,0);
      dp[0]=1;
      for(int i = 0 ;i<coin.length;i++){
          for(int j = 1;j<=sum;j++){
              if(j>=coin[i]){
                  dp[j] = (dp[j] +dp[j-coin[i]] ) %mod;
              }
          }
      }
      System.out.println(dp[sum]);
      
	    
		
	}
}