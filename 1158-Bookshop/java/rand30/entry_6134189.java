import java.util.Arrays;
import java.util.Scanner;
 
public class entry_6134189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// number of books
        int x = sc.nextInt();// at most purchase cost;
        int[] value = new int[n];
        int[] pages = new int[n];
        for(int i=0;i<n;i++){
            value[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            pages[i]=sc.nextInt();
        }
 
        int [][] dp =new int[2][x+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<x+1;j++){
                if(j-value[i-1]>=0){
                    dp[1][j]=Math.max(pages[i-1]+dp[0][j-value[i-1]],dp[0][j]);
                }
                else dp[1][j]=dp[0][j];
            }
            for(int j=0;j<x+1;j++){
                dp[0][j]=dp[1][j];
            }
        }
        System.out.println(dp[1][x]);
     
        
    }
   
    
}