 
import java.io.*;
import java.util.*;
import java.lang.*;
 
 
public class entry_3159815 {
 
    static void solve(int tc) {
 
        int n = fs.nInt();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(fs.nInt());
        }
        out.println(set.size());
    }
 
    static boolean multiTestCase = false;static FastScanner fs;static PrintWriter out;
    static void println(int tc,int ans){
        out.println("Case #"+tc+": "+ans);
    }
    static void println(int tc,String ans){
        out.println("Case #"+tc+": "+ans);
    }
    static void sort(int[]ar){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:ar)
            list.add(i);
        Collections.sort(list);
        for(int i=0;i<ar.length;i++){
            ar[i] = list.get(i);
        }
    }
    public static void main(String[] args) {
        try{
            fs = new FastScanner();out = new PrintWriter(System.out);
            int tc = (multiTestCase)? fs.nInt() : 1;
            int t = 1;
            while ( t <= tc ){
                solve(t);t++;
            }
            out.flush();out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String n() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String nLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        int nInt() {return Integer.parseInt(n()); }
        long nLong() {return Long.parseLong(n());}
        int[]aI(int n){
            int[]ar = new int[n];
            for(int i=0;i<n;i++)
                ar[i] = nInt();
            return ar;
        }
    }
}