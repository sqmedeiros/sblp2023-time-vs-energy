import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class entry_509468 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        long n = Long.parseLong(in.readLine());
        BigInteger res = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf((long) (1e9+7));
        long minl = (long) 1e9;
        for (long i = 1; i*i <= n; i++) {
            long r = n/i;
            long l = n/(i+1)+1;
            res = res.add(((BigInteger.valueOf(r-l+1)).multiply(BigInteger.valueOf(l+r))).divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(i)));
            res = res.mod(mod);
            minl = Math.min(minl, l);
        }
        for (int i = 1; i < minl; i++) {
            int k = i;
            res = res.add(BigInteger.valueOf(n/k * k));
            res = res.mod(mod);
        }
        System.out.println(res.longValue());
    }
 
}
/*
 
 
 */