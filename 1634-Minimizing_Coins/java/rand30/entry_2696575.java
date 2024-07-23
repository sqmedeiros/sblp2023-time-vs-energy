//package DynamicProgramming;
import java.io.*;
import java.util.*;
 
public class entry_2696575 {
	
	
	
/*	
	public static  int recCoin(int x,int arr[]) {
		int ans=Integer.MAX_VALUE;
		//int res=0;
		
		if(x==0)
			return 0;
		
		else {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=x) {
			int res=1+recCoin(x-arr[i],arr);
			
			//System.out.println(ans);
			ans=Math.min(ans, res);
			}
			
		}
	
		}
		return ans;
	}
	*/
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=sc.nextInt();
		int x=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		//System.out.println(recCoin(x,arr));
		
		
		long dp[]=new long[x+1];
		dp[0]=0;
		for(int i=1;i<=x;i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(i>=arr[j]) {
					dp[i]=Math.min(dp[i],1+dp[i-arr[j]]);
				}
			}
		}
		if(dp[x]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
		System.out.println(dp[x]);
	}
 
}
