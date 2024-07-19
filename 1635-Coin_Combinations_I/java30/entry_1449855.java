import java.util.*;
import java.io.*;
public class entry_1449855 {
   public static void main(String[] args) throws IOException{
      BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
      String[] l = sc.readLine().split(" ");
      int n = Integer.parseInt(l[0]);
      int x = Integer.parseInt(l[1]);
      l = sc.readLine().split(" ");
      int[] c = new int[n];
      for(int i = 0; i < n; i++){
         c[i] = Integer.parseInt(l[i]);
      }
      long[] dp = new long[x+1];
      dp[0] = 1;
      for(int i = 0; i <= x; i++){
         for(int j = 0; j < n; j++){
            if(i - c[j] >= 0)
               dp[i] += dp[i-c[j]];
               dp[i] %= 1000000007;
         }
      }
      System.out.println(dp[x]);
   }
}