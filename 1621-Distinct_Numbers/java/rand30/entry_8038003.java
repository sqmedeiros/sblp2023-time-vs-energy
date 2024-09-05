import java.io.*;
import java.nio.Buffer;
import java.util.*;
 
public class entry_8038003 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
 
    public static void main(String[] argv) throws IOException {
        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
 
        HashSet<Integer> ans = new HashSet<>();
 
        st = new StringTokenizer(bf.readLine());
        for(int x=0; x<a; x++){
            ans.add(Integer.parseInt(st.nextToken()));
        }
 
        System.out.println(ans.size());
    }
}
