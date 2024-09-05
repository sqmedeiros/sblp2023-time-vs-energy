import java.io.*;
import java.util.*;
public class entry_7958848 {
    
    public static class Task {
  
 
        public void solve(Scanner sc) throws IOException {
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++){
                set.add(sc.nextInt());
            }
 
            System.out.println(set.size());
        }
        
    }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    public static void main(String... args) throws IOException {
        Scanner sc = new Scanner(System.in);
 
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setOut(new PrintStream(
                    new FileOutputStream("output.txt")));
 
                sc = new Scanner(new FileReader(System.getenv("INPUT")));
            }
  
            // Catch block to handle the exceptions
            catch (Exception e) {
            }
        }
 
        Task t = new Task();
        int T = 1;
        while (T-- > 0)
            t.solve(sc);
    }
}
 
class Scanner {
    private StringTokenizer st;
    private BufferedReader br;
    public Scanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }
    public Scanner(FileReader s) throws FileNotFoundException {
        br = new BufferedReader(s);
    }
    public String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    public String nextLine() throws IOException {
        return br.readLine();
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
 
 
 
 
    public int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }
    public long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }
    public String[] readStringArray(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }
    
}
