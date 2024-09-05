import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class entry_6718434 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
 
        StringTokenizer st = new StringTokenizer(r.readLine());
        Set<Integer> hash_Set = new HashSet<>();
 
        for (int i = 0; i<n; i++){
            hash_Set.add(Integer.parseInt(st.nextToken()));
        }
        pw.println(hash_Set.size());
 
 
 
        pw.close();
    }
}
