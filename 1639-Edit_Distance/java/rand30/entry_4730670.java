import java.util.*;
import java.io.*;
 
public class entry_4730670 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=s.length();i>=0;i--) {
            for(int j=t.length();j>=0;j--) {
                if(i>=s.length() || j>=t.length()) {
                    dp[i][j]=Math.max(s.length()-i,t.length()-j);
                } else {
                    if(s.charAt(i)==t.charAt(j)) {
                        dp[i][j]=dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                    }
                }
            }
        }
        // int val = f(s,t,0,0,dp);
        
        System.out.println(dp[0][0]);
        // print(dp);
    }
    
    public static int f(String s1,String s2,int i,int j,int[][] dp) {
        int l1=s1.length()-i,l2=s2.length()-j;
        if(i>=s1.length() || j>=s2.length()) return Math.max(l1,l2);
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 0;
        if(s1.charAt(i)==s2.charAt(j)) {
            ans = f(s1,s2,i+1,j+1,dp);
        } else {
            ans = Math.min(f(s1,s2,i+1,j+1,dp),Math.min(f(s1,s2,i+1,j,dp),f(s1,s2,i,j+1,dp)))+1;
        }
        
        // System.out.println(i+" "+j+" "+ans);
        return dp[i][j]=ans;
    }
    
    public static void print(int[][] dp) {
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[i].length;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}