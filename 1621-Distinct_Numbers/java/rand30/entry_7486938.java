import java.util.*;
 
public class entry_7486938 {
    static Scanner in = new Scanner(System.in);
 
    static HashMap <Integer, Integer> map = new HashMap <Integer, Integer> ();
 
    public static void main(String[] args) {
        int n = in.nextInt();
 
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            map.put(x, 1);
        }
 
        System.out.println(map.size());
    }
}
