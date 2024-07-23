import java.io.*;
import java.util.*;
 
public class entry_3942429 {
	static PrintWriter pw;
	static Scanner sc;
 
	public static void main(String[] args) throws IOException, InterruptedException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		long n = sc.nextLong();
		long ans = 0;
		int k = sc.nextInt();
		long[] arr = sc.nextlongArray(k);
		w: for (int i = 1; i < 1 << k; i++) {
			long mul = 1;
			for (int j = 0; j < k; j++) {
				if ((i & (1 << j)) != 0) {
					if (mul > n / arr[j]) {
						continue w;
					} else {
						mul *= arr[j];
					}
				}
			}
			if (Integer.bitCount(i) % 2 == 0) {
				ans -= n / mul;
			} else
				ans += n / mul;
		}
		pw.println(ans);
		pw.flush();
	}
 
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}
 
		public Scanner(String s) throws IOException {
			br = new BufferedReader(new FileReader(new File(s)));
		}
 
		public String readAllLines(BufferedReader reader) throws IOException {
			StringBuilder content = new StringBuilder();
			String line;
 
			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}
 
			return content.toString();
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}
 
		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
 
		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
 
		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
	}
}