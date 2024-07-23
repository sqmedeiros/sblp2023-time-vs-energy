import java.util.*;
import java.io.*;
 
class entry_3154081 {
    // SOLUTION BEGIN
    void pre() throws Exception {
 
    }
 
    class J {
        int s, f, v;
    }
 
    void solve(int TC) throws Exception {
        int n = ni();
        ArrayList<J> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new J());
            jobs.get(i).s = ni();
            jobs.get(i).f = ni();
            jobs.get(i).v = ni();
        }
        Collections.sort(jobs, (a, b) -> a.f - b.f);
        long dp[] = new long[n + 1];
        dp[0] = jobs.get(0).v;
        for (int i = 1; i < n; i++) {
            long include = jobs.get(i).v;
            int idx = binarySearch(jobs, i);
            long exclude = dp[i - 1];
            if (idx != -1) {
                include += dp[idx];
            }
            dp[i] = Math.max(include, exclude);
        }
        pn(dp[n - 1]);
    }
 
    private int binarySearch(ArrayList<entry_3154081.J> jobs, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (jobs.get(m).f < jobs.get(i).s) {
                if (jobs.get(m + 1).f < jobs.get(i).s) {
                    low = m + 1;
                } else {
                    return m;
                }
            } else
                high = m - 1;
        }
        return -1;
    }
 
    static boolean multipleTC = false;
    static FastReader in;
    static PrintWriter out;
    static Scanner sc;
 
    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        sc = new Scanner(System.in);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }
 
    public static void main(String[] args) throws Exception {
        try {
            new entry_3154081().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }
 
    void p(Object o) {
        out.print(o);
    }
 
    void pn(Object o) {
        out.println(o);
    }
 
    void pni(Object o) {
        out.println(o);
        out.flush();
    }
 
    String n() throws Exception {
        return in.next();
    }
 
    String nln() throws Exception {
        return in.nextLine();
    }
 
    int ni() throws Exception {
        return in.nextInt();
    }
 
    long nl() throws Exception {
        return in.nextLong();
    }
 
    double nd() throws Exception {
        return in.nextDouble();
    }
 
}
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(next());
    }
 
    long nextLong() {
        return Long.parseLong(next());
    }
 
    double nextDouble() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
