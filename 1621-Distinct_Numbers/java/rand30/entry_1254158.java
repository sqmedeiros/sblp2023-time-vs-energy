import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
 
public class entry_1254158 {
 
	public static void main(String[] args) {
		Task task = new Task();
		task.solve();
	}
 
	public static class Task {
		static final long MOD = (long) 1e9 + 7;
 
		public void solve() {
			Scan sc = new Scan();
			int n = (int) sc.scanLong();
			int target = (int) sc.scanLong();
			List<Pair> arr = new ArrayList<Pair>();
			int[] ip = new int[n];
			for (int i = 0; i < n; ++i)
				ip[i] = (int) sc.scanLong();
			for (int i = 0; i < n; ++i) {
				for (int j = i + 1; j < n; ++j) {
					int first = ip[i];
					int second = ip[j];
					arr.add(new Pair((first + second), i, j));
				}
			}
			Collections.sort(arr);
			int left = 0;
			int right = -1 + (n * (n - 1)) / 2;
			while (left < right) {
				Pair leftPair = arr.get(left);
				Pair rightPair = arr.get(right);
				int sum = leftPair.sum + rightPair.sum;
				if (sum == target && leftPair.a != rightPair.a && leftPair.a != rightPair.b && leftPair.b != rightPair.a
						&& leftPair.b != rightPair.b) {
					System.out.println(leftPair + " " + rightPair);
					return;
				} else if (sum < target)
					++left;
				else
					--right;
			}
			System.out.println("IMPOSSIBLE");
		}
 
		private class Pair implements Comparable<Pair> {
			int sum, a, b;
 
			Pair(int sum, int a, int b) {
				this.sum = sum;
				this.a = a;
				this.b = b;
			}
 
			@Override
			public int compareTo(Pair o) {
				return Integer.compare(this.sum, o.sum);
			}
 
			public String toString() {
				return (1 + this.a) + " " + (1 + this.b);
			}
		}
	}
 
	public static class Scan {
		private byte[] buf = new byte[1024];
		private int index;
		private InputStream in;
		private int total;
 
		public Scan() {
			in = System.in;
		}
 
		public int scan() {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				try {
					total = in.read(buf);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}
 
		public long scanLong() {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}
 
		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}
 
		public String scanString() {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}
 
		public char scanChar() {
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			return (char) n;
		}
 
		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}
}