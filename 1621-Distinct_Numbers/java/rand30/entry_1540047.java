import java.io.*;
import java.util.*;
 
public class entry_1540047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] aa = new Integer[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            aa[i] = Integer.parseInt(st.nextToken());
            map.put(aa[i],0);
        }
        System.out.println(map.size());
    }
}
