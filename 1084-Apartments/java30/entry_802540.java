import java.util.*;
import java.io.*;
 
public class entry_802540
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer line = new StringTokenizer(input.readLine());
      
      int people = Integer.parseInt(line.nextToken());
      int aptsNum = Integer.parseInt(line.nextToken());
      int diff = Integer.parseInt(line.nextToken());
      int possible = 0;
      
      PriorityQueue<Integer> wantedSize = new PriorityQueue<Integer>();
      PriorityQueue<Integer> size = new PriorityQueue<Integer>();
      
      line = new StringTokenizer(input.readLine());
      
      for (int i = 0; i < people; i++)
      {
         wantedSize.add(Integer.parseInt(line.nextToken()));
      }
      
      line = new StringTokenizer(input.readLine());
      
      for (int i = 0; i < aptsNum; i++)
      {
         size.add(Integer.parseInt(line.nextToken()));
      }
      
      while (wantedSize.size() > 0 && size.size() > 0)
      {
         if (Math.max(wantedSize.peek(), size.peek()) - Math.min(wantedSize.peek(), size.peek()) <= diff)
         {
            wantedSize.poll();
            size.poll();
            possible++;
         }
         else
         {
            if (wantedSize.peek() > size.peek())
            {
               size.poll();
            }
            else
            {
               wantedSize.poll();
            }
         }
      }
      
      pw.println(possible);
      pw.close();
   }
}