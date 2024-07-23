import java.io.*;
 
public class entry_1463695 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());
 
        long sum = 0, MOD = 1000000007;
        for (long i = 1, j = 1; i <= n; i = j) {
            long q = n / i;
            j = n / q + 1;
            long jsum = (j + MOD) % MOD * ((j - 1 + MOD) % MOD) / 2 % MOD,
                    isum = (i + MOD) % MOD * ((i - 1 + MOD) % MOD) / 2 % MOD;
            sum = ((sum + MOD) % MOD + (q + MOD) % MOD * (jsum - isum + MOD) % MOD) % MOD;
        }
 
        pw.println(sum);
        pw.close();
        br.close();
    }
}