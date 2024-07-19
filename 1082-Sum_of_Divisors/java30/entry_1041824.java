import java.util.*;
import java.io.*;
public class entry_1041824 {
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		long ans = 0;
		for(long a = 1; a * a <= n; a++){
			long num = (n / a) % MOD;
			long sumofa = (a * ((num - a + 1 + MOD) % MOD)) % MOD;
			long sumofpart = ((num * (num + 1)) / 2 % MOD - (a * (a + 1) / 2) % MOD + MOD) % MOD;
			ans = (sumofa + sumofpart + ans) % MOD;
		}
		System.out.println(ans);
	}
}