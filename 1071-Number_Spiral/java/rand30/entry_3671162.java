import java.io.*;
import java.util.Scanner;
 
public class entry_3671162 {
 
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt();
 
            long l = Math.max(x, y), d = (l - 1) * (l - 1) + l, delta = Math.max(x, y) - Math.min(x, y);
            long sign = x > y && l % 2 == 0 || x < y && l % 2 == 1 ? 1 : -1, rslt = d + sign * delta;
            pw.println(rslt);
        }
        pw.close();
    }
}