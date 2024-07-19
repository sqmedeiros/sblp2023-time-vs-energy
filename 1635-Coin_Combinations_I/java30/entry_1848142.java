/*
CSES
Dynamic Programming #3
*/
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
 
public class entry_1848142 {
 
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO(System.in);
 
		int n = in.nextInt();
		int x = in.nextInt();
		int[] c = new int[n];
 
		for (int i = 0; i < n; i++) c[i] = in.nextInt();
		Arrays.sort(c);
		
		int[] dp = new int[x + 1];
		int mod = (int) 1E9 + 7;
		dp[0] = 1;
 
		for (int i = 1; i <= x; i++) {
			for (int j = 0; j < n; j++) {
				if (c[j] > i) {
					break;
				}
				dp[i] += dp[i - c[j]];
				if (dp[i] > mod) dp[i] -= mod;
			}
		}
 
		System.out.println(dp[x] % mod);
 
		in.close();
	}
 
	public static class FastIO {
		private InputStream dis;
		private byte[] buffer = new byte[1 << 17];
		private int pointer = 0;
 
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
 
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte b;
 
			do {
				b = nextByte();
			} while (b <= ' ');
 
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
 
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte b;
 
			do {
				b = nextByte();
			} while (b <= ' ');
 
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
 
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		public byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
 
		public String next() throws IOException {
			StringBuffer ret = new StringBuffer();
			byte b;
 
			do {
				b = nextByte();
			} while (b <= ' ');
 
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
 
			return ret.toString();
		}
 
		public void close() throws IOException {
			dis.close();
		}
	}
}