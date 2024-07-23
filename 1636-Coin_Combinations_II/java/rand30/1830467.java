import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
 
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Character.*;
import static java.lang.System.in;
import static java.lang.Math.*;
import static java.lang.System.out;
import static java.util.Arrays.*;
import static java.util.Collections.*;
 
public final class entry_1830467 {
	private static final int MOD = (int) 1e9 + 7;
 
	static void solve() {
		int n = readInt(), x = readInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = readInt();
		}
		long[] dp = new long[x + 1];
		dp[0] = 1;
		for (int ci = 0; ci < n; ci++) {
			for (int i = coins[ci]; i <= x; i++) {
				dp[i] = (dp[i] + dp[i - coins[ci]]) % MOD;
			}
		}
		out.printf("%d%n", dp[x]);
	}
 
	public static void main(String[] args) {
		solve();
		out.flush();
	}
 
	// @formatter:off
	static final PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static final BufferedReader br=new BufferedReader(new InputStreamReader(in));
	static StringTokenizer st;static String readLine(){try{return br.readLine();}catch(Exception e){throw new RuntimeException(e);}}
	static String read(){while(st==null||!st.hasMoreElements()){st=new StringTokenizer(readLine());}return st.nextToken();}
	static int readInt(){return parseInt(read());}static long readLong(){return parseLong(read());}
	static int[]readInts(int n){int[]array=new int[n];for(int i=0;i<n;i++){array[i]=readInt();}return array;}
	static long[]readLongs(int n){long[]array=new long[n];for(int i=0;i<n;i++){array[i]=readLong();}return array;}
}