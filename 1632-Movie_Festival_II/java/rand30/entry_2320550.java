import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;
 
/**
 * @author ethan55
 */
public class entry_2320550 {
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
 
    public void solve(InputReader in, OutputWriter out) {
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
 
  public static class OutputWriter {
    private static final int BUFFER_SIZE = 1 << 13;
    private final byte[] outputBuffer = new byte[BUFFER_SIZE];
    private final OutputStream outputStream;
    private int outputBufferIndex = 0;
 
    public OutputWriter(OutputStream os) {
      this.outputStream = os;
    }
 
    public OutputWriter println(int x) {
      return writeln(x);
    }
 
    public void flush() {
      innerflush();
      try {
        outputStream.flush();
      } catch (IOException e) {
        throw new IllegalStateException("Failed to flush");
      }
    }
 
    private OutputWriter write(byte b) {
      outputBuffer[outputBufferIndex++] = b;
      if (outputBufferIndex == BUFFER_SIZE) {
        innerflush();
      }
      return this;
    }
 
    private OutputWriter write(String s) {
      s.chars()
          .forEach(
              c -> {
                outputBuffer[outputBufferIndex++] = (byte) c;
                if (outputBufferIndex == BUFFER_SIZE) {
                  innerflush();
                }
              });
      return this;
    }
 
    private static int countDigits(int l) {
      if (l >= 1000000000) {
        return 10;
      }
      if (l >= 100000000) {
        return 9;
      }
      if (l >= 10000000) {
        return 8;
      }
      if (l >= 1000000) {
        return 7;
      }
      if (l >= 100000) {
        return 6;
      }
      if (l >= 10000) {
        return 5;
      }
      if (l >= 1000) {
        return 4;
      }
      if (l >= 100) {
        return 3;
      }
      if (l >= 10) {
        return 2;
      }
      return 1;
    }
 
    private OutputWriter write(int x) {
      if (x == Integer.MIN_VALUE) {
        return write((long) x);
      }
      if (outputBufferIndex + 12 >= BUFFER_SIZE) {
        innerflush();
      }
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = outputBufferIndex + d - 1; i >= outputBufferIndex; i--) {
        outputBuffer[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      outputBufferIndex += d;
      return this;
    }
 
    private static int countDigits(long l) {
      if (l >= 1000000000000000000L) {
        return 19;
      }
      if (l >= 100000000000000000L) {
        return 18;
      }
      if (l >= 10000000000000000L) {
        return 17;
      }
      if (l >= 1000000000000000L) {
        return 16;
      }
      if (l >= 100000000000000L) {
        return 15;
      }
      if (l >= 10000000000000L) {
        return 14;
      }
      if (l >= 1000000000000L) {
        return 13;
      }
      if (l >= 100000000000L) {
        return 12;
      }
      if (l >= 10000000000L) {
        return 11;
      }
      if (l >= 1000000000L) {
        return 10;
      }
      if (l >= 100000000L) {
        return 9;
      }
      if (l >= 10000000L) {
        return 8;
      }
      if (l >= 1000000L) {
        return 7;
      }
      if (l >= 100000L) {
        return 6;
      }
      if (l >= 10000L) {
        return 5;
      }
      if (l >= 1000L) {
        return 4;
      }
      if (l >= 100L) {
        return 3;
      }
      if (l >= 10L) {
        return 2;
      }
      return 1;
    }
 
    private OutputWriter write(long x) {
      if (x == Long.MIN_VALUE) {
        return write("" + x);
      }
      if (outputBufferIndex + 21 >= BUFFER_SIZE) {
        innerflush();
      }
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = outputBufferIndex + d - 1; i >= outputBufferIndex; i--) {
        outputBuffer[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      outputBufferIndex += d;
      return this;
    }
 
    private OutputWriter writeln(int x) {
      return write(x).writeln();
    }
 
    private OutputWriter writeln() {
      return write((byte) '\n');
    }
 
    private void innerflush() {
      try {
        outputStream.write(outputBuffer, 0, outputBufferIndex);
        outputBufferIndex = 0;
      } catch (IOException e) {
        throw new IllegalStateException("Failed to inner flush");
      }
    }
  }
 
  public static class InputReader {
    private final InputStream inputStream;
    private final byte[] inputBuffer = new byte[1024];
    private int bytesRead = 0;
    private int inputBufferIndex = 0;
 
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
      OutputWriter out = new OutputWriter(System.out);
      int testCases = MULTIPLE_TEST_CASES ? in.nextInt() : 1;
      for (int i = 1; i <= testCases; i++) {
        new TestCase().solve(in, out);
      }
      out.flush();
    }
 
  }
}