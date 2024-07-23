import java.util.*;
import java.io.*;
 
public class entry_930089 {
	public static void main(String[] args) throws IOException {
		setIO();
		
		long N = nlg();
		out.println(solve(N));
		
		f.close();
		out.close();
	}
	
	static long MOD = 1000000007, INV = 500000004;
	
	static long solve(long N) {
		int MAXK = (int) (Math.sqrt(N));
		long[] d = new long[MAXK+1];
		
		long ans = 0;
		for (int k = 1; k <= MAXK; k++) {
			d[k] = (N / k) % MOD;
			ans += ((k % MOD) * d[k]) % MOD;
			ans %= MOD;
		}
		
		for (int k = 1; k < MAXK; k++) {
			long b = d[k], a = d[k+1];
			long temp = mult(b, b+1) * INV % MOD - mult(a, a+1) * INV % MOD;
			if (temp < 0) temp += MOD;
			ans += (k % MOD) * temp % MOD;
			ans %= MOD;
		}
		
		for (int k = MAXK + 1; k <= d[MAXK]; k++) {
			ans += (N / k) % MOD * (k % MOD) % MOD;
			ans %= MOD;
		}
		
		return ans;
	}
	
	static long mult(long a, long b) {
		return (a % MOD) * (b % MOD) % MOD;
	}
 
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;
 
	static String rl() throws IOException {
		return f.readLine();
	}
 
	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}
 
	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}
 
	static int ni() throws IOException {
		return Integer.parseInt(rl());
	}
 
	static long nlg() throws IOException {
		return Long.parseLong(rl());
	}
 
	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(rl());
	}
 
	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}
 
	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}
 
	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}
 
	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}
 
	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
 
	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}
 
	static void setIO() {
		setIn();
		setOut();
	}
}