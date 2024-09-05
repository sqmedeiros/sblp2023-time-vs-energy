import java.io.*;
import java.util.*;
 
public class entry_3243860{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(set.size());
	}
}
