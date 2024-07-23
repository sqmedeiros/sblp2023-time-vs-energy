import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Pradyumn Agrawal (coderbond007)
 */
public class entry_2323850 {
  public static void main(String[] args) throws InterruptedException {
    Thread t =
        new Thread(null, null, ":)", Runtime.getRuntime().maxMemory()) {
          @Override
          public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastScanner in = new FastScanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            Projects solver = new Projects();
            solver.solve(1, in, out);
            out.close();
          }
        };
    t.start();
    t.join();
  }
 
  static class Projects {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
      int n = in.nextInt();
      Projects.Project[] projects = new Projects.Project[n];
      for (int i = 0; i < n; ++i) {
        projects[i] = new Projects.Project(in.nextInt(), in.nextInt(), in.nextInt());
      }
      Arrays.sort(projects);
      long max = 0;
      long[] dp = new long[n];
      for (int i = 0; i < n; ++i) {
        if (i != 0) dp[i] = dp[i - 1];
 
        int possibleEnd = projects[i].start;
        int high = i;
        int low = -1;
        while (high - low > 1) {
          int mid = (high + low) >>> 1;
          if (projects[mid].end < possibleEnd) {
            low = mid;
          } else {
            high = mid;
          }
        }
 
        if (low >= 0) dp[i] = Math.max(dp[i], projects[i].money + dp[low]);
        else dp[i] = Math.max(dp[i], projects[i].money);
        max = Math.max(max, dp[i]);
      }
      out.println(max);
    }
 
    static class Project implements Comparable<Projects.Project> {
      int start;
      int end;
      int money;
 
      public Project(int start, int end, int money) {
        this.start = start;
        this.end = end;
        this.money = money;
      }
 
      public int compareTo(Projects.Project o) {
        return end - o.end;
      }
    }
  }
 
  static class FastScanner {
    BufferedReader reader;
    StringTokenizer tokenizer;
 
    public FastScanner(InputStream inputStream) {
      reader = new BufferedReader(new InputStreamReader(inputStream), 32768);
      tokenizer = null;
    }
 
    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}