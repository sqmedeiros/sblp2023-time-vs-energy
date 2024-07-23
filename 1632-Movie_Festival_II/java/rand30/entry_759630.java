import java.io.*;
import java.util.*;
 
public class entry_759630 { 
    static Random random;
    public static void main(String[] args) {
        FastScanner in = new FasterScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
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
            RandomTree set = new RandomTree(random);
            set.insert(0).count = k;
 
            int ans = 0;
            for(int i = 0; i<n; i++){
                Tuple movie = input.get(i);
                RandomTree.Node person = set.floor(movie.b);
                if(person == null) continue;
 
                ans++;
                if(--person.count == 0) set.erase(person.key);
                person = set.get(movie.a);
                if(person == null) person = set.insert(movie.a);
                person.count++;
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
        
 
        private static class RandomTree {
            class Node{
                int key, count, priority;
                private Node left, right;
                Node(int key) {
                    this.key = key;
                    this.count = 0;
                    priority = random.nextInt();
                }
                @Override
                public String toString() {
                    return "(" + key + ", " + priority + ")";
                }
            }
 
            Random random;
            Node root;
            int size;
            public RandomTree (Random random) {
                this.random = random;
            }
            public Node get(int key){
                Node cur = root;
                while(cur != null){
                    if(cur.key > key)       cur = cur.left;
                    else if(cur.key < key)  cur = cur.right;
                    else return cur;
                }
                return cur;
            }
 
            public Node floor(int key){
                Node cur = root, ret = null;
                while(cur != null){
                    if(key < cur.key){
                        cur = cur.left;
                    } else {
                        ret = cur;
                        cur = cur.right;
                    }
                }
                return ret;
            }
 
            public Node insert(int key){
                Node newNode = new Node(key);
                Node cur = root, par = null;
                while(cur != null){
                    if(newNode.priority > cur.priority){
                        split(cur, newNode);
                        break;
                    } 
                    par = cur;
                    if(newNode.key < cur.key) cur = cur.left;
                    else                      cur = cur.right;
                }
                if(par == null)                 root = newNode;
                else if(newNode.key < par.key)  par.left = newNode;
                else                            par.right = newNode;
                return newNode;
            }
 
            public Node erase(int key){
                Node cur = root, par = null;
                while(cur != null){
                    if(cur.key == key){
                        if(par == null)        root = merge(cur.left, cur.right); 
                        else if(key < par.key) par.left = merge(cur.left, cur.right);
                        else                   par.right = merge(cur.left, cur.right);
                        return cur;
                    }
                    par = cur;
                    if(key < cur.key) cur = cur.left;
                    else              cur = cur.right;
                }
                return null;
            }
 
            private Node merge(Node left, Node right) {
                if(left == null || right == null) return (left == null)? right : left;
                if(left.priority > right.priority){
                    left.right = merge(left.right, right);
                    return left;
                } else {
                    right.left = merge(left, right.left);
                    return right;
                }
            }
 
            private void split(Node subtree, Node separator) {
                if(subtree == null) return;
                if(separator.key < subtree.key){
                    split(subtree.left, separator);
                    subtree.left = separator.right;
                    separator.right = subtree;
                } else {
                    split(subtree.right, separator);
                    subtree.right = separator.left;
                    separator.left = subtree;
                }
            }
 
            public int[] toArray(){
                if(size == 0) return new int[0];
                int arr[] = new int[size];
                toArray(root, arr, 0);
                return arr;
            }
 
            private int toArray(Node node, int[] arr, int shift) {
                if(node.left != null) shift = toArray(node.left, arr, shift);
                arr[shift++] = node.key;
                if(node.right != null) shift = toArray(node.right, arr, shift);
                return shift;
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