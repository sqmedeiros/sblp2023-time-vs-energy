import java.util.Scanner;
 
public class entry_2987782 {
    static int MOD = (int) 1e9 + 7;
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long ans = 0;
        for (long i = 1, j; i <= n; i = j + 1) {
            long q = n / i;
            j = n / q;
            long sum = modMul(modMul(j - i + 1, i + j), 500000004);
            ans += modMul(sum, q);
            ans %= MOD;
        }
        System.out.println(ans);
    }
 
    static long modMul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
}