import java.io.PrintWriter;
import java.util.*;
 
/**
 * https://codeforces.com/contest/1216/problem/C
 */
public class entry_2526174 {
    private static int n, x, p1, p2;
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] num;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        StringTokenizer line = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(line.nextToken());
        x = Integer.parseInt(line.nextToken());
 
        num = new int[n + 1];
        line = new StringTokenizer(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(line.nextToken());
            map.put(num[i], i);
        }
 
        sumof2num();
 
 
        PrintWriter pw = new PrintWriter(System.out);
        if (p1 == 0 || p2 == 0)
            pw.println("IMPOSSIBLE");
        else
            pw.println(String.format("%d %d", p1, p2));
        pw.close();
    }
 
    public static void sumof2num() {
        for (int i = 1; i <= n; i++) {
            int remaining = x - num[i];
            Integer v2 = map.get(remaining);
            if (v2 != null && i != v2) {
                p1 = i;
                p2 = v2;
                return;
            }
        }
    }
}
