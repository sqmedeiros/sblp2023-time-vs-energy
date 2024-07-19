import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
 
public class entry_2205556 {
    public static void main(String []args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" "); int j = 0, n = Integer.parseInt(s[0]), i = 0; 
		int x = Integer.parseInt(s[1]), a[] = new int [n]; s = br.readLine().split(" "); 
		HashMap <Integer, Integer> map = new HashMap<>(); 
		for(i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
			if(map.containsKey(x - a[i])) {
				j = map.get(x - a[i]);
				break;
			}
			map.put(a[i], i);
		}
		
		System.out.println(((i < n && a[j] + a[i] == x) ? ((j+1)+" "+(i+1)) : "IMPOSSIBLE"));;
	}
}	
 
