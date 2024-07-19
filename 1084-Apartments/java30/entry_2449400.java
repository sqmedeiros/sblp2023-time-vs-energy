import java.util.*;
import java.io.*;
import java.math.*;
 
public class entry_2449400 {
    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() throws FileNotFoundException {
 
            {
                // Input is System.in
                br = new BufferedReader(new InputStreamReader(System.in), 32768);
                st = null;
            }
 
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
 
        int i() {
            return Integer.parseInt(next());
        }
 
        int[] intArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++)
                ret[i] = i();
            return ret;
        }
 
        long l() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = l();
            return ret;
        }
 
        double d() {
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
 
    // **********************Code Begins From Here*********************
    public static void solve() {
        int n = c.i(), m = c.i(), k = c.i(), a[] = c.intArray(n), b[] = c.intArray(m), cnt = 0;
        sort(a);
        sort(b);
        int i = 0, j = 0;
        while (i < n) {
            while (j < m && b[j] < a[i] - k)
                j++;
            if (j<m&&abs(b[j] - a[i]) <= k) {
                cnt++;
                i++;
                j++;
            } else
                i++;
        }
        pn(cnt);
    }
 
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner sc = new Scanner(System.in);
        c = new FastScanner();
        pw = new PrintWriter(System.out);
        for (long i = 0; i < arr.length; i++) {
            if (arr[(int) i]) {
                primes.add(i);
            }
        }
        // for(int i=1;i<1000000;i++)
        // {
        // sumList.add((long)(i*(i+1)/2));
        // }
        int tc = 1;
        long start = System.currentTimeMillis();
        for (int t = 0; t < tc; t++) {
            // p("Case #"+(t+1)+": ");
            solve();
        }
        long end = System.currentTimeMillis();
        // if (System.getProperty("ONLINE_JUDGE") == null) {
        // pn("The Program takes " + (end - start) + "ms");
        // }
        pw.close();
    }
 
    // ArrayList<Integer> al = new ArrayList<>();
    // Set<Integer> set = new TreeSet<>();
    // Map<Integer, Integer> map = new HashMap<>();
    // for(Map.Entry<Integer,Integer> e:map.entrySet())pn(e.getKey()+"
    // "+e.getValue());
    // LinkedList<Integer> ll = new LinkedList<>();
    // Stack<Integer>st = new Stack<>();
    private static FastScanner c;
    private static Pair<Integer, Integer> pair;
    private static PrintWriter pw;
    private static int mod = (int) (1e9 + 7);
    private static final int IBIG = 1000000007;
    private static final int IMAX = 2147483647;
    private static final int IMIN = -2147483648;
    private static final long LMAX = 9223372036854775807L;
    private static final long LMIN = -9223372036854775808L;
    private static boolean arr[] = sieve(1000001);
    private static ArrayList<Long> primes = new ArrayList<>();
    private static ArrayList<Long> sumList = new ArrayList<>();
    private static ArrayList<Integer> divisors = new ArrayList<>();
    private static ArrayList<Long> divisorsL = new ArrayList<>();
    private static ArrayList<Integer> primedivisors = new ArrayList<>();
    private static ArrayList<Integer> perfectSquares = new ArrayList<>();
    private static int freq[] = new int[200005];
    private static ArrayList<Integer> primefactorsofN = new ArrayList<>();;
 
    // Pair<Integer, Integer> pair;
    private static void pn(Object o) {
        pw.println(o);
    }
 
    private static void p(Object o) {
        pw.print(o);
    }
 
    private static Random rand = new Random();
 
    // math util
    private static int minof(int a, int b, int c) {
        return min(a, min(b, c));
    }
 
    private static int minof(int... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return min(x[0], x[1]);
        if (x.length == 3)
            return min(x[0], min(x[1], x[2]));
        int min = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] < min)
                min = x[i];
        return min;
    }
 
    private static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String arr[] = new String[s.length() - k + 1];
 
        for (int i = 0; i < s.length() - k + 1; i++) {
            arr[i] = s.substring(i, i + k);
        }
 
        for (int j = 0; j < arr.length - 1; j++) {
            for (int g = 0; g < arr.length - 1; g++) {
                String p = arr[g];
                String q = arr[g + 1];
                boolean t = true;
                String temp = "";
                for (int w = 0; w < k; w++) {
                    char pkaCharacter = p.charAt(w);
                    int b = (int) pkaCharacter;
 
                    char qkaCharacter = q.charAt(w);
                    int c = (int) qkaCharacter;
 
                    if (b == c)
                        continue;
                    else if (b > c) {
                        t = false;
                        break;
                    } else if (b < c) {
                        t = true;
                        break;
                    }
                }
 
                if (t == false) {
                    temp = arr[g + 1];
                    arr[g + 1] = arr[g];
                    arr[g] = temp;
                } else {
                    continue;
                }
            }
        }
        smallest += arr[0];
        largest += arr[arr.length - 1];
        return smallest;
        // pn(largest);
    }
 
    private static long minof(long a, long b, long c) {
        return min(a, min(b, c));
    }
 
    private static long minof(long... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return min(x[0], x[1]);
        if (x.length == 3)
            return min(x[0], min(x[1], x[2]));
        long min = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] < min)
                min = x[i];
        return min;
    }
 
    private static int maxof(int a, int b, int c) {
        return max(a, max(b, c));
    }
 
    private static int maxof(int... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return max(x[0], x[1]);
        if (x.length == 3)
            return max(x[0], max(x[1], x[2]));
        int max = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] > max)
                max = x[i];
        return max;
    }
 
    private static long maxof(long a, long b, long c) {
        return max(a, max(b, c));
    }
 
    private static long maxof(long... x) {
        if (x.length == 1)
            return x[0];
        if (x.length == 2)
            return max(x[0], x[1]);
        if (x.length == 3)
            return max(x[0], max(x[1], x[2]));
        long max = x[0];
        for (int i = 1; i < x.length; ++i)
            if (x[i] > max)
                max = x[i];
        return max;
    }
 
    private static int fli(double d) {
        return (int) d;
    }
 
    private static int cei(double d) {
        return (int) Math.ceil(d);
    }
 
    private static long fll(double d) {
        return (long) d;
    }
 
    private static long cel(double d) {
        return (long) Math.ceil(d);
    }
 
    private static int gcf(int a, int b) {
        return b == 0 ? a : gcf(b, a % b);
    }
 
    private static long gcf(long a, long b) {
        return b == 0 ? a : gcf(b, a % b);
    }
 
    private static int lcm(int a, int b) {
        return a * b / gcf(a, b);
    }
 
    private static long lcm(long a, long b) {
        return a * b / gcf(a, b);
    }
 
    private static int randInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
 
    private static long mix(long x) {
        x += 0x9e3779b97f4a7c15L;
        x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >> 27)) * 0x94d049bb133111ebL;
        return x ^ (x >> 31);
    }
 
    // array util
    private static void reverse(int[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            int swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    private static void reverse(int[] a, int n, int k) {
        if (k > n) {
            System.out.println("Invalid k");
            return;
        }
 
        // One by one reverse first
        // and last elements of a[0..k-1]
        for (int i = 0; i < k / 2; i++) {
            int tempswap = a[i];
            a[i] = a[k - i - 1];
            a[k - i - 1] = tempswap;
        }
    }
 
    private static void reverse(long[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            long swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    private static void reverse(double[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            double swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    private static void reverse(char[] a) {
        for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
            char swap = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = swap;
        }
    }
 
    private static void shuffle(int[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            int swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    private static void shuffle(long[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            long swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    private static void shuffle(double[] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; ++i) {
            int ind = randInt(i, n);
            double swap = a[i];
            a[i] = a[ind];
            a[ind] = swap;
        }
    }
 
    private static void sortList(ArrayList<Integer> al) {
        Collections.sort(al);
    }
 
    static void reverseList(ArrayList<Integer> al) {
        Collections.reverse(al);
    }
 
    // static void sortList(ArrayList<Pair<Integer,Integer>>al)
    // {Collections.sort(al);}
    private static void sort(int[] a) {
        shuffle(a);
        Arrays.parallelSort(a);
    }
 
    private static void sort(long[] a) {
        shuffle(a);
        Arrays.parallelSort(a);
    }
 
    private static void sort(double[] a) {
        shuffle(a);
        Arrays.parallelSort(a);
    }
 
    private static int[] copy(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    private static long[] copy(long[] a) {
        long[] ans = new long[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    private static double[] copy(double[] a) {
        double[] ans = new double[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    private static char[] copy(char[] a) {
        char[] ans = new char[a.length];
        for (int i = 0; i < a.length; ++i)
            ans[i] = a[i];
        return ans;
    }
 
    // graph util
    private static List<List<Integer>> g(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            g.add(new ArrayList<>());
        return g;
    }
 
    private static List<Set<Integer>> sg(int n) {
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            g.add(new HashSet<>());
        return g;
    }
 
    private static void c(List<? extends Collection<Integer>> g, int u, int v) {
        g.get(u).add(v);
        g.get(v).add(u);
    }
 
    private static void cto(List<? extends Collection<Integer>> g, int u, int v) {
        g.get(u).add(v);
    }
 
    private static void dc(List<? extends Collection<Integer>> g, int u, int v) {
        g.get(u).remove(v);
        g.get(v).remove(u);
    }
 
    private static void dcto(List<? extends Collection<Integer>> g, int u, int v) {
        g.get(u).remove(v);
    }
 
    // output
 
    private static void pn(int i) {
        pw.println(i);
    }
 
    private static void pn(long l) {
        pw.println(l);
    }
 
    private static void prln(long l) {
        pw.println(l);
    }
 
    private static void pr(double d) {
        pw.print(d);
    }
 
    private static void prln(double d) {
        pw.println(d);
    }
 
    private static void pr(char c) {
        pw.print(c);
    }
 
    private static void prln(char c) {
        pw.println(c);
    }
 
    private static void pr(char[] s) {
        pw.print(new String(s));
    }
 
    private static void prln(char[] s) {
        pw.println(new String(s));
    }
 
    private static void pr(String s) {
        pw.print(s);
    }
 
    private static void prln(String s) {
        pw.println(s);
    }
 
    private static void pr(Object o) {
        pw.print(o);
    }
 
    private static void prln(Object o) {
        pw.println(o);
    }
 
    private static void prln() {
        pw.println();
    }
 
    private static void pryes() {
        prln("yes");
    }
 
    private static void pry() {
        prln("Yes");
    }
 
    private static void pY() {
        prln("YES");
    }
 
    private static void prno() {
        prln("no");
    }
 
    private static void prn() {
        prln("No");
    }
 
    private static void pN() {
        prln("NO");
    }
 
    private static void pryesno(boolean b) {
        prln(b ? "yes" : "no");
    };
 
    private static void pryn(boolean b) {
        prln(b ? "Yes" : "No");
    }
 
    private static void prYN(boolean b) {
        prln(b ? "YES" : "NO");
    }
 
    private static void prln(int... a) {
        for (int i = 0, len = a.length - 1; i < len; pr(a[i]), pr(' '), ++i)
            ;
        if (a.length > 0)
            prln(a[a.length - 1]);
        else
            prln();
    }
 
    private static void prln(long... a) {
        for (int i = 0, len = a.length - 1; i < len; pr(a[i]), pr(' '), ++i)
            ;
        if (a.length > 0)
            prln(a[a.length - 1]);
        else
            prln();
    }
 
    private static void prln(double... a) {
        for (int i = 0, len = a.length - 1; i < len; pr(a[i]), pr(' '), ++i)
            ;
        if (a.length > 0)
            prln(a[a.length - 1]);
        else
            prln();
    }
 
    private static <T> void prln(Collection<T> c) {
        int n = c.size() - 1;
        Iterator<T> iter = c.iterator();
        for (int i = 0; i < n; pr(iter.next()), pr(' '), ++i)
            ;
        if (n >= 0)
            prln(iter.next());
        else
            prln();
    }
 
    private static void h() {
        prln("hlfd");
        flush();
    }
 
    private static void flush() {
        pw.flush();
    }
 
    private static void close() {
        pw.close();
    }
 
    private static int uniquePairs(int a[], int n) {
        HashSet<Integer> visited1 = new HashSet<Integer>();
 
        // un[i] stores number of unique elements
        // from un[i + 1] to un[n - 1]
        int un[] = new int[n];
 
        // Last element will have no unique elements
        // after it
        un[n - 1] = 0;
 
        // To count unique elements after every a[i]
        int count = 0;
        for (int i = n - 1; i > 0; i--) {
 
            // If current element has already been used
            // i.e. not unique
            if (visited1.contains(a[i]))
                un[i - 1] = count;
            else
                un[i - 1] = ++count;
 
            // Set to true if a[i] is visited
            visited1.add(a[i]);
        }
 
        HashSet<Integer> visited2 = new HashSet<Integer>();
 
        // To know which a[i] is already visited
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
 
            // If visited, then the pair would
            // not be unique
            if (visited2.contains(a[i]))
                continue;
 
            // Calculating total unqiue pairs
            answer += un[i];
 
            // Set to true if a[i] is visited
            visited2.add(a[i]);
        }
        return answer;
    }
 
    private static int[] replaceAll(int[] a, int val, int newVal) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == val)
                a[i] = newVal;
        return a;
    }
 
    private static int countDigits(int l) {
        if (l >= 1000000000)
            return 10;
        if (l >= 100000000)
            return 9;
        if (l >= 10000000)
            return 8;
        if (l >= 1000000)
            return 7;
        if (l >= 100000)
            return 6;
        if (l >= 10000)
            return 5;
        if (l >= 1000)
            return 4;
        if (l >= 100)
            return 3;
        if (l >= 10)
            return 2;
        return 1;
    }
 
    private static int countDigits(long l) {
        if (l >= 1000000000000000000L)
            return 19;
        if (l >= 100000000000000000L)
            return 18;
        if (l >= 10000000000000000L)
            return 17;
        if (l >= 1000000000000000L)
            return 16;
        if (l >= 100000000000000L)
            return 15;
        if (l >= 10000000000000L)
            return 14;
        if (l >= 1000000000000L)
            return 13;
        if (l >= 100000000000L)
            return 12;
        if (l >= 10000000000L)
            return 11;
        if (l >= 1000000000L)
            return 10;
        if (l >= 100000000L)
            return 9;
        if (l >= 10000000L)
            return 8;
        if (l >= 1000000L)
            return 7;
        if (l >= 100000L)
            return 6;
        if (l >= 10000L)
            return 5;
        if (l >= 1000L)
            return 4;
        if (l >= 100L)
            return 3;
        if (l >= 10L)
            return 2;
        return 1;
    }
 
    private static long factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (long) ((n * factorial(n - 1)) % mod);
    }
 
    private static void watch(int[] a) {
        for (int e : a)
            p(e + " ");
        pn("");
    }
 
    private static void watch(double[] a) {
        for (double e : a)
            p(e + " ");
        pn("");
    }
 
    private static void watch(long[] a) {
        for (long e : a)
            p(e + " ");
        pn("");
    }
 
    private static void watchList(ArrayList<Integer> al) {
        for (int e : al)
            p(e + " ");
        pn("");
    }
 
    private static void watchListString(ArrayList<String> al) {
        for (String e : al)
            p(e + " ");
        pn("");
    }
 
    private static void watchListD(ArrayList<Double> al) {
        for (double e : al)
            p(e + " ");
        pn("");
    }
 
    private static void watchListOfArrays(ArrayList<int[]> al) {
        for (int[] e : al)
            watch(e);
    }
 
    private static void watchLongList(ArrayList<Long> al) {
        for (long e : al)
            p(e + " ");
        pn("");
    }
 
    private static void watchSet(Set<Integer> set) {
        for (int e : set)
            p(e + " ");
        pn("");
    }
 
    private static void watchSetOfArrays(Set<int[]> set) {
        for (int[] e : set)
            watch(e);
    }
 
    private static Set<Integer> putSet(int[] a) {
        Set<Integer> set = new TreeSet<>();
        for (int e : a)
            set.add(e);
        return set;
    }
 
    private static Set<Long> putSet(long[] a) {
        Set<Long> set = new TreeSet<>();
        for (long e : a)
            set.add(e);
        return set;
    }
 
    private static int bs(int[] a, int x) {
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (a[mid] == x)
                return mid;
            else if (a[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
 
    private static String newString(String s, int k) {
        // new string
        String X = "";
 
        // Remove characters until
        // the string is empty
        while (s.length() > 0) {
 
            char temp = s.charAt(0);
 
            // Traverse to find the smallest character in the
            // first k characters
            for (int i = 1; i < k && i < s.length(); i++) {
                if (s.charAt(i) < temp) {
                    temp = s.charAt(i);
                }
            }
 
            // append the smallest character
            X = X + temp;
 
            // removing the lexicographically smallest
            // character from the string
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == temp) {
 
                    s = s.substring(0, i) + s.substring(i + 1);
                    // s.erase(s.begin() + i);
                    break;
                }
            }
        }
 
        return X;
    }
 
    private static boolean exist(int[] a, int x) {
        for (int e : a) {
            if (e == x)
                return true;
        }
        return false;
    }
 
    private static int digitsum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit;
        }
        return sum;
    }
 
    private static long digitsum(long n) {
        long sum = 0;
        while (n > 0) {
            long digit = n % 10;
            n /= 10;
            sum += digit;
        }
        return sum;
    }
 
    private static int countPalindromicSubsequence(String str) {
        int N = str.length();
 
        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N][N];
 
        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;
 
        // check subsequence of length L is
        // palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N - L; i++) {
                int k = L + i - 1;
                if (str.charAt(i) == str.charAt(k)) {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1;
                } else {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
                }
            }
        }
        // return total palindromic subsequence
        return cps[0][N - 1];
    }
 
    private static int LCSubStr(char X[], char Y[], int m, int n) {
        // Create a table to store
        // lengths of longest common
        // suffixes of substrings.
        // Note that LCSuff[i][j]
        // contains length of longest
        // common suffix of
        // X[0..i-1] and Y[0..j-1].
        // The first row and first
        // column entries have no
        // logical meaning, they are
        // used only for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
 
        // To store length of the longest
        // common substring
        int result = 0;
 
        // Following steps build
        // LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                } else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }
 
    private static List<String> subStrings(String s) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                al.add(s.substring(i, j));
            }
        }
        return al;
    }
 
    private static boolean isSubSequence(String str1, String str2, int m, int n) {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;
 
        // If last characters of two strings are matching
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);
 
        // If last characters are not matching
        return isSubSequence(str1, str2, m, n - 1);
    }
 
    private static boolean number_Is_Divisible_By_Its_Digits(long n) {
        long temp = n;
        while (temp > 0) {
            long digit = temp % 10;
            temp /= 10;
            if (digit != 0 && n % digit != 0)
                return false;
        }
        return true;
    }
 
    private static int countDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0)
                cnt++;
            divisors.add(i);
        }
        return cnt;
    }
 
    private static ArrayList<Integer> divisorsList(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (!divisors.contains(i))
                    divisors.add(i);
                if (!divisors.contains(n / i))
                    divisors.add(n / i);
            }
        }
        return divisors;
    }
 
    private static ArrayList<Long> divisorsList(long n) {
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisorsL.add(i);
                divisorsL.add(n / i);
            }
        }
        return divisorsL;
    }
 
    private static ArrayList<Integer> primeFactorList(int n) {
        for (int i = 2; i <= n; i++) {
            if ((n % i) == 0 && primedivisors.contains(i) == false)
                primedivisors.add(i);
        }
        return primedivisors;
    }
 
    private static boolean isStringSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1))
                return false;
        }
        return true;
    }
 
    private static boolean isPalindromeString(String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i) + "";
        }
        return ((s.equals(temp)) ? true : false);
    }
 
    private static boolean isPalindrome(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != a[a.length - 1 - i])
                return false;
        }
        return true;
    }
 
    private static boolean isSorted(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
 
    private static boolean isSortedStrictly(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] >= a[i])
                return false;
        }
        return true;
    }
 
    private static boolean isSorted(long[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
 
    private static boolean isSortedStrictly(long[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] >= a[i])
                return false;
        }
        return true;
    }
 
    private static boolean solution(int n, int x) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit;
        }
        return (sum == x) ? true : false;
    }
 
    private static ArrayList<Integer> perfectSquares(int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            al.add(i * i);
        }
        return al;
    }
 
    private static boolean checkDuplicateAll(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1))
                return false;
        }
        return true;
    }
 
    private static String reverseString(String s, int x) {
        String ans = "", temp = s.substring(0, x);
        for (int i = x; i < s.length(); i++) {
            ans = s.charAt(i) + ans;
        }
        return temp + ans;
    }
 
    private static boolean number_Is_Not_Divisible_By_Its_Digits(int num) {
        String s = num + "";
        if (s.contains("0"))
            return false;
        int temp = num;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            if (temp % digit == 0)
                return false;
        }
        return true;
    }
 
    private static boolean palindrome(int n) {
        int temp = n, rev = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            rev = rev * 10 + digit;
        }
        return (temp == rev) ? true : false;
    }
 
    private static boolean checkparanthesis(String s)
 
    {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                st.push('(');
            else {
                if (st.size() == 0)
                    return false;
                else
                    st.pop();
            }
        }
        return (st.size() == 0) ? true : false;
    }
 
    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
 
    private static int[][] graph(int from[], int to[], int n) {
        int g[][] = new int[n][];
        int cnt[] = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[cnt[i]];
        }
        Arrays.fill(cnt, 0);
        for (int i = 0; i < from.length; i++) {
            g[from[i]][cnt[from[i]]++] = to[i];
            g[to[i]][cnt[to[i]]++] = from[i];
        }
        return g;
    }
 
    private static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
 
    private static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
 
    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
 
    private static int abs(int a, int b) {
        return (int) Math.abs(a - b);
    }
 
    private static int abs(int a) {
        return (int) Math.abs(a);
    }
 
    private static long abs(long a) {
        return (long) Math.abs(a);
    }
 
    private static long abs(long a, long b) {
        return (long) Math.abs(a - b);
    }
 
    private static void swap(int a, int b) {
        int c = b;
        b = a;
        a = c;
    }
 
    private static void swap(long a, long b) {
        long c = b;
        b = a;
        a = c;
    }
 
    private static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
 
    private static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
 
    private static long max(long a, long b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
 
    private static long min(long a, long b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
 
    private static long pow(long n, long p, long m) {
        long result = 1;
        if (p == 0) {
            return 1;
        }
        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            if (result >= m) {
                result %= m;
            }
            p >>= 1;
            n *= n;
            if (n >= m) {
                n %= m;
            }
        }
        return result;
    }
 
    private static int pow(int base, int exp) {
        int result = 1;
        while (exp != 0) {
            if ((exp & 1) == 1)
                result *= base;
            exp >>= 1;
            base *= base;
        }
        return result;
    }
 
    private static long pow(long n, long m) {
        long mod = 1000000007;
        if (m == 0)
            return 1;
        if (m == 1)
            return n;
        if (m % 2 == 0) {
            long ans = pow(n, m / 2);
            return (ans * ans) % mod;
        } else {
            long ans = pow(n, ((m - 1) / 2));
            return ((n * ans) % mod * ans) % mod;
        }
    }
 
    private static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
 
    private static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;
 
        public <U, V> Pair<U, V> makePair(U first, V second) {
            return new Pair<U, V>(first, second);
        }
 
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
 
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
 
            Pair pair = (Pair) o;
 
            return !(first != null ? !first.equals(pair.first) : pair.first != null)
                    && !(second != null ? !second.equals(pair.second) : pair.second != null);
        }
 
        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
 
        public Pair<V, U> swap() {
            return makePair(second, first);
        }
 
        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }
 
        @SuppressWarnings({ "unchecked" })
        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) first).compareTo(o.first);
            if (value != 0) {
                return value;
            }
            return ((Comparable<V>) second).compareTo(o.second);
        }
    }
 
}