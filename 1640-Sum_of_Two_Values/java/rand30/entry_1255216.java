/*
ID: krishpa2
LANG: JAVA
TASK: SumTwoValues
*/
 
import java.util.*;
import java.io.*;
 
public class entry_1255216 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()); int X = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i<N; i++) a[i] = Integer.parseInt(st.nextToken());
 
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i<N; i++) {
            if (map.containsKey(X-a[i])) {
                out.println(i+1 + " " + map.get(X-a[i]));
                out.close();
                break;
            }
            map.put(a[i],i+1);
        }
        out.println("IMPOSSIBLE");
        in.close();
        out.close();
    }
 
}
