import java.util.*;
import java.io.*;
 
public class entry_183728{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] dp = new long[n]; // max subarray sum ending at index i
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = Math.max(0, arr[0]);
        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1] + arr[i];
            if(dp[i] < 0){
                dp[i] = 0;
            }
        }
        long max = 0;
        for(long element : dp){
            max = Math.max(max, element);
        }
        long subMax = Integer.MIN_VALUE;
        for(long element : arr){
            subMax = Math.max(subMax, element);
        }
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                flag = true;
            }
        }
        if(flag){
            pw.println(max);
        } else{
            pw.println(subMax);
        }
 
        br.close();
        pw.close();
    }
}
