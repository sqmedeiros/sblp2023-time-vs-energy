import java.io.*;
import java.util.*;
public class entry_553632
{
   public static void main(String args[])throws IOException
   {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer tk = new StringTokenizer(reader.readLine());
      long n = Long.parseLong(tk.nextToken());
      long x = Long.parseLong(tk.nextToken());
      StringTokenizer tk1 = new StringTokenizer(reader.readLine());
      HashMap<Long,Long> hm = new HashMap<Long,Long>();
      long ha[] = {-1,-1};
      int j=0;
      for(long i=1;i<=n;i++)
      {
        long m = Long.parseLong(tk1.nextToken());
        if(m==x/2 && j!=2)
        {
          ha[j]=i;
          j++;
        }
        hm.put(m,i);
      }
      if(ha[1]!=-1 && x%2==0)
      {
        System.out.println(ha[0]+" "+ha[1]);
        return;
      }
      String ans = "IMPOSSIBLE";
      for(Map.Entry<Long,Long> mp:hm.entrySet())
      {
        long temp=mp.getKey();
        if(hm.containsKey(x-temp))
        {
          long ind = hm.get(x-temp);
          if(hm.get(temp)!=ind)
          {
            long min=Math.min(hm.get(temp),ind);
            long max=Math.max(hm.get(temp),ind);
            ans=min+" "+max;
            break;
          }
        }
      }
      System.out.println(ans);
   }
}
