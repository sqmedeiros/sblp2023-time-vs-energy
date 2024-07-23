import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class entry_3641902 {
 
    public static void main(String[] arg) {
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
 
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
 
        while(n > 0) {
            long r = sc.nextLong();
            long c = sc.nextLong();
 
            if (r > c) {
                if (r % 2 == 0) {
                    writer.println((r * r) - (c - 1));
                }
                else {
                    writer.println((r - 1) * (r - 1) + c);
                }
            }
            else {
                if (c % 2 == 1) {
                    writer.println((c * c) - (r - 1));
                }
                else {
                    writer.println((c - 1) * (c - 1) + r);
                }
            }
            n--;
        }
        writer.close();
    }
}