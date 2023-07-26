import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_5802530{
 static class FastReader {
        BufferedReader br;
        StringTokenizer st;
       public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));}
  String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String args[]){   
        FastReader sc = new FastReader();
        long t=sc.nextInt();
        while(t--!=0){
            long x=sc.nextInt();
            long y=sc.nextInt();
            if (x < y)
        {
            if (y % 2 == 1)
            {
                long r = y * y;
                System.out.println(r-x+1);
            }
            else
            {
                long r = (y - 1) * (y - 1) + 1;
                System.out.println(r+x-1);
            }
        }
        else
        {
            if (x % 2 == 0)
            {
                long r = x * x;
                System.out.println(r-y+1);
            }
            else
            {
                long r = (x - 1) * (x - 1) + 1;
                System.out.println(r+y-1);
            }
        }
    }      
    }
}
 
