import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class measure02 {
  static final int N = 2;
  static final int micro2mil = 1000; //to convert from microseconds to miliseconds
  
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(in.readLine());
    final int x = Integer.parseInt(tokenizer.nextToken());
    System.out.println("Read " + x);
    try {
      Thread.sleep(N * x / micro2mil);
    } catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    }
  }
}
