//  Edit Distance
 
import java.util.*;
import java.io.*;
 
public class entry_5637540 {
    static void solve() {
        StringBuilder res = new StringBuilder();
        String s = sc.next(), t = sc.next();
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for(int[] d:dp) Arrays.fill(d,-1);
        print(dfs(s,t,0,0,dp));
    }
    static int dfs(String s,String t,int i,int j,int[][] dp){
        if(i==s.length()||j==t.length()) return s.length()-i+t.length()-j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j] = dfs(s,t,i+1,j+1,dp);
        int a = dfs(s,t,i+1,j,dp);
        int b = dfs(s,t,i,j+1,dp);
        int c = dfs(s,t,i+1,j+1,dp);
        return dp[i][j] = 1+Math.min(a,Math.min(b,c));
    }
 
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    static FastReader sc;
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        sc = new FastReader();
        out = new PrintWriter(System.out);
        int tt = 1;//sc.nextInt();
        for (int t = 1; t <= tt; t++) {
            solve();
        }
        out.close();
    }
 
    static <E> void print(E res) {
        out.println(res);
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
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
 
        int[] readIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++)
                res[i] = nextInt();
            return res;
        }
 
        long[] readLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = nextLong();
            return res;
        }
    }
 
}