import java.io.*;
import java.util.*;
import java.util.concurrent.*;
 
final class entry_3462380 {
 
 
  static InputStream in = new BufferedInputStream(System.in);
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
  static void swap(int[] arr, int i, int j) {
    int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
  }
 
 
  static void qsort(int[] arr, int l, int r) {
    if (l>=r) return;
    int p = ThreadLocalRandom.current().nextInt(l, r+1);
    int pe = arr[p];
    int i=l, j=r;
    for (int k=l; k<=j; ) {
      if (arr[k]<pe) swap(arr, k++, i++);
      else if (arr[k]>pe) swap(arr, k, j--);
      else ++k;
    }
    qsort(arr, l, i-1);
    qsort(arr, j+1, r);
  }
 
  static void qsort(int[] arr) {
    qsort(arr, 0, arr.length-1);
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
    } catch (Exception e) {
    }
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
    } catch (Exception e) {
    }
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
    } catch (Exception e) {
    }
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
 
 
 
  public static void main(String[] args) {
 
    int n = nextInt();
    int k = nextInt();
    int[][] movies = new int[n][2];
    read(movies);
    Arrays.sort(movies, (a,b) -> a[1]-b[1]);
    NavigableSet<int[]> crits = new TreeSet<>((a, b) -> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
    int watched = n;
    for (int[] movie:movies) {
      // write(movie, false); write("->", false); write(crits);
      int[] low = crits.floor(new int[]{movie[0], movie[0]});
      if (low!=null) {
        crits.remove(low);
      }
      if (crits.size()<k) crits.add(movie);
      else --watched;
    }
    out.println(watched);
    out.flush();
  }
}