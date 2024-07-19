import java.io.*;
import java.util.*;
public class entry_2073331 {
    public static void main(String[]args) throws Exception { 
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());
        int n = Integer.parseInt( st.nextToken());
        int x = Integer.parseInt( st.nextToken());
        st = new StringTokenizer( br.readLine());
        LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<>();
        for(int i=0; i<n; i++) {
            int key = Integer.parseInt( st.nextToken());
            if( mp.containsKey(x-key) ) {
                int si = mp.get(x-key)+1;
                int ei = i+1;
                if( si!=ei ){
                    System.out.println( si+" "+ei);
                    return;
                }
            }
            mp.put( key, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}
