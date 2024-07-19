 /*
  * @UtkarshAgarwal
  */
 
 import java.util.Scanner;
 
 class entry_4557402 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         long t = scanner.nextInt();
         StringBuilder ans = new StringBuilder();
         while (t-- > 0) {
             long x = scanner.nextInt() - 1;
             long y = scanner.nextInt() - 1;
             long n = Math.max(x, y);
             long val = (long) n * n + 1;
             val += (n & 1) != 0 ? (x + (n - y)) : (y + (n - x));
             ans.append(val).append("\n");
         }
         System.out.println(ans);
     }
 }