import java.util.*;
public class entry_5943270 {
 
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int n = Integer.parseInt(scan.next());
			Set<Integer> set = new TreeSet<Integer>();
			
			for (int i = 0; i < n; i++) {
				set.add(Integer.parseInt(scan.next()));
			}
			
			System.out.println(set.size());
	}
 
}