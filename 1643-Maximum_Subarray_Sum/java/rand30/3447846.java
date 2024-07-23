import java.sql.SQLOutput;
import java.util.Scanner;
 
public class entry_3447846 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        long sum = 0, best = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            nums[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++){
            sum = Math.max(sum+nums[i], nums[i]);
            best = Math.max(best, sum);
        }
        System.out.println(best);
    }
}
