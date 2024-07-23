/*
Written by Kabir Kanha Arora
@kabirkanha
 */
 
import java.util.*;
import java.io.*;
 
public class entry_1208099 {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int maxDiff = scanner.nextInt();
        PriorityQueue<Integer> applicants = new PriorityQueue<>();
        PriorityQueue<Integer> apartments = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            applicants.add(scanner.nextInt());
        }
        for (int i = 0; i < m; ++i) {
            apartments.add(scanner.nextInt());
        }
 
        int ans = 0;
        int nextApplicant = applicants.peek();
        int nextApartment = apartments.peek();
        while (!apartments.isEmpty() && !applicants.isEmpty()) {
            if (Math.abs(nextApartment - nextApplicant) <= maxDiff) {
                ans++;
                apartments.poll();
                applicants.poll();
                if (!applicants.isEmpty()) nextApplicant = applicants.peek();
                if (!apartments.isEmpty()) nextApartment = apartments.peek();
            } else if (nextApartment < nextApplicant) {
                apartments.poll();
                if (!apartments.isEmpty()) nextApartment = apartments.peek();
            }
            else {
                applicants.poll();
                if (!applicants.isEmpty()) nextApplicant = applicants.peek();
            }
        }
        System.out.println(ans);
    }
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}