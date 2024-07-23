// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class entry_5692596 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
 
		Set<Integer> distinctNumbersCount = new HashSet<Integer>(); // create a set 
 
		for (int i = 0; i < n; i++) {
			int number = s.nextInt();
			distinctNumbersCount.add(number);
 
		}
 
		System.out.println(distinctNumbersCount.size());
 
	}
}