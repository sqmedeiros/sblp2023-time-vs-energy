import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
 
public class entry_870099 {
 
    private static class StartEnd  {
        private final Integer start;
        private final Integer end;
 
        StartEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
 
    }
 
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        int n = in.nextInt();
        int x = in.nextInt();
 
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        boolean found = false;
        for(Integer i=0; i<n;i++) {
            Integer current = in.nextInt();
            Integer diff = x - current;
            if(map.containsKey(diff)) {
                System.out.println(map.get(diff)+" "+(i+1));
                found =true;
                break;
            }else{
                map.put(current, (i+1));
            }
        }
 
        if(!found) {
            System.out.println("IMPOSSIBLE");
        }
 
    }
 
    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
