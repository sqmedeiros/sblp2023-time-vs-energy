//package problems;
 
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
 
public class entry_3646329 {
	
	public static void main(String[] args) {
		
		Scanner mScanner = new Scanner(System.in);
		
		int n = Integer.parseInt(mScanner.nextLine());
		String[] integers = mScanner.nextLine().split(" ");
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(integers[i]));
		}
		
		System.out.println(set.size());
		
	}
 
}