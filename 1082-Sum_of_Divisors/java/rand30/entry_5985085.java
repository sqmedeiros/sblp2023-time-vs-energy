import java.sql.Array;
import java.util.Scanner;
 
public class entry_5985085 {
    static long MOD = (1000000000 + 7);
    static final int TWO_MOD_INV = 500000004;
 
    public static void main(String[] str) {
        Scanner cin = new Scanner(System.in);
        long n = cin.nextLong();
        long a = 2, b, res = n;
        while (a <= n) {
            long t = n / a;
            b = n / t + 1;
            res = (res + sum(a, b - 1) * t) % MOD;
            a = b;
        }
        System.out.println(res);
    }
 
    public static long sum(long start, long end) {
        return ((((end - start + 1) % MOD) * ((start + end) % MOD) % MOD) *
                TWO_MOD_INV % MOD);
    }
 
 
}