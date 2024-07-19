//package com.rajan.codeforces.csesProblemSet.DynamicProgramming;
 
import java.io.*;
import java.util.Arrays;
 
public class entry_4021112 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[][] data = new int[n][3];
        for (int i = 0; i < n; i++)
            data[i] = parseInt(reader.readLine(), 3);
        Arrays.sort(data, (x, y) -> Integer.compare(x[1], y[1]));
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                dp[0] = data[i][2];
            else {
                int l = 0, r = i - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((m == i - 1 && data[m][1] < data[i][0]) || (m < i - 1 && data[m][1] < data[i][0] && data[m + 1][1] >= data[i][0])) {
                        l = m;
                        break;
                    } else if (m < i - 1 && data[m + 1][1] < data[i][0])
                        l = m + 1;
                    else
                        r = m - 1;
                }
                if (l >= 0 && l < i && data[l][1] < data[i][0])
                    dp[i] = Math.max(dp[i], dp[l] + data[i][2]);
                dp[i] = Math.max(dp[i], dp[i - 1]);
                dp[i] = Math.max(dp[i], data[i][2]);
            }
        }
        writer.write(dp[n - 1] + "\n");
//        writer.write(solution(data, 0, 1) + "\n");
        writer.flush();
    }
 
    private static long solution(int[][] data, int i, int j) {
        int n = data.length;
        if (j > n)
            return 0L;
        long ans = 0L;
        if (i == 0 || data[i - 1][1] < data[j - 1][0])
            ans = data[j - 1][2] + solution(data, j, j + 1);
        ans = Math.max(ans, solution(data, i, j + 1));
        return ans;
    }
 
    private static int[] parseInt(String str, int n) {
        int[] ans = new int[n];
        int idx = 0;
        for (int k = 0; k < str.length(); ) {
            int j = k;
            int sum = 0;
            while (j < str.length() && str.charAt(j) != ' ') {
                if (str.charAt(j) == '-') {
                    j++;
                    continue;
                }
                sum = sum * 10 + str.charAt(j) - '0';
                j++;
            }
            ans[idx++] = (str.charAt(k) == '-' ? -1 : 1) * sum;
            k = j + 1;
        }
        return ans;
    }
}