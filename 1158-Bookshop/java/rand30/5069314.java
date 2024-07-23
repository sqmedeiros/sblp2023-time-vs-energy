import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class entry_5069314 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(s[0]);
        int x=Integer.parseInt(s[1]);
        String s1[]=br.readLine().split(" ");
        int price[]=new int[n];
        int pages[]=new int[n];
        for(int i=0;i<n;i++)price[i]=Integer.parseInt(s1[i]);
        String s2[]=br.readLine().split(" ");
        for(int i=0;i<n;i++)pages[i]=Integer.parseInt(s2[i]);
        int dp[][]=new int[n+1][x+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=x;j++){
                dp[i][j]=dp[i-1][j];
                int remain=j-price[i-1];
                if(remain>=0){
                    dp[i][j]=Math.max(dp[i][j], dp[i-1][remain]+pages[i-1]);
                }
            }
        }
        out.println(dp[n][x]);out.flush();
 
    }
}