//package kg.my_algorithms.Codeforces;
 
import java.util.*;
import java.io.*;
 
public class entry_4801919 {
    private static final FastReader fr = new FastReader();
    private static final long mod = 1_000_000_007L;
    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = fr.nextInt();
        int target = fr.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++) coins[i] = fr.nextInt();
        long[] dp = new long[target+1];
        dp[0] = 1L;
        for(int i=1;i<=target;i++){
            for(int c: coins){
                if(i>=c && dp[i-c]!=0) dp[i] = (dp[i]+dp[i-c])%mod;
            }
        }
 //       System.out.println(Arrays.toString(dp));
        sb.append(dp[target]);
        output.write(sb.toString());
        output.flush();
 
    }
 
}
 
//Fast Input
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() { return Integer.parseInt(next()); }
 
    long nextLong() { return Long.parseLong(next()); }
 
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
 
    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}