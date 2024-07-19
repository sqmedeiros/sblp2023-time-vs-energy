import java.util.*;
 
public class entry_3785822 {
 
    public static class Pair {
        public int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this. b = b;
        }
    }
    public static void fourSum(int[] a, int t) {
        Map<Integer, Pair> prevTwoSums = new HashMap<>();
        for (int j = 0; j < a.length; j++) {
            for (int k = j + 1; k < a.length; k++) {
                int curSum = a[j] + a[k];
                if (prevTwoSums.containsKey(t - curSum)) {
                    Pair prevPair = prevTwoSums.get(t - curSum);
                    System.out.println( ++prevPair.a + " " + ++prevPair.b + " "  + ++j + " " + ++k);
                    return;
                }
            }
            for (int k = 0; k < j; k++) {
                prevTwoSums.put(a[j] + a[k], new Pair(k, j));
            }
        }
        System.out.println("IMPOSSIBLE");
        return;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        fourSum(a,t);
    }
}