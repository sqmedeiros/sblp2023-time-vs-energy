/*
5
*/
import java.util.*;
import java.io.*;
 
public class entry_3412182 {
  public static long n; 
  public static long max = 1000000L;
  public static long mod = 1000000007L;
  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
      n = Long.parseLong(br.readLine());
      long md = n % mod; 
      long answer = (md * md) % mod; 
      //n = divisor * quotient + remainder, want sum of all remainders
      //considering larger quotient
      for(long q = 1; q <= max; q++){
        long r = n / q; 
        long l = (n / (q + 1)) + 1;
        //n * (r - l + 1) = (sum of all l + l + 1 + l + 2... + r) * q + remainderSums  
        long x = (r - l + 1) % mod;
        answer -= (md * x) - (((((((r + l) % mod) * x) % mod) * 500000004) % mod) * q) % mod;
        answer = (answer + mod * mod) % mod; 
      }
      //considering larger divisor 
      for(long d = 1; d <= n / (max + 1); d++){
        answer -= (n % d);
        answer = (answer + mod * mod) % mod; 
      }
      System.out.println(answer);
      br.close();
  }
}