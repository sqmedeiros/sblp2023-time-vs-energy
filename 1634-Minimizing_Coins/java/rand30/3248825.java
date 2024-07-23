import java.util.Scanner;
import java.lang.Math;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Time;
import java.io.OutputStream;
 
class entry_3248825 {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int numCoins = io.getInt();
    int sum = io.getInt();
    int[] coins = new int[numCoins];
    for (int i = 0; i < numCoins; i++) {
      coins[i] = io.getInt();
    }
    System.out.println(mincoins(sum, coins));
    io.close();
  }
 
  public static long mincoins(int sum, int[] coins) {
    Arrays.sort(coins);
    int[] dp = new int[sum + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= sum; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
 
    return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
  }
}
 
class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
 
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }
 
  public boolean hasMoreTokens() {
    return peekToken() != null;
  }
 
  public int getInt() {
    return Integer.parseInt(nextToken());
  }
 
  public double getDouble() {
    return Double.parseDouble(nextToken());
  }
 
  public long getLong() {
    return Long.parseLong(nextToken());
  }
 
  public String getWord() {
    return nextToken();
  }
 
  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;
 
  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null)
            return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) {
      }
    return token;
  }
 
  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}