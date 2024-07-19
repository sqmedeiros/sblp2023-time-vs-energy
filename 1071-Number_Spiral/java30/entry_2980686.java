import java.util.*;
import java.io.*;
public class entry_2980686 {
 
	static class fast {
		BufferedReader br;
		StringTokenizer st;
		public fast() {
			br = new BufferedReader(new
			                        InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
 
 
 
 
 
	public static void main(String[] args)throws IOException {
		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setIn(new FileInputStream(new File("i.txt")));
				System.setOut(new PrintStream(new File("o.txt")));
			} catch (Exception e) {}
		}
		fast f = new fast();
		int t = f.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			long y = f.nextLong();
			long x = f.nextLong();
			long ans = 0;
			if (x > y) {
				if (x % 2 == 1) {
					ans = x * x - (y - 1);
				} else {
					x--;
					ans = (x * x) + y;
				}
			} else {
				if (y % 2 == 0) {
					ans = y * y - (x - 1);
				} else {
					y--;
					ans = (y * y) + x;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
 
 