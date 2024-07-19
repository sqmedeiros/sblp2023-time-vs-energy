import java.util.*;
public class entry_3326640 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long target = sc.nextInt();
        Map<Long,Integer> map = new HashMap<>();
        long arr[] = new long[N];
        for (int i=0;i<N;i++) {
            arr[i] = sc.nextLong();
        }
        for (int i=0;i<N;i++) {
            if (map.containsKey(target-arr[i])) {
                System.out.println(map.get(target-arr[i])+" "+(i+1));
                return;
            }
            map.put(arr[i], i+1);
        }
        System.out.println("IMPOSSIBLE");
    }
}
