import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class entry_1342289 {
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long res = 0;
        for (long i = 1; i <= n; i++) {
            long z = n / i;
            long x = n / z;
            long sum = i + x;
            long div = x-i+1;
            if (div%2==0) div/=2;
            else sum /= 2;
            div %= MOD;
            sum %= MOD;
            res = (res+(div%MOD * sum%MOD * z % MOD))%MOD;
            i=x;
        }
        System.out.println(res);
    }
}