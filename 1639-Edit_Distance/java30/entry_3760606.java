//package com.company;
import java.io.*;
 
public class entry_3760606 {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String m = br.readLine(); String n = br.readLine();
        br.close();
        int mL = m.length(); int nL = n.length();
        int[][] dp = new int[mL + 1][nL + 1];
        for(int i = 0; i < mL + 1; i++) {
            for(int j = 0; j < nL + 1; j++) {
                int val = Integer.MAX_VALUE;
                if(i > 0) val = Math.min(dp[i-1][j] + 1, val);
                if(j > 0) val = Math.min(dp[i][j-1] + 1, val);
                if(i > 0 && j > 0) {
                    if(m.charAt(i - 1) == n.charAt(j - 1)) val = Math.min(dp[i-1][j-1], val);
                    else val = Math.min(dp[i-1][j-1] + 1, val);
                }
                if(val == Integer.MAX_VALUE) val = 0;
                dp[i][j] = val;
            }
        }
        System.out.println(dp[mL][nL]);
    }
}