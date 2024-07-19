import java.io.*;
import java.util.*;
import java.math.*;
 
public class entry_2472312 {
	public static void main(String[] args) {
		// solveKnapsack();
		// solveKnapsack_improved();
		solveKnapsack_optimze();
	}
 
	// For test theory only
	static void solveKnapsack() {
		int n = ni(), x = ni();
		int[] prices = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prices[i] = ni();
		}
		int[] pages = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			pages[i] = ni();
		}
 
		int[][] maxPages = new int[n + 1][x + 1];
		int maxPage = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= x; j++) {
				maxPages[i][j] = Math.max(maxPages[i][j - 1], maxPages[i - 1][j]);
				if (j - prices[i] >= 0) {
					maxPages[i][j] = Math.max(maxPages[i][j], maxPages[i - 1][j - prices[i]] + pages[i]);
				}
				maxPage = Math.max(maxPage, maxPages[i][j]);
			}
		}
		System.out.println(maxPage);
	}
 
	static void solveKnapsack_improved() {
		int n = ni(), x = ni();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = ni();
		}
		int[] pages = new int[n];
		for (int i = 0; i < n; i++) {
			pages[i] = ni();
		}
 
		int[] maxPages = new int[x + 1];
		Arrays.fill(maxPages, -1);
		maxPages[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = x; j >= 0; j--) {
				if (j - prices[i] >= 0 && maxPages[j - prices[i]] >= 0) {
					maxPages[j] = Math.max(maxPages[j], maxPages[j - prices[i]] + pages[i]);
				}
			}
		}
 
		int maxPage = 0;
		for (int j = x; j >= 0; j--) {
			maxPage = Math.max(maxPage, maxPages[j]);
		}
		System.out.println(maxPage);
	}
 
	static void solveKnapsack_optimze() {
		int n = ni(), x = ni();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = ni();
		}
		int[] pages = new int[n];
		for (int i = 0; i < n; i++) {
			pages[i] = ni();
		}
 
		int[] maxPages = new int[x + 1];
		int price = 0, page = 0;
		for (int i = 0; i < n; i++) {
			price = prices[i];
			page = pages[i];
			for (int j = x; j >= price; j--) {
				maxPages[j] = Math.max(maxPages[j], maxPages[j - price] + page);
			}
		}
 
		System.out.println(maxPages[x]);
	}
 
	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;
 
	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
 
	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}
 
	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}
 
	static double nd() {
		return Double.parseDouble(ns());
	}
 
	static char nc() {
		return (char) skip();
	}
 
	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
 
	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
 
	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
 
	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}