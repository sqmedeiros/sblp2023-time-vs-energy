import java.util.*;
import java.io.*;
public class entry_1454376 {
   public static void main(String[] args) throws IOException{
      BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
      String[] l = sc.readLine().split(" ");
      int n = Integer.parseInt(l[0]);
      int x = Integer.parseInt(l[1]);
      int[] p = new int[n];
      int[] num = new int[n];
      l = sc.readLine().split(" ");
      for(int i = 0; i < n; i++){
         p[i] = Integer.parseInt(l[i]);
      }
      l = sc.readLine().split(" ");
      for(int i = 0; i < n; i++){
         num[i] = Integer.parseInt(l[i]);
      }
      int[] dp = new int[x+1];
      for(int i = 1; i <= x; i++){
         dp[i] = -1;
      }
      for(int i = 0; i < n; i++){
         for(int j = x; j >= 0; j--){
            if(j - p[i] >= 0)
               dp[j] = Math.max(dp[j], dp[j - p[i]] + num[i]);
         }
      }
      int max = 0;
      for(int i = 0; i <= x; i++){
         max = Math.max(max, dp[i]);
      }
      System.out.println(max);
   }
}