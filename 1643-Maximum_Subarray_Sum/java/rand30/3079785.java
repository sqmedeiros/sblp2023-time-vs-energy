import java.io.*;
import java.util.*;
public class entry_3079785 {
	static long[] a;
	static long ans, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		a = new long[n];
		for(int i=0; i<n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		ans = -1000000000;
		max = -1000000000;
		for(int i =0; i< n; i++) {
			if(ans+a[i]<a[i]) {
				ans = a[i];
			}
			else {
				ans+=a[i];
			}
			max = Math.max(max, ans);
		}
		System.out.println(max);
 
	}
 
}
