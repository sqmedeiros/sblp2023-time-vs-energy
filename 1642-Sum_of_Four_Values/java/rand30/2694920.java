import java.util.*;
import java.io.*;
 
public class entry_2694920 {
    public static class Pair {
        int f, s;
        public Pair(int _f, int _s) {
            f = _f;
            s = _s;
        }
        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return p.f == f && p.s == s;
        }
        @Override
        public int hashCode() {
            return (37*f+s)*37;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        HashMap<Integer,Pair> m = new HashMap<>();
        boolean found = false;
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (m.containsKey(x-a[i]-a[j])) {
                    found = true;
                    Pair p = m.get(x-a[i]-a[j]); 
                    pw.println((i+1) + " " + (j+1) + " " + (p.f+1) + " " + (p.s+1));
                    break;
                }
            }
            for (int k = 0; k<i; k++) {
                m.put(a[i]+a[k],new Pair(i,k));
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            pw.println("IMPOSSIBLE");
        }
        pw.close();
    }
}