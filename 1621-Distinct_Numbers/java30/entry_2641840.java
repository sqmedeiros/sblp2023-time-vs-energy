import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class entry_2641840 {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
 
		Set<Integer> distinct = new HashSet<>();
 
		for (int i = 0; i < n; i++) {
			distinct.add(sc.nextInt());
		}
 
		System.out.print(distinct.size());
 
	}
 
}