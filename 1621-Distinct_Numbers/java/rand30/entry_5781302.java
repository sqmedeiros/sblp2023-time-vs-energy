import java.util.HashSet;
import java.util.Scanner;
 
public class entry_5781302 {
 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashSet<Integer> uni = new HashSet<Integer>();
		for (int i = 0; i < n; i++) uni.add(s.nextInt());
		System.out.println(uni.size());
	}
 
}
