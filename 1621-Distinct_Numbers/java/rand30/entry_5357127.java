import java.util.*;
 
class Pair7 {
    int num;
    int index;
    Pair7(int num, int index) {
        this.num = num;
        this.index = index;
    }
}
 
public class entry_5357127 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
 
        Map<Integer, Pair7> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = x - (nums[i] + nums[j]);
                if (map.containsKey(sum)) {
                    System.out.println((i + 1) + " " + (j + 1) + " " + (map.get(sum).num + 1) + " " + (map.get(sum).index + 1));
                    return;
                }
            }
            for (int j = 0; j < i; j++) {
                map.put(nums[j] + nums[i], new Pair7(j, i));
            }
        }
 
        System.out.println("IMPOSSIBLE");
    }
}