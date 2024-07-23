import java.io.*;
import java.sql.Array;
import java.util.*;
 
public class entry_4844393 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n=Integer.parseInt(r.readLine());
        StringTokenizer st=new StringTokenizer(r.readLine());
        HashSet<Integer> nums=new HashSet<>();
        int distinct=0;
        for (int i=0; i<n; i++) {
            int next=Integer.parseInt(st.nextToken());
            if (!nums.contains(next)) {
                nums.add(next);
                distinct++;
            }
        }
        pw.println(distinct);
        pw.close();
    }
}