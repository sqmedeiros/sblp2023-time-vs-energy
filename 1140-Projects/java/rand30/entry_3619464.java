import java.io.*;
import java.util.*;
 
public class entry_3619464
{
    static class Project implements Comparable<Project> {
        int s, e, p;
        public Project(int s, int e, int p) { this.s = s; this. e = e; this.p = p; }
        public int compareTo(Project o) {
            if (this.e != o.e) return this.e - o.e;
            return this.s - o.s;
        }
    }
    public static void projects(Project[] ps, Kattio io) {
        Arrays.sort(ps);
        long[] dp = new long[ps.length];
        for (int i = 0; i < ps.length; ++i) {
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo >> 1);
                if (ps[mid].e >= ps[i].s) hi = mid;
                else lo = mid + 1;
            }
            lo--;
            dp[i] = ps[i].p;
            if (lo >= 0) dp[i] = dp[lo] + ps[i].p;
            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        // io.println(Arrays.toString(dp));
        io.println(dp[ps.length - 1]);
    }
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        Project[] ps = new Project[n];
        for (int i = 0; i < n; ++i) ps[i] = new Project(io.nextInt(), io.nextInt(), io.nextInt());
        projects(ps, io);
        io.close();
    }
 
    static final int mod = (int) 1e9 + 7;
    static final Random random = new Random();
    static void shuffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int nex = random.nextInt(n), temp = a[nex];
            a[nex] = a[i]; a[i] = temp;
        }
        Arrays.sort(a);
    }
    static long add(long a, long b) { return (a + b) % mod; }
    static long sub(long a, long b) { return ((a - b) % mod + mod) % mod; }
    static long mul(long a, long b) { return (a * b) % mod; }
    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp >> 1);
        if ((exp & 1) == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];
    static void calc_factorials() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] =
                exp(factorials[factorials.length - 1], mod - 2);
        for (int i=invFactorials.length - 2; i >=0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }
    static class Kattio extends PrintWriter {
        private final int BS = 1 << 16;
        private final char NC = (char) 0;
        private final byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;
 
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            in = new BufferedInputStream(System.in, BS);
        }
        // USA CO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            in = new BufferedInputStream(new FileInputStream(problemName + ".in"), BS);
        }
        // returns null if no more input
        private char getChar() {
            while (bId == size) {
                try { size = in.read(buf); }
                catch (Exception e) { return NC; }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }
 
        public int nextInt() { return (int) nextLong(); }
 
        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar())
            { res = (res << 3) + (res << 1) + c - '0'; cnt *= 10; }
            return neg ? -res : res;
        }
 
        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }
 
        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) { res.append(c); c = getChar(); }
            return res.toString();
        }
 
        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') { res.append(c); c = getChar(); }
            return res.toString();
        }
 
        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }
}