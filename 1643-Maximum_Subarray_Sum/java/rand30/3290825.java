import java.util.*;
import java.io.*;
public class entry_3290825{
   public static long[] prefix;
   //public static long[] min;
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      prefix=new long[N+1];
      long min=0;
      long maxSum=Long.MIN_VALUE;
      s=new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++){
         long input=Long.parseLong(s.nextToken());
         prefix[i]=prefix[i-1]+input;
         maxSum=Math.max(prefix[i]-min,maxSum);
         min=Math.min(prefix[i],min);
      }
      System.out.println(maxSum);
   }
}
