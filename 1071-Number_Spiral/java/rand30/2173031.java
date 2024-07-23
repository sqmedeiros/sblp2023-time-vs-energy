import java.util.*;
 
public class entry_2173031 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
 
		while(t-- > 0) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			long z = Math.max(y, x);
			long ans;
			if (z % 2 == 1) {
				if (y == z) {
					ans = (z-1) * (z-1) + x;
				} else {
					ans = z * z - y + 1;
				}
			} else {
				if (y == z) {
					ans = z * z - x + 1;
				} else {
					ans = (z-1) * (z-1) + y;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}