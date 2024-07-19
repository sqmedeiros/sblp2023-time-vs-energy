import java.util.*;
 
class entry_3712197 {
 
	// Recursive Approach
	private static int minDistance(char[] ch1, char[] ch2, int idx1, int idx2, int len1, int len2) {
        if (idx1 == len1) {
            return len2 - idx2;
        }
        if (idx2 == len2) {
            return len1 - idx1;
        }
 
        if (ch1[idx1] == ch2[idx2]) {
            return minDistance(ch1, ch2, idx1+1, idx2+1, len1, len2);
        } else {
            return Math.min(
                minDistance(ch1, ch2, idx1, idx2+1, len1, len2),
                Math.min(
                    minDistance(ch1, ch2, idx1+1, idx2, len1, len2),
                    minDistance(ch1, ch2, idx1+1, idx2+1, len1, len2)
                )
            ) + 1;
        }
    }
 
 //    private static void print(int[] arr) {
	// 	for (int i = 0; i < arr.length; i++) {
	// 		System.out.print(arr[i] + " ");
	// 	}
	// 	System.out.println("");
	// }
 
	// private static void print(int[][] arr) {
	// 	for (int i  = 0; i < arr.length; i++) {
	// 		print(arr[i]);
	// 	}
	// }
 
    // DP Approach
	private static int minDistance(char[] n, char[] m) {
		int nL = n.length;
		int mL = m.length;
		int[][] dp = new int[nL+1][mL+1];
 
		for (int i = 1; i <= mL; i++) {
			dp[0][i] = i;
		}
 
		for (int i = 1; i <= nL; i++) {
			dp[i][0] = i;
		}
 
		for (int i = 1; i <= nL; i++) {
			for (int j = 1; j <= mL; j++) {
				if (n[i-1] == m[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
				}
			}
		}
 
		// print(dp);
 
		return dp[nL][mL];
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		String n = sc.nextLine();
		String m = sc.nextLine();
 
		// System.out.println(minDistance(n.toCharArray(), m.toCharArray(), 0, 0, n.length(), m.length()) + "");
		System.out.println(minDistance(n.toCharArray(), m.toCharArray()) + "");
	}
}