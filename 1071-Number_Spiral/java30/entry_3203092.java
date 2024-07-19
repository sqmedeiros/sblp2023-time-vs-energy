import java.util.*;
import java.io.*;
 
public class entry_3203092 {
 
 
  static class FastReader {
      BufferedReader br; StringTokenizer st;
      public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
      }
      String next(){
        while (st == null || !st.hasMoreElements()) {
          try
            { st = new StringTokenizer(br.readLine()); }
          catch (IOException e)
            { e.printStackTrace(); }
        }
        return st.nextToken();
      }
      int    nextInt()    { return Integer.parseInt(next());   }
      long   nextLong()   { return Long.parseLong(next());     }
      double nextDouble() { return Double.parseDouble(next()); }
      String nextLine()   {
          String str = "";
          try
            { str = br.readLine(); }
          catch (IOException e)
            { e.printStackTrace(); }
          return str;
      }
  }
 
 
  public static void main(String[] args){
    FastReader  sc  = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    long t = sc.nextLong();
    while(t-- > 0){
      long x = sc.nextLong();
      long y = sc.nextLong();
      if(y > x){
        if(y%2 == 1)
          out.println( (y*y) - x + 1);
        else
          out.println( (y*y) - ((y-1)*2) + x - 1 );
      }
      else{
        if(x%2 == 0)
          out.println( (x*x) - y + 1 );
        else
          out.println( (x*x) - ((x-1)*2) + y - 1 );
      }
    }
    out.flush();
  }
 
 
}
