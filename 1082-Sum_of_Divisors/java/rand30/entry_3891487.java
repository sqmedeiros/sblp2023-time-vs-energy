import java.util.*;
import java.io.*;
public class entry_3891487 {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static long modulo = 1_000_000_000 + 7;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long sum = 0;
        for (long i = 1; i * i <= n; i++) {
        	sum += i * (n / i);
        	sum += i * summation(1 + Math.max(i, n / (i + 1)), n / i) % modulo;
        	sum %= modulo;
        }
        
        out.println(sum);
        out.close();
    }
    public static long summation(long a, long b) {
    	if (a > b) {
    		return 0;
    	}
    	if ((a + b) % 2 == 0) {
    		return (((a + b) / 2 % modulo) * ((b - a + 1) % modulo)) % modulo;
    	}
    	return (((a + b) % modulo) * ((b - a + 1) / 2 % modulo)) % modulo;
    }
}