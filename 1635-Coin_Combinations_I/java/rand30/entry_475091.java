import java.util.*;
import java.io.*;
 
public class entry_475091 extends PrintStream {
    entry_475091() {
        super(System.out, true);
    }
 
    Scanner sc = new Scanner(System.in);
 
    public static void main(String[] $) {
        entry_475091 o = new entry_475091();
        o.main();
        o.flush();
    }
    static final int Mod = 1000000007;
 
    void main() {
 
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] c = new int[a];
        int[] d = new int[b + 1];
 
        for (int i = 0; i < a; i++)
            c[i] = sc.nextInt();
        d[0] = 1;
        for (int i = 1; i <= b; i++) {
            int e = 0;
            for (int j = 0; j < a; j++) {
                int f = c[j];
 
                if (f <= i)
                    e = (e + d[i - c[j]]) % (Mod);
            }
            d[i] = e;
        }
 
        System.out.println(d[b]);
    }
}
 
