import java.io.*;
import java.util.*;
 
public class entry_7719960 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
 
        int n = Integer.parseInt(r.readLine());
        HashSet<Integer> x = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++){
            x.add(Integer.parseInt(st.nextToken()));
        }
        pw.println(x.size());
 
        pw.close();
    }
}
