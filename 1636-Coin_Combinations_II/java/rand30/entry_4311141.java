import java.util.Scanner;
 
class entry_4311141 {
    public static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        final long md = (long) (1e9 + 7);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        long[] f = new long[x + 1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        f[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = a[j]; i <= x; i++) {
                f[i] = (f[i] + f[i - a[j]]) % md;
            }
        }
        System.out.println(f[x]);
    }
}
