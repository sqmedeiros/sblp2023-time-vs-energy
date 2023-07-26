import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
 
public class entry_4555777 {
	public static void main(String[] args) throws IOException {
 
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		Map<Integer, Integer> nums = new TreeMap<Integer, Integer>();
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}
 
		boolean possible = false;
		for (int i = 0; i < N; i++) {
			if (nums.containsKey(X - array[i])) {
				System.out.print((i + 1) + " " + nums.get(X - array[i]));
				possible = true;
				break;
			}
			nums.put(array[i], i + 1);
		}
	
		if (!possible) {
			System.out.print("IMPOSSIBLE");
		}
		
	}
}
