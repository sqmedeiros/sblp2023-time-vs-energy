import java.io.*;
import java.util.*;
 
public class entry_752416 { 
    static Random random;
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));;
        random = new Random();
 
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }
 
    /* ------------------------------------- START -------------------------------------------- */
    static class Solver {
        public void solve(FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int input[] = new int[n];
 
            for(int i = 0; i<n; i++){
                input[i] = in.nextInt();
            }
 
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<n; i++){
                for(int j = i+1; j<n; j++){
                    int part = input[i] + input[j];
                    if(map.containsKey(sum-part)){
                        int X = map.get(sum-part);
                        int a = X % n;
                        int b = X / n;
                        out.println((a+1) + " " + (b+1) + " " + (i+1) + " " + (j+1));
                        return;
                    }
                }
                for(int j = i-1; j>=0; j--){
                    int part = input[i] + input[j];
                    map.put(part, i*n+j);
                }
            }
            out.println("IMPOSSIBLE");
            return ;
        }
    }
    /* -------------------------------------- END --------------------------------------------- */
 
    /* Shuffle function to shuffle before Arrays.sort */
    static void shuffle(int[] arr){
        int swapTemp;
        for(int i = arr.length-1; i>= 1; i--){
            int pos = random.nextInt(i+1);
            if(pos == i) continue;
            {swapTemp = arr[i]; arr[i] = arr[pos]; arr[pos] = swapTemp;}
        }
    }
 
    /* Fast Input reader */
    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }
 
        String next() {
            while (!tokenizer.hasMoreTokens()) {
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine() {
            String string = "";
            try {
                string = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return string;
        }
    }
}