import java.io.*;
import java.util.*;
public class entry_5419593 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long prev = 0;
		long max = Long.MIN_VALUE;
		for(int i=0;i<n;i++) {
			prev = Math.max(arr[i],arr[i]+prev);
			max = Math.max(prev,max);
		}
		System.out.println(max);
	}
}
