import java.io.*;
import java.util.*;
 
public class entry_4091586 {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
 
        for (int i = 0; i < n; i++) {
 
            int ele = Integer.parseInt(st.nextToken());
            int diff = x - ele;
 
            if (map.containsKey(diff)) {
 
                a = map.get(diff);
                b = i + 1;
            }
            else map.put(ele, i + 1);
        }
        
        sb.append(a == b ? "IMPOSSIBLE" : a + " " + b);
 
        pw.println(sb.toString().trim());
 
        pw.close();
    }
}
