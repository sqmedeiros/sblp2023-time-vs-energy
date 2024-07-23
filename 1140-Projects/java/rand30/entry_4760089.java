import java.io.*;
import java.util.*;
import java.util.concurrent.*;
 
final class entry_4760089 {
 
 
  static InputStream in = new BufferedInputStream(System.in);
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
  static final int MOD = (int)1e9 + 7;
  static final long MODL = (int)1e9 + 7;
  static final int INF = Integer.MAX_VALUE;
 
  static long start = System.currentTimeMillis();
  static long run = System.currentTimeMillis();
 
  static void measure(String s) {
 
    long now = System.currentTimeMillis();
    System.err.printf("%20s: time elapsed %s millis. total: %s millis.\n", s, now-run, now-start);
    run = now;
  }
 
  static void measure() {
    measure("");
  }
 
  static void log(String s) {
    System.err.println(s);
  }
 
 
  static <T> void swap(T[] arr, int i, int j) {
    T t = arr[i]; arr[i] = arr[j]; arr[j] = t;
  }
 
  // This outperforms Arrays.sort(..) ?!
  static <T> void sort(T[] arr, int l, int r, Comparator<? super T> c) {
    if (l>=r) return;
    int p = ThreadLocalRandom.current().nextInt(l, r+1);
    T pe = arr[p];
    int i=l, j=r;
    for (int k=l; k<=j; ) {
      int d = c.compare(arr[k],pe);
      if (d<0) swap(arr, k++, i++);
      else if (d>0) swap(arr, k, j--);
      else ++k;
    }
    sort(arr, l, i-1, c);
    sort(arr, j+1, r, c);
  }
 
  static <T> void sort(T[] arr, Comparator<? super T> c) {
    sort(arr, 0, arr.length-1, c);
  }
 
  static void swap(int[] arr, int i, int j) {
    int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
  }
 
  static void sort(int[] arr, int l, int r, Comparator<Integer> c) {
    if (l>=r) return;
    int p = ThreadLocalRandom.current().nextInt(l, r+1);
    int pe = arr[p];
    int i=l, j=r;
    for (int k=l; k<=j; ) {
      int d = c.compare(arr[k],pe);
      if (d<0) swap(arr, k++, i++);
      else if (d>0) swap(arr, k, j--);
      else ++k;
    }
    sort(arr, l, i-1, c);
    sort(arr, j+1, r, c);
  }
 
  static void sort(int[] arr) {
    sort(arr, 0, arr.length-1, (a,b) -> a-b);
  }
 
  static void sort(int[] arr, Comparator<Integer> c) {
    sort(arr, 0, arr.length-1, c);
  }
 
  static String next() {
 
    StringBuilder sb = new StringBuilder();
    try {
      int c = in.read();
      while (Character.isWhitespace(c))
        c = in.read();
      while (!Character.isWhitespace(c)) {
        sb.append((char)c);
        c = in.read();
      }
    } catch (Exception ignore) { }
 
    return sb.toString();
  }
 
 
  static int nextInt() {
 
    int sign = 1;
    int r = 0;
    try {
      int c = in.read();
      while (c!='-' && (c<'0' || c>'9')) c = in.read();
      if (c=='-') {
        sign = -1;
        c = in.read();
      }
      while (c>='0' && c<='9') {
        r = r*10 + (c-'0');
        c = in.read();
      }
    } catch (Exception ignore) { }
 
    return r*sign;
  }
 
 
  static long nextLong() {
 
    int sign = 1;
    long r = 0;
    try {
      int c = in.read();
      while (c!='-' && (c<'0' || c>'9')) c = in.read();
      if (c=='-') {
        sign = -1;
        c = in.read();
      }
      while (c>='0' && c<='9') {
        r = r*10 + (c-'0');
        c = in.read();
      }
    } catch (Exception ignore) { }
 
    return r*sign;
  }
 
 
  static void write(Object o, boolean newline) {
 
    if (o instanceof int[])
      out.print(Arrays.toString((int[])o));
    else if (o instanceof Object[])
      out.print(Arrays.deepToString((Object[])o));
    else if (o instanceof Collection) {
      for (Object x:(Collection)o) {
        write(x, false);
        out.print(" ");
      }
    }
    else out.print(o);
    if (newline) out.println();
  }
 
  static void write(Object o) {
    write(o, true);
  }
 
  static void writef(Object o) {
    write(o, true);
    out.flush();
  }
 
 
  static void read(Object o) {
 
    if (o instanceof int[]) {
      int[] arr = (int[])o;
      for (int i=0; i<arr.length; ++i)
        arr[i] = nextInt();
    } else if (o instanceof long[]) {
      long[] arr = (long[])o;
      for (int i=0; i<arr.length; ++i)
        arr[i] = nextLong();
    } else if (o instanceof String[]) {
      String[] arr = (String[])o;
      for (int i=0; i<arr.length; ++i) {
        arr[i] = next();
      }
    } else if (o instanceof int[][]) {
      int[][] arr = (int[][])o;
      for (int i=0; i<arr.length; ++i) {
        for (int j=0; j<arr[i].length; ++j) {
          arr[i][j] = nextInt();
        }
      }
    }
  }
 
 
  // Binary Indexed Tree
  static int bitCount(int[] bit, int x) {
 
    int sum = 0;
    for (; x>0; x -= x&-x)
      sum += bit[x];
    return sum;
  }
 
  static void bitUpdate(int[] bit, int x, int val) {
 
    for (; x<bit.length; x += x&-x)
      bit[x] += val;
  }
 
  // Order Statistics Tree using BIT (Binary Indexed Tree)
  static int bitSelect(int[] bit, int ith) {
 
    int lo=1, hi=bit.length-1;
    while (lo<hi) {
      int mid = (lo + hi)>>>1;
      int r = bitCount(bit, mid);
      if (r>=ith)
        hi = mid;
      else
        lo = mid+1;
    }
    return lo;
  }
 
 
  public static void main(String[] args) {
 
    int n = nextInt();
    int[][] proj = new int[n][3];
    read(proj);
    Arrays.sort(proj, (a,b) -> a[0] - b[0]);
    long mx = 0;
    long[] mem = new long[n+1];
    for (int i=n-1; i>=0; --i) {
      int[] p = proj[i];
      int lo = i+1;
      int hi = n;
      while (lo < hi) {
        int mid = (lo + hi)>>>1;
        if (proj[mid][0]<=p[1])
          lo = mid+1;
        else
          hi = mid;
      }
      mem[i] = Math.max(mem[i+1], p[2]+mem[lo]);
      mx = Math.max(mx, mem[i]);
    }
    writef(mx);
  }
}