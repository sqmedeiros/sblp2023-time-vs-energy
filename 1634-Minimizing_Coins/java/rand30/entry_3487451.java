//package com.company;
 
import java.util.*;
import java.io.*;
 
public class entry_3487451 {
 
    static int n, max;
    static int[] values, dp;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
 
        values = new int[n + 1];
        dp = new int[max + 1];
 
        values[0] = -1;
        st = new StringTokenizer(br.readLine());
 
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
 
        }
 
        Arrays.sort(values);
 
        tabulate();
    }
 
    public static void tabulate() {
        Arrays.fill(dp, 1000000007);
        dp[0] = 0;
 
        for (int i = 1; i <= n; i++) {
            int v = values[i];
            if (v > max) break;
 
            for (int o = 0; o <= max; o++) {
                if (o - v >= 0) {
                    dp[o] = Math.min(dp[o], dp[o - v] + 1);
                }
            }
        }
 
        if (dp[max] == 1000000007) System.out.println(-1);
        else System.out.println(dp[max]);
    }
}