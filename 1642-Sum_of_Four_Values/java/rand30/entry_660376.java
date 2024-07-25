import java.util.*;
import java.io.*;
 
public class entry_660376 {
 
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				int x = t - a[i] - a[j];
				if(map.containsKey(x)){
					int c[] = map.get(x);
					System.out.println((i+1) + " " + (j+1) + " " + c[0] + " " + c[1]);
					return;
				}
			}
			
			for(int j = 0; j < i; j++){
				map.put(a[i] + a[j], new int[]{i+1, j+1});
			}
		}
		System.out.println("IMPOSSIBLE");
	}
 
}