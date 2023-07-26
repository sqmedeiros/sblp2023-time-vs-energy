import java.io.*;
import java.util.*;
 
public class entry_2066959 {
	static class Pair implements Comparable<Pair> {
		int f, s;
		Pair(int f, int s) {
			this.f = f; this.s = s;
		}
		public int compareTo(Pair other) {
			if (this.f != other.f) return this.f - other.f;
			return this.s - other.s;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), x = readInt();
		Pair p[] = new Pair[n + 1];
		for (int i = 1; i <= n; ++i)
			p[i] = new Pair(readInt(), i);
		Arrays.sort(p, 1, n + 1);
		for (int i = 1, j = n; i < j; ++i) {
			while (i < j && p[i].f + p[j].f > x) --j;
			if (i < j && p[i].f + p[j].f == x) {
				System.out.println(p[i].s + " " + p[j].s);
				return;
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}
