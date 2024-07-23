import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;
public class entry_3369699 {
 
    static void solve(int tc) {
 
        int n = fs.nInt();
        PairI[]proj = new PairI[n+1];
        proj[0] = new PairI(0,0,0);
        for(int i=1;i<=n;i++){
            proj[i] = new PairI(fs.nInt(),fs.nInt(),fs.nInt());
        }
        Arrays.sort(proj,Comparator.comparingInt(o -> o.s));
        int[]end = new int[n+1];
        for(int i=0;i<=n;i++){
            end[i] = proj[i].s;
        }
        long[]dp = new long[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int j = search(end,proj[i].f);
            dp[i] = max(dp[i-1],proj[i].t+dp[j]);
        }
        out.println(dp[n]);
    }
    static int search(int[]end,int x){
        int l = 0,r = end.length-1,ans = 0;
        while (l <= r ){
            int mid = (l+r)/2;
            if( end[mid] < x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
 
    static class PairI{
        int f,s,t;
        PairI(int f,int s,int t){
            this.f = f;
            this.s = s;
            this.t = t;
        }
    }
    static class Pair{
        long f;
        long s;
        Pair(long f,long s){
            this.f = f;
            this.s = s;
        }
        void renew(int f,int s){
            this.f = f;
            this.s = s;
        }
 
    }
    static int MIN = Integer.MIN_VALUE,MAX = Integer.MAX_VALUE,MOD = (int)1e9+7;
    static boolean multiTestCase = false;static FastScanner fs;static PrintWriter out;
    static void println(int tc,int ans){
        out.println("Case #"+tc+": "+ans);
    }
    static void println(int tc,String ans){
        out.println("Case #"+tc+": "+ans);
    }
    public static void sort(int[] arr){
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    public static void sort(long[] arr){
        ArrayList<Long> ls = new ArrayList<>();
        for(long x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
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
    static class FastScanner extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;
 
        // standard input
        public FastScanner() { this(System.in,System.out); }
        public FastScanner(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastScanner(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
 
        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }
 
        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nInt() { // nextLong() would be implemented similarly
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public long nLong(){return Long.parseLong(next());}
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}