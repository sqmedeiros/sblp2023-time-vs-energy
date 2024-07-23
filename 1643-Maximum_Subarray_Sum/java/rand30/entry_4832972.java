import java.io.*;
import java.util.*;
 
public class entry_4832972 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(in.readLine());
		long sum = 0, ans = Long.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			long x = Integer.parseInt(st.nextToken());
			sum += x;
			ans = Math.max(ans, sum);
			if (sum < 0) sum = 0;
		}
		System.out.println(ans);
		in.close();
		out.close();
	}
	
}
