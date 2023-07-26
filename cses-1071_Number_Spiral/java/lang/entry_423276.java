import java.io.*;
import java.util.*;
 
public class entry_423276 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        for (int te = 0; te < t; te++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long y = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());
            if (x == 1 && y == 1) {
                out.println("1");
                continue;
            }
            if (x > y) {
                long start = 0;
                if (x % 2 == 0) {
                    start = (x-1)*(x-1) + 1;
                    start += y;
                    start--;
                } else {
                    start = x*x;
                    start -= y;
                    start++;
                }
                out.println(start);
            } else {
                long start = 0;
                if (y % 2 == 0) {
                    start = y*y;
                    start -= x;
                    start++;
                } else {
                    start = (y-1)*(y-1) + 1;
                    start += x;
                    start--;
                }
                out.println(start);
            }
        }
        out.close();
    }
    
}
/*
 
 */
