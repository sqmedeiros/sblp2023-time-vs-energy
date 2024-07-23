import java.io.*;
 
public class entry_1463731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());
 
        // find the number of multiples within [1,n] each number 1..n has
        // some numbers i...j-1 have the same number of multiples, so process these
        // together
 
        long sum = 0, MOD = 1000000007;
        for (long i = 1, j = 1; i <= n; i = j) {
            // want to find the range of numbers that have the same number of multiples as i
            // first calculate how many multiples i has
            // then find the smallest number with less multiples in [1,n] than i
 
            // math:
            // q = n/i -> q is number of multiples of i
            // find smallest j such that n/j < q
            // j must be positive
            // n/q < j
            // j > n/q
            // smallest so j = n/q + 1
 
            long q = n / i; // the number of multiples i has in [1,n]
            j = n / q + 1; // the smallest number with less multiples than i has
 
            // now sum the numbers in range [i,j-1], they all have q multiples
            // sum of [1,j-1] is (j)(j-1)/2 - jsum
            // sum of unwanted: [1,i-1] is i(i-1)/2 - isum
            // sum = jsum - isum
            // MOD AT EVERY STEP
 
            long jsum = (j + MOD) % MOD * ((j - 1 + MOD) % MOD) / 2 % MOD,
                    isum = (i + MOD) % MOD * ((i - 1 + MOD) % MOD) / 2 % MOD;
 
            sum = ((sum + MOD) % MOD + (q + MOD) % MOD * (jsum - isum + MOD) % MOD) % MOD;
        }
 
        pw.println(sum);
        pw.close();
        br.close();
    }
}