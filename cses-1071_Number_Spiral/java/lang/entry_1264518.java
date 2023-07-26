import java.util.*;
import java.lang.*;
import java.io.*;
 
class entry_1264518
{
	public static void main (String[] args) throws java.lang.Exception
	{
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
 
            while (T-- > 0) {
                String[] line = br.readLine().trim().split("\\s+");
                long y = Long.parseLong(line[0]);
                long x = Long.parseLong(line[1]);
 
                if (x > y) {
                    if (x % 2 == 1) {
                        // System.out.println(x*x - y + 1);
                        sb.append((x*x - y + 1) + "\n");
                    } else {
                        x--;
                        // System.out.println(x*x + y);
                        sb.append((x*x + y) + "\n");
                    }
                } else {
                    if (y % 2 == 0) {
                        // System.out.println(y*y - x + 1);
                        sb.append((y*y - x + 1) + "\n");
                    } else {
                        y--;
                        // System.out.println(y*y + x);
                        sb.append((y*y + x) + "\n");
                    }
                }
            }
            System.out.print(sb);
        } catch (Exception e) {
            return;
        }
    }
}
