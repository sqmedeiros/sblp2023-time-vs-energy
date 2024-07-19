import java.io.*;
import java.util.*;
 
// Dynamic Programming, improve performance for endpoints.sort
public class entry_2363947 {
 
	public static void main(String[] args) throws Exception {
		int n = ni();
		List<Integer> endPoints = new ArrayList<>();
		endPoints.add(0);
		List<Project> projects = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Project project = new Project(ni() - 1, ni(), ni());
			endPoints.add(project.end);
			projects.add(project);
		}
 
		projects.sort((p1, p2) -> p1.start - p2.start);
		Collections.sort(endPoints);
 
		List<Integer> points = new ArrayList<>();
		int i = 0, j = 0;
		points.add(0);
		while (i < projects.size() || j < endPoints.size()) {
			int last = points.get(points.size() - 1);
			int min = 0;
			if (i < projects.size() && j < endPoints.size()) {
				int start = projects.get(i).start;
				int end = endPoints.get(j);
				if (start < end) {
					i++;
					min = start;
				} else {
					j++;
					min = end;
				}
			} else if (i == projects.size()) {
				min = endPoints.get(j++);
			} else if (j == endPoints.size()) {
				min = projects.get(i++).start;
			}
			if (min != last) {
				points.add(min);
			}
		}
 
		long[] earnings = new long[points.size()];
		int current = 0;
		for (Project project : projects) {
			while (points.get(current) < project.start) {
				current++;
				earnings[current] = Math.max(earnings[current], earnings[current - 1]);
			}
			int endIndex = Collections.binarySearch(points, project.end);
			earnings[endIndex] = Math.max(earnings[endIndex], earnings[current] + project.reward);
		}
 
		long max = 0;
		for (long earning : earnings) {
			max = Math.max(max, earning);
		}
 
		System.out.println(max);
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