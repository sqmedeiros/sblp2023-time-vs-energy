import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class entry_615005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!set.contains(num)){
                set.add(num);
                count++;
            }
        }
        PrintStream out = new PrintStream(System.out);
        out.println(count);
    }
}