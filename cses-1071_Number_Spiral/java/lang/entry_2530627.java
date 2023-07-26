import java.io.*;
import java.util.*;
 
class entry_2530627 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
 
		for(int i = 0; i < n; i++) {
			String inp = br.readLine();
			StringTokenizer st = new StringTokenizer(inp);
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
 
			long max = Math.max(x,y);
			long min = Math.min(x,y);
			long diag = (max * max) - (max - 1);
 
			if(x == y && x == 1) {
				System.out.println(1);
			} else if(x == y) {
				System.out.println(diag);
			} else {
				if(x < y) {
					if(y % 2 == 0) {
						System.out.println(diag  - (max-min));
					} else {
						System.out.println(diag + (max-min));
					}
				} else {
					if(x % 2 == 0) {
						System.out.println(diag  + (max-min));
					} else {
						System.out.println(diag - (max-min));
					}
				}
			}
		}
 
	}
}
