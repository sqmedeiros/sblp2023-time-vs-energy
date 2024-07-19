import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class entry_4019764 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
 
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] a = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            indexMap.put(a[i], i);
        }
 
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int diff = x - a[i];
            if (indexMap.containsKey(diff) && indexMap.get(diff) != i) {
                found = true;
                out.println((i + 1) + " " + (indexMap.get(diff) + 1));
                break;
            }
        }
 
        if (!found) {
            out.println("IMPOSSIBLE");
        }
        out.close();
    }
}
