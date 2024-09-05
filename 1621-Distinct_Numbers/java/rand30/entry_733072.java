import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class entry_733072 {
    
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
 
        int n = in.nextInt();
 
        int[] arr = new int[n];
 
        for(int i = 0; i < n ; i++) {
            arr[i] = in.nextInt();
        }
 
        Set<Integer> s = new HashSet<Integer>();
 
        for(int i = 0; i < n; i++) {
            s.add(arr[i]);
        }
 
        System.out.println(s.size());
 
    }
}
