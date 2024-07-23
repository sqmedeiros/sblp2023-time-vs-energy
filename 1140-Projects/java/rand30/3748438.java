import java.io.*;
import java.util.*;
 
public class entry_3748438 {
	public static void main(String[] args) throws Exception {
		var in = new FastScanner(System.in);
 
		int n = in.nextInt();
		var events = new ArrayList<Triple>();
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			events.add(new Triple(a, b, c));
		}
		Collections.sort(events);
 
		long ans = 0;
		var upd = new PriorityQueue<Tuple>();
		for (var e : events) {
			while (!upd.isEmpty() && upd.peek().a < e.a) {
				ans = Math.max(ans, upd.poll().b);
			}
			upd.add(new Tuple(e.b, ans + e.c));
		}
		while (!upd.isEmpty()) {
			ans = Math.max(ans, upd.poll().b);
		}
 
		System.out.println(ans);
	}
 
	static class Tuple implements Comparable<Tuple> {
		int a;
		long b;
		Tuple(int a, long b) {
			this.a = a;
			this.b = b;
		}
		@Override public int compareTo(Tuple that) {
			return this.a - that.a;
		}
	}
 
	static class Triple implements Comparable<Triple> {
		int a;
		int b;
		long c;
		Triple(int a, int b, long c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override public int compareTo(Triple that) {
			return this.a - that.a;
		}
	}
 
	//{{{
	static class FastScanner {
		BufferedReader in;
		StringTokenizer line;
 
		FastScanner(InputStream in) {
			this.in = new BufferedReader(new InputStreamReader(in), 1<<15);
		}
 
		String next() {
			while (line == null || !line.hasMoreTokens()) {
				try {
					line = new StringTokenizer(in.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return line.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	//}}}
}