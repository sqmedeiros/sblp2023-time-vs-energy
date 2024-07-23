//package usaco.gold.knapsackdp;
 
import java.util.*;
import java.io.*;
public class entry_2051622 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }
 
        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }
 
        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }
    static PrintWriter pw = new PrintWriter(System.out);
    static InputReader r = new InputReader(System.in);
 
    static int[] dp, coins;
    static boolean[] possible;
    static int n,size;
 
    public static void main(String[] args){
        size=r.nextInt();
        coins=new int[size];
        n=r.nextInt()+1;
        dp=new int[n]; possible=new boolean[n];
 
        for(int i=0; i<size; i++){
            coins[i]=r.nextInt();
        }
 
        dp[0]=0; possible[0]=true;
        for(int i=1; i<n; i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=1; i<n; i++){
            for(int c: coins){
                if(i-c>=0 && possible[i-c]){
                    dp[i]=Math.min(dp[i],dp[i-c]+1);
                }
            }
            if(dp[i]!=Integer.MAX_VALUE){
                possible[i]=true;
            }
        }
 
        if(dp[n-1]!=Integer.MAX_VALUE){
            pw.println(dp[n-1]);
        }
        else{
            pw.println(-1);
        }
        pw.close();
 
    }
}