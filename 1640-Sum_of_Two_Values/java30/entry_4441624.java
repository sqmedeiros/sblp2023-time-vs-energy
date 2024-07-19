import java.io.*;
import java.util.*;
 
public class entry_4441624 {
    public static void main(String[] args) throws IOException {
        //BufferedReader r = new BufferedReader(new FileReader("template.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("template.out")));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //r.readLine() reads the next line
        //st.newToken() reads up to whitespace and returns a String
        //Integer.parseInt converts String (above) to Integer
        //Double.parseDouble
        //Long.parseLong
        //pw.println()
        //pw.print()
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        HashSet<Integer> s = new HashSet<Integer>();
        int x1 = 0;
        int x1i = -1;
        int x2i = -1;
        int[] a = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (!(s.contains(x-a[i]))) {
                s.add(a[i]);
            }
            else {
                x1=x-a[i];
                x2i=i;
                break;
            }
        }
        for (int i=0; i<a.length; i++) {
            if (x1==a[i]) {
                x1i=i;
                break;
            }
        }
        if (x1i!=-1 && x2i!=-1) {
            System.out.println((x1i+1)+" "+(x2i+1));
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
        r.close();
        pw.close();
    }
}
