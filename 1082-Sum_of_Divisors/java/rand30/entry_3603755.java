import java.io.*;
import java.util.*;
 
public class entry_3603755 {
 
	static long mod = (long) (1e9+7);
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		long n = Long.parseLong(br.readLine());
		long sum = 0;
		
		for(long i = 1; i <= Math.sqrt(n); i++) { 
						
			sum = (sum + sumMod(n/i, mod)) % mod;	
			
			if(n/i != i) {
								
				sum = ((n/i - n/(i+1)) % mod * sumMod(i, mod)) % mod + sum % mod;
				
			}else {
				
				sum = ((n/i - n/(i+1) - 1) % mod * sumMod(i, mod)) % mod + sum % mod;
				break;
				
			}
			
		}
		
		
		pw.println(sum % mod);
		pw.close();
		
	}
	
	static long sumMod(long n, long m) {
		
		return (((n % m) * ((n+1) % m)) % m * 500000004) % m;
		
	}
 
}