import java.util.*;
import java.io.*;
 
public class entry_5195530 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long t = Long.parseLong(br.readLine());
 
    for (long i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long r = Long.parseLong(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      long ans = 0;
 
      if (r > c) {
        if (r % 2 == 0) ans = r * r - c + 1; else ans = (r - 1) * (r - 1) + c;
      } else {
        if (c % 2 == 0) ans = (c - 1) * (c - 1) + r; else ans = c * c - r + 1;
      }
      System.out.println("" + ans);
    }
  }
}
