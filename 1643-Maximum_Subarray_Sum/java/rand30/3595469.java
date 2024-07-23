import java.io.*;
import java.util.*;
 
public class entry_3595469 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		
		long[] a = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i ++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		long maxSubSum = a[0];
		long runningPrefixSum = 0;
		long minPrefixSum = 0;
		
		for(long i : a) {
			runningPrefixSum += i;
			maxSubSum = Math.max(maxSubSum, runningPrefixSum-minPrefixSum);
			minPrefixSum = Math.min(minPrefixSum, runningPrefixSum);
		}
		
		pw.println(maxSubSum);
		
		br.close();
		pw.close();
	}
 
}
