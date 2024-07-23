 
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class entry_1449152
{
   static int n, m, k;
 
   public static void main(String[] args) throws Exception
   {
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter outf = new PrintWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(f.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
 
      PriorityQueue<Integer> applicants = new PriorityQueue<>();
      PriorityQueue<Integer> apartments = new PriorityQueue<>();
 
      st = new StringTokenizer(f.readLine());
      for (int i = 0; i < n; i++)
      {
         applicants.add(Integer.parseInt(st.nextToken()));
      }
 
      st = new StringTokenizer(f.readLine());
      for (int i = 0; i < m; i++)
      {
        apartments.add(Integer.parseInt(st.nextToken()));
      }
 
      int ans = 0;
 
      while (!apartments.isEmpty() && !applicants.isEmpty())
      {
         int currApp = applicants.peek();
         int currApt = apartments.peek();
         int difference = Math.abs(currApp - currApt);
 
         if(difference > k && currApt < currApp)
         {
            apartments.remove();
         }
         else if (difference > k && currApp < currApt)
         {
            applicants.remove();
         }
         else if (difference <= k)
         {
            apartments.remove();
            applicants.remove();
            ans++;
         }
 
 
      }
 
      outf.println(ans);
      f.close();
      outf.close();
   }
}