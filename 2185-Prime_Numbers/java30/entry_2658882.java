import java.util.Scanner;
 
public class entry_2658882 {
	static int ones(int n) {
		String s = Integer.toString(n, 2);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') res++;
		}
		return res;
	}
	
	static String pad(String s, int i) {
		if (s.length() > i) s = s.substring(0, i);
		while (s.length() < i) s = "0" + s;
		return s;
	}
	
	static long count(long n, long[] p) {
		int k = p.length;
		double prod = 0;
		long product = 0;
		long res = 0;
		for (int i = 1; i < Math.pow(2, k); i++) {
			String s = pad(Integer.toString(i, 2), k);
			int coeff = (int)Math.pow(-1, ones(i)) * -1;
			product = 1;
			prod = 1;
			for (int j = 0; j < k; j++) {
				if (s.charAt(j) == '1') {
					product *= p[j];
					prod *= (double)p[j];
				}
			}
			if (prod > n) continue;
			res += coeff * (long)(n / product);
		//	System.out.println(i + " " + s + " " + coeff + " " + prod + " " + (long)(n / product));
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		long n = x.nextLong();
		int k = x.nextInt();
		long[] p = new long[k];
		for (int i = 0; i < k; i++) p[i] = x.nextLong();
		System.out.println(count(n, p));
	}
}