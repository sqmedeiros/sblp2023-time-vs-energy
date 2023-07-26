import java.util.*;
 
public class entry_5468017 {
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(x - list.get(i)) != null) {
                System.out.printf("%d %d\n", i + 1, map.get(x - list.get(i)));
                return;
            }
            map.put(list.get(i), i + 1);
        }
        System.out.println("IMPOSSIBLE");
    }
}
