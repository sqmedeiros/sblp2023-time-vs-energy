import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
 
class entry_1806450 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numberCount = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
 
    Set<Integer> values = new HashSet<Integer>();
    while (st.hasMoreElements()) {
      int value = Integer.parseInt(st.nextToken());
      values.add(value);
    }
 
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    pw.println(values.size());
    pw.close();
  }
}