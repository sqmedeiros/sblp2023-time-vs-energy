import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
public class entry_4117346 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int flag = 0;
        int[] values = new int[n];
        // use a map to avoid using a very large array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
 
        for (int i = 0; i < n; i++) {
            // target minus a number is the other number
            if (map.containsKey(x - values[i])) {
                System.out.println((i + 1) + " " + map.get(x - values[i]));
                // remember to close here before exiting to avoid
                // blank output
                sc.close();
                System.exit(0);
            }
            map.put(values[i], i + 1);
        }
        System.out.println("IMPOSSIBLE");
        sc.close();
    }
}
