import java.util.Scanner;
 
public class entry_4371657 {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int n = r.nextInt();
        long currentSum = Integer.MIN_VALUE;
        long best = Integer.MIN_VALUE;
    
        for (int i = 0; i < n; i++) {
            int nextInt = r.nextInt();
            currentSum = Math.max(nextInt, currentSum + nextInt);
            best = Math.max(best, currentSum);
        }
    
        System.out.println(best);
    }
}
