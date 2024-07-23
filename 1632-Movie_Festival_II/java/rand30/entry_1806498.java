import java.io.*;
import java.util.*;
import java.lang.*;
 
public class entry_1806498 {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    //    static int MOD = 998244353;
    static long MOD2 = MOD * MOD;
    static FastReader sc = new FastReader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e17)+9;
    public static void main(String[] args) throws Exception {
        int test = 1;
//        test = sc.nextInt();
        for (int i = 1; i <= test; i++){
//            out.print("Case #"+i+": ");
            solve();
        }
        out.flush();
        out.close();
    }
    static void solve()throws Exception{
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Pair> A = new ArrayList<>();
        for(int i= 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            A.add(new Pair(2*x+1,2*y));
        }
        Collections.sort(A);
        int ans = 0;
        TreeMap<Integer,Integer> T = new TreeMap<>();
        int size = 0;
        for(Pair p: A){
            Integer key = T.lowerKey(p.x);
            if(key==null&&size<k){
                T.put(p.y,T.getOrDefault(p.y,0)+1);
                ans++;
                size++;
            }
            if(key!=null&&size<=k){
                T.put(key,T.get(key)-1);
                size--;
                if(T.get(key)==0){
                    T.remove(key);
                }
                T.put(p.y,T.getOrDefault(p.y,0)+1);
                ans++;
                size++;
            }
        }
        out.println(ans);
    }
    static int size(TreeMap<Integer,Integer> A){
        int ans = 0;
        for(int x: A.values()){
            ans += x;
        }
        return ans;
    }
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
//        int idx;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
//            this.idx = idx;
        }
        @Override
        public int compareTo(Pair o){
            if(this.y==o.y){
                return this.x-o.x;
            }
            return this.y-o.y;
        }
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long add(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    public static long c2(long n) {
        if ((n & 1) == 0) {
            return mul(n / 2, n - 1);
        } else {
            return mul(n, (n - 1) / 2);
        }
    }
    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n); int temp= a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    //Brian Kernighans Algorithm
    static long countSetBits(long n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
    //Euclidean Algorithm
    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    //Modular Exponentiation
    static long fastExpo(long x, long n) {
        if (n == 0) return 1;
        if ((n & 1) == 0) return fastExpo((x * x) % MOD, n / 2) % MOD;
        return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    public static long modinv(long x) {
        return modpow(x, MOD - 2);
    }
    public static long modpow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = modpow(a, b / 2);
        x = (x * x) % MOD;
        if (b % 2 == 1) {
            return (x * a) % MOD;
        }
        return x;
    }
 
 
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public FastReader(String file_name) throws IOException{
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String nextLine() {
            try{
                byte[] buf = new byte[10000000]; // line length
                int cnt = 0, c;
                while ((c = read()) != -1) {
                    if (c == '\n')
                        break;
                    buf[cnt++] = (byte) c;
                }
                return new String(buf, 0, cnt);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
 
        public int nextInt()  {
            int ret = 0;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                boolean neg = (c == '-');
                if (neg) c = read();
                do{
                    ret = ret * 10 + c - '0';
                }  while ((c = read()) >= '0' && c <= '9');
 
                if (neg) return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
 
        public long nextLong()   {
 
            try {
                long ret = 0;
                byte c = read();
                while (c <= ' ') c = read();
                boolean neg = (c == '-');
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                }
                while ((c = read()) >= '0' && c <= '9');
                if (neg)
                    return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
 
        public double nextDouble()  {
 
            try {
                double ret = 0, div = 1;
                byte c = read();
                while (c <= ' ')
                    c = read();
                boolean neg = (c == '-');
                if (neg) c = read();
 
                do {
                    ret = ret * 10 + c - '0';
                }
                while ((c = read()) >= '0' && c <= '9');
                if (c == '.') {
                    while ((c = read()) >= '0' && c <= '9') {
                        ret += (c - '0') / (div *= 10);
                    }
                }
 
                if (neg) return -ret;
                return ret;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
 
        private void fillBuffer() throws IOException{
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException  {
            try{
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            }catch(Exception e){
                System.out.println(e.getMessage());
                return -1;
            }
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}