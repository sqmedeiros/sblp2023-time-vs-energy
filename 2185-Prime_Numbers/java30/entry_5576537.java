import java.util.*;
import java.lang.*;
import java.io.*;
 
class entry_5576537
{
    static int maxK = 20;
    static int K;
    static long N, cnt;
    static long[] a = new long[maxK];
    static double EPS = 0.001;
 
    static void solve()
    {
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextLong();
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            a[i] = sc.nextLong();
        }
 
        cnt = N;
        double RHS = Math.log(N) + EPS;
        for (int mask = 0; mask < (1 << K); mask++) {
            boolean odd = Integer.bitCount(mask) % 2 != 0;
 
            long prod = 1;
            double LHS = 0.0;
            for (int i = 0; i < K; i++) {
                if ((mask & (1 << i)) != 0) {
                    LHS += Math.log(a[i]);
                    prod *= a[i];
                }
            }
 
            if (LHS < RHS) {
                cnt += (odd ? 1 : -1) * (N / prod);
            }
        }
 
        System.out.println(cnt);
    }
 
    public static void main (String[] args) throws java.lang.Exception
    {
        solve();
    }
}