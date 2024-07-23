import java.io.*;
import java.util.*;
 
public class entry_2569317 {
	public static void main(String args[]) throws Exception {
 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer line = new StringTokenizer(in.readLine());
		
		PrintWriter out = new PrintWriter(System.out);
		
		long n = Long.parseLong(line.nextToken());
		int k = Integer.parseInt(line.nextToken());
		
		line = new StringTokenizer(in.readLine());
		
		long[] a = new long[k];
		
		for (int i = 0; i < k; i++) {
			
			a[i] = Long.parseLong(line.nextToken());
				
		}
		
		long ans = 0l;
		
		for (int i = 0; i < (1l << k); ++i) {
			
			long p = 1;
			int count = 0;
			
			ArrayList<Long> taken = new ArrayList<>();
			
			for (int j = 0; j < k; ++j) {
				
				if ((i & (1l << j)) > 0l) {
					
					if (p > n / a[j]) {
						p = n + 1;
						break;
					}
					
					p *= a[j];
					taken.add(a[j]);
					++count;
					
				}
				
			}
			
			if (count == 0) {
				continue;
			}
			
			if (count % 2 == 1) {
				ans += n / p;
			} else {
				ans -= n / p;
			}
			
		}
 
		out.println(ans);
		
		in.close();
		out.close();
		
	}
}