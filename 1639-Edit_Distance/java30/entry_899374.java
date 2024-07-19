//package Codes;
import java.util.*;	
public class entry_899374 {
 
	public static int mod=1000000007;
 
 
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			String str1=sc.next();
			String str2=sc.next();
			
			int dp[][]=new int[str1.length()+1][str2.length()+1];
			
			for(int i=0;i<=str1.length();i++) {
				
				for(int j=0;j<=str2.length();j++) {
					if(i==0 && j==0)
						continue;
					if(i==0 )
					{
						dp[i][j]=j;
						continue;
					}
					if(j==0) {
						dp[i][j]=i;
						continue;
					}
					if(str1.charAt(i-1)!=str2.charAt(j-1))
						dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					else
						dp[i][j]=dp[i-1][j-1];
					
				}
			}
			System.out.println(dp[str1.length()][str2.length()]);
	}
	
}
		
 
 
 
 
		
		
	
 
	
	
	
	
	
	
		
	
	
	
	
		
	
	
 
		
		
 
	
	
	
	
 
			
	
		
	
	
		
	
	
	
	
	
 
 