import java.util.Scanner;
 
public class entry_741942 {
 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int MOD = 1_000_000_000 + 7;
 
		while (input.hasNext()) {
			int n = input.nextInt();
			int x = input.nextInt();
			int[] c = new int[n];
			long[] ways = new long[x + 1];
 
			for (int i = 0; i < c.length; ++i) {
				c[i] = input.nextInt();
 
				if (c[i] < ways.length) {
					ways[c[i]] = 1;
				}
			}
 
			for (int i = 1; i < ways.length; ++i) {
				for (int j = 0; j < c.length; ++j) {
					if (i - c[j] > 0) {
						ways[i] += ways[i - c[j]];
						ways[i] %= MOD;
					}
				}
			}
 
			System.out.println(ways[x]);
		}
	}
 
}