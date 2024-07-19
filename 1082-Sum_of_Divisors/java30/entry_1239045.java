import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class entry_1239045 {
    public static long MOD = (long) 1000000007;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long ans = 0;
        for (long i = 1, j; i <= N; i = j) {
            long q = N / i;
            j = N / q + 1;
            // process terms [i..j-1] of the summation
            // since they all have the same quotient q
            // now we add q*sum(i..j-1) to the answer
            long x = j - i, y = i + j - 1; // x*y/2 = sum(i..j-1)
            if (x % 2 == 0) x /= 2;
            else y /= 2;
            x %= MOD;
            y %= MOD;
            ans = (ans + q % MOD * x % MOD * y % MOD) % MOD;
        }
        System.out.println(ans);
 
    }
}