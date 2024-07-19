import java.util.*;
public class entry_5240298 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<n; i++) {
            if(!set.contains(arr[i])) {
                set.add(arr[i]);
                counter++;
            }
        }
        System.out.println(counter);
    }
}