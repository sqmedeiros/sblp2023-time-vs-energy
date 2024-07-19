import java.util.Arrays;
import java.util.Scanner;
 
public class entry_4203042 {
  static final int mod =(int)(Math.pow(10, 9) + 7);
  static long modularBinaryExponentiation(int base, int exponent) {
    if (exponent == 0) return 1;
    long result = modularBinaryExponentiation(base, exponent / 2);
    if (exponent % 2 == 1) {
      return (((result * result) % mod) * base) % mod;
    } else {
      return (result * result) % mod;
    }
  }
 
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    long answer = 0;
 
    for(long i = 1, j; i <= n; i = j) {
      long q = n / i;
      j = n / q + 1;
      long sum = (((((2 * (i % mod) % mod) + (j - i - 1) % mod) * ((j - i) % mod)) % mod) * modularBinaryExponentiation(2, mod - 2))% mod;
      answer = (answer + (q % mod) * sum) % mod;
    }
    System.out.println(answer);
  }
}