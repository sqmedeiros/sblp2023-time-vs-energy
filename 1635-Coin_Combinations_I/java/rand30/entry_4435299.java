//package com.denisbogdanov.cses.problemset.dp;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_4435299 {
    private static final int MOD = 1_000_000_007;
 
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
 
        int n = in.nextInt();
        int target = in.nextInt();
        int[] coins = new int[n];
 
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
 
        Arrays.sort(coins);
 
        long[] dp = new long[target + 1];
        dp[0] = 1;
 
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] < 0) break;
                dp[i] += dp[i - coins[j]];
            }
 
            dp[i] %= MOD;
        }
 
        System.out.println(dp[target]);
    }
 
    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
 
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}