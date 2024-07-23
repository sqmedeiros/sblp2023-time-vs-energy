import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// نورت الكود يا كبير اتفضل
 
// يا رب Accepted
public class entry_2605546 {
    private static String str1, str2;
    private static final int[][] dp = new int[5007][5007];
 
    private static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
 
    private static int editDist(int n, int m) {
 
        if (n == 0)
            return m;
 
        if (m == 0)
            return n;
 
        if (dp[n][m] != -1)
            return dp[n][m];
 
        if (str1.charAt(n - 1) == str2.charAt(m - 1))
            return dp[n][m] = editDist(n - 1, m - 1);
 
        return dp[n][m] = (1 + min(editDist(n - 1, m), editDist(n, m - 1), editDist(n - 1, m - 1)));
 
    }
 
    private static int editDistIter(int n, int m) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0)
                    dp[i][0] = i;
                else if (i == 0)
                    dp[0][j] = j;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(
                            dp[i - 1][j], // Delete
                            dp[i][j - 1], // Add
                            dp[i - 1][j - 1]  // replace
                    );
            }
 
        }
        return dp[n][m];
    }
 
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        str1 = in.nextLine();
        str2 = in.nextLine();
//        for (int i = 0; i < 2001; i++)
//            Arrays.fill(dp[i], -1);
//        out.println(editDist(str1.length(), str2.length()));
        out.println(editDistIter(str1.length(), str2.length()));
 
        out.close();
    }
 
    private static class FastReader {
        BufferedReader br;
 
        FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}