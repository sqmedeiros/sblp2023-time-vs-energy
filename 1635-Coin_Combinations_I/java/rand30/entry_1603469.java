import java.util.*;
import java.io.*;
 
public class entry_1603469 {
   static long dp[]=new long[1000002];
        static long mincost(int n,int arr[],int k){
        
            dp[0]=1;
            for(int j=1;j<=k;j++){
                dp[j]=0;
                for(int i=0;i<n;i++)
                {
                        if(arr[i]<=j)
                        dp[j]=(dp[j]+dp[j-arr[i]])%(1000000000+7);
                        //dp[j]=
             
                }
           
        }   
       return dp[k]; 
	}
           
    
         
    
    public static void main(String args[]) {
      
      Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    int k=sc.nextInt();
    int arr[]=new int[n+2];
    for(int i=0;i<n;i++){
         arr[i]=sc.nextInt();
     }
   
     System.out.println(mincost(n,arr,k));
        
 
    }
    
}