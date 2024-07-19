import java.io.*;
import java.util.*;
 
public class entry_443030 extends PrintStream {
	entry_443030() { super(System.out, true); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		int k, l; byte[] bb = new byte[1 << 15];
		byte getc() {
			if (k >= l) {
				k = 0;
				try { l = in.read(bb); } catch (IOException e) { l = 0; }
				if (l <= 0) return -1;
			}
			return bb[k++];
		}
		int nextInt() {
			byte c = 0; while (c <= 32) c = getc();
			int a = 0;
			while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		entry_443030 o = new entry_443030(); o.main(); o.flush();
	}
 
	Random rand = new Random();
	void sort(int[] aa, int n) {
		for (int i = 0; i < n; i++) {
			int j = rand.nextInt(i + 1);
			int tmp = aa[i]; aa[i] = aa[j]; aa[j] = tmp;
		}
		Arrays.sort(aa, 0, n);
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = sc.nextInt();
		int[] bb = new int[m];
		for (int j = 0; j < m; j++)
			bb[j] = sc.nextInt();
		sort(aa, n);
		sort(bb, m);
		int ans = 0;
		for (int i = 0, j = 0; i < n && j < m; )
			if (Math.abs(aa[i] - bb[j]) <= k) {
				ans++;
				i++;
				j++;
			} else if (aa[i] < bb[j]) {
				i++;
			} else {
				j++;
			}
		println(ans);
	}
}
