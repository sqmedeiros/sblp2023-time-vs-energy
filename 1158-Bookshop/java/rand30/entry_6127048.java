import java.io.*;
import java.util.*;
public class entry_6127048 {
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
		int[] price = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] page = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[x+1];
		for(int i=0;i<n;i++) {
			for(int j=x;j>=0;j--) {
				if(j-price[i]>=0) dp[j] = Math.max(dp[j], dp[j-price[i]]+page[i]);
			}
		}
		System.out.println(dp[x]);
	}
}
