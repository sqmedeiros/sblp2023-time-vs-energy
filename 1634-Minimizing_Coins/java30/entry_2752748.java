// package com.adityap.thecool;
import java.util.Scanner;
public class entry_2752748 {
    static int[] c_i, dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x=in.nextInt();
        c_i = new int[n];
        for (int i = 0; i < n; i++) c_i[i]= in.nextInt();
        dp = new int[x+1]; dp[0]=0;
        for (int i = 1;  i<= x;i ++) {
            int best = Integer.MAX_VALUE;
            for (int c: c_i) {
                if (i-c >= 0 && dp[i-c] < Integer.MAX_VALUE) {
                    best = Math.min(best, 1+dp[i-c]);
                }
            }
            dp[i]=best;
        }
        System.out.println(dp[x] < Integer.MAX_VALUE ? dp[x] : -1);
    }
}