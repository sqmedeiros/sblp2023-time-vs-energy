import java.io.*;
import java.util.*;
 
public class entry_5978325 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long number = Long.parseLong(in.readLine());
		long curr = 1;
		long answer = 0;
		long MOD = 1000000007;
		
		while(curr <= number) {
			long count = number / curr;
			long end = number / count;
			//System.out.println(end);
			
			if(end > number) end = number;
			
			long ends = ((end + 1) % MOD * end % MOD) % MOD;
			long currs = ((curr - 1) % MOD * curr % MOD) % MOD;
			
			long sum = ((((end - curr + 1) % MOD) * ((curr + end) % MOD) % MOD) * (MOD / 2 + 1) % MOD);
			answer = (answer + count * sum) % MOD;
			
			curr = end + 1;
			//System.out.println(answer + " " + curr);
		}
		
		System.out.println(answer);
	}
}