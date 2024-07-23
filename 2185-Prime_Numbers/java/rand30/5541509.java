 
import java.io.*;
import java.math.*;
import java.util.*;
 
public class entry_5541509 {
 
	static class Pair {
		int x;
		int y;
 
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
 
		}
	}
 
	static class Compare {
 
		void compare(Pair arr[], int n) {
			// Comparator to sort the pair according to second element
			Arrays.sort(arr, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
					if (p1.x != p2.x) {
						return (int) (p1.x - p2.x);
					} else {
						return (int) (p1.y - p2.y);
					}
//		            	return Double.compare(a[0], b[0]);
				}
			});
 
//		        for (int i = 0; i < n; i++) { 
//		            System.out.print(arr[i].x + " " + arr[i].y + " "); 
//		        } 
//		        System.out.println(); 
		}
	}
 
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
 
		public Scanner() {
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
	}
 
 
	public static void main(String args[]) throws Exception {
 
		Scanner sc = new Scanner();
		StringBuilder res = new StringBuilder();
 
		int tc = 1;
 
		while (tc-- > 0) {
 
			long n = sc.nextLong();
			int k = sc.nextInt();
			
			long a[] = new long[k];
			
			for(int i=0;i<k;i++) {
				a[i] = sc.nextLong();
			}
			
			long ans = 0;
			
			for(int i=1;i<(1<<k);i++) {
				
				ArrayList<Long> fac = new ArrayList<>();
				
				for(int j=0;j<k;j++) {
					
					if((i & (1<<j)) != 0) {
						fac.add(a[j]);
					}
				}
				
				long mul = 1;
				
				for(int j=0;j<fac.size();j++) {
					
					if(mul  <= n / fac.get(j)) {
						mul *= fac.get(j);
					}
					else {
						mul = n + 1;
						break;
					}
				}
				
				if((fac.size() & 1) != 0) {
					ans += n / mul;
				}
				else {
					ans -= n/mul;
				}
			}
			
			res.append(ans+"\n");
		}
		System.out.println(res);
	}
}