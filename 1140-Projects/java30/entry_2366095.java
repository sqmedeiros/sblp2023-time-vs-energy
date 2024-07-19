import java.io.*;
import java.util.*;
 
// Dynamic Programming
public class entry_2366095 {
 
	public static void main(String[] args) throws Exception {
		int n = ni();
		List<Project> projects = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Project project = new Project(ni() - 1, ni(), ni());
			projects.add(project);
		}
		projects.sort((p1, p2) -> p1.end - p2.end);
 
		int currentEnd = 1;
		int[] projectEnds = new int[n + 1];
		long maxEarn = 0;
		long[] earnings = new long[n + 1];
		for (Project project : projects) {
			int startIndex = Arrays.binarySearch(projectEnds, 0, currentEnd, project.start);
			if (startIndex < 0) {
				startIndex = ~startIndex - 1;
			}
			projectEnds[currentEnd] = project.end;
			maxEarn = Math.max(maxEarn, earnings[currentEnd]);
			maxEarn = Math.max(maxEarn, earnings[startIndex] + project.reward);
			earnings[currentEnd] = maxEarn;
			currentEnd++;
		}
		System.out.println(maxEarn);
	}
 
	static class Project {
		public int start;
		public int end;
		public int reward;
 
		public Project(int start, int end, int reward) {
			this.start = start;
			this.end = end;
			this.reward = reward;
		}
	}
 
	/*
	 * **********************BASIC READER ******************************************
	 * *****************************************************************************
	 *****************************************************************************/
 
	static InputStream is = System.in;;
	static byte[] inbuf = new byte[1024 << 4];
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
 
	static int ns() {
		int b = skip();
		int result = 0;
		while (!(isSpaceChar(b))) {
			result |= (1 << (b - 'a'));
			b = readByte();
		}
		return result;
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
}