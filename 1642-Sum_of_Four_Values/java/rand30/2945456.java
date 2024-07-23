//package cses.advancetechniques;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
 
import static java.lang.System.out;
import static java.util.stream.Collectors.joining;
 
 
/**
 * @author pribic (Priyank Doshi)
 * @see <a href="https://cses.fi/problemset/task/1642" target="_top">https://cses.fi/problemset/task/1642</a>
 * @since 04/10/21 9:23 PM
 */
public class entry_2945456 {
  static FastScanner sc = new FastScanner(System.in);
 
  public static void main(String[] args) {
    try (PrintWriter out = new PrintWriter(System.out)) {
      int T = 1;//sc.nextInt();
      for (int tt = 1; tt <= T; tt++) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
 
        // i j k l
        // idea is to iterate over all the pairs of k and l, for them, try to find i and j.
        // to do so, we keep sum of all pairs before k so that when we are exploring current pair of k  and l,
        // we can just look up if there is a pair so far with some x - arr[k] - arr[l] if yes, we know they 
        // came before k so there is no chance of overlapping and reusing same index;
        Map<Integer, int[]> values = new HashMap<>();
        boolean found = false;
        outer:
        for (int k = 0; k < n; k++) {
          for (int l = k + 1; l < n; l++) {
            int key = x - arr[k] - arr[l];
            if (values.containsKey(key)) {
              found = true;
              System.out.println(values.get(key)[0] + " " + values.get(key)[1] + " " + (k + 1) + " " + (l + 1));
              break outer;
            }
          }
          for (int i = 0; i < k; i++) {
            int key = arr[i] + arr[k];
            values.putIfAbsent(key, new int[]{i + 1, k + 1});
          }
        }
        if(!found)
          System.out.println("IMPOSSIBLE");
      }
    }
  }
 
  //n^4 solution
  private static int bruteforce(int[] arr, int x) {
    int ways = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          for (int l = k + 1; l < arr.length; l++) {
            if ((long) arr[i] + arr[j] + arr[k] + arr[l] == (long) x)
              ways++;
          }
        }
 
      }
    }
    return ways;
  }
 
  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner(File f) {
      try {
        br = new BufferedReader(new FileReader(f));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
 
    public FastScanner(InputStream f) {
      br = new BufferedReader(new InputStreamReader(f), 32768);
    }
 
    String next() {
      while (st == null || !st.hasMoreTokens()) {
        String s = null;
        try {
          s = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (s == null)
          return null;
        st = new StringTokenizer(s);
      }
      return st.nextToken();
    }
 
    boolean hasMoreTokens() {
      while (st == null || !st.hasMoreTokens()) {
        String s = null;
        try {
          s = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (s == null)
          return false;
        st = new StringTokenizer(s);
      }
      return true;
    }
 
    int nextInt() {
      return Integer.parseInt(next());
    }
 
    long nextLong() {
      return Long.parseLong(next());
    }
 
    double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}