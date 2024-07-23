import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;
 
/**
 * @author ethan55
 */
public class entry_2320472 {
  public static void main(String[] args) {
    TestRunner.run();
  }
 
  public static class TestCase {
    static class Time {
      int start;
      int end;
 
      public Time(int start, int end) {
        this.start = start;
        this.end = end;
      }
    }
 
    public void solve(InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int k = in.nextInt();
      Time[] times = new Time[n];
      for (int i = 0; i < n; i++) {
        times[i] = new Time(in.nextInt(), in.nextInt());
      }
      Arrays.sort(times, (a, b) -> a.end - b.end);
      TreeMap<Integer, Integer> ends = new TreeMap<>();
      ends.put(0, k);
      int result = 0;
      for (Time t : times) {
        Integer key = ends.floorKey(t.start);
        if (key != null) {
          result++;
          ends.put(key, ends.get(key) - 1);
          if (ends.get(key) == 0) {
            ends.remove(key);
          }
          ends.put(t.end, ends.getOrDefault(t.end, 0) + 1);
        }
      }
      out.println(result);
    }
  }
 
  public static class InputReader {
    private final byte[] inputBuffer = new byte[1024];
    private int bytesRead = 0;
    private int inputBufferIndex = 0;
    private final InputStream inputStream;
 
    public InputReader(InputStream inputStream) {
      this.inputStream = inputStream;
    }
 
    private int readByte() {
      if (bytesRead == -1) {
        throw new InputMismatchException();
      }
      if (inputBufferIndex >= bytesRead) {
        inputBufferIndex = 0;
        try {
          bytesRead = inputStream.read(inputBuffer);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (bytesRead <= 0) {
          return -1;
        }
      }
      return inputBuffer[inputBufferIndex++];
    }
 
    public int nextInt() {
      return (int) nextLong();
    }
 
    public long nextLong() {
      long num = 0;
      int b;
      boolean minus = false;
      do {
        b = readByte();
      } while (b != -1 && !((b >= '0' && b <= '9') || b == '-'));
      if (b == '-') {
        minus = true;
        b = readByte();
      }
 
      while (true) {
        if (b >= '0' && b <= '9') {
          num = num * 10 + (b - '0');
        } else {
          return minus ? -num : num;
        }
        b = readByte();
      }
    }
  }
 
  public static class TestRunner {
    private static final boolean MULTIPLE_TEST_CASES = false;
 
    public static void run() {
      InputReader in = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      int testCases = MULTIPLE_TEST_CASES ? in.nextInt() : 1;
      for (int i = 1; i <= testCases; i++) {
        new TestCase().solve(in, out);
      }
      out.flush();
    }
 
  }
}