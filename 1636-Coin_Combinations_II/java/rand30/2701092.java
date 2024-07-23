//package DynamicProgramming;
import java.util.*;
import java.io.*;
public class entry_2701092 {
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//long mod=(long)10e+7;
		long mod=1000000007;
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int n=sc.nextInt();
	    int x=sc.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++)
	    	arr[i]=sc.nextInt();
	    
	    long dp[]=new long[1000001];
	    dp[0]=1;
	    
	   for(int i=0;i<n;i++) {
		   for(int j=0;j<=x;j++) {
			   if(j>=arr[i]) {
				   dp[j]=dp[j]+dp[j-arr[i]];
				   if(dp[j]>=mod)
					   dp[j]-=mod;
			   }
		   }
	   }
	    System.out.println(dp[x]);
	
	
	}
 
}