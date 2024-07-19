import java.util.*;
public class entry_2271996 {
    static int dp[];
    static int mod=1000000007;
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int sum=sc.nextInt();
           int a[]=new int[n];
           for(int i=0;i<n;i++){
             a[i]=sc.nextInt();   
           }
           dp=new int[sum+1];
       
           Arrays.fill(dp,Integer.MAX_VALUE);
           dp[0]=0;
           for(int i=1;i<=sum;i++){
            for(int j=0;j<n;j++){
                if(i-a[j]>=0 && dp[i-a[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-a[j]]+1);
                }
            }
           }
 
 
           if(dp[sum]==Integer.MAX_VALUE)
            System.out.println("-1");
           else
           System.out.println(dp[sum]);
           
        }
     
}