import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
 
public class entry_2956102 {
    static BigInteger[] arr = new BigInteger[30];
    static BigInteger[] a = new BigInteger[30];
    static BigInteger n;
    static int k;
 
    public static void getVal(BigInteger mulval, int cnt, int idx) {
        if (idx > k) return;
        arr[cnt + 1] = arr[cnt + 1].add(n.divide(mulval.multiply(a[idx])));
        getVal(mulval.multiply(a[idx]), cnt + 1 , idx + 1);
        getVal(mulval, cnt ,idx + 1);
    }
    public static void main(String [] args)  {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        n = BigInteger.valueOf(fs.nextLong());
        k = fs.nextInt();
        for(int i = 1 ; i <= k; ++i) {
            a[i] = BigInteger.valueOf(fs.nextLong()) ;
        }
        for(int i = 1 ; i <= k; ++i) arr[i] = BigInteger.valueOf(0);
        getVal(BigInteger.valueOf(1), 0 ,  1);
        BigInteger ans = new BigInteger("0");
        BigInteger sign = new BigInteger("1");
        for (int i = 1 ; i <= k ; ++i) {
            ans = ans.add(sign.multiply(arr[i])) ;
            sign = sign.multiply(BigInteger.valueOf(-1));
        }
        out.println(ans);
        out.close();
 
    }
 
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
 
 
}