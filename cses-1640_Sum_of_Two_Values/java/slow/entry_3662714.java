import java.util.HashMap;
import java.util.Scanner;
 
public class entry_3662714 {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int target = r.nextInt();
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = r.nextInt();
        }
        
        int[] indices = twoSum(nums, target);
        if (indices[0] == -1) {
            System.out.println("IMPOSSIBLE");
        } else System.out.println(indices[0] + " " + indices[1]);
    }
    
    static int[] twoSum(int[] nums, int target) {
        var checkMap = new HashMap<Integer, Integer>();
 
        for (int i = 0; i < nums.length; i++) {
            Integer get = checkMap.get(nums[i]);
            if (get == null) {
                checkMap.put(target - nums[i], i);
            } else {
                return new int[]{get + 1, i + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
