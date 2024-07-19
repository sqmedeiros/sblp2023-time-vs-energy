import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class entry_6208064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
 
        Set<Integer> distinctValues = new HashSet<>();
        for (int i = 0; i < n; i++) {
            distinctValues.add(arr[i]);
        }
 
        int distinctCount = distinctValues.size();
        System.out.println(distinctCount);
    }
}