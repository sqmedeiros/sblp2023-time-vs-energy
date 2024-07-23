import java.io.*;
import java.util.*;
 
class entry_3854205 { 
  public static void main(String[] args) throws FileNotFoundException {
    // InputStream in = new FileInputStream("test_input.txt");
    // Scanner reader = new Scanner(in);
    InputStream in = System.in;
    // Using FAST IO
    InputReader reader = new InputReader(in);
    // StringBuilder res = new StringBuilder("");
    
    int n = reader.nextInt();
    Long[] arr = new Long[n];
    for(int i = 0; i < n; i++) {
      arr[i] = reader.nextLong();
    }
    Long[] dp = new Long[n];
    dp[n - 1] = arr[n - 1];
    Long ans = dp[n - 1];
    for(int i = n - 2; i >= 0; i--) {
      dp[i] = Math.max(arr[i], arr[i] + dp[i + 1]);
      ans = Math.max(dp[i], ans);
    }
    System.out.println(ans);
  }
  public static void quickSort(int[] arr, int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);
 
        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }
  }
  private static int partition(int[] arr, int begin, int end) {
    int pivot = arr[end];
    int i = (begin-1);
 
    for (int j = begin; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;
 
            int swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }
 
    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;
 
    return i+1;
  }
}
class Element implements Comparable<Element> {
  int index;
  int value;
 
  public Element(int index, int value) {
    this.index = index;
    this.value = value;
  }
 
  public int compareTo(Element e) {
    return this.value - e.value;
  }
 
}
// FAST IO
 
class InputReader  {
 
  private InputStream stream;
  private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
  private static final int EOF = -1;
  private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
  private int curChar;
  private int numChars;
 
  public InputReader(InputStream stream) {
    this.stream = stream;
  }
 
  public int[] readIntArray(int tokens) {
    int[] ret = new int[tokens];
    for (int i = 0; i < tokens; i++) {
      ret[i] = nextInt();
    }
    return ret;
  }
 
  public int read() {
    if (this.numChars == EOF) {
      throw new UnknownError();
    } else {
      if (this.curChar >= this.numChars) {
        this.curChar = 0;
 
        try {
          this.numChars = this.stream.read(this.buf);
        } catch (IOException ex) {
          throw new InputMismatchException();
        }
 
        if (this.numChars <= 0) {
          return EOF;
        }
      }
 
      return this.buf[this.curChar++];
    }
  }
 
  public int nextInt() {
    int c;
    for (c = this.read(); isSpaceChar(c); c = this.read()) {
    }
 
    byte sgn = 1;
    if (c == 45) {
      sgn = -1;
      c = this.read();
    }
 
    int res = 0;
 
    while (c >= 48 && c <= 57) {
      res *= 10;
      res += c - 48;
      c = this.read();
      if (isSpaceChar(c)) {
        return res * sgn;
      }
    }
 
    throw new InputMismatchException();
  }
 
  public long nextLong() {
    int c;
    for (c = this.read(); isSpaceChar(c); c = this.read()) {
    }
 
    byte sgn = 1;
    if (c == 45) {
      sgn = -1;
      c = this.read();
    }
 
    long res = 0;
 
    while (c >= 48 && c <= 57) {
      res *= 10L;
      res += c - 48;
      c = this.read();
      if (isSpaceChar(c)) {
        return res * sgn;
      }
    }
    throw new InputMismatchException();
  }
 
  public double nextDouble() {
    double ret = 0, div = 1;
    int c = read();
    while (c <= ' ') {
      c = read();
    }
    boolean neg = (c == '-');
    if (neg) {
      c = read();
    }
 
    do {
      ret = ret * 10 + c - '0';
    }
    while ((c = read()) >= '0' && c <= '9');
 
    if (c == '.') {
      while ((c = read()) >= '0' && c <= '9') {
        ret += (c - '0') / (div *= 10);
      }
    }
 
    if (neg) {
      return -ret;
    }
    return ret;
  }
 
  public String next() {
    int c;
    while (isSpaceChar(c = this.read())) {
    }
 
    StringBuilder result = new StringBuilder();
    result.appendCodePoint(c);
 
    while (!isSpaceChar(c = this.read())) {
      result.appendCodePoint(c);
    }
 
    return result.toString();
  }
 
  public String nextLine() {
    int c;
    StringBuilder result = new StringBuilder();
    boolean read = false;
    while ((c = this.read()) != '\n') {
      if (c == -1) {
        return null;
      }
      result.appendCodePoint(c);
      read = true;
    }
    if (!read) {
      return null;
    }
    return result.toString();
  }
 
  public static boolean isSpaceChar(int c) {
    return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
  }
 
  public int[] nextIntArray(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }
    return arr;
  }
 
  public long[] nextLongArray(int n) {
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextLong();
    }
    return arr;
  }
 
  public int[][] nextIntMatrix(int n, int m) {
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = nextInt();
      }
    }
    return arr;
  }
 
  public long[][] nextLongMatrix(int n, int m) {
    long[][] arr = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = nextLong();
      }
    }
    return arr;
  }
 
  public char[] nextCharArray() {
    return next().toCharArray();
  }
 
  public double[] nextDoubleArray(int n) {
    double[] ret = new double[n];
    for (int i = 0; i < n; i++) {
      ret[i] = nextDouble();
    }
    return ret;
  }
 
  public int[]
  nextIntArrayOneBased(int n) {
    int[] ret = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      ret[i] = nextInt();
    }
    return ret;
  }
 
  public char[][] nextCharMatrix(int n, int m) {
    char[][] res = new char[n][m];
    for (int i = 0; i < n; ++i) {
      res[i] = nextCharArray();
    }
    return res;
  }
}
