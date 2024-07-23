import java.io.*;
import java.util.*;
 
public class entry_756063 { 
    static Random random;
    public static void main(String[] args) {
        FastScanner in = new FasterScanner();
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
            int k = in.nextInt();
            ArrayList<Tuple> input = new ArrayList<>(n);
            for(int i = 0; i<n; i++){
                int l = in.nextInt(), r = in.nextInt();
                input.add(new Tuple(r, l));
            }
 
            Collections.sort(input);
            TreeSet<Tuple> set = new TreeSet<>();
            for(int i = 0; i<k; i++){
                set.add(new Tuple(0, i));
            }
 
            int ans = 0;
            for(int i = 0; i<n; i++){
                Tuple movie = input.get(i);
                Tuple person = set.lower(new Tuple(movie.b, k));
                if(person == null) continue;
 
                ans++;
                set.remove(person);
                person.a = movie.a;
                set.add(person);
            }
 
            out.println(ans);
 
        }
 
        static class Tuple implements Comparable<Tuple> {
            public int a, b;
            public Tuple(int a, int b){
                this.a = a;
                this.b = b;
            }
            public boolean equals(Object o) {
                if(o == null || getClass() != o.getClass()) return false;
                Tuple p = (Tuple) o;
                return a == p.a && b == p.b;
            }
            public int hashCode() {
                return Arrays.hashCode(new int[]{a, b});
            }
            public String toString(){
                return "(" + a + ", " + b + ')';
            }
            public int compareTo(Tuple p) {
                if(a == p.a) 
                    return (b == p.b)? 0 : ((b > p.b)? 1 : -1);
                else 
                    return ((a > p.a)? 1 : -1);
            }
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
 
    /* FUCK THE PROBLEM AUTHOR FOR MAKING ME USE THIS */
    static class FasterScanner extends FastScanner {
        final private int BUFFER_SIZE = 1 << 12; 
        private DataInputStream inputStream; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public FasterScanner() { 
            inputStream = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public FasterScanner(String fileName) { 
            try{
                inputStream = new DataInputStream(new FileInputStream(fileName));     
                buffer = new byte[BUFFER_SIZE]; 
                bufferPointer = bytesRead = 0; 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
  
        String readLine() { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
 
        String next() {
            StringBuilder ret = new StringBuilder();
            byte c = read();
            while(c <= ' ') c = read();
            do{
                ret.append((char) c);
            } while((c = read()) > ' ');
            return new String(ret);
        }
  
        int nextInt() { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) return -ret; 
            return ret; 
        } 
  
        long nextLong() { 
            long ret = 0; 
            byte c = read();
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) return -ret; 
            return ret; 
        }
  
        double nextDouble() { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') c = read(); 
            boolean neg = (c == '-'); 
            if (neg) c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
            if (neg) return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() { 
            try{
                bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
                if (bytesRead == -1) buffer[0] = -1; 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
  
        private byte read() { 
            if (bufferPointer == bytesRead) fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() { 
            if (inputStream == null)  return; 
            try{
                inputStream.close(); 
            } catch (Exception e){
                e.printStackTrace();
            }
        } 
    } 
 
}