import java.io.*;
import java.util.*;
 
public class entry_1639078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        HashSet<Integer> set = new HashSet<>();
 
        for(int i=0;i<N;i++)
            set.add(Integer.parseInt(st.nextToken()));
        System.out.println(set.size());
    }
}