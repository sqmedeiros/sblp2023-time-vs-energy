import java.util.*;
 
public class entry_5647179 {
    static int K;
    static long N, cnt, a[] = new long[20];
    static final double EPS = 0.001;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextLong();
        K = in.nextInt();
        for (int i = 0; i < K; i++)
            a[i] = in.nextLong();
 
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
 
            if (LHS < RHS)
                cnt += (odd ? 1 : -1) * (N / prod);
        }
 
        System.out.println(cnt);
    }
}