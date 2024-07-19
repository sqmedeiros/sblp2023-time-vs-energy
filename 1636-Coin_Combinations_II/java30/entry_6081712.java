import java.util.*;
import java.io.*;
 
public class entry_6081712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), M = (int) 1e9 + 7;
        int[] c = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            c[i] = Integer.parseInt(s.nextToken());
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j >= c[i])
                    dp[j] += dp[j - c[i]];
                dp[j] %= M;
            }
        }
        pw.println(dp[x]);
        pw.close();
    }
}