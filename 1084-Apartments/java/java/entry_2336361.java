import java.util.*;
import java.io.*;
 
public class entry_2336361 {
 
	public static void main(String[] args) {
		StringBuilder outputBuffer = new StringBuilder();
		List<Integer> listApplicants = new ArrayList<Integer>();
		List<Integer> listApartments = new ArrayList<Integer>();
 
		int noOfApplicants = ni();
		int noOfApartments = ni();
		int maxDifferents = ni();
 
		int count = 0;
		for (int i = 0; i < noOfApplicants; i++) {
			listApplicants.add(ni());
		}
		for (int i = 0; i < noOfApartments; i++) {
			listApartments.add(ni());
		}
		Collections.sort(listApplicants);
		Collections.sort(listApartments);
 
//		int i = noOfApplicants - 1;
//		int j = noOfApartments - 1;
//		while (i >= 0 && j >= 0) {
//			int applicant = listApplicants.get(i);
//			int apartment = listApartments.get(j);
//			if (Math.abs(apartment - applicant) <= maxDifferents) {
//				count++;
//				i--;
//				j--;
//			} else {
//				if (applicant > apartment) {
//					i--;
//				} else {
//					j--;
//				}
//			}
//		}
		int i = 0;
		int j = 0;
 
		while (i <= listApplicants.size() - 1 && j <= listApartments.size() - 1) {
			if (listApplicants.get(i) < listApartments.get(j) - maxDifferents) {
				i++;
			} else if (listApplicants.get(i) > listApartments.get(j) + maxDifferents) {
				j++;
			} else {
				count++;
				i++;
				j++;
			}
		}
		outputBuffer.append(count);
		System.out.println(count);
 
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
 
	static float nf() {
		return Float.parseFloat(ns());
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