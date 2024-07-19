import java.io.*;
import java.util.*;
 
public class entry_4105953 {
    private static long solution(long x, long y) {
        long max = Math.max(x,y) - 1;
        long ans = 0;
        if(max%2==1){
            if(x<y){
                ans = max * max + x;
            }
            else {
                ans = max * max + 2 * max - y + 2;
            }
        }
        else {
            if(x<y){
                ans = max * max + 2 * max -x + 2;
            }
            else {
                ans = max * max + y;
            }
        }
        return ans;
    }
 
    public static void main(String[] args) {
        entry_4105953.Reader sc=new entry_4105953.Reader();
        int n=sc.nextInt();
        while (n-- >0){
            long x = sc.nextLong();
            long y = sc.nextLong();
            long ans = solution(x,y);
            System.out.println(ans);
        }
    }
 
    static class Reader
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next()
        {
            while(!st.hasMoreTokens())
            {
                try
                {
                    st=new StringTokenizer(br.readLine());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public String nextLine()
        {
            try
            {
                return br.readLine();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext()
        {
            String next=null;
            try
            {
                next=br.readLine();
            }
            catch(Exception e)
            {
            }
            if(next==null)
            {
                return false;
            }
            st=new StringTokenizer(next);
            return true;
        }
    }
 
}
