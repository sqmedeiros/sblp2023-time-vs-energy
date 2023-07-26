import java.lang.*;
import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class entry_4420332 {
    static PrintWriter out;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out = new PrintWriter(System.out);
 
        int T = 1;//in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
 
            solve(n, x, arr);
        }
 
        in.close();
        out.close();
    }
 
    private static void solve(int n, int t, int[] arr) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < n; i++) {
        if (map.containsKey(t - arr[i])) {
            System.out.println((map.get(t - arr[i]) + 1) + " " + (i  + 1));
            return;
        }
        map.put(arr[i], i);
       }
       System.out.println("IMPOSSIBLE");
    }
 
}
