import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class entry_1305274 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1082 solver = new Task1082();
    solver.solve(1, in, out);
    out.close();
  }
 
  static class Task1082 {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      final long mod = (long) 1e9 + 7;
      final long n = in.nextLong();
 
      long ans = 0;
      long ni = n;
      for (int i = 1; i * (long) i <= n; i++) {
        ni = n / i;
        ans += ni * i;
        if (ans >= 0) {
          ans %= mod;
        }
      }
      for (ni--; ni > 0; ni--) {
        long hi = n / ni;
        long lo = n / (ni + 1);
        hi %= mod;
        lo %= mod;
        long s = (hi * (hi + 1) - lo * (lo + 1)) / 2 % mod;
        if (s < 0) {
          s += mod;
        }
        ans += s * ni;
        if (ans >= 0) {
          ans %= mod;
        }
      }
 
      out.println(ans);
    }
  }
 
  static final class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1 << 21];
    private int curChar;
    private int numChars;
 
    public InputReader() {
      this.stream = System.in;
    }
 
    public InputReader(final InputStream stream) {
      this.stream = stream;
    }
 
    private final int read() {
      if (this.numChars == -1) {
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
            return -1;
          }
        }
 
        return this.buf[this.curChar++];
      }
    }
 
    public final long nextLong() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {}
 
      byte sgn = 1;
      if (c == 45) { // 45 == '-'
        sgn = -1;
        c = this.read();
      }
 
      long res = 0;
 
      while (c >= 48 && c <= 57) { // 48 == '0', 57 == '9'
        res *= 10L;
        res += c - 48; // 48 == '0'
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }
      throw new InputMismatchException();
    }
 
    private static final boolean isSpaceChar(final int c) {
      return c == 32 || c == 10 || c == 13 || c == 9
          || c == -1; // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    }
  }
}